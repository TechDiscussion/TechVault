package TechVault.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("search")
public class Search {

    /**
     * To the the profile of the user corresponding to the user id.
     * @return A Response entity which will have all the user details.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/{keyword}")
    public ResponseEntity<?> getSearchResults() {
        return null;
    }
}
