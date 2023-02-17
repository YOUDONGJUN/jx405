package com.example.mapper;




import java.util.List;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.dto.MovieScheduleDto;
import com.example.dto.ShowScheduleScreenDto;
import com.example.vo.AudienceType;
import com.example.vo.NonExistentSeat;
import com.example.vo.Screen;
import com.example.vo.ShowDayType;
import com.example.vo.ShowSchedule;
import com.example.vo.ShowStartTimeType;
import com.example.vo.ShowType;
import com.example.vo.Ticket;
import com.example.vo.TicketSeat;
import com.example.web.form.ScreenListInsertForm;
import com.example.web.form.TicketNoForm;

@Mapper
public interface ShowFormMapper {

	public List<ShowStartTimeType> getStartTimeType(String starTime);
	public ShowDayType getShowDayType(String name);
	public MovieScheduleDto getScheduleList(ScreenListInsertForm form);
	public List<MovieScheduleDto> getSeatAllscreenNo(@Param("screenNo")int screenNo,@Param("theaterNo") int theaterNo);	//스크린번호로 조회하는 상영관 빈좌석과 상영관의 행과 열
	public List<ShowScheduleScreenDto> getScreenDayAllMovieNo(@Param("movieNo") int movieNo, @Param("showTypeNo") int showTypeNo); // 영화관 번호화 상영번호로 조회하는 상영시간표 
	//public List<TicketSeat> getTicketSeatByTicketNo(int ticketNo);//티켓번호로 조회하는 예약만료한좌석
	//public List<Ticket> getAllTicketByShowScheduleNo(int schedultNo, int customerNo);//손님번호와 스케쥴번호로 조회하는 티켓정보
	public List<AudienceType> getAudienceType(); //관람등급을 조회함
	public List<AudienceType> getExceptAudienceType(int audienceTypeNo);//관람등급을 제외하고 조회한다. 
	public ShowType getShowTypeByShowTypeNo(int showTypeNo);//상영관정보를 조회한다. 
	public Screen getScreenByNo(int screenNo, int theaterNo);//상영관좌석을 조회한다.
	public List<NonExistentSeat> getNonExistentSeat(int screenNo);//빈좌석을 조회한다. 
	public List<TicketSeat> getTicketNoByScheduleNo(TicketNoForm form);//스케쥴번호를 이용하여 티켓번호를 조회한다.
	public List<ShowSchedule> getShowSchduleByNo(int movieNo, int screenNo, int showTypeNo);//상영스케쥴에 대해서 조회한다.
}
