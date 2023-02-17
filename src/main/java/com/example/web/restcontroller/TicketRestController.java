package com.example.web.restcontroller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.MovieRatingDto;
import com.example.dto.ResponseDto;
import com.example.dto.ShowScheduleScreenDto;
import com.example.exception.CustomException;
import com.example.service.MovieTicketService;
import com.example.service.TicketingServiece;
import com.example.utils.SessionUtils;
import com.example.vo.Customer;
import com.example.vo.NonExistentSeat;
import com.example.vo.PointHistory;
import com.example.vo.PointHistoryType;
import com.example.vo.PointHistoryTypeDetail;
import com.example.vo.Region;
import com.example.vo.Screen;
import com.example.vo.ShowDayType;
import com.example.vo.ShowSchedule;
import com.example.vo.SpecialScreen;
import com.example.vo.Theater;
import com.example.vo.Ticket;
import com.example.vo.TicketSeat;
import com.example.web.form.InsertTicketForm;
import com.example.web.form.TicketingPayForm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/rest")
@Transactional
public class TicketRestController {
	
	@Autowired
	private MovieTicketService movieticketService;
	@Autowired
	private TicketingServiece ticketService;
	
	  @GetMapping("/screenList")
	  public ResponseDto<?>getAllList(@RequestParam("movieNo")int movieNo){
	  List<ShowScheduleScreenDto> screens = movieticketService.allListByMovie(movieNo); 
	  ResponseDto<List<ShowScheduleScreenDto>> response = new ResponseDto<>();
	  response.setStatus(true);
	  response.setItems(screens);
	  return response;
	  }
	  
	  @GetMapping("/theaterList")
	  public ResponseDto<?>getAllListBytheaterNo(@RequestParam("movieNo") int movieNo, @RequestParam("theaterNo") int theaterNo, @RequestParam("timeNo") int timeNo, @RequestParam("dayNm") int day){
		  List<ShowScheduleScreenDto> theaters = movieticketService.listByTheaterNo(movieNo,theaterNo);
		  log.info("나오는 값"+theaters);
		  List<ShowScheduleScreenDto> theater = new ArrayList<>();
		  ResponseDto<List<ShowScheduleScreenDto>> response = new ResponseDto<>();
		  int screenNo = 0;
		  long showScheduleNo = 0;
		  int totalSeat = 0;
		  LocalDate now = LocalDate.now();
		  int dayOfMonth = now.getDayOfMonth();
		
		  if(dayOfMonth != day) {
			  for(ShowScheduleScreenDto sd : theaters) {
					screenNo = sd.getScreenNo();
					showScheduleNo = sd.getShowScheduleNo();
					totalSeat = sd.getScreenTotalSeat();
					 int notSeat = movieticketService.getlistnonExistentSeatByScreenNo(screenNo);
					 int disabledSeat = movieticketService.getListTicketSeatByShowScheduleNo(showScheduleNo);
					 sd.setReservableSeat(totalSeat-notSeat-disabledSeat);
					 sd.setRealTotalSeat(totalSeat-notSeat);
				  }
			 
			  response.setStatus(true);
			  response.setItems(theaters);
			  return response;
			  
		  } else {
			  for(ShowScheduleScreenDto sc :theaters) {
				  DateFormat dateFormat = new SimpleDateFormat("HH");
				  String startTime = dateFormat.format(sc.getShowScheduleStartTime());
				  int time = Integer.parseInt(startTime);
				  screenNo = sc.getScreenNo();
				  showScheduleNo = sc.getShowScheduleNo();
				  int notSeat = movieticketService.getlistnonExistentSeatByScreenNo(screenNo);
				  int disabledSeat = movieticketService.getListTicketSeatByShowScheduleNo(showScheduleNo);
				  sc.setReservableSeat(sc.getScreenTotalSeat()-notSeat-disabledSeat);
				  sc.setRealTotalSeat(sc.getScreenTotalSeat()-notSeat);
				  log.info("시간은"+time);
				  log.info("시간은"+timeNo);
				 if(time>=timeNo) {
					 theater.add(sc);
				 } 
			  }
			  response.setItems(theater);
			  response.setStatus(true);
			  log.info("시간은"+theater);
			  return response;
		  }
	  }
	  
	  @GetMapping("/theater")
	  public ResponseDto<?>getRegionBytheaterNo(@RequestParam(required=false, value="regionNo", defaultValue="10") int regionNo) {
		  List<Theater> theaters =  movieticketService.listByRegionNo(regionNo);
		  ResponseDto<List<Theater>> response = new ResponseDto<>();
		  response.setStatus(true);
		  response.setItems(theaters);
		  return response;
	  }
	  
	  @GetMapping("/ticketing/complete")
	  public void getTicketPay(InsertTicketForm content) throws JsonMappingException, JsonProcessingException{
		  	log.info("받은 데이터"+content);
		  	//티켓저장, 좌석 저장, 포인트 적립 
		  	Customer customer = (Customer)SessionUtils.getAttribute("LOGIN_USER");
			long showScheduleNo = content.getShowScheduleNo();
			int savePoint = (int)(content.getTicketingPay()*0.05);
			Ticket tickets = Ticket.builder().showScheduleNo(showScheduleNo).customerNo(customer.getNo()).ticketTotalAmount(content.getTicketingToTalPay())
				.ticketUsedPoint(content.getPoint()).ticketExpectedEarningPoint(savePoint).build();
			Ticket findTicket = ticketService.saveTicket(tickets);
			String seatList = content.getSeatList();
			String result = seatList.substring(seatList.lastIndexOf("[")+1);
			List<String> seats = new ArrayList<>();
			String[] arrays = result.split(",");
			for(int i=0; i<arrays.length;i++) {
				seats.add(arrays[i]);
			}
			String str = seats.get(3).replace("]"," ");
			String seast3 = seats.get(2).trim();
			String seast2 = seats.get(1).trim();
			String seast4 = str.trim();
			TicketSeat seats1 = TicketSeat.builder().ticketNo(findTicket.getNo()).no(seats.get(0)).build();
			TicketSeat seats2 = TicketSeat.builder().ticketNo(findTicket.getNo()).no(seast2).build();
			TicketSeat seats3 = TicketSeat.builder().ticketNo(findTicket.getNo()).no(seast3).build();
			TicketSeat seats4 = TicketSeat.builder().ticketNo(findTicket.getNo()).no(seast4).build();
			log.info("의자"+seats1);
			log.info("의자"+seats2);
			log.info("의자"+seats3);
			log.info("의자"+seats4);
			int total = 0;
			if(!seats1.getNo().isEmpty()) {
				TicketSeat seat1 = ticketService.saveTicketSeat(seats1);
				total += 1;
			//	ticketService.updateMovieTotalNumber(Integer.parseInt(content.getMovie()));
			} 
			if(!seats2.getNo().isEmpty()) {
				TicketSeat seat2 = ticketService.saveTicketSeat(seats2);
			//	ticketService.updateMovieTotalNumber(Integer.parseInt(content.getMovie()));
				total += 1;
			} 
			if(!seats3.getNo().isEmpty()) {
				TicketSeat seat3 = ticketService.saveTicketSeat(seats3);
			//	ticketService.updateMovieTotalNumber(Integer.parseInt(content.getMovie()));
				total += 1;
			}
			if(!seats4.getNo().isEmpty()) {
				TicketSeat seat4 = ticketService.saveTicketSeat(seats4);
			//	ticketService.updateMovieTotalNumber(Integer.parseInt(content.getMovie()));
				total += 1;
			}
			log.info("몇개 :"+ total);
			int save = content.getUserDiscountPoint();
			int usePoint = content.getUserPoint();
			if(save != 0) {
				PointHistoryTypeDetail detail2 = PointHistoryTypeDetail.builder().detailName("영화관적립").name("적립").build();
				PointHistoryTypeDetail details2 = ticketService.insertPointHistory(detail2);
				PointHistory historys2 = PointHistory.builder().customerNo(customer.getNo()).pointHistoryPoint(save)
						.pointHistoryTypeDetailNo(details2.getNo()).build();
				ticketService.insertPointHistory(historys2);
				customer.setCurrentPoint(customer.getCurrentPoint()+save);
				ticketService.updateCustomerPoint(customer);
			} 
			if(usePoint != 0) {
				PointHistoryTypeDetail detail1 = PointHistoryTypeDetail.builder().detailName("영화관사용").name("사용").build();
				PointHistoryTypeDetail details1 = ticketService.insertPointHistory(detail1);
				PointHistory historys1 = PointHistory.builder().customerNo(customer.getNo()).pointHistoryPoint(usePoint)
						.pointHistoryTypeDetailNo(details1.getNo()).build();
				ticketService.insertPointHistory(historys1);
				customer.setCurrentPoint(customer.getCurrentPoint()-usePoint);
				ticketService.updateCustomerPoint(customer);
			}
			int movieNo = Integer.parseInt(content.getMovie());
			ticketService.updateMovieTotalNumber(movieNo,total);
		 }
}
