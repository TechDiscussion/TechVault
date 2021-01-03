package TechVault.service.user.persistence;
import TechVault.service.user.model.Content;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ContentRepository extends MongoRepository<Content, String> {

    public Content findByUuid(String contentID);
}