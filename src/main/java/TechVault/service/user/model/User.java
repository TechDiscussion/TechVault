package TechVault.service.user.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "user")
@Builder
@Getter
@Data
@Setter
public class User {
    @Field(name = "userId")
    private String userId;

    @Field(name = "userName")
    private String userName;

    @Field(name = "email")
    private String email;

    @Field(name = "password")
    private String password;
}
