package TechVault.services.User.response;

import lombok.Data;

@Data
public class UserResponse {
    private String email;
    private String userName;
    private Integer emailVerified;
}
