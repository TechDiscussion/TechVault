package TechVault.services.User.persistence;

import TechVault.services.User.model.Session;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessionRepository extends MongoRepository<Session, Long> {
    Optional<Session> findById(String id);
}