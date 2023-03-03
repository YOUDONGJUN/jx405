package vo;

import lombok.Data;

import java.util.Date;

@Data
public class Qna {

    private int no;
    private int customerNo;
    private int qnaTypeNo;
    private int theaterNo;
    private String title;
    private String content;
    private Date createdDate;
    private String answered;
    private String answeredContent;
    private Date answeredDate;
}
