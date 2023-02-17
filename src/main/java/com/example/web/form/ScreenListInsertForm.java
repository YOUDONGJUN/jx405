package com.example.web.form;

import java.util.Date;

import org.springframework.util.StringUtils;

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
public class ScreenListInsertForm {

	private String ticketingDay;//날짜와 글자
	private int ticketingsDay;//날짜
	private int movieNo;//영화 번호 
	private String day;////날짜와 글자
	private int theaterNo;//극장 번호 
	private String time;//시간
	private int ratingNo;
	private int screenNo;
	private int regionNo;
	private int showTypeNo;
	private int dayNo;//요일 번호 
	private long showScheduleNo;
}
