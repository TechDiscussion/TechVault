package TechVault.service.user.persistence;


import TechVault.service.user.model.BookMark;

import java.util.List;

public interface BookMarkDao {
    public List<BookMark> getBookMarksByUserId(String userId);
}
