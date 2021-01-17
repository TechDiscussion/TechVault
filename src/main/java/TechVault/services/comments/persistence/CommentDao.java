package TechVault.services.comments.persistence;

import java.util.List;

import TechVault.services.comments.model.Comment;

public interface CommentDao {
    
    public List<Comment> getCommentsByBlog(String blogUUID);

    public void addComment(String contentId, String parentCommentId, String userName, String comment);
        
}
