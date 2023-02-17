package com.example.web.form;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class TicketAdienceTypeForm {

	private long ticketNo;
	private int audienceTypeNo;
}
