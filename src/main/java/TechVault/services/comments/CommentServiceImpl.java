package TechVault.services.comments;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import TechVault.services.comments.model.CommentResponse;
import TechVault.services.comments.persistance.CommentDao;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public List<CommentResponse> getComments(String postId) {
        // TODO Auto-generated method stub
        
        return null;
    }

    @Override
    public void addComment(String contentId, String parentCommentId, String userName, String comment) {
        commentDao.addComment(contentId, parentCommentId, userName, comment);
    }
    
}
