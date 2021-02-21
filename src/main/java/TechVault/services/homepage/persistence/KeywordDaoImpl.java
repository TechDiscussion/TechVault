package TechVault.services.homepage.persistence;

import TechVault.services.homepage.model.KeywordCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class KeywordDaoImpl implements KeywordCountDao {
    @Autowired
    private KeywordCountRepository keywordCountRepository;

    @Override
    public List<KeywordCount> getSortedByFrequency() {
        List<KeywordCount> keywordCounts = keywordCountRepository.findAll(Sort.by(Sort.Direction.DESC, "frequency"));
        return keywordCounts;
    }
}
