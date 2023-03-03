package vo;

import lombok.Data;

@Data
public class Screen {

    private int no;
    private int theaterNo;
    private int specialScreenNo;
    private String name;
    private String totalSeatRow;
    private int totalSeatColumn;
    private int totalSeat;
}
