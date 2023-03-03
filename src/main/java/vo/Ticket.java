package vo;

import lombok.Data;

import java.util.Date;

@Data
public class Ticket {

    private long no;
    private long customerNo;
    private long showScheduleNo;
    private long ticketTotalAmount;
    private long ticketUsedPoint;
    private long ticketExpectedEarningPoint;
    private Date ticketCreatedDate;
    private String ticketCancled;
    private Date ticketCanlledDate;

}
