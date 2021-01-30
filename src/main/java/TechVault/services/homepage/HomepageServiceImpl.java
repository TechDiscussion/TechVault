package TechVault.services.homepage;

import TechVault.services.homepage.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import TechVault.services.homepage.persistence.HomepageDao;
import org.springframework.stereotype.Service;

@Service
public class HomepageServiceImpl implements  HomepageService {
    private static final int PAGESIZE = 10;
    private static final String DATE = "date";
    private static final String DISCUSSED = "comment";
    private static final String LIKED = "like";

    @Autowired
    private HomepageDao homepageDao;

    @Override
    public List<Blog> getTrending(Integer pageNo) {
        return null;
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
}
