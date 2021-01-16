package TechVault.service.user.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserProfileResponse {
    private final String userId;
    private final List<ContentResponse> bookmarks;

    @JsonIgnore
    private final HttpStatus status;
}
