package TechVault.services.homepage;

import TechVault.services.homepage.model.Blog;

import java.util.List;

public interface SearchService {
    public List<Blog> searchByCompanyNames(String[] companyNames, Integer pageNo);

    public List<Blog> searchByKeywords(String[] keywords, Integer pageNo);
}
