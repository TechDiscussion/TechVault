package TechVault.services.homepage.persistence;

import TechVault.services.homepage.model.Blog;
import TechVault.services.homepage.model.CompanyCount;

import java.util.List;


public interface HomepageDao {

    List<Blog> getBlog(Integer pageNo, Integer pageSize, String sortBy);

    List<CompanyCount> getBlogsCountBy(String companyOrConference);

}