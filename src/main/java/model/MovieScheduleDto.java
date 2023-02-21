package model;

import lombok.Data;

import java.util.Date;

@Data
public class MovieScheduleDto {

    private long showScheDuleNo;
    private int screenNo;
    private int movieNo;
    private int showTypeNo;
    private Date showScheduleStartTime;
    private Date showScheduleEndTime;
    private int theaterNo;
    private String screenName;
    private String screenTotalSeatRow;
    private int screenTotalSeatCoulumn;
    private int screenTotalSeat;
    private String nonexistentSeatNo;

}
