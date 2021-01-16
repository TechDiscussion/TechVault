package TechVault.service.user;

import TechVault.service.user.request.LoginRequest;
import TechVault.service.user.request.UserProfileCreateRequest;
import TechVault.service.user.response.ContentResponse;
import TechVault.service.user.response.LoginResponse;
import TechVault.service.user.response.UserProfileCreateResponse;
import TechVault.service.user.response.UserProfileResponse;

import java.util.UUID;

public interface UserService {
    public ContentResponse getContent(String contentID);

    public UserProfileCreateResponse createUserProfile(UserProfileCreateRequest userProfileCreateRequest);

    public LoginResponse login(LoginRequest loginRequest);

    public UserProfileResponse userProfile(String userId);
}
