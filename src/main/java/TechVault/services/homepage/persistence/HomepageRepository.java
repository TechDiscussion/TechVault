package TechVault.services.homepage.persistence;

import TechVault.services.homepage.model.Blog;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import TechVault.services.homepage.model.CompanyCount;

@Repository
public interface HomepageRepository extends PagingAndSortingRepository<Blog, Integer> {
    
    @Aggregation("{$group : { _id : ?0 , count : { $sum : 1}}}")
    List<CompanyCount> groupBlogsBy(String companyOrConference);

    Page<Blog> findByCompany(String companyName, Pageable pageable);

    @Query(value = "{ 'keywords' : {$all : [?0] }}")
    Page<Blog> findAnyOfTheseValues(String[] arrayValues, Pageable pageable);
}