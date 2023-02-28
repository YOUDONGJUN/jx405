package form;

import lombok.Data;

@Data
public class TicketForm {
    private String showTime;
    private int showDayTypeNo;
    private int showTypeNo;
    private int screenNo;
    private int movieNo;
    private int theaterNo;
    private String day;
    private String ticketingDay;
    private long showScheduleNo;
}
