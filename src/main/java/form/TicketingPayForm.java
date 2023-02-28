package form;

import lombok.Data;

@Data
public class TicketingPayForm {

    private String seat1;
    private String seat2;
    private String seat3;
    private String seat4;
    private int movieNo;
    private int screenNo;
    private String audult;
    private String audultTotal;
    private String baby;
    private String babyTotal;
    private String old;
    private String oldTotal;
    private long showScheduleNo;
    private String ticketingPay;

}
