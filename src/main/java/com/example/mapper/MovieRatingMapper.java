package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.dto.MovieRatingDto;

@Mapper
public interface MovieRatingMapper {
	
	public List<MovieRatingDto> getAllList();
	public MovieRatingDto getAllListByMovieNo(int movieNo);
}
