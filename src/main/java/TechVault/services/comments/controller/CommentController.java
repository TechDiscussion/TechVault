package TechVault.services.comments.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@Validated
@RestController
@RequestMapping("comment")
public class CommentController {

    /**
     * To the the profile of the user corresponding to the user id.
     * @return A Response entity which will have all the user details.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{blog_id}")
    public ResponseEntity<?> getCommentsForBlog() {
        HttpHeaders responseHeaders = new HttpHeaders();
        //CommentResponse cr =  new CommentResponse(UUID.randomUUID(), UUID.randomUUID(),(long) 123, new Timestamp(System.currentTimeMillis()));
        return new ResponseEntity<>(cr, HttpStatus.OK);
    }

    /**
     * To the the profile of the user corresponding to the user id.
     * @return A Response entity which will have all the user details.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/{blog_id}")
    public ResponseEntity<?> postCommentsForBlog() {
        HttpHeaders responseHeaders = new HttpHeaders();
        List<String> x = new ArrayList<>();
        x.add("asdasd");
        x.add("1121e");
        return new ResponseEntity<>(x, responseHeaders, HttpStatus.OK);
    }
}
