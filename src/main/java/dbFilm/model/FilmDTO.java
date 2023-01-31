package dbFilm.model;

import lombok.Data;

@Data
public class FilmDTO {
    private int film_id;
    private String title;
    private String description;
    private int release_year;
    private int rental_duration;
    private double rental_rate;
    private int length;
    private String special_features;

}
