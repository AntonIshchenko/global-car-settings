package com.epam.globalcarsettings.dto;

import com.fasterxml.jackson.annotation.JsonCreator;

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

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getDuplicatePassword() {
    return duplicatePassword;
  }


}
