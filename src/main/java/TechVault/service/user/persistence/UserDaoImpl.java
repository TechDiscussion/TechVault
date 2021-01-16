package TechVault.service.user.persistence;

import TechVault.service.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class UserDaoImpl implements UserDao {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String addUser(String email, String password, String userName) {
        long userId = new Random().nextLong();
        userRepository.save(User.builder()
        .userId(Long.toString(userId))
        .userName(userName)
        .password(password)
        .email(email)
        .build());
        return null;
    }

    @Override
    public boolean getUserByEmailPassword(String email, String password) {
        User temp = this.userRepository.findByEmail(email);
        if (temp.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public User getUserByUserId(String userId) {
        return this.userRepository.findByUserId(userId);
    }
}
