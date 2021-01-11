package TechVault.service.user.persistence;


import TechVault.service.user.model.User;

public interface UserDao {

    public String addUser(String email, String password, String userName);

    public boolean getUserByEmailPassword(String email, String password);

    public User getUserByUserId(String userId);
}
