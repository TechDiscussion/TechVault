package TechVault.services.homepage;

import TechVault.services.homepage.model.Blog;

import java.util.List;

public interface SearchService {
    public List<Blog> searchByCompanyNames(List<String> companyNames, Integer pageNo);

    public List<Blog> searchByKeywords(List<String> keywords, Integer pageNo);
}
