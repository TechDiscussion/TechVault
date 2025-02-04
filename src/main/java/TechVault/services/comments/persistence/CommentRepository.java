package TechVault.services.comments.persistence;

import TechVault.services.comments.model.Comment;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
    public List<Comment> findByContentIdOrderByPostedTimeDesc(String contentId);
}