package form;

import lombok.Data;

import java.util.List;

@Data
public class ReviewEditForm {

    private long no;
    private int movieNo;
    private int reviewScore;
    private String reviewContent;
    private List<Integer> pointNo;
}
