package model;

import lombok.Data;

@Data
public class ShowScheduleScreenDto {

    private int movieNo;
    private int theaterNo;
    private int screenNo;
    private String screenName;
    private int screenTotalSeat;
    private int regionNo;
    private String regionName;
    private String theaterName;
    private int specialScreenNo;
    private long showScheduleNo;
    private String specialScreenName;
    private int showScheduleTimeNo;
    private int movieRatingNo;
    private String movieRatingName;
    private String movieName;
    private int showTypeNo;
    private String showTypeName;
    private String showTypeSubTitle;
    private int screenTotalSeatRow;
    private int sceenTotalSeatCoulumn;
    private int reservableSeat;
    private int realTotalSeat;

}
