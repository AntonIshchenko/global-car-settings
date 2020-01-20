package com.epam.globalcarsettings.service;

import com.epam.globalcarsettings.dto.CarModelDto;
import com.epam.globalcarsettings.entities.CarModel;
import com.epam.globalcarsettings.repository.CarModelRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

  private final static Logger log = LoggerFactory.getLogger(CarService.class);

  private final CarModelRepository carModelRepository;

  @Autowired
  public CarService(CarModelRepository carModelRepository) {
    this.carModelRepository = carModelRepository;
  }

  public CarModel addCarModel(CarModelDto carModelDto) {
    CarModel carModel = carModelRepository.findByMakeAndModel(carModelDto.getMake(), carModelDto.getModel());
    if(carModel ==null)
    carModelRepository.save(carModel);
    return carModel;
  }
}
