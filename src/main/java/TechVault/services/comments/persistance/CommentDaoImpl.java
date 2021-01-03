package TechVault.services.comments.persistance;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import TechVault.services.comments.model.Comment;

@Component
public class CommentDaoImpl implements CommentDao {

    @Autowired  
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getCommentsByBlog(String blogUUID) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String addComment(String contentId, String parentCommentId, String userName, String comment) {
        commentRepository.save(Comment.builder()
        .parentCommentId(parentCommentId)
        .userName(userName)
        .contentId(contentId)
        .build());

        return null;
    }
    
}
