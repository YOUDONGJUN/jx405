package com.example.mapper;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.dto.ScreenDto;

public interface ScreenScheduleMapper {
	public List<ScreenDto> getAllScreenByTheaterNo(@Param("no") int theaterNo, @Param("movieNo") int movieNo, @Param("showDate")String showDate);  
}
