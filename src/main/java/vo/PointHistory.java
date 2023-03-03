package vo;

import lombok.Data;

import java.util.Date;

@Data
public class PointHistory {

    private Date pointHistoryDate;
    private long customerNo;
    private int pointHistoryTypeDetailNo;
    private long pointHistoryPoint;
}
