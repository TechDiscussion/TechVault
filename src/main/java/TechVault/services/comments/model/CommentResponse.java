package TechVault.services.comments.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class CommentResponse {

    public  CommentResponse (Comment comment ) {
        this(comment.getCommentId(), comment.getContentId(), 
        comment.getUserName(), comment.getPostedTime(), comment.getComment(), 
        new ArrayList<>());
    }

	private String commentId;
    private String contentId;
    private String userName;
    private String postedTime;
    private String comment;
    private List<CommentResponse> childComments;
}
