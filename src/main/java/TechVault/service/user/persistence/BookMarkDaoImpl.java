package TechVault.service.user.persistence;

import TechVault.service.user.model.BookMark;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookMarkDaoImpl implements BookMarkDao {

    @Autowired
    private BookMarkRepository bookMarkRepository;

    @Override
    public List<BookMark> getBookMarksByUserId(String userId) {
        return this.bookMarkRepository.findAllByUserId(userId);
    }
}
