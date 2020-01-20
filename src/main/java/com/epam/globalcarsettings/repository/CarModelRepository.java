package com.epam.globalcarsettings.repository;

import com.epam.globalcarsettings.entities.CarBrand;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarModelRepository extends JpaRepository<CarBrand, Long> {

  CarBrand findByBrandAndCountry(String brand, String country);

  List<CarBrand> findAllCarBrandByCountry(String country);

  CarBrand findCarBrandByBrand(String brand);

}
