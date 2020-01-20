package com.epam.globalcarsettings.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class UserLoginForm {

  private final String email;
  private final String password;

  @JsonCreator
  public UserLoginForm(String name, String email, String password) {
    this.email = email;
    this.password = password;
  }
}
