package TechVault.services.homepage;

import TechVault.services.homepage.model.Blog;
import TechVault.services.homepage.model.CompanyCount;
import TechVault.services.homepage.model.KeywordCount;

import java.util.List;

public interface HomepageService {

    public List<Blog> getTrending(Integer pageNo);

    public List<Blog> getLatest(Integer pageNo);

    public List<Blog> getTopDiscussed(Integer pageNo);

    public List<Blog> getTopLiked(Integer pageNo);

    List<CompanyCount> getBlogsCountByCompany();

    List<KeywordCount> getContentByKeywordCount();
}