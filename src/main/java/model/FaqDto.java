package model;

import lombok.Data;

@Data
public class FaqDto {

    private int faqNo;
    private int questionNo;
    private String questionName;
    private String faqQuestion;
    private String faqAnswer;
}
