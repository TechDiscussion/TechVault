package TechVault.services.User;

import TechVault.services.User.exception.InvalidArgumentException;
import TechVault.services.User.exception.ResourceNotFoundException;
import TechVault.services.User.model.User;
import TechVault.services.User.persistence.UserRepository;
import TechVault.services.User.request.ChangePasswordRequest;
import TechVault.services.User.request.PasswordForgotRequest;
import TechVault.services.User.request.UserLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.security.SecureRandom;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    @Override
    public boolean register(User user) throws InvalidArgumentException {
        String password = user.getPassword();
        if (password.isEmpty()) {
            throw new InvalidArgumentException("Invalid password.");
        }

        if (user.getUserName().isEmpty()) {
            user.setUserName(user.getEmail());
        }

        User userExists = userRepository.findByUserName(user.getUserName());

        if (userExists != null) {
            throw new InvalidArgumentException(user.getUserName() + " already registered.");
        }

        if (userRepository.findByEmail(user.getEmail()).get() != null) {
            throw new InvalidArgumentException(user.getEmail() + " already registered.");
        }

        // Disable user until they click on confirmation link in email
        user.setEmailVerified(0);
        user.setId(RANDOM.nextLong());
        // Generate random 36-character string token for confirmation link
        user.setConfirmationToken(UUID.randomUUID().toString());

        userRepository.save(user);

        return true;
    }

    @Override
    public User resetUser(PasswordForgotRequest passwordForgotRequest) {

        User userExists = userRepository.findByEmail(passwordForgotRequest.getEmail()).get();

        if (userExists == null) {
            throw new InvalidArgumentException(passwordForgotRequest.getEmail() + " is not registered.");
        }

        String password = generatePassword(10);
        userExists.setPassword(password);
        userExists.setTempPassword(true);

        userRepository.save(userExists);

        // return the user with plain password so that we can send it to the user's email.
        userExists.setPassword(password);

        return userExists;
    }

    @Override
    public void changeUserPassword(ChangePasswordRequest changePasswordRequest) {
        User userExists = userRepository.findByUserName(changePasswordRequest.getUserName());

        if (userExists == null) {
            throw new InvalidArgumentException(changePasswordRequest.getUserName() + " is not registered.");
        }

        if (userExists.getEmailVerified() == 0) {
            throw new InvalidArgumentException("The user is not enabled.");
        }

        userExists.setPassword(changePasswordRequest.getPassword());

        userRepository.save(userExists);
    }

    @Override
    public void confirmUser(String token) {
        User user = userRepository.findByConfirmationToken(token);

        if (user == null) {
            throw new InvalidArgumentException("Invalid token.");
        }
        // Token found
        user.setEmailVerified(1);
        user.setConfirmationToken("");

        // Save user
        userRepository.save(user);
    }

    @Override
    public boolean loginUser(UserLoginRequest userLoginRequest) {
        if (userLoginRequest.getEmail() == null && userLoginRequest.getUserName() == null) {
            throw new InvalidArgumentException("Required either email or user name.");
        }
        User userExists = null;
        if (userLoginRequest.getUserName() != null) {
            userExists = userRepository.findByUserName(userExists.getUserName());
        } else {
            userExists = userRepository.findByEmail(userExists.getEmail()).get();
        }

        if (userExists == null) {
            throw new InvalidArgumentException("Invalid user name.");
        }

        String password = userLoginRequest.getPassword();
        if (!password.equals(userExists.getPassword())) {
            throw new InvalidArgumentException("Invalid user name and password combination.");
        }

        if (userExists.getEmailVerified() == 0) {
            throw new InvalidArgumentException("The user is not enabled.");
        }

        userExists.setPassword("");
        userExists.setId(0L);
        return true;
    }

    @Override
    public User fetchUser(String email) throws AccessDeniedException {
        if (Objects.isNull(email)) {
            throw new AccessDeniedException("Invalid access");
        }

        Optional<User> user = userRepository.findByEmail(email);
        if (!user.isPresent()) {
            throw new ResourceNotFoundException("User not found");
        }
        return user.get();
    }

    @Override
    public User saveUser(User user) {
        if (Objects.isNull(user)) {
            throw new InvalidArgumentException("Null user");
        }

        return userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        if (Objects.isNull(email)) {
            throw new InvalidArgumentException("Null email");
        }

        return userRepository.findByEmail(email).orElse(null);
    }

    @Override
    public boolean userExistsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean userExistsByUserName(String userName) {
        return userRepository.existsByUserName(userName);
    }

    @Override
    public Boolean getVerificationStatus(User user) throws AccessDeniedException {
        return user.getEmailVerified() == 1;
    }

    public static String generatePassword(int length) {
        StringBuilder returnValue = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }
}
