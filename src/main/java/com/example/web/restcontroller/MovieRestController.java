package com.example.web.restcontroller;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ResponseDto;
import com.example.service.MovieService;
import com.example.vo.Movie;

@RestController
@RequestMapping("/rest")
public class MovieRestController {

	@Autowired
	private MovieService movieService;
	
	@GetMapping("/count")
	public Movie likeCount(int movieNo) {
		return movieService.getLikeCount(movieNo);
	}
	
	@GetMapping("/top4")
	public List<Movie> getTop4() {
		return movieService.getTop4();
	}
	
	@GetMapping("rating")
	public ResponseDto<Map<String, Object>> getRating(int movieNo) {
		ResponseDto<Map<String, Object>> response = new ResponseDto<Map<String, Object>>();
		
		String SalesRating = movieService.getSalesRating(movieNo);
		int totalAudience = movieService.getTotalAudience(movieNo);
		
		response.setStatus(true);
		response.setItems(Map.of("rating", SalesRating, "totalAudience", totalAudience));
		
		return response;
	}
}
