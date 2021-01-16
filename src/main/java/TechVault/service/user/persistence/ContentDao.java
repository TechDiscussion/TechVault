package TechVault.service.user.persistence;

import TechVault.service.user.model.Content;

import java.util.UUID;

public interface ContentDao {

    public Content getContentByID(String contentID);
}