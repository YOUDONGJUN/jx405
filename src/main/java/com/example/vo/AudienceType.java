package com.example.vo;

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
public class AudienceType {

	private int no;
	private String name;
	public void setNo(int no) {
		this.no = no;
	}
	public void setName(String name) {

		if(name.equals("ADULT")) {
			this.name = "성인";
		} else if(name.equals("YOUTH")) {
			this.name = "청소년";
		} else if(name.equals("OLD_MAN")) {
			this.name = "우대";
		}
	}
	
}
