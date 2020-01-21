package com.epam.globalcarsettings.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

@Getter
public class CarBrandDto {

  private final String brand;
  private final String country;

  @JsonCreator
  public CarBrandDto(String brand, String country) {
    this.brand = brand;
    this.country = country;
  }
}
