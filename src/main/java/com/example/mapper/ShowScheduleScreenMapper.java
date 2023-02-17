package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.dto.ShowScheduleScreenDto;
import com.example.vo.NonExistentSeat;
import com.example.vo.Region;
import com.example.vo.SpecialScreen;
import com.example.vo.TicketSeat;

@Mapper
public interface ShowScheduleScreenMapper {

	public List<ShowScheduleScreenDto> allListByMovie(int movieNo);
	public int countRegionByNo(int regionNo);
	public List<ShowScheduleScreenDto> listByTheaterNo(@Param("movieNo") int movieNo ,@Param("theaterNo") int theaterNo);
	public int getListByShowScheduleNo(long showScheduleNo);
	public int getListByscreenNo(int screenNo);
}
