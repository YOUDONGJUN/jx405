package com.example.dto;

import java.util.List;

import com.example.vo.ReviewPointType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDto {

	private long reviewNo;
	private String customerId;
	private List<ReviewPointType> reviewPoints;
	private int reviewScore;
	private String reviewContent;
}
