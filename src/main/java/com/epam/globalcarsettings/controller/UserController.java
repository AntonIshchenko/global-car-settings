package com.epam.globalcarsettings.controller;

import com.epam.globalcarsettings.constants.AuthentificationResponse;
import com.epam.globalcarsettings.dto.UserRegistrationForm;
import com.epam.globalcarsettings.entities.User;
import com.epam.globalcarsettings.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  private final static Logger log = LoggerFactory.getLogger(UserController.class);

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/register")
  public AuthentificationResponse registerUser(UserRegistrationForm registrationForm) {
    boolean passwordMatch = userService.checkPasswords(registrationForm);
    User user = userService.addUser(registrationForm);

    if(passwordMatch) {
      return AuthentificationResponse.SUCCESS;
    } else {
      return AuthentificationResponse.NOT_SUCCESS;
    }
  }

  @PostMapping("/login")
  public AuthentificationResponse loginUser(UserRegistrationForm registrationForm) {
    boolean isExist = userService.loginUser(registrationForm);
    return AuthentificationResponse.SUCCESS;
  }

}
