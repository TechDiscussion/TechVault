package TechVault.services.homepage.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "keyword_counts")
@Builder
@Getter
@Setter
public class KeywordCount {
    @Field(name = "keyword")
    private String keyword;

    @Field(name = "frequency")
    private int frequency;
}
