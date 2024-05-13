package org.example.repository.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity(name = "car_parts")
public class CarPart {
  @Id
  @GeneratedValue
  private UUID id;
  @NonNull
  @Column(name = "oe_number")
  private String oeNumber;
  @NonNull
  private Double price;
  @NonNull
  private Integer stock;
  @ManyToOne
  @JoinColumn(name = "name_id")
  private CarPartName name;

  @ManyToOne
  @JoinColumn(name = "car_id")
  private Car car;

  @Override
  public String toString() {
    return name.toString() + " for " + car.toString() + " (OE No.:" + oeNumber +" )";
  }
}
