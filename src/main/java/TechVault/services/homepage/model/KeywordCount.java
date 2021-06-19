package TechVault.services.homepage.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class KeywordCount {
    @Id
    private String keyword;

    private long count;

}
