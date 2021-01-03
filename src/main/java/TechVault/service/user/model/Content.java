package TechVault.service.user.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Document(collection = "blogs")
@Builder
@Getter
@Data
@Setter
public class Content {
  @Field(name = "uuid")
  private String uuid;

  @Field(name = "date")
  private String datePosted;

  @Field(name = "author")
  private String author;

  @Field(name = "link")
  private String link;

  @Field(name = "company")
  private String company;

  @Field(name = "abstract")
  private String abstractText;

  @Field(name = "categories")
  private String categories;

  @Field(name = "title")
  private String title;

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getDatePosted() {
    return datePosted;
  }
}
