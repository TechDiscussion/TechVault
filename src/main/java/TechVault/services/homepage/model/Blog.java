package TechVault.services.homepage.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "contents")
@Builder
@Getter
@Setter
public class Blog {
    @Id
    @Field(name = "_id")
    private String id;

    @Field(name = "author")
    private String author;

    @Field(name = "company")
    private String company;

    @Field(name = "link")
    private String link;

    @Field(name = "date")
    private String date;

    @Field(name = "abstract")
    private String blogAbstract;

    @Field(name = "title")
    private String title;

    @Field(name = "uuid")
    private String uuid;

    @Field(name = "totalLikes")
    private String likes;

    @Field(name = "totalViews")
    private String views;

    @Field(name = "totalComments")
    private String comments;

    @Field(name = "keywords")
    private String[] keywords;

    @Field(name = "type")
    private String type;
}
