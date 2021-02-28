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
    public List<Blog> searchByCompanyName(String companyName, Integer pageNo) {
        return homepageDao.getBlogsByCompany(companyName, pageNo, PAGE_SIZE, LIKED);
    }

    @Override
    public List<Blog> searchByKeyword(String keyword, Integer pageNo) {
        return homepageDao.getContentsByKeyword(new String[]{keyword}, pageNo, PAGE_SIZE, LIKED);
    }
}
