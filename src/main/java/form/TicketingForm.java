package form;

import lombok.Data;

@Data
public class TicketingForm {

    private String ticketingPay;
    private int showNo;
    private String adult;
    private String adultCount;
    private String baby;
    private String babyCount;
    private String old;
    private String oldCount;
    private String[] seats;
    private long showScheDuleNo;
    private int screenNo;
    private int movieNo;
    private int showTypeNo;
    private String showScheduleStartTime;
    private int theaterNo;
    private String seat1;
    private String seat2;
    private String seat3;
    private String seat4;
    private String date;
    private String dayName;

    public void setShowNo(int showNo) {
        this.showNo = showNo;
    }

    public void setSeats(String[] seats) {
        this.seats = seats;
        this.seat1 = seats[0];
        this.seat2 = seats[1];
        this.seat3 = seats[2];
        this.seat4 = seats[3];
    }


}
