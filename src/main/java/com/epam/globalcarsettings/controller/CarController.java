package com.epam.globalcarsettings.controller;

import com.epam.globalcarsettings.dto.CarBrandDto;
import com.epam.globalcarsettings.entities.CarBrand;
import com.epam.globalcarsettings.service.CarService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/car")
public class CarController {

  private final static Logger log = LoggerFactory.getLogger(CarController.class);

  private final CarService carService;

  @Autowired
  public CarController(CarService carService) {
    this.carService = carService;
  }

  @PostMapping("/add-car-brand")
  public CarBrand addCarBrand(CarBrandDto carBrandDto) {
    return carService.addCarBrand(carBrandDto);
  }

  @GetMapping("/get-car-brand")
  public List<CarBrand> getCarBrand(String country) {
    return carService.getCarBrand(country);
  }

  @GetMapping("/get-car-country")
  public CarBrand getCarCountry(String brand) {
    return carService.getCarCountry(brand);
  }
}
