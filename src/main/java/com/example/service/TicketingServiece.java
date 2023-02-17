package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.exception.MovieTicketingErrorException;
import com.example.mapper.TheaterMapper;
import com.example.mapper.TicketingMapper;
import com.example.utils.SessionUtils;
import com.example.vo.AudienceType;
import com.example.vo.Customer;
import com.example.vo.FeeType;
import com.example.vo.Movie;
import com.example.vo.PointHistory;
import com.example.vo.PointHistoryType;
import com.example.vo.PointHistoryTypeDetail;
import com.example.vo.Screen;
import com.example.vo.ShowDayType;
import com.example.vo.ShowStartTimeType;
import com.example.vo.Theater;
import com.example.vo.Ticket;
import com.example.vo.TicketAudience;
import com.example.vo.TicketSeat;
import com.example.web.form.TicketAdienceTypeForm;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class TicketingServiece {

	@Autowired
	private TicketingMapper ticketDto;
	@Autowired
	private TheaterMapper theaterDto;
	
	public Theater getTheaterByNo(int no) {
		return theaterDto.getTheaterByNo(no);
	}
	public Ticket saveTicket(Ticket ticket) {
		Ticket ticketBuilder = Ticket.builder().no(ticket.getNo()).customerNo(ticket.getCustomerNo())
				.showScheduleNo(ticket.getShowScheduleNo()).ticketTotalAmount(ticket.getTicketTotalAmount())
				.ticketUsedPoint(ticket.getTicketUsedPoint()).ticketExpectedEarningPoint(ticket.getTicketExpectedEarningPoint())
				.build();
		Ticket ticketByNo = ticketDto.ticketByNo(ticketBuilder.getNo());
		if(ticketByNo == null) {
			 ticketDto.insertTicket(ticketBuilder);
			 return ticketDto.ticketByNo(ticketBuilder.getNo());
		} else {
			return ticketByNo;
		}
	}
	public Ticket updateTicket(Ticket ticket) {
		Ticket ticketByNo = ticketDto.ticketByNo(ticket.getNo());
		ticketByNo.setTicketUsedPoint(ticket.getTicketUsedPoint());
		ticketByNo.setTicketTotalAmount(ticket.getTicketTotalAmount());
		ticketByNo.setTicketExpectedEarningPoint(ticket.getTicketExpectedEarningPoint());
		ticketDto.updateticketByPoint(ticketByNo);
		return ticketDto.ticketByNo(ticketByNo.getNo());
	}
	public TicketAudience saveTicketAudience(TicketAudience audience) {
		TicketAudience audienceBuilder = TicketAudience.builder().ticketNo(audience.getTicketNo()).audienceTypeNo(audience.getAudienceTypeNo())
				.ticketNo(audience.getTicketNo()).totalNumber(audience.getTotalNumber()).build();
		TicketAdienceTypeForm form = TicketAdienceTypeForm.builder().ticketNo(audienceBuilder.getTicketNo()).audienceTypeNo(audienceBuilder.getAudienceTypeNo()).build();
		TicketAudience audiences = ticketDto.ticketAudienceByNo(form);
		if(audiences==null) {
			ticketDto.insertTicketAudience(audienceBuilder);
			return ticketDto.ticketAudienceByNo(form);
		} else {
			return audiences;
		}
	}
	public Movie getMovieTotalNumberByNo(int movieNo) {
		return ticketDto.getMovieByNo(movieNo);
	}
	public void updateMovieTotalNumber(int movieNo, int total){
		Movie findMovie = ticketDto.getMovieByNo(movieNo); 
		int number =findMovie.getMovieAudienceTotalNumber()+total;
		findMovie.setMovieAudienceTotalNumber(number);
		findMovie.setNo(movieNo);
		ticketDto.countUpdateTotalNumber(findMovie);
	}
	public TicketSeat saveTicketSeat(TicketSeat seat) {
		TicketSeat ticket = ticketDto.ticketSeatBySeat(seat);//동일한 좌석이 존재하면 저장하지 않기 위해 조회한다.
		if(ticket == null) {
			ticketDto.insertTicetSeat(seat);
			return ticketDto.ticketSeatBySeat(seat);
		} else {
		   throw new MovieTicketingErrorException("예약된 좌석입니다.");
		}
	}
	public ShowStartTimeType getStartType(String time) {
		return ticketDto.getStartType(time);
	}
	public ShowDayType getShowDayType(String name) {
		return ticketDto.getShowDayType(name);
	}
	public List<AudienceType> getAudienceTypeName(String audult, String old, String baby) {
		List<String> name = new ArrayList<>();
		if(audult.equals("성인")) {
			name.add("ADULT");
		} else if(old.equals("우대")) {
			name.add("OLD_MAN");
		} else if(baby.equals("청소년")) {
			name.add("YOUTH");
		}
		if(name.size() >= 1) {
			return ticketDto.getAudienceTypeName(name);
		} else {
			AudienceType type = null;
			type =  ticketDto.getAudienceTypeNameByOne(name.get(0));
			List<AudienceType> typeName = new ArrayList<>();
			typeName.add(type);
			return typeName;
			
		}
		
	}
	public List<FeeType> getAllFeeType(int showTypeNo, int dayTypeNo, int showStartTimeNo, int audienceTypeNo){
		return ticketDto.getAllFeeType(showTypeNo, dayTypeNo, showStartTimeNo, audienceTypeNo);
	}
	public FeeType getFeeTypeByNo(int showTypeNo, int dayTypeNo, int showStartTimeNo, int audienceTypeNo) {
		FeeType fee = ticketDto.getAllFeeTypeByNo(showTypeNo, dayTypeNo, showStartTimeNo, audienceTypeNo);
		if(fee.equals(null)) {
			FeeType fees = FeeType.builder().showDayTypeNo(dayTypeNo).showTypeNo(showTypeNo).audienceTypeNo(audienceTypeNo).showStartTypeNo(showStartTimeNo)
					.build();
			if(audienceTypeNo == 1) {
				fees.setFee(10000);
			} else if(audienceTypeNo == 2) {
				fees.setFee(8000);
			} else if(audienceTypeNo == 3) {
				fees.setFee(5000);
			}
			 ticketDto.insertFeeType(fees);
			 return ticketDto.getAllFeeTypeByNo(showTypeNo, dayTypeNo, showStartTimeNo, audienceTypeNo);
		} else {
			return ticketDto.getAllFeeTypeByNo(showTypeNo, dayTypeNo, showStartTimeNo, audienceTypeNo);
		}
	}
	public Screen getScreenByNo(int screenNo) {
		return ticketDto.getScreenByNo(screenNo);
	}
	public void insertPointHistory(PointHistory pointHistory) {
		 ticketDto.insertPointHistory(pointHistory);
	}
	public PointHistoryTypeDetail insertPointHistory(PointHistoryTypeDetail detail) {
		ticketDto.insertPointHistoryDetail(detail);
		return ticketDto.getDetailHistory(detail.getNo());
	}
	public PointHistoryType insertPointType(PointHistoryType type) {
		return ticketDto.getType(type.getName());
	}
	public void updateCustomerPoint(Customer customer) {
			ticketDto.updateCustomerPoint(customer);
	}
}
