package com.example.web.controller;

import java.text.DateFormat;




import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.example.dto.MovieRatingDto;
import com.example.dto.MovieScheduleDto;
import com.example.dto.ResponseDto;
import com.example.dto.ShowScheduleScreenDto;
import com.example.exception.CustomException;
import com.example.service.MovieRatingService;
import com.example.service.MovieTicketService;
import com.example.service.TicketingServiece;
import com.example.utils.SessionUtils;
import com.example.vo.AudienceType;
import com.example.vo.Customer;
import com.example.vo.FeeType;
import com.example.vo.NonExistentSeat;
import com.example.vo.Region;
import com.example.vo.Screen;
import com.example.vo.ShowDayType;
import com.example.vo.ShowSchedule;
import com.example.vo.ShowStartTimeType;
import com.example.vo.ShowType;
import com.example.vo.Theater;
import com.example.vo.Ticket;
import com.example.vo.TicketAudience;
import com.example.vo.TicketSeat;
import com.example.web.form.InsertTicketForm;
import com.example.web.form.ScreenListInsertForm;
import com.example.web.form.ScreenListInsertForm.ScreenListInsertFormBuilder;
import com.example.web.form.TicketForm;
import com.example.web.form.TicketNoForm;
import com.example.web.form.TicketingForm;
import com.example.web.form.TicketingPayForm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@Transactional
public class TicketController {

	@Autowired
	private MovieRatingService movieRatingService;
	@Autowired
	private MovieTicketService movieTicketService;
	@Autowired
	private TicketingServiece ticketService;
	
	@GetMapping("/ticketing/screenList")
	public String screenList(Model model,@RequestParam(value = "no", required = false, defaultValue = "0") int no) {
		List<MovieRatingDto> movies = movieRatingService.getAllList();
		List<Region> regions = movieTicketService.listByRegion();
		int number = 0;
		for(Region rs : regions) {
			number = rs.no;
		}
		int countRegion = movieTicketService.countRegionByNo(number);
		log.info(movies.toString());
		model.addAttribute("movies", movies);
		model.addAttribute("regions", regions);
		model.addAttribute("countRegion", countRegion);
		log.info(model.toString());
		return "/ticketing/screenList";
	}
	
	@GetMapping("/ticketing/ticketingList")
	public String ticketingList(@ModelAttribute("TicketForm") String forms, Model model) throws JsonMappingException, JsonProcessingException {
		//좌석꺼내기, 영화꺼내기 그리고 모델에 담기 
		ObjectMapper mapper = new ObjectMapper();
		TicketForm ticket = mapper.readValue(forms, TicketForm.class);
		ScreenListInsertForm form = ScreenListInsertForm.builder().screenNo(ticket.getScreenNo()).showScheduleNo(ticket.getShowScheduleNo())
				.movieNo(ticket.getMovieNo()).showTypeNo(ticket.getShowTypeNo()).theaterNo(ticket.getTheaterNo()).dayNo(ticket.getShowDayTypeNo())
				.day(ticket.getDay()).time(ticket.getShowTime()).build();
		log.info("빈좌석",ticket.getShowScheduleNo());
		MovieScheduleDto screens = movieRatingService.getScheduleList(form);
		MovieRatingDto movieRated = movieRatingService.getListByMovieNo(form.getMovieNo());//영화 번호로 관람에 대해서 조회
		ShowDayType days = movieRatingService.getShowDayType(form.getDay());	//일자 조회
		List<AudienceType> audience = movieRatingService.getAudienceType(movieRated.getRatingNo());//관람자 조회
		ShowType showType = movieRatingService.getShowTypeByNo(form.getShowTypeNo());
		Screen realySeat = movieRatingService.getScreenByNo(form.getScreenNo(), form.getTheaterNo());
		List<NonExistentSeat> emptySeat = movieRatingService.getNonExistentSeat(form.getScreenNo());//빈좌석 조회
		log.info("빈좌석",form.getScreenNo());
		//티켓조회 후 예약된 좌석 출력하기
		SimpleDateFormat format = new SimpleDateFormat("yyyy");
		Date time = new Date();
		String year = format.format(time);
		String month = ticket.getTicketingDay().substring(0, ticket.getTicketingDay().length()-2);
		String day = ticket.getTicketingDay().substring(ticket.getTicketingDay().length()-2, ticket.getTicketingDay().length());
		String totalDay = year+"-"+month+"-"+day;
		TicketNoForm ticketForm = TicketNoForm.builder().movieNo(ticket.getMovieNo()).showScheduleNo(screens.getShowScheDuleNo()).build();
		log.info("티켓확인",ticketForm);
		List<TicketSeat> findTicketSeat = movieRatingService.getTicketNoByScheduleNo(ticketForm);
		log.info("티켓확인2",findTicketSeat);
		model.addAttribute("screens", screens);
		model.addAttribute("ratied", movieRated);
		model.addAttribute("emptySeat", emptySeat);//빈좌석
		model.addAttribute("realySeat", realySeat); //현재좌석
		model.addAttribute("day", days);
		model.addAttribute("audience", audience);
		model.addAttribute("showType", showType);
		model.addAttribute("ticketingDay",totalDay); //일자
		model.addAttribute("noEamptySeat",findTicketSeat); //예약된 좌석
		
		log.info("movieRated"+movieRated);
		log.info("emptySeat 비어있는좌석"+emptySeat);
		log.info("realySeat 남아있는좌석"+realySeat);
		log.info("noEamptySeat 예약좌석"+findTicketSeat);
		log.info("days"+days);
		log.info("audience"+audience);
		log.info("screens"+screens);
		log.info("showType"+showType);
		log.info("ticketingDay"+totalDay);
		return "/ticketing/ticketingList";
	}
	
	@PostMapping("/ticketing/ticketingList")
	public String postTicketingList(ScreenListInsertForm form, RedirectAttributes redirect) throws JsonProcessingException {
		String result = form.getDay().substring(form.getDay().length()-1, form.getDay().length());
		String result1 = form.getDay().substring(form.getDay().length()-5, form.getDay().length()-1);
		form.setDay(result);
		form.setTicketingDay(result1);
		ShowDayType day = movieRatingService.getShowDayType(form.getDay());
		log.info("값확인",form.getShowScheduleNo());
		ScreenListInsertForm save = ScreenListInsertForm.builder().movieNo(form.getMovieNo()).day(form.getDay()).ratingNo(form.getRatingNo())
		.regionNo(form.getRegionNo()).screenNo(form.getScreenNo()).showTypeNo(form.getShowTypeNo()).showScheduleNo(form.getShowScheduleNo())
		.theaterNo(form.getTheaterNo()).ticketingDay(form.getTicketingDay()).time(form.getTime()).dayNo(day.getNo()).build();
		MovieScheduleDto movieSchedul = movieRatingService.getScheduleList(save);
		DateFormat dateFormat = new SimpleDateFormat("HH");
		String showTime = dateFormat.format(movieSchedul.getShowScheduleStartTime());
		TicketForm forms = new TicketForm();
		forms.setShowDayTypeNo(form.getDayNo());
		forms.setTheaterNo(save.getTheaterNo());
		forms.setMovieNo(save.getMovieNo());
		forms.setScreenNo(save.getScreenNo());
		forms.setShowTypeNo(save.getShowTypeNo());
		forms.setShowTime(showTime);
		forms.setDay(save.getDay());
		forms.setShowScheduleNo(save.getShowScheduleNo());
		log.info(result);
		log.info(result1);
		log.info("보낸일자"+result1);
		forms.setTicketingDay(result1);
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(forms);
		redirect.addAttribute("TicketForm",jsonStr);
		return "redirect:/ticketing/ticketingList";
	}

	@GetMapping("/ticketing/ticketingPay")
	public String ticketingPay(@ModelAttribute(value="formByPay") String jsonForm, Model model) throws JsonMappingException, JsonProcessingException,Exception {
	
		ObjectMapper mapper = new ObjectMapper();
		TicketingPayForm form = mapper.readValue(jsonForm, TicketingPayForm.class);
		TicketingPayForm forms = TicketingPayForm.builder().screenNo(form.getScreenNo()).showScheduleNo(form.getShowScheduleNo())
				.showDayByForm(form.getShowDayByForm()).ticketingPay(form.getTicketingPay()).seat1(form.getSeat1())
				.seat2(form.getSeat2()).seat3(form.getSeat3()).seat4(form.getSeat4())
				.startTimesByForm(form.getStartTimesByForm()).movieNo(form.getMovieNo()).audult(form.getAudult()).baby(form.getBaby()).old(form.getOld()).
				audultTotal(form.getAudultTotal()).babyTotal(form.getBabyTotal()).oldTotal(form.getOldTotal()).build();
		log.info("넘어온 파일" + forms);
		Customer customer = (Customer)SessionUtils.getAttribute("LOGIN_USER");
		if(customer == null) {
			throw new CustomException("잘못된 요청입니다.");
		}
		List<String> seatList = new ArrayList<>();
		seatList.add(forms.getSeat1());
		seatList.add(forms.getSeat2());
		seatList.add(forms.getSeat3());
		seatList.add(forms.getSeat4());
		Screen screen = ticketService.getScreenByNo(forms.getScreenNo());
		Theater theater = ticketService.getTheaterByNo(screen.getTheaterNo());
		MovieRatingDto movieRating = movieRatingService.getListByMovieNo(forms.getMovieNo());
		model.addAttribute("movie", movieRating);
		model.addAttribute("showTime", form.getShowDayByForm());
		model.addAttribute("startTime", form.getStartTimesByForm());
		model.addAttribute("ticketAudience", form.getTicketAudienceKindByForm());
		model.addAttribute("screen", screen);
		model.addAttribute("theater", theater);
		model.addAttribute("seatList", seatList);
		model.addAttribute("showScheduleNo", form.getShowScheduleNo());
		model.addAttribute("ticketingPay", form.getTicketingPay());
		int point = (int)(Integer.parseInt(form.getTicketingPay())*0.05);
		model.addAttribute("point",point);
		if(form.getAudult() != null) {
			model.addAttribute("audult", form.getAudult()+form.getAudultTotal());
		}
		if(form.getBaby() != null) {
			model.addAttribute("baby", form.getBaby()+form.getBabyTotal());
		}
		if(form.getOld() != null) {
			model.addAttribute("old", form.getOld()+form.getOldTotal());
		}
		
		log.info("point"+customer.getCurrentPoint());
		log.info("영화" +movieRating);
		log.info("영화일자" +form.getShowDayByForm());
		log.info("시작시간"+form.getStartTimesByForm());
		log.info("티켓구매타입"+form.getTicketAudienceKindByForm());
		log.info("상영관정보"+screen);
		log.info("극장정보"+theater);
		log.info("성인"+form.getAudult()+form.getAudultTotal());
		log.info("청소년"+form.getBaby()+form.getBabyTotal());
		log.info("노인"+form.getOld()+form.getOldTotal());
		log.info("좌석"+seatList);
		return "/ticketing/ticketingPay";
	}
	
	@PostMapping("/ticketing/ticketingPay")
	public String postTicketingPay(TicketingForm form, RedirectAttributes redirect) throws JsonProcessingException {
		Customer customer = (Customer)SessionUtils.getAttribute("LOGIN_USER");
		if(customer == null) {
			 throw new CustomException("로그인을 다시 진행하세요");
		} 
		TicketingForm ticket = TicketingForm.builder().adult(form.getAdult()).adultCount(form.getAdultCount()).baby(form.getBaby()).babyCount(form.getBabyCount())
				.old(form.getOld()).oldCount(form.getOldCount()).movieNo(form.getMovieNo()).screenNo(form.getScreenNo()).ticketingPay(form.getTicketingPay())
				.theaterNo(form.getTheaterNo()).showTypeNo(form.getShowTypeNo()).seats(form.getSeats()).showScheduleStartTime(form.getShowScheduleStartTime())
				.showScheDuleNo(form.getShowScheDuleNo()).showNo(form.getShowNo()).seat1(form.getSeat1()).seat2(form.getSeat2())
				.seat3(form.getSeat3()).seat4(form.getSeat4()).date(form.getDate()).dayName(form.getDayName()).build();
		log.info("폼입력 값" + ticket);
		//현재값을 뿌리기 위해 조회하는 값이다. 
		ShowDayType showDay = ticketService.getShowDayType(ticket.getDayName());
		ShowStartTimeType startTime = ticketService.getStartType(ticket.getShowScheduleStartTime());
		//List<AudienceType> audiences = ticketService.getAudienceTypeName(ticket.getAdult(),ticket.getBaby(),ticket.getOld());
		log.info("일정조회" + showDay);
		log.info("시작시간조회" + startTime);
		log.info("좌석" + ticket.getSeat1());
		log.info("좌석" + ticket.getSeat2());
		log.info("좌석" + ticket.getSeat3());
		log.info("좌석" + ticket.getSeat4());
		log.info("영화번호" + ticket.getMovieNo());
		
		
		TicketingPayForm formByPay = TicketingPayForm.builder().ticketingPay(form.getTicketingPay()).seat1(ticket.getSeat1())
				.seat2(ticket.getSeat2()).seat3(ticket.getSeat3()).seat4(ticket.getSeat4())
				.showDayByForm(showDay).startTimesByForm(startTime).showScheduleNo(ticket.getShowScheDuleNo())
				.movieNo(ticket.getMovieNo()).audult(form.getAdult()).audultTotal(form.getAdultCount()).screenNo(form.getScreenNo())
				.baby(form.getBaby()).babyTotal(form.getBabyCount()).oldTotal(form.getOldCount()).old(form.getOld()).build();
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(formByPay);
		redirect.addAttribute("formByPay",jsonStr);
		return "redirect:/ticketing/ticketingPay";
		//결제를 진행하지 않으면 좌석과 티켓이 취소되는 스케쥴러 구현해야함 2-5
	}
	

	 
}
