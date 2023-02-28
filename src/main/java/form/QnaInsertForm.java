package form;

import lombok.Data;

@Data
public class QnaInsertForm {

    private int customerNo;
    private int qnaTypeNo;
    private int theaterNo;
    private String title;
    private String content;
}
