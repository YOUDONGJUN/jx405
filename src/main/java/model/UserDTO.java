package model;

import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    private String userId;
    private String password;
    private String name;
    private Date birthDate;
    private String phoneNumber;
    private String email;


//    private String username;
//    private String password;
//    private String nickname;
//    private int level;
}