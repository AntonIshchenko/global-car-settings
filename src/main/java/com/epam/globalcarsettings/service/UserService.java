package com.epam.globalcarsettings.service;

import com.epam.globalcarsettings.dto.UserRegistrationForm;
import com.epam.globalcarsettings.entities.User;
import com.epam.globalcarsettings.repository.UserRepository;
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
    return form.getPassword().equals(form.getDuplicatePassword());
  }

  public boolean addUser(UserRegistrationForm registrationForm) {
    User user = new User().builder()
        .name(registrationForm.getName())
        .email(registrationForm.getEmail())
        .password(registrationForm.getPassword())
        .build();

    userRepository.save(user);
    return true;
  }
}
