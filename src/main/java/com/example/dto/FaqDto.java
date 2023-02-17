package com.example.dto;

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
public class FaqDto {

	private int faqNo;
	private int questionNo;
	private String questionName;
	private String faqQuestion;
	private String faqAnswer;
}
