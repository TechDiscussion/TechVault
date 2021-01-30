package TechVault.services.homepage.persistence;


import TechVault.services.homepage.model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomepageRepository extends PagingAndSortingRepository<Blog, Integer> {}