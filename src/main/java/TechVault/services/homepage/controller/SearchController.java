package TechVault.services.homepage.controller;

import TechVault.services.homepage.SearchService;
import TechVault.services.homepage.model.Blog;
import TechVault.services.homepage.request.SearchByCompanyOrKeywordRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("search")
public class SearchController {

    @Autowired
    private SearchService service;

    /**
     * Search by company name.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/company")
    public ResponseEntity<?> searchByCompanyName(@RequestBody @Valid SearchByCompanyOrKeywordRequest searchByCompanyOrKeywordRequest,
                                                 @RequestParam(defaultValue = "0") Integer pageNo) {
        List<Blog> blogs = null;
        try {
            blogs = service.searchByCompanyNames(searchByCompanyOrKeywordRequest.getSearchWords(), pageNo);
        } catch (Exception e) {
            return new ResponseEntity<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    /**
     * Search by keyword.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/keyword")
    public ResponseEntity<?> searchByKeyword(@RequestBody @Valid SearchByCompanyOrKeywordRequest searchByCompanyOrKeywordRequest,
                                             @RequestParam(defaultValue = "0") Integer pageNo) {
        List<Blog> blogs = null;
        try {
            blogs = service.searchByKeywords(searchByCompanyOrKeywordRequest.getSearchWords(), pageNo);
        } catch (Exception e) {
            return new ResponseEntity<>("ERROR", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }
}
