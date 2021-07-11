package TechVault.services.homepage.persistence;

import TechVault.services.homepage.model.Blog;
import TechVault.services.homepage.model.CompanyCount;

import TechVault.services.homepage.model.KeywordCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Component
public class HomepageDaoImpl implements HomepageDao {

    @Autowired
    private HomepageRepository repo;

    @Override
    public List<Blog> getBlog(Integer pageNo, String type, Integer pageSize, String sortBy) {
        Pageable pageable = pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        Page<Blog> page;
        if (type.equals("all")) {
            page = repo.findAll(pageable);
        } else {
            page = repo.findByType(type, pageable);
        }
        return page.getContent();
    }

    @Override
    public List<Blog> getBlogsByCompanies(List<String> companyNames, String type, Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        Page<Blog> page = null;
        if (type.equals("all")) {
            page = repo.findByCompanyIn(companyNames, pageable);
        } else {
            page = repo.findByTypeAndCompanyIn(type, companyNames, pageable);
        }
        return page.getContent();
    }

    @Override
    public List<Blog> getContentsByKeywords(List<String> keyword, String type, Integer pageNo, Integer pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        Page<Blog> page = null;
        if (type.equals("all")) {
            page = repo.findAnyOfTheseValues(keyword, pageable);
        } else {
            page = repo.findByTypeAndAnyOfTheseValues(keyword, type, pageable);
        }
        return page.getContent();
    }

    @Override
    public List<CompanyCount> getBlogsCountByCompany() {
        List<CompanyCount> blogGroups = repo.groupBlogsByCompany(Sort.by(Sort.Order.desc("total")));
        blogGroups.sort(Comparator.comparing(CompanyCount::getCount).reversed()); //.filter((blogGroup) -> blogGroup.getCompany() != null);
        return blogGroups;
    }

    @Override
    public List<KeywordCount> getBlogsCountByKeywords() {
        List<KeywordCount> blogGroups = repo.groupBlogsByKeywords();
        blogGroups.removeIf(blogGroup -> blogGroup.getCount() < 30);
        blogGroups.sort(Comparator.comparing(KeywordCount::getCount).reversed());
        return blogGroups;
    }
}
