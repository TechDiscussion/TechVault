package TechVault.services.comments.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CommentResponse {
    public CommentResponse(UUID randomUUID, UUID randomUUID2, long l, Timestamp timestamp) {
	}

	private UUID commentId;
    private UUID postId;
    private long userId;
    private Timestamp postedTime;
    private String comment;
    private List<CommentResponse> childComments;

    @JsonIgnore
    private HttpStatus status;
}
