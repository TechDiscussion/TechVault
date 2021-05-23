package TechVault.services.User.request;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserLoginRequest {

    @Size(min = 3, max = 52)
    private String email;

    @Size(min = 3, max = 52)
    private String userName;

    @NotBlank
    @Size(min = 6, max = 52)
    private String password;
}
