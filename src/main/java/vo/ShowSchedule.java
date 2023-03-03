package vo;

import lombok.Data;

import java.util.Date;

@Data
public class ShowSchedule {

    private long no;
    private int screenNo;
    private int movieNo;
    private int showTypeNo;
    private Date StartTime;
    private Date EndTime;
    private int TimeNo;
}
