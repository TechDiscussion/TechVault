package TechVault.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Validated
@RestController
@RequestMapping("v1/home")
public class HomeInterface {
    /**
     * To get the home page sorted by likes in descending order.
     * @return A Response entity which will have all the blogs to be loaded as home page.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/liked")
    public ResponseEntity<?> getTopLiked() {
        return null;
    }

    /**
     * To get the home page sorted by number of discussions in descending order.
     * @return A Response entity which will have all the blogs to be loaded as home page.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/discussed")
    public ResponseEntity<?> getTopDiscussed() {
        return null;
    }


    /**
     * To get the latest home page.
     * @return A Response entity which will have all the blogs to be loaded as home page.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/latest")
    public ResponseEntity<?> getLatest() {
        return null;
    }

    /**
     * To get the trending home page.
     * @return A Response entity which will have all the blogs to be loaded as home page.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/discussed")
    public ResponseEntity<?> getTrending() {
        return null;
    }
}
