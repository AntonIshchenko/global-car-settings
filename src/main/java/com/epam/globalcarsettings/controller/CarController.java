package com.epam.globalcarsettings.controller;

import com.epam.globalcarsettings.dto.CarModelDto;
import com.epam.globalcarsettings.entities.CarModel;
import com.epam.globalcarsettings.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

  @PostMapping("/add-car-model")
  public CarModel addCarModel(CarModelDto carModelDto) {
    return carService.addCarModel(carModelDto);
  }

}
