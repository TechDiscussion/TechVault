package TechVault.services.User;

import TechVault.services.User.model.User;
import TechVault.services.User.request.ChangePasswordRequest;
import TechVault.services.User.request.PasswordForgotRequest;
import TechVault.services.User.request.UserLoginRequest;
import TechVault.services.User.response.UserResponse;

import java.nio.file.AccessDeniedException;

public interface UserService {
    boolean register(User user);

    User fetchUser(String email) throws AccessDeniedException;

    User saveUser(User user);

    User resetUser(PasswordForgotRequest passwordForgotRequest);

    void changeUserPassword(ChangePasswordRequest changePasswordRequest);

    void confirmUser(String token);

    String loginUser(UserLoginRequest userLoginRequest);

    void logoutUser(String sessionId);

    UserResponse getUser(String sessionId);

    boolean userExistsByEmail(String email);

    boolean userExistsByUserName(String userName);

    Boolean getVerificationStatus(User user) throws AccessDeniedException;
}
