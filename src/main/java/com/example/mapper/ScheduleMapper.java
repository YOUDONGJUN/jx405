package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.dto.ScheduleDto;

public interface ScheduleMapper {
	public List<ScheduleDto> getAllScheduleByTheaterNo(@Param("no") int no,@Param("movieNo") int movieNo, @Param("screenNo") int screenNo, @Param("showDate") String showDate);
}
