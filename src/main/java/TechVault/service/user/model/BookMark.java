package TechVault.service.user.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.security.Timestamp;

@Document(collection = "bookmark")
@Builder
@Getter
@Data
@Setter
public class BookMark {
    @Field(name = "contentId")
    private String contentId;

    @Field(name = "userId")
    private String userId;

    @Field(name = "timeStamp")
    private Timestamp postedTime;
}
