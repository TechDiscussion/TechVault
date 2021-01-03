package TechVault.service.user.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
public class ContentResponse {
    private String title;
    private String source;
    private String timestamp;
    private HttpStatus status;

    public ContentResponse(String title, String company, String datePosted, HttpStatus httpStatus) {
        this.title = title;
        this.source = company;
        this.timestamp = datePosted;
        this.status = httpStatus;
    }

    public String getTitle() {
        return title;
    }

    public String getSource() {
        return source;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
