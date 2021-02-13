package TechVault.services.homepage.persistence;

import TechVault.services.homepage.model.Blog;
import TechVault.services.homepage.model.CompanyCount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HomepageDaoImpl implements HomepageDao {

    @Autowired
    private HomepageRepository repo;

    @Override
    public List<Blog> getBlog(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        Page<Blog> page = repo.findAll(pageable);

        return page.getContent();
    }

    @Override
    public List<CompanyCount> getBlogsCountBy(String companyOrConference) {
        List<CompanyCount> blogGroups = repo.groupBlogsBy(companyOrConference);
        blogGroups.stream().filter((blogGroup) -> blogGroup.getCompany() != null);
        return blogGroups;
    }
}
