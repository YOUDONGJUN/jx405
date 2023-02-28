package form;

import lombok.Data;

@Data
public class CustomerSignUpForm {
    private String id;
    private String password;
    private String name;
    private String phoneNumber;
    private String email;
}
