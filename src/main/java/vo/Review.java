package vo;

import lombok.Data;

import java.util.Date;

@Data
public class Review {

    private long no;
    private int customerNo;
    private int movieNo;
    private int reviewScore;
    private String reviewContent;
    private Date createdDate;
}
