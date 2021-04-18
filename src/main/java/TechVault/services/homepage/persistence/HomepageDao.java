package TechVault.services.homepage.persistence;

import TechVault.services.homepage.model.Blog;
import TechVault.services.homepage.model.CompanyCount;

import java.util.List;


public interface HomepageDao {

    List<Blog> getBlog(Integer pageNo, Integer pageSize, String sortBy);

    List<CompanyCount> getBlogsCountBy(String companyOrConference);

    List<Blog> getBlogsByCompanies(String[] companyName, Integer pageNo, Integer pageSize, String sortBy);

    List<Blog> getContentsByKeywords(String[] keyword, Integer pageNo, Integer pageSize, String sortBy);
}