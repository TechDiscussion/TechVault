package TechVault.services.User.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ChangePasswordRequest {

    @NotBlank
    @Size(min = 3, max = 52)
    private String userName;

    @NotBlank
    @Size(min = 6, max = 52)
    private String password;

    @NotBlank
    @Size(min = 6, max = 52)
    private String passwordRepeat;
}
