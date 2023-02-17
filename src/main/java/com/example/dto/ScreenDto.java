package com.example.dto;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ScreenDto {

	private int screenNo;
	private String screenName;
	private int totalSeat;	//상영관이랑 조인
	private int showTypeNo;
	private String showTypeName;
	private List<ScheduleDto> scheduleList; 
}
