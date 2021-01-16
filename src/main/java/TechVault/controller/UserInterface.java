package TechVault.controller;

import TechVault.service.user.UserService;
import TechVault.service.user.request.LoginRequest;
import TechVault.service.user.request.UserProfileCreateRequest;
import TechVault.service.user.response.ContentResponse;
import TechVault.service.user.response.LoginResponse;
import TechVault.service.user.response.UserProfileCreateResponse;
import TechVault.service.user.response.UserProfileResponse;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("user")
public class UserInterface {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/{contentID}")
    public ResponseEntity<?> getContent(@PathVariable String contentID) {
        System.out.println("Entering get Content");
        ContentResponse contentResponse = userService.getContent(contentID);
        System.out.println("Content Response = " + contentResponse.getTitle());
        return new ResponseEntity<>(contentResponse, HttpStatus.OK);
    }

    /**
     * To the the profile of the user corresponding to the user id.
     * @return A Response entity which will have all the user details.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{user_id}")
    public ResponseEntity<?> getUserProfile(@PathVariable String userID) {
        UserProfileResponse userProfileResponse = userService.userProfile(userID);
        return new ResponseEntity<>(userProfileResponse, userProfileResponse.getStatus());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/createProfile", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createUserProfile(@RequestBody UserProfileCreateRequest userProfileRequest) {
        UserProfileCreateResponse userProfileCreateResponse = userService.createUserProfile(userProfileRequest);
        return new ResponseEntity<>(userProfileCreateResponse, userProfileCreateResponse.getStatus());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        LoginResponse loginResponse = userService.login(loginRequest);
        return new ResponseEntity<>(loginResponse, loginResponse.getStatus());
    }
}
