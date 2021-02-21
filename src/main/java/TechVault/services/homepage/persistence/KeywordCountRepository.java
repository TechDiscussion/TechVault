package TechVault.services.homepage.persistence;

import TechVault.services.homepage.model.KeywordCount;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface KeywordCountRepository extends MongoRepository<KeywordCount, String> {
}