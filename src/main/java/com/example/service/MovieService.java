package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mapper.MovieMapper;
import com.example.vo.Movie;

@Service
public class MovieService {

	@Autowired
	private MovieMapper movieMapper;
	
	public Movie getLikeCount(int movieNo) {
		return movieMapper.getMovieLikeCount(movieNo);
	}
	
	public List<Movie> getTop4() {
		return movieMapper.getTop4();
	}
	
	public String getSalesRating(int movieNo) {
		int totalAudience = movieMapper.getTotalAudience();
		int movieAudience = movieMapper.getAudienceCountByMovieNo(movieNo);
		
		double rating = (double) movieAudience * 100 / totalAudience;
		String formattedRating = String.format("%.1f", rating);
		
		return formattedRating;
	}
	
	public int getTotalAudience(int movieNo) {
		return movieMapper.getAudienceCountByMovieNo(movieNo);
	}
}
