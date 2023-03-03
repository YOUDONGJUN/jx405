package vo;

import lombok.Data;

@Data
public class Faq {

    private int no;
    private int questionTypeNo;
    private String question;
    private String answer;
}
