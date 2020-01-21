package com.epam.globalcarsettings.service;

import com.epam.globalcarsettings.dto.CarBrandDto;
import com.epam.globalcarsettings.entities.CarBrand;
import com.epam.globalcarsettings.repository.CarBrandRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

  private final static Logger log = LoggerFactory.getLogger(CarService.class);

  private final CarBrandRepository carBrandRepository;

  @Autowired
  public CarService(CarBrandRepository carBrandRepository) {
    this.carBrandRepository = carBrandRepository;
  }

  public CarBrand addCarBrand(CarBrandDto carBrandDto) {
    CarBrand carBrand = carBrandRepository.findByBrandAndCountry(carBrandDto.getBrand(), carBrandDto.getCountry());
    if (carBrand == null) {
      carBrand = new CarBrand().builder()
          .brand(carBrandDto.getBrand())
          .country(carBrandDto.getCountry()).build();
      carBrandRepository.save(carBrand);
    }
    return carBrand;
  }

  public List<CarBrand> getCarBrand(String country) {
    return carBrandRepository.findAllCarBrandByCountry(country);
  }

  public CarBrand getCarCountry(String brand) {
    return carBrandRepository.findCarBrandByBrand(brand);
  }
}
