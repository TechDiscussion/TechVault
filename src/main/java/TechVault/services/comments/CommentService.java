package TechVault.services.comments;

import java.util.List;

import TechVault.services.comments.model.Comment;

public interface CommentService {
    
    public List<Comment> getComments (String postId);

    public void addComment(String postId, String userId, String comment);
}
