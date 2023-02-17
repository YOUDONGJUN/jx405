package com.example.web.form;

import java.util.List;

import com.example.vo.AudienceType;
import com.example.vo.FeeType;
import com.example.vo.ShowDayType;
import com.example.vo.ShowStartTimeType;
import com.example.vo.Ticket;
import com.example.vo.TicketAudience;
import com.example.vo.TicketSeat;

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
public class TicketingPayForm {

	private ShowDayType showDayByForm;
	private ShowStartTimeType startTimesByForm;
	private List<TicketAudience> ticketAudienceKindByForm;
	private String seat1;
	private String seat2;
	private String seat3;
	private String seat4;
	private int movieNo;
	private int screenNo;
	private String audult;
	private String audultTotal;
	private String baby;
	private String babyTotal;
	private String old;
	private String oldTotal;
	private long showScheduleNo;
	private String ticketingPay;
	
}
