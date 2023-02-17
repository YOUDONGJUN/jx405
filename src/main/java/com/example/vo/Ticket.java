package com.example.vo;

import java.util.Date;

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
public class Ticket {

	private long no;
	private long customerNo;
	private long showScheduleNo;
	private long ticketTotalAmount;
	private long ticketUsedPoint;
	private long ticketExpectedEarningPoint;
	private Date ticketCreatedDate;
	private String ticketCancled;
	private Date ticketCanlledDate;
	
}
