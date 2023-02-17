package com.example.service;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dto.MovieScheduleDto;
import com.example.dto.ShowScheduleScreenDto;
import com.example.mapper.MovieScheduleMapper;
import com.example.mapper.ShowScheduleScreenMapper;
import com.example.mapper.TheaterMapper;
import com.example.vo.NonExistentSeat;
import com.example.vo.Region;
import com.example.vo.SpecialScreen;
import com.example.vo.Theater;
import com.example.vo.TicketSeat;

@Service
@Transactional
public class MovieTicketService {

	@Autowired
	private MovieScheduleMapper movieDao;
	@Autowired
	private ShowScheduleScreenMapper showDao;
	@Autowired
	private TheaterMapper theaterDao;
	@Autowired
	private MovieScheduleMapper schedulDao;
	
	public List<ShowScheduleScreenDto> allListByMovie(int movieNo){
		return showDao.allListByMovie(movieNo);
	}
	public int countRegionByNo(int regionNo) {
		return showDao.countRegionByNo(regionNo);
	}
	public List<ShowScheduleScreenDto> listByTheaterNo(int movieNo, int theaterNo){
		return showDao.listByTheaterNo(movieNo, theaterNo);
	}
	public int getlistnonExistentSeatByScreenNo(int screenNo){
		return showDao.getListByscreenNo(screenNo);
	}
	public int getListTicketSeatByShowScheduleNo(long showScheduleNo){
		return showDao.getListByShowScheduleNo(showScheduleNo);
	}
	public List<Region> listByRegion(){
		return theaterDao.getAllRegion();
	}
	public List<Theater> listByRegionNo(int regionNo){
		return schedulDao.getAllMovieScheduler(regionNo);
	}
	}

