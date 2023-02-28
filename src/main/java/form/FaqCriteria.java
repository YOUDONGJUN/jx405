package form;

import lombok.Data;

@Data
public class FaqCriteria {

    private int page;
    private String option;
    private String keyword;
    private int beginIndex;
    private int endIndex;
}
