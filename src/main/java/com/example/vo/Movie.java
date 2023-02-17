package com.example.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

	private int no;
	private int movieRatingNo;
	private String movieName;
	private int movieAudienceTotalNumber;
	private int likeCount;
}
