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
@Table(name = "CAR_BRAND")
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CarBrand {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String brand;
  private String country;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CarBrand carBrand = (CarBrand) o;
    return Objects.equals(id, carBrand.id) &&
        Objects.equals(brand, carBrand.brand) &&
        Objects.equals(country, carBrand.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, brand, country);
  }

  @Override
  public String toString() {
    return "CarModel{" +
        "id=" + id +
        ", make='" + brand + '\'' +
        ", model='" + country + '\'' +
        '}';
  }
}
