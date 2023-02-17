package com.example.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Setter
public class MovieScheduleDto {

	private long showScheDuleNo;
	private int screenNo;
	private int movieNo;
	private int showTypeNo;
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="HH:mm", timezone="Asia/Seoul")
	private Date showScheduleStartTime;
	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="HH:mm", timezone="Asia/Seoul")
	private Date showScheduleEndTime;
	private int theaterNo;
	private String screenName;
	private String screenTotalSeatRow;
	private int sceenTotalSeatCoulumn;
	private int screenTotalSeat;
	private String nonexistentSeatNo;
	
}
