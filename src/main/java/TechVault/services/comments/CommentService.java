package TechVault.services.comments;

import java.util.List;

import TechVault.services.comments.model.CommentResponse;

public interface CommentService {
    
    public List<CommentResponse> getComments (String postId);

    public void addComment(String contentId, String parentCommentId, String userName, String comment);
}
