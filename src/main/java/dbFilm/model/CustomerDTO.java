package dbFilm.model;


import lombok.Data;

import java.sql.Date;

@Data
public class CustomerDTO {
    private int customer_id;
    private int store_id;
    private String first_name;
    private String last_name;
    private String email;
    private int address_id;
    private Date create_date;
    private Date last_update;

}
