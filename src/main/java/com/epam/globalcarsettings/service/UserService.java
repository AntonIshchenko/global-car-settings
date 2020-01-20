package com.epam.globalcarsettings.service;

import com.epam.globalcarsettings.dto.UserLoginForm;
import com.epam.globalcarsettings.dto.UserRegistrationForm;
import com.epam.globalcarsettings.entities.User;
import com.epam.globalcarsettings.repository.UserRepository;
import com.epam.globalcarsettings.util.ExceptionMessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

  private final static Logger log = LoggerFactory.getLogger(UserService.class);

  private final UserRepository userRepository;
  private final ExceptionMessageHandler exceptionMessageHandler;

  @Autowired
  public UserService(UserRepository userRepository,
      ExceptionMessageHandler exceptionMessageHandler) {
    this.userRepository = userRepository;
    this.exceptionMessageHandler = exceptionMessageHandler;
  }

  public boolean checkPasswords(UserRegistrationForm form) {
    if (!form.getPassword().equals(form.getDuplicatePassword())) {
      String message = "Invalid password confirmation!";
      log.error(message);
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
    }
    return true;
  }

  public User addUser(UserRegistrationForm registrationForm) {
    User user = buildUser(registrationForm);

    if (userRepository.findUserByEmail(registrationForm.getEmail()) == null) {
      log.debug("User registered and added to database");
      userRepository.save(user);
      return user;
    } else {
      String message = "User with " + registrationForm.getEmail() + " email, already registered, please log in";
      log.error(message);
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
    }
  }

  private User buildUser(UserRegistrationForm registrationForm) {
    return new User().builder()
        .name(registrationForm.getName())
        .email(registrationForm.getEmail())
        .password(registrationForm.getPassword())
        .build();
  }

  public User loginUser(UserLoginForm loginForm) {
    User user = userRepository.findUserByEmail(loginForm.getEmail());
    if (user != null) {
      log.info("User logged in");
      return user;
    } else {
      String message = "User with " + loginForm.getEmail() + " email, does not exist";
      log.error(message);
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, message);
    }
  }
}
