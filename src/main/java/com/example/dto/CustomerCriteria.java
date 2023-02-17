package com.example.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class CustomerCriteria {
	@Setter
	private String find;	// "id" 또는 "password"
	@Setter
	private String id;
	@Setter
	private String name;
	@Setter
	private String phoneNumber;
	private Date birthDate;
	
	// 매개변수의 String 값을 Date로 변환해서 필드에 저장한다.
	public void setBirthDate(String birthDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		this.birthDate = sdf.parse(birthDate);
	}
}
