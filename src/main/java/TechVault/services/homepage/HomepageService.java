package TechVault.services.homepage;

import TechVault.services.homepage.model.Blog;

import java.util.List;

public interface HomepageService {

    public List<Blog> getTrending(Integer pageNo);

    public List<Blog> getLatest(Integer pageNo);

    public List<Blog> getTopDiscussed(Integer pageNo);

    public List<Blog> getTopLiked(Integer pageNo);
}