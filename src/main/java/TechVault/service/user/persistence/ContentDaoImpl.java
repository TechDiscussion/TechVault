package TechVault.service.user.persistence;

import TechVault.service.user.model.Content;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.stereotype.Component;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.UUID;

@Component
public class ContentDaoImpl implements ContentDao {

    @Autowired
    private ContentRepository contentRepository;

    @Override
    public Content getContentByID(String contentID) {
        System.out.println("Content ID = " + contentID);
        Content temp = this.contentRepository.findByUuid(contentID);
        System.out.println("Content = " + temp);
        return temp;
    }
}