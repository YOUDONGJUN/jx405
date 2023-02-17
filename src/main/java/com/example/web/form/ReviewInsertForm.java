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
public class ReviewInsertForm {

	private int customerNo;
	private int movieNo;
	private int reviewScore; // 점수
	private String reviewContent; // 관람평 내용
	private List<Integer> pointNo; // 관람포인트 두 개 (하나여도 상관 없음)
}
