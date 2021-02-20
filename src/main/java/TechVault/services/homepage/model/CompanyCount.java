package TechVault.services.homepage.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class CompanyCount {
  @Id
  private String company;

  private long count;

}
