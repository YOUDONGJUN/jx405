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
public class FaqCriteria {

	private int page;
	private String option;
	private String keyword;
	private int beginIndex;
	private int endIndex;
}
