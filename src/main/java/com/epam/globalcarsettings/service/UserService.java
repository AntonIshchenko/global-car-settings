package com.epam.globalcarsettings.service;

import com.epam.globalcarsettings.dto.UserLoginForm;
import com.epam.globalcarsettings.dto.UserRegistrationForm;
import com.epam.globalcarsettings.entities.User;
import com.epam.globalcarsettings.exceptions.UserExceptions;
import com.epam.globalcarsettings.repository.UserRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final static Logger log = LoggerFactory.getLogger(UserService.class);

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public boolean checkPasswords(UserRegistrationForm form) {
    if (!form.getPassword().equals(form.getDuplicatePassword())) {
      String message  ="Invalid password confirmation!";
      log.error(message);
      throw new UserExceptions(message);
    }
    return true;
  }

  public User addUser(UserRegistrationForm registrationForm) {
    User user = buildUser(registrationForm);

    if (findUserByEmail(registrationForm.getEmail()) == null) {
      log.debug("User registered and added to database");
      userRepository.save(user);
      return user;
    } else {
      String message = "User with " + registrationForm.getEmail() + " email, already registered, please log in";
      log.error(message);
      throw new UserExceptions(message);
    }
  }

  private User buildUser(UserRegistrationForm registrationForm) {
    return new User().builder()
        .name(registrationForm.getName())
        .email(registrationForm.getEmail())
        .password(registrationForm.getPassword())
        .build();
  }

  private User findUserByEmail(String email) {
    List<User> all = userRepository.findAll();
    for (User currentUser : all) {
      if (currentUser.getEmail().equals(email)) {
        return currentUser;
      }
    }
    return null;
  }

  public User loginUser(UserLoginForm loginForm) {
    User user = findUserByEmail(loginForm.getEmail());
    if (user != null) {
      log.info("User logged in");
      return user;
    } else {
      String message = "User with " + loginForm.getEmail() + " email, does not exist";
      log.error(message);
      throw new UserExceptions(message);
    }
  }
}
