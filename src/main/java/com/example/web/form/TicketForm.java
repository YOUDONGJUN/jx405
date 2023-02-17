package com.example.web.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TicketForm {
	private String showTime;
	private int showDayTypeNo;
	private int showTypeNo;
	private int screenNo;
	private int movieNo;
	private int theaterNo;
	private String day;
	private String ticketingDay;
	private long showScheduleNo;
}
