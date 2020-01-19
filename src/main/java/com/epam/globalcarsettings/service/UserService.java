package com.epam.globalcarsettings.service;

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
      throw new UserExceptions("Invalid password confirmation!");
    }
    return true;
  }

  public User addUser(UserRegistrationForm registrationForm) {
    User user = buildUser(registrationForm);

    if (!isExists(user)) {
      userRepository.save(user);
    }
    return user;
  }

  private User buildUser(UserRegistrationForm registrationForm) {
    return new User().builder()
        .name(registrationForm.getName())
        .email(registrationForm.getEmail())
        .password(registrationForm.getPassword())
        .build();
  }

  private boolean isExists(User user) {
    List<User> all = userRepository.findAll();
    for (User currentUser : all) {
      if (currentUser.getEmail().equals(user.getEmail())) {
        return true;
      }
    }
    return false;
  }

  public boolean loginUser(UserRegistrationForm registrationForm) {
    User user = buildUser(registrationForm);
    return isExists(user);
  }
}
