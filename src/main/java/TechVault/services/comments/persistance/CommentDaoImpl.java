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
    public String addCommenttoBlog(String blogUUID, String parentCommentId, long userId, String comment) {
        // TODO Auto-generated method stub
        System.out.println("inside commentDAO");
        commentRepository.save(Comment.builder()
        .parentCommentId(parentCommentId)
        .userId(userId)
        .postId(blogUUID)
        .build());


        System.out.println("printing............");

        commentRepository.findAll().forEach(u -> System.out.println(u.getPostId()));

        return null;
    }
    
}
