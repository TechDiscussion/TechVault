package TechVault.services.User.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "session_token")
@Getter
@Setter
@NoArgsConstructor
public class Session {

    @Id
    @Field(name = "_id")
    private String id;

    @Field(name = "user_id")
    private Long user_id;
}
