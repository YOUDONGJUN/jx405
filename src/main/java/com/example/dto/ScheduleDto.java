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
public class ScheduleDto {
	
	private long showScheduleNo;	//상영번호
	private int timeNo;	//상영회차
	private int showTypeNo;	//상영타입번호
	private int showTypeName;	//상영타입번호
	private Date startTime;	//시작시간
	private Date endTime;	//끝시간
}
