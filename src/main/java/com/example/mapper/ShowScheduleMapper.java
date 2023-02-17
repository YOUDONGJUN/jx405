package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.dto.ScheduleDto;
import com.example.dto.ShowDto;
import com.example.dto.ShowScheduleDto;

public interface ShowScheduleMapper {
	List<ShowDto> getAllScheduleByTheaterNo(@Param("no")int no, @Param("showDate")String showDate);
	
	
}
