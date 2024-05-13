package org.example.repository.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@RequiredArgsConstructor
@Data
@Entity(name = "car_parts_names")
public class CarPartName {
  @Id
  @GeneratedValue
  private UUID id;
  @NonNull
  private String name;

  @Override
  public String toString() {
    return name;
  }
}
