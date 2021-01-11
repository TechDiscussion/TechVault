package TechVault.service.user.persistence;

import TechVault.service.user.model.BookMark;
import TechVault.service.user.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookMarkRepository extends MongoRepository<BookMark, String>  {
    public List<BookMark> findAllByUserId(String userId);
}
