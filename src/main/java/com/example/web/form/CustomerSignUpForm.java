package com.example.web.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerSignUpForm {
	private String id;
	private String password;
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthDate;
	private String phoneNumber;
	private String email;
}
