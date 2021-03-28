package TechVault.services.User.controller;

import TechVault.services.User.EmailService;
import TechVault.services.User.UserService;
import TechVault.services.User.model.User;
import TechVault.services.User.request.ChangePasswordRequest;
import TechVault.services.User.request.PasswordForgotRequest;
import TechVault.services.User.request.RegisterUserRequest;
import TechVault.services.User.request.UserLoginRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@Validated
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;
    @Value("${webServerUrl}")
    private String webServerUrl;


    @PostMapping(value = "/register")
    public ResponseEntity<?> registerUser(@RequestBody @Valid RegisterUserRequest registerUserRequest) {
        User user = new User();
        user.setEmail(registerUserRequest.getEmail());
        user.setPassword(registerUserRequest.getPassword());
        user.setUserName(registerUserRequest.getUserName());
        try {
            if (userService.register(user)) {
                SimpleMailMessage registrationEmail = new SimpleMailMessage();
                registrationEmail.setTo(user.getEmail());
                registrationEmail.setSubject("Registration Confirmation");
                registrationEmail.setText("To confirm your e-mail address, please click the link below:\n" + webServerUrl
                        + "/user/confirm?token=" + user.getConfirmationToken());
                registrationEmail.setFrom("noreply@domain.com");

                emailService.sendEmail(registrationEmail);
            }
            return new ResponseEntity<>("Registered.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/confirm")
    public ResponseEntity<?> confirm(@RequestParam("token") String token) {
        try {
            userService.confirmUser(token);
            return new ResponseEntity<>("Confirmed.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/login")
    public ResponseEntity<?> login(@Valid @RequestBody UserLoginRequest userLoginRequest) {
        try {
            userService.loginUser(userLoginRequest);
            return new ResponseEntity<>("Successful.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/reset")
    public ResponseEntity<?> forgotPasswordRequest(@Valid @RequestBody PasswordForgotRequest passwordForgotRequest) {
        try {
            User resetUser = userService.resetUser(passwordForgotRequest);
            if (resetUser != null) {
                SimpleMailMessage registrationEmail = new SimpleMailMessage();
                registrationEmail.setTo(passwordForgotRequest.getEmail());
                registrationEmail.setSubject("Temporary Password Sent From TechVault");
                registrationEmail
                        .setText("To access your account, please use this temporary password:  " + resetUser.getPassword()
                                + ".\r\nNOTE: This email was sent from an automated system. Please do not reply.");
                registrationEmail.setFrom("noreply@domain.com");
                emailService.sendEmail(registrationEmail);
            }
            return new ResponseEntity<>("Check your email.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/changepwd")
    public ResponseEntity<?> changePassword(@Valid @RequestBody ChangePasswordRequest changePasswordRequest) {
        userService.changeUserPassword(changePasswordRequest);
        return new ResponseEntity<>("Changed.", HttpStatus.OK);
    }
}
