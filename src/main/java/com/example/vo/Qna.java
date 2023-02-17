package com.example.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Qna {

	private int no;
	private int customerNo;
	private int qnaTypeNo;
	private int theaterNo;
	private String title;
	private String content;
	private Date createdDate;
	private String answered;
	private String answeredContent;
	private Date answeredDate;
}
