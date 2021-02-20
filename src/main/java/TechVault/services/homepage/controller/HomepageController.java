package TechVault.services.homepage.controller;

import TechVault.services.homepage.HomepageService;
import TechVault.services.homepage.model.Blog;
import TechVault.services.homepage.model.CompanyCount;

import TechVault.services.homepage.model.KeywordCount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("home")
public class HomepageController {
    private static final Logger LOGGER = LoggerFactory.getLogger(HomepageController.class);

    @Autowired
    private HomepageService service;

    /**
     * To get the home page sorted by likes in descending order.
     * @return A Response entity which will have all the blogs to be loaded as home page.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/liked")
    public ResponseEntity<?> getTopLiked(@RequestParam(defaultValue = "0") Integer pageNo) {
        List<Blog> blogs = null;
        try {
            blogs = service.getTopLiked(pageNo);
        } catch (Exception e) {
            LOGGER.error("Unable to get blogs ", e);
            return new ResponseEntity<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    /**
     * To get the home page sorted by number of discussions in descending order.
     * @return A Response entity which will have all the blogs to be loaded as home page.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/discussed")
    public ResponseEntity<?> getTopDiscussed(@RequestParam(defaultValue = "0") Integer pageNo) {
        List<Blog> blogs = null;
        try {
            blogs = service.getTopDiscussed(pageNo);
        } catch (Exception e) {
            LOGGER.error("Unable to get blogs ", e);
            return new ResponseEntity<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }


    /**
     * To get the latest home page.
     * @return A Response entity which will have all the blogs to be loaded as home page.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/latest")
    public ResponseEntity<?> getLatest(@RequestParam(defaultValue = "0") Integer pageNo) {
        List<Blog> blogs = null;
        try {
            blogs = service.getLatest(pageNo);
        } catch (Exception e) {
            LOGGER.error("Unable to get blogs ", e);
            return new ResponseEntity<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    /**
     * To get the trending home page.
     * @return A Response entity which will have all the blogs to be loaded as home page.
     */
    @RequestMapping(method = RequestMethod.GET, value = "")
    public ResponseEntity<?> getTrending(@RequestParam(defaultValue = "0") Integer pageNo) {
        List<Blog> blogs = null;
        try {
            blogs = service.getTrending(pageNo);
        } catch (Exception e) {
            LOGGER.error("Unable to get blogs ", e);
            return new ResponseEntity<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    /**
     * To get count of blogs by company.
     * @return A Response entity which will have all the blogs to be loaded as home page.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/blogsCount")
    public ResponseEntity<?> getBlogsCount() {
        List<CompanyCount> blogsCount = null;
        try {
            blogsCount = service.getBlogsCountByCompany();
        } catch (Exception e) {
            LOGGER.error("Unable to get blogs Count ", e);
            return new ResponseEntity<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(blogsCount, HttpStatus.OK);
    }

    /**
     * To get count of blogs by company.
     * @return A Response entity which will have all the blogs to be loaded as home page.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/keywordsCount")
    public ResponseEntity<?> getKeywordsCount() {
        List<KeywordCount> keywordCounts = null;
        try {
            keywordCounts = service.getContentByKeywordCount();
        } catch (Exception e) {
            LOGGER.error("Unable to get blogs Count ", e);
            return new ResponseEntity<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(keywordCounts, HttpStatus.OK);
    }
}