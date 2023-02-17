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
public class PointHistory {

	private Date pointHistoryDate;
	private long customerNo;
	private int pointHistoryTypeDetailNo;
	private long pointHistoryPoint;
}
