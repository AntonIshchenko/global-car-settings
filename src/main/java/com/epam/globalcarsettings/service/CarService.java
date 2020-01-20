package com.epam.globalcarsettings.service;

import com.epam.globalcarsettings.dto.CarBrandDto;
import com.epam.globalcarsettings.entities.CarBrand;
import com.epam.globalcarsettings.repository.CarModelRepository;
import java.util.List;
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

  public CarBrand addCarBrand(CarBrandDto carBrandDto) {
    CarBrand carBrand = carModelRepository.findByBrandAndCountry(carBrandDto.getBrand(), carBrandDto.getCountry());
    if (carBrand == null) {
      carBrand = new CarBrand().builder()
          .brand(carBrandDto.getBrand())
          .country(carBrandDto.getCountry()).build();
      carModelRepository.save(carBrand);
    }
    return carBrand;
  }

  public List<CarBrand> getCarBrand(String country) {
    return carModelRepository.findAllCarBrandByCountry(country);
  }

  public CarBrand getCarCountry(String brand) {
    return carModelRepository.findCarBrandByBrand(brand);
  }
}
