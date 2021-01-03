package TechVault.service.user;

import TechVault.service.user.response.ContentResponse;

import java.util.UUID;

public interface UserService {
    public ContentResponse getContent(String contentID);
}
