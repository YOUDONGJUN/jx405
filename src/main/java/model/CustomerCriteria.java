package model;

import lombok.Data;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class CustomerCriteria {
    @Setter
    private String find;    // "id" 또는 "password"
    @Setter
    private String id;
    @Setter
    private String name;
    @Setter
    private String phoneNumber;
    private Date birthDate;

    // 매개변수의 String 값을 Date로 변환해서 필드에 저장한다.
    public void setBirthDate(String birthDate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        this.birthDate = sdf.parse(birthDate);
    }
}
