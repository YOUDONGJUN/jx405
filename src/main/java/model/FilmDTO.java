package model;

import lombok.Data;

@Data

public class FilmDTO {
    private int id;
    private String title;
    private String summary;
    private int rating;
}
