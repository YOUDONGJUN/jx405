package com.example.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowSchedule {

	private long no;
	private int screenNo;
	private int movieNo;
	private int showTypeNo;
	private Date StartTime;
	private Date EndTime;
	private int TimeNo;
}
