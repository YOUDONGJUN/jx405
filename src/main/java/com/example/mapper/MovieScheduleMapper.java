package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.dto.MovieScheduleDto;
import com.example.vo.Theater;

public interface MovieScheduleMapper {

	public List<Theater> getAllMovieScheduler(int regionNo);
	
}
