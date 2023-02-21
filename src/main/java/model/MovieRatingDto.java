package model;

import lombok.Data;

import java.util.Date;


@Data

public class MovieRatingDto {

    private int ratingNo;
    private String ratingName;
    private String ratingImageURL;
    private int movieNo;
    private String movieName;
    private long showScheduleNo;
    private Date showScheduleStartTime;
}
