package TechVault.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("user")
public class UserInterface {

    /**
     * To the the profile of the user corresponding to the user id.
     * @return A Response entity which will have all the user details.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{user_id}")
    public ResponseEntity<?> getUserProfile() {
        return null;
    }
}
