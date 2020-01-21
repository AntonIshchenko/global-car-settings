package com.epam.globalcarsettings.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class UserRegistrationForm {

  private final String name;
  private final String email;
  private final String password;
  private final String duplicatePassword;

  @JsonCreator
  public UserRegistrationForm(String name, String email, String password, String duplicatePassword) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.duplicatePassword = duplicatePassword;
  }

}
