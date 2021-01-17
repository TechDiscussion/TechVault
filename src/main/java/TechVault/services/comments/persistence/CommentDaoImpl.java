package TechVault.services.comments.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import TechVault.services.comments.model.Comment;


@Component
public class CommentDaoImpl implements CommentDao {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(CommentDaoImpl.class);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Autowired  
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getCommentsByBlog(String contentId) {
        return commentRepository.findByContentIdOrderByPostedTimeDesc(contentId);
    }

    @Override
    public void addComment(String contentId, String parentCommentId, String userName, String comment) {
        commentRepository.save(Comment.builder()
        .parentCommentId(parentCommentId)
        .userName(userName)
        .contentId(contentId)
        .comment(comment)
        .postedTime(LocalDateTime.now().format(formatter))
        .build());

        LOGGER.info("Successfully save comment for user: {} and contentId: {}", userName, contentId);
    }
    
}
