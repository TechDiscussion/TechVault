package TechVault.services.comments.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "comments")
@Builder
@Getter
@Setter
public class Comment {
  @Id
  @Field(name = "commentId")
  private String commentId;

  @Field(name = "contentId")
  private String contentId;

  @Field(name = "parentCommentId")
  private String parentCommentId;

  @Field(name = "userName")
  private String userName;

  @JsonFormat(pattern = "yyyy-mm-dd'T'HH:mm:ss")
  @Field(name = "postedTime")
  private Timestamp postedTime;

  @Field(name = "comment")
  private String comment;

}
