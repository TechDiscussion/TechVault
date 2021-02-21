package TechVault.services.homepage.persistence;

import TechVault.services.homepage.model.KeywordCount;

import java.util.List;

public interface KeywordCountDao {
    List<KeywordCount> getSortedByFrequency();
}
