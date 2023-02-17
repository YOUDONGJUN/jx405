package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.vo.Movie;

@Mapper
public interface MovieMapper {

	Movie getMovieLikeCount(int movieNo);
	List<Integer> getAllMovieNo();
	List<Movie> getTop4();
	int getTotalAudience();
	int getAudienceCountByMovieNo(int movieNo);
}
