package TechVault.services.comments.controller;

import java.util.List;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import TechVault.services.comments.CommentService;
import TechVault.services.comments.model.CommentResponse;

@Controller
@RequestMapping("comment")
public class CommentController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentService commentService;

    /**
     * To the the profile of the user corresponding to the user id.
     * @return A Response entity which will have all the user details.
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value = "/{contentId}")
    public ResponseEntity<?> getComments(@PathVariable String contentId) {
        List<CommentResponse> comments = null;
        try {
            comments = commentService.getComments(contentId);
        } catch (Exception e) {
            LOGGER.error("Unable to get comments ", e);
            return new ResponseEntity<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

    /**
     * To the the profile of the user corresponding to the user id.
     * @return A Response entity which will have all the user details.
     */
    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/postComment", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postComment(@RequestBody String commentJson) {

        JsonObject commentBody =  JsonParser.parseString(commentJson).getAsJsonObject();
        try {
            commentService.addComment(commentBody.get("contentId").getAsString(),
                commentBody.get("parentCommentId").getAsString(),
                commentBody.get("userName").getAsString(),
                commentBody.get("comment").getAsString());
        } catch (Exception e) {
            LOGGER.error("Error while posting comments", e);
            return new ResponseEntity<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

}
