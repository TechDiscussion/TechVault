package TechVault.service.user.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContentResponse {
    private String title;
    private String source;
    private String timestamp;

    public ContentResponse(String title, String company, String datePosted) {
        this.title = title;
        this.source = company;
        this.timestamp = datePosted;
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

}
