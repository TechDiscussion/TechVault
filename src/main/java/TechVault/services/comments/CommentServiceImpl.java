package TechVault.services.comments;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.google.common.base.Strings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TechVault.services.comments.model.Comment;
import TechVault.services.comments.model.CommentResponse;
import TechVault.services.comments.persistence.CommentDao;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public List<CommentResponse> getComments(String contentId) {

        List<Comment> comments = commentDao.getCommentsByBlog(contentId);
        Map<String, CommentResponse> map = new HashMap<>();
        List<CommentResponse> result = new ArrayList<>();
        for (Comment comment : comments) {
            CommentResponse commentResponse = new CommentResponse(comment);
            if (Strings.isNullOrEmpty(comment.getParentCommentId())) {
                result.add(commentResponse);
            }
            map.put(comment.getCommentId(), commentResponse);
        }
        for (Comment comment : comments) {
            if (!Strings.isNullOrEmpty(comment.getParentCommentId())) {
                CommentResponse parent = map.get(comment.getParentCommentId());
                parent.getChildComments().add(map.get(comment.getCommentId()));
            }
        }
        return result;
    }

    @Override
    public void addComment(String contentId, String parentCommentId, String userName, String comment) {
        commentDao.addComment(contentId, parentCommentId, userName, comment);
    }
    
}
