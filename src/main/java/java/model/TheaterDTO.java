package java.model;

public class TheaterDTO {

    private int theaterId;
    private String theaterName;
    private String location;
    private String number;

    public TheaterDTO() {

    }

    public TheaterDTO(int theaterId) {
        this.theaterId = theaterId;
    }

    public TheaterDTO(TheaterDTO origin) {
        this.theaterId = origin.theaterId;
        this.theaterName = origin.theaterName;
        this.location = origin.location;
        this.number = origin.number;
    }

    public int getId() {
        return theaterId;
    }

    public void setId(int id) {
        this.theaterId = theaterId;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean equals(TheaterDTO o) {
        if (o instanceof TheaterDTO) {
            TheaterDTO t = (TheaterDTO) o;
            return theaterId == t.theaterId;
        }
        return false;
    }
}
