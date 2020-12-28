package TechVault.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("update")
public class Updation {
    /**
     * To post a single like by a user.
     * @return A Response entity which will have the response.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/like")
    public ResponseEntity<?> postLike() {
        return null;
    }

    /**
     * To post a single comment by a user.
     * @return A Response entity which will have the response.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/comment")
    public ResponseEntity<?> postComment() {
        return null;
    }

    /**
     * To post a single bookmark by a user.
     * @return A Response entity which will have the response.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/bookmark")
    public ResponseEntity<?> postBookMark() {
        return null;
    }
}
