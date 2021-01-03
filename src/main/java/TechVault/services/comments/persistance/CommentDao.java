package TechVault.services.comments.persistance;

import java.util.List;

import TechVault.services.comments.model.Comment;

public interface CommentDao {
    
    public List<Comment> getCommentsByBlog(String blogUUID);

    public String addComment(String contentId, String parentCommentId, String userName, String comment);

    
}
