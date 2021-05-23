package TechVault.services.User.response;

import lombok.Data;

@Data
public class UserResponse {
    private String userName;
    private Integer emailVerified;

    public UserResponse(String userName, Integer emailVerified) {
        this.userName = userName;
        this.emailVerified = emailVerified;
    }
}
