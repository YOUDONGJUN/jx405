package com.example.web.restcontroller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.annotation.LoginedUser;
import com.example.dto.ResponseDto;
import com.example.exception.ErrorException;
import com.example.service.MyMovieService;
import com.example.vo.Customer;
import com.example.vo.MyMovie;

@RestController
@RequestMapping("/rest")
public class MyMovieRestController {

	@Autowired
	private MyMovieService myMovieService;
	
	@PostMapping("/like")
	public ResponseDto<Map<String, Object>> like(@LoginedUser Customer customer, int movieNo) {
		
		if (customer == null) {
			throw new ErrorException("로그인이 필요한 서비스입니다.");
		}
		
		ResponseDto<Map<String, Object>> response = new ResponseDto<>();
		
		MyMovie liker = myMovieService.upLike(customer.getNo(), movieNo);
		int likeCount = myMovieService.getLikeCount(movieNo);
		
		response.setStatus(true);
		response.setItems(Map.of("liker", liker, "likeCount", likeCount));
		
		return response;
	}
	
	@DeleteMapping("/like")
	public ResponseDto<Map<String, Object>> delete(@LoginedUser Customer customer, int movieNo) {

		ResponseDto<Map<String, Object>> response = new ResponseDto<>();
		
		MyMovie liker = myMovieService.downLike(customer.getNo(), movieNo);
		int likeCount = myMovieService.getLikeCount(movieNo);
		
		response.setStatus(true);
		response.setItems(Map.of("liker", liker, "likeCount", likeCount));
		
		return response;
	}
	
	@GetMapping("/myMovies") 
	public ResponseDto<List<MyMovie>> myMovies(@LoginedUser Customer customer) {
		
		ResponseDto<List<MyMovie>> response = new ResponseDto<>();
		List<MyMovie> movies = myMovieService.getMyMovies(customer.getNo());
		
		if (movies == null) {
			response.setStatus(false);
			return response;
		}
		
		response.setStatus(true);
		response.setItems(movies);
		
		return response;
	}
}
