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
  private String brandId;
  private String model;
  private String bodyId;

}
