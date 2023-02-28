package model;

import lombok.Data;

import java.util.List;

@Data
public class ScreenDto {

    private int screenNo;
    private String screenName;
    private int totalSeat;    //상영관이랑 조인
    private int showTypeNo;
    private String showTypeName;
    private List<ScheduleDto> scheduleList;
}
