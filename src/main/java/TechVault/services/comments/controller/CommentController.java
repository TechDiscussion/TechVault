package TechVault.services.comments.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import TechVault.services.comments.CommentService;

@Validated
@RestController
@RequestMapping("comment")
public class CommentController {
    private static final Logger logger = LoggerFactory.getLogger("SampleLogger");

    @Autowired
    private CommentService commentService;

    /**
     * To the the profile of the user corresponding to the user id.
     * @return A Response entity which will have all the user details.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{blog_id}")
    public ResponseEntity<?> getCommentsForBlog() {
        HttpHeaders responseHeaders = new HttpHeaders();
        //CommentResponse cr =  new CommentResponse(UUID.randomUUID(), UUID.randomUUID(),(long) 123, new Timestamp(System.currentTimeMillis()));
        return new ResponseEntity<>( HttpStatus.OK);
    }

    /**
     * To the the profile of the user corresponding to the user id.
     * @return A Response entity which will have all the user details.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/postComment", produces =  MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> postComment(@RequestBody String commentJson) {
        //contentId, String parentCommentId, String userName, String comment
        JsonObject commentBody =  JsonParser.parseString(commentJson).getAsJsonObject();
        try {
            commentService.addComment(commentBody.get("contentId").getAsString(),
                commentBody.get("parentCommentId").getAsString(),
                commentBody.get("userName").getAsString(),
                commentBody.get("comment").getAsString());
        } catch (Exception e) {
            logger.error("Error while posting comments", e);
            return new ResponseEntity<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public ResponseEntity<?> test() {
        HttpHeaders responseHeaders = new HttpHeaders();
        //CommentResponse cr =  new CommentResponse(UUID.randomUUID(), UUID.randomUUID(),(long) 123, new Timestamp(System.currentTimeMillis()));
        return new ResponseEntity<>( "Hitting", HttpStatus.OK);
    }
}
