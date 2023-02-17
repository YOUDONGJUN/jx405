package com.example.web.form;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewEditForm {

	private long no;
	private int movieNo;
	private int reviewScore;
	private String reviewContent;
	private List<Integer> pointNo;
}
