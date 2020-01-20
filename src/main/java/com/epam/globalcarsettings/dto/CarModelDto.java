package com.epam.globalcarsettings.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class CarModelDto {

  private final String make;
  private final String model;

  @JsonCreator
  public CarModelDto(String make, String model) {
    this.make = make;
    this.model = model;
  }
}
