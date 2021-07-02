package TechVault.services.homepage;

import TechVault.services.homepage.model.Blog;
import TechVault.services.homepage.model.CompanyCount;

import TechVault.services.homepage.model.KeywordCount;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import TechVault.services.homepage.persistence.HomepageDao;
import org.springframework.stereotype.Service;

@Service
public class HomepageServiceImpl implements HomepageService {
    private static final int PAGESIZE = 20;
    private static final String DATE = "date";
    private static final String DISCUSSED = "totalComments";
    private static final String LIKED = "totalLikes";
    private static final String VIEWED = "totalViews";

    @Autowired
    private HomepageDao homepageDao;

    @Override
    public List<Blog> getTrending(Integer pageNo) {
        return getBlogs(pageNo, VIEWED);
    }

    @Override
    public List<Blog> getLatest(Integer pageNo) {
        return getBlogs(pageNo, DATE);
    }

    @Override
    public List<Blog> getTopDiscussed(Integer pageNo) {
        return getBlogs(pageNo, DISCUSSED);
    }

    @Override
    public List<Blog> getTopLiked(Integer pageNo) {
        return getBlogs(pageNo, LIKED);
    }

    private List<Blog> getBlogs(Integer pageNo, String sortBy) {
        return homepageDao.getBlog(pageNo, PAGESIZE, sortBy);
    }

    @Override
    public List<CompanyCount> getBlogsCountByCompany() {
        return homepageDao.getBlogsCountByCompany();
    }

    @Override
    public List<KeywordCount> getContentByKeywordCount() {
        return homepageDao.getBlogsCountByKeywords();
    }
}
