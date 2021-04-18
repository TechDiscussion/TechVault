package TechVault.services.homepage.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class SearchByCompanyOrKeywordRequest {
    @NotBlank
    private List<String> searchWords;
}
