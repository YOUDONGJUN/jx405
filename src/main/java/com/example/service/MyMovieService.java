package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mapper.MyMovieMapper;
import com.example.vo.MyMovie;

@Service
@Transactional
public class MyMovieService {

	@Autowired
	private MyMovieMapper myMovieMapper;
	
	public MyMovie upLike(int customerNo, int movieNo) {
		
		MyMovie liker = new MyMovie();
		liker.setCustomerNo(customerNo);
		liker.setMovieNo(movieNo);
		
		myMovieMapper.saveLike(liker);
		myMovieMapper.upLike(movieNo);
		
		return liker;
	}
	
	public MyMovie downLike(int customerNo, int movieNo) {
		MyMovie liker = new MyMovie();
		liker.setCustomerNo(customerNo);
		liker.setMovieNo(movieNo);
		
		myMovieMapper.deleteLike(liker);
		myMovieMapper.downLike(movieNo);
		
		return liker;
	}
	
	public int getLikeCount(int movieNo) {
		return myMovieMapper.getLikeCount(movieNo);
	}
	
	public List<MyMovie> getMyMovies(int customerNo) {
		return myMovieMapper.getMyMovies(customerNo);
	}
}
