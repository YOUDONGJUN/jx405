package com.example.service;

import java.text.DateFormat;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.MovieRatingDto;
import com.example.dto.MovieScheduleDto;
import com.example.dto.ShowScheduleScreenDto;
import com.example.exception.MovieTicketingErrorException;
import com.example.mapper.MovieRatingMapper;
import com.example.mapper.ShowFormMapper;
import com.example.vo.AudienceType;
import com.example.vo.FeeType;
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

@Service
@Transactional
public class MovieRatingService {

	@Autowired
	private MovieRatingMapper movieRatingDto;
	@Autowired
	private ShowFormMapper showDto;
	
	public List<MovieRatingDto> getAllList(){
		return movieRatingDto.getAllList();
	}
	public MovieRatingDto getListByMovieNo(int movieNo) {
		return movieRatingDto.getAllListByMovieNo(movieNo);
	}
	public List<ShowStartTimeType> getStartTimeType(String starTime) {
		return showDto.getStartTimeType(starTime);
	}
	public ShowDayType getShowDayType(String name) {
		return showDto.getShowDayType(name);
	}
	public MovieScheduleDto getScheduleList(ScreenListInsertForm form) {
		MovieScheduleDto movies = showDto.getScheduleList(form);
			return movies;
	}
	public List<MovieScheduleDto> getSeatAllscreenNo(int screenNo, int theaterNo){
		List<MovieScheduleDto> movies =  showDto.getSeatAllscreenNo(screenNo, theaterNo);
		if(movies == null) {
			throw new MovieTicketingErrorException("해당 영화에 좌석이 존재하지 않습니다.");
		} else {
			return movies;
		}
	}
	public List<ShowScheduleScreenDto> getScreenDayAllMovieNo(int movieNo, int showTypeNo){
		List<ShowScheduleScreenDto> schedules = showDto.getScreenDayAllMovieNo(movieNo, showTypeNo);
		if(schedules == null) {
			throw new MovieTicketingErrorException("해당 시간표가 존재하지 않습니다. ");
		} else {
			return schedules;
		}
	}
	public List<AudienceType> getAudienceType(int ratingNo){
		if(ratingNo == 5) {
			return showDto.getExceptAudienceType(2);
		} else {
			return showDto.getAudienceType();
		}
		
	}
	public ShowType getShowTypeByNo(int showType) {
		return showDto.getShowTypeByShowTypeNo(showType);
	}
	public Screen getScreenByNo(int screenNo, int theaterNo) {
		return showDto.getScreenByNo(screenNo, theaterNo);
	}
	public List<NonExistentSeat> getNonExistentSeat(int screenNo){
		return showDto.getNonExistentSeat(screenNo);
	}
	public List<ShowSchedule> getShowScheduleByNo(int movieNo, int screenNo, int showTypeNo) {
		List<ShowSchedule> schedule = new ArrayList<>();
		List<ShowSchedule>  array = showDto.getShowSchduleByNo(movieNo, screenNo, showTypeNo);
		 for(ShowSchedule sc : array) {
			  DateFormat dateFormat = new SimpleDateFormat("HH:mm");
			  String startTime = dateFormat.format(sc.getStartTime());
			  int time = Integer.parseInt(startTime);
			  LocalTime now = LocalTime.now();
			  int hour = now.getHour();
			 if(time>=hour) {
				 schedule.add(sc);
			 } 
		  }
		 return schedule;
	}
	public List<TicketSeat> getTicketNoByScheduleNo(TicketNoForm form) {
		return showDto.getTicketNoByScheduleNo(form);
	}
}
