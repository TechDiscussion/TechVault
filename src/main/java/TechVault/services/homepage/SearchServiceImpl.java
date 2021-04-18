package TechVault.services.homepage;

import TechVault.services.homepage.model.Blog;
import TechVault.services.homepage.persistence.HomepageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {
    private static final int PAGE_SIZE = 10;
    private static final String LIKED = "totalLikes";

    @Autowired
    private HomepageDao homepageDao;

    @Override
    public List<Blog> searchByCompanyNames(String[] companyNames, Integer pageNo) {
        return homepageDao.getBlogsByCompanies(companyNames, pageNo, PAGE_SIZE, LIKED);
    }

    @Override
    public List<Blog> searchByKeywords(String[] keywords, Integer pageNo) {
        return homepageDao.getContentsByKeywords(keywords, pageNo, PAGE_SIZE, LIKED);
    }
}
