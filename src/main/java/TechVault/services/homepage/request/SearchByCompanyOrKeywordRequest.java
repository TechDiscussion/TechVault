package TechVault.services.homepage.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SearchByCompanyOrKeywordRequest {
    @NotBlank
    private String[] searchWords;
}
