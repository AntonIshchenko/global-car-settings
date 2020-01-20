package com.epam.globalcarsettings.entities;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Table(name = "CAR_MODEL")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarModel {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String brand;
  private String model;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarModel carModel = (CarModel) o;
    return Objects.equals(id, carModel.id) &&
        Objects.equals(brand, carModel.brand) &&
        Objects.equals(model, carModel.model);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, brand, model);
  }

  @Override
  public String toString() {
    return "CarModel{" +
        "id=" + id +
        ", brand='" + brand + '\'' +
        ", model='" + model + '\'' +
        '}';
  }
}
