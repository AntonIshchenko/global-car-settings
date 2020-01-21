package com.epam.globalcarsettings.service;

import com.epam.globalcarsettings.controller.CarController;
import com.epam.globalcarsettings.entities.CarBody;
import com.epam.globalcarsettings.entities.CarBodyTypes;
import com.epam.globalcarsettings.entities.CarBrand;
import com.epam.globalcarsettings.exceptions.DatabaseServiceException;
import com.epam.globalcarsettings.repository.CarBodyRepository;
import com.epam.globalcarsettings.repository.CarBrandRepository;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;
import org.aspectj.bridge.IMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {

  private final static Logger log = LoggerFactory.getLogger(DatabaseService.class);

  private final CarBodyRepository carBodyRepository;
  private final CarBrandRepository carBrandRepository;

  @Autowired
  public DatabaseService(CarBodyRepository carBodyRepository,
      CarBrandRepository carBrandRepository) {
    this.carBodyRepository = carBodyRepository;
    this.carBrandRepository = carBrandRepository;
  }

  @Bean
  public void setCarBodyRepository() {
    CarBodyTypes[] values = CarBodyTypes.values();
    CarBody carBody = new CarBody();
    long id = 1;
    for (CarBodyTypes currentType: values) {
      carBody.setBodyTypes(currentType);
      carBody.setId(id++);
      carBodyRepository.save(carBody);
    }
  }

  @Bean
  public void setCarBrandRepository() {
    CarBrand carBrand = new CarBrand();
    long id = 1;
//    File f = new File("src/com/mkyong/data.txt");
    try {
      String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\CAR_BRANDS.txt";
      System.out.println(path);
      List<String> lines = Files.readAllLines(Path.of(path));

      for (String line : lines) {
        carBrand.setBrand(line);
        carBrand.setCountry("Unknown");
        carBrand.setId(id++);
        carBrandRepository.save(carBrand);
      }
    } catch (IOException e) {
      String message = "Can not read CAR_BRANDS.txt file \n" + e.getMessage();
      log.error(message);
      throw new DatabaseServiceException(message);
    }
  }
}
