package TechVault.services.comments.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "comments")
@Builder
@Getter
@Setter
public class Comment {
  @Id
  private String commentId;

  @Indexed
  @Field(name = "contentId")
  private String contentId;

  @Field(name = "parentCommentId")
  private String parentCommentId;

  @Field(name = "userName")
  private String userName;

  @Field(name = "postedTime")
  private String postedTime;

  @Field(name = "comment")
  private String comment;

}
