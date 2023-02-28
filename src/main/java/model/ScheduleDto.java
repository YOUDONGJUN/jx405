package model;

import lombok.Data;

import java.util.Date;

@Data
public class ScheduleDto {

    private long showScheduleNo;    //상영번호
    private int timeNo;    //상영회차
    private int showTypeNo;    //상영타입번호
    private int showTypeName;    //상영타입번호
    private Date startTime;    //시작시간
    private Date endTime;    //끝시간
}
