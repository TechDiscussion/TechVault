package TechVault.service.user;

import TechVault.service.user.model.BookMark;
import TechVault.service.user.model.Content;
import TechVault.service.user.model.User;
import TechVault.service.user.persistence.BookMarkDao;
import TechVault.service.user.persistence.ContentDao;
import TechVault.service.user.persistence.UserDao;
import TechVault.service.user.request.LoginRequest;
import TechVault.service.user.request.UserProfileCreateRequest;
import TechVault.service.user.response.ContentResponse;
import TechVault.service.user.response.LoginResponse;
import TechVault.service.user.response.UserProfileCreateResponse;
import TechVault.service.user.response.UserProfileResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private ContentDao contentDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private BookMarkDao bookMarkDao;

    @Override
    public ContentResponse getContent(String contentID) {
        Content content = contentDao.getContentByID(contentID);
        System.out.println("Content Response = " + content.getTitle());
        return new ContentResponse(content.getTitle(), content.getCompany(), content.getDatePosted());
    }

    @Override
    public UserProfileCreateResponse createUserProfile(UserProfileCreateRequest userProfileCreateRequest) {
        try {
            userDao.addUser(userProfileCreateRequest.getEmail(), userProfileCreateRequest.getPassword(), userProfileCreateRequest.getUserName());
            return new UserProfileCreateResponse("Created profile.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new UserProfileCreateResponse("Failed to create profile.", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        if (userDao.getUserByEmailPassword(loginRequest.getEmail(), loginRequest.getPassword())) {
            return new LoginResponse("Successful", HttpStatus.OK);
        }
        return new LoginResponse("Try again!", HttpStatus.BAD_REQUEST);
    }

    @Override
    public UserProfileResponse userProfile(String userId) {
        try {
            User user = userDao.getUserByUserId(userId);

            List<BookMark> bookMarks = bookMarkDao.getBookMarksByUserId(userId);

            List<ContentResponse> contentResponseList = new ArrayList<>();

            for (BookMark bookMark : bookMarks) {
                String contentId = bookMark.getContentId();

                Content content = contentDao.getContentByID(contentId);

                contentResponseList.add(new ContentResponse(content.getTitle(), content.getCompany(), bookMark.getPostedTime().toString()));
            }

            return new UserProfileResponse(userId, contentResponseList, HttpStatus.OK);
        } catch (Exception e) {
            return new UserProfileResponse(null, null, HttpStatus.BAD_REQUEST);
        }
    }
}
