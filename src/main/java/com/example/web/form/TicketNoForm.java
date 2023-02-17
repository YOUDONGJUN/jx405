package com.example.web.form;

import java.util.List;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TicketNoForm {

	private long showScheduleNo;
	private int movieNo;
	private int customerNo;
	private long ticketNo;
	private List<String> seatList;
	private long movieAudienceTotalNumber;
}
