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

}
