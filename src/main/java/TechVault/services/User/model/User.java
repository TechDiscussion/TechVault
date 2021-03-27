package TechVault.services.User.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "user")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @Field(name = "id")
    private Long id;

    @Field(name = "email")
    private String email;

    @Field(name = "password")
    private String password;

    @Field(name = "user_name")
    private String userName;

    @Field(name = "email_verified")
    private Integer emailVerified;

    private String confirmationToken;

    private boolean isTempPassword;
}
