package TechVault.services.homepage.controller;

import TechVault.services.homepage.SearchService;
import TechVault.services.homepage.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private SearchService service;

    /**
     * Search by company name.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/company/{companyName}")
    public ResponseEntity<?> searchByCompanyName(@PathVariable String companyName, @RequestParam(defaultValue = "0") Integer pageNo) {
        List<Blog> blogs = null;
        try {
            blogs = service.searchByCompanyName(companyName, pageNo);
        } catch (Exception e) {
            return new ResponseEntity<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    /**
     * Search by keyword.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/keyword/{keyword}")
    public ResponseEntity<?> searchByKeyword(@PathVariable String keyword, @RequestParam(defaultValue = "0") Integer pageNo) {
        List<Blog> blogs = null;
        try {
            blogs = service.searchByKeyword(keyword, pageNo);
        } catch (Exception e) {
            return new ResponseEntity<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
