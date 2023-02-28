package model;

import lombok.*;

@Data
public class ResponseDto<T> {

    private boolean status;    // true면 성공
    private String error;
    private T items;
}
