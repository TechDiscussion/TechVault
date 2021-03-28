package TechVault.services.User.persistence;

import TechVault.services.User.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {
    User findByEmail(String email);

    Boolean existsByEmail(String email);

    Boolean existsByUserName(String userName);

    User findByUserName(String username);

    User findByConfirmationToken(String confirmationToken);
}