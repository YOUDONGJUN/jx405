package form;

import lombok.Data;

import java.util.List;

@Data
public class TicketNoForm {

    private long showScheduleNo;
    private int movieNo;
    private int customerNo;
    private long ticketNo;
    private List<String> seatList;
    private long movieAudienceTotalNumber;
}
