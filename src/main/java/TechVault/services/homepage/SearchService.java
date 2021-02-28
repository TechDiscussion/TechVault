package TechVault.services.homepage;

import TechVault.services.homepage.model.Blog;

import java.util.List;

public interface SearchService {
    public List<Blog> searchByCompanyName(String companyName, Integer pageNo);

    public List<Blog> searchByKeyword(String keyword, Integer pageNo);
}
