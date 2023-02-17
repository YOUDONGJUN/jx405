package com.example.vo;

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
public class Screen {

	private int no;
	private int theaterNo;
	private int specialScreenNo;
	private String name;
	private String totalSeatRow;
	private int totalSeatColumn;
	private int totalSeat;
}
