package dbFilm.model;

import lombok.Data;

@Data
public class StaffDTO {

    private int staff_id;
    private String username;
    private String password;
    private int address_id;
    private int store_id;

}
