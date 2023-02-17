package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

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
import com.example.vo.Ticket;
import com.example.vo.TicketAudience;
import com.example.vo.TicketSeat;
import com.example.web.form.TicketAdienceTypeForm;

@Mapper
public interface TicketingMapper {

	public void insertTicket(Ticket ticket);
	public ShowStartTimeType getStartType(String time);
	public ShowDayType getShowDayType(String name);
	public List<AudienceType> getAudienceTypeName(List<String> name);
	public AudienceType getAudienceTypeNameByOne(String name);
	public List<FeeType> getAllFeeType(int showTypeNo, int dayTypeNo, int showStartTimeNo, int audienceTypeNo);
	public FeeType getAllFeeTypeByNo(int showTypeNo, int dayTypeNo, int showStartTimeNo, int audienceTypeNo);
	public void insertTicketAudience(TicketAudience audience);
	//티켓의 좌석을 저장한다.
	public void insertTicetSeat(TicketSeat seat);
	public void insertFeeType(FeeType fee);
	public Ticket ticketByNo(long ticketNo);
	public Ticket ticketByscheduleNo(long scheduleNo);
	public TicketAudience ticketAudienceByNo(TicketAdienceTypeForm form);
	//예약된 좌석을 티켓번호로 조회한다.
	public TicketSeat ticketSeatBySeat(TicketSeat seat);
	public Movie getMovieByNo(int movieNo);//영화관람자수 조회
	public void countUpdateTotalNumber(Movie movie);//영화관람자수 증가
	public void deleteticketSeatByNo(String no);//예약 취소시 삭제 
	public void updateticketByPoint(Ticket ticket);//point사용시 수정될 ticket내용
	public void insertPointHistory(PointHistory history);
	public void insertPointHistoryDetail(PointHistoryTypeDetail detailHistory);
	public void updateCustomerPoint(Customer customer);//구매시 update될 customer의 point
	public Screen getScreenByNo(int screenNo);
	public PointHistoryType getType(String name);
	public PointHistoryTypeDetail getDetailHistory(int no);
}
