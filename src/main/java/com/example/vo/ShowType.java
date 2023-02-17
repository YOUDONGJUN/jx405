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
public class ShowType {

	private int no;
	private String name;
	private String subTitle;//자막있는지 여부
	public void setNo(int no) {
		this.no = no;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSubTitle(String subTitle) {
		if(subTitle.equals("Y")) {
			this.subTitle = "자막있음";
		} else if(subTitle.equals("N")) {
			this.subTitle = "자막없음";
		}
	}
	
}
