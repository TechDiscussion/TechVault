package TechVault.services.homepage.persistence;

import TechVault.services.homepage.model.Blog;
import TechVault.services.homepage.model.CompanyCount;
import TechVault.services.homepage.model.KeywordCount;

import java.util.List;


public interface HomepageDao {

    List<Blog> getBlog(Integer pageNo, Integer pageSize, String sortBy);

    List<CompanyCount> getBlogsCountByCompany();

    List<KeywordCount> getBlogsCountByKeywords();

    List<Blog> getBlogsByCompanies(List<String> companyName, Integer pageNo, Integer pageSize, String sortBy);

    List<Blog> getContentsByKeywords(List<String> keyword, Integer pageNo, Integer pageSize, String sortBy);
}