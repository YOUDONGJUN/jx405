package com.example.web.form;

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
public class Criteria {

	private int page;
	private int movieNo;
	private String option;
	private int beginIndex;
	private int endIndex;
}
