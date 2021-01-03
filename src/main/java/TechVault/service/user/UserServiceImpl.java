package TechVault.service.user;

import TechVault.service.user.model.Content;
import TechVault.service.user.persistence.ContentDao;
import TechVault.service.user.response.ContentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private ContentDao contentDao;

    @Override
    public ContentResponse getContent(String contentID) {
        Content content = contentDao.getContentByID(contentID);
        System.out.println("Content Response = " + content.getTitle());
        return new ContentResponse(content.getTitle(), content.getCompany(), content.getDatePosted(), HttpStatus.OK);
    }
}
