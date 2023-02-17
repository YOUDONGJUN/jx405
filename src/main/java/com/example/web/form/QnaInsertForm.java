package com.example.web.form;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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
public class QnaInsertForm {

	private int customerNo;
	private int qnaTypeNo;
	private int theaterNo;
	private String title;
	private String content;
	private List<MultipartFile> upfiles;
}
