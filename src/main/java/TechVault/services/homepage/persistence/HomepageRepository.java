package TechVault.services.homepage.persistence;

import TechVault.services.homepage.model.Blog;

import java.util.List;

import TechVault.services.homepage.model.KeywordCount;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import TechVault.services.homepage.model.CompanyCount;

@Repository
public interface HomepageRepository extends PagingAndSortingRepository<Blog, Integer> {
    
    @Aggregation("{$group : { _id : $company , count : { $sum : 1}}}")
    List<CompanyCount> groupBlogsByCompany(Sort sort);

    @Aggregation("{$group : { _id : {$arrayElemAt : [$keywords, 0] , $arrayElemAt : [$keywords, 1]} , count : { $sum : 1}}}")
    List<KeywordCount> groupBlogsByKeywords();

    Page<Blog> findByCompanyIn(List<String> companyName, Pageable pageable);

    Page<Blog> findByTypeAndCompanyIn(String type, List<String> companyName, Pageable pageable);

    Page<Blog> findByType(String type, Pageable pageable);

    @Query(value = "{ 'keywords' : {$all : [?0] }}")
    Page<Blog> findAnyOfTheseValues(List<String> arrayValues, Pageable pageable);

    @Query(value = "{$and: [{ 'keywords' : {$all : [?0] }}, { 'type' : ?1}]}")
    Page<Blog> findByTypeAndAnyOfTheseValues(List<String> arrayValues, String type, Pageable pageable);
}
