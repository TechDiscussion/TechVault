package TechVault.services.homepage.request;

import lombok.Data;

import java.util.List;

@Data
public class SearchByCompanyOrKeywordRequest {
    private List<String> searchWords;
}
