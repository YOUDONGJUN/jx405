package vo;

import lombok.Data;

import java.util.Date;

@Data
public class Customer {
    private Integer no;
    private Integer gradeNo;
    private String id;
    private String password;
    private String name;
    private String phoneNumber;
    private String email;
    private String streetAddress;
    private Date birthDate;
    private Integer currentPoint;
    private Date createdDate;
    private String deleted;    // "Y"이면 삭제된 고객, "N"이면 정상 고객
    private Date deletedDate;
}
