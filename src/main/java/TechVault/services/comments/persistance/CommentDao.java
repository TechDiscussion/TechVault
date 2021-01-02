package TechVault.services.comments.persistance;

import java.util.List;

import TechVault.services.comments.model.Comment;

public interface CommentDao {
    
    public List<Comment> getCommentsByBlog(String blogUUID);

    public String addCommenttoBlog(String blogUUID, String parentCommentId, long userId, String comment);

    
}
