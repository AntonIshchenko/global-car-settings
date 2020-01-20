package com.epam.globalcarsettings.repository;

import com.epam.globalcarsettings.dto.CarModelDto;
import com.epam.globalcarsettings.entities.CarModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarModelRepository extends JpaRepository<CarModel, Long> {

  CarModel findByMakeAndModel(String make, String model);

}
