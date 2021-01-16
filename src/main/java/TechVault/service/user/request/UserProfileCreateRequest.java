package TechVault.service.user.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserProfileCreateRequest {
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String userName;
}
