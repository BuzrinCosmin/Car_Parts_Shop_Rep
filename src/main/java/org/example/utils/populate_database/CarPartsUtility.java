package org.example.utils.populate_database;

import org.example.repository.CarPartNameRepository;
import org.example.repository.CarPartRepository;
import org.example.repository.CarRepository;
import org.example.repository.entities.Car;
import org.example.repository.entities.CarPart;
import org.example.repository.entities.CarPartName;
import org.hibernate.Session;

import java.util.List;

public class CarPartsUtility {
  public static void deleteExisting(Session session) {
    CarPartRepository carPartRepository = new CarPartRepository(session);
    carPartRepository.findAll().stream().map(CarPart::getId).forEach(carPartRepository::delete);
  }

  public static void populate(Session session) {
    final List<CarPartName> names = new CarPartNameRepository(session).findAll();
    CarRepository carRepository = new CarRepository(session);
    final List<Car> cars = carRepository.findAll();
    CarPartRepository carPartRepository = new CarPartRepository(session);
    cars.forEach(car -> names.forEach(name -> {
        CarPart carPart = new CarPart(
          String.valueOf(121000937 + (int)(641332247 * Math.random())),
          ((int)(100 * (12 + 55 * Math.random()))) / 100.,
          10 + (int)(40 * Math.random())
        );
        carPart.setName(name);
       carPart.setCar(car);
        carPartRepository.insert(carPart);
      }
    ));
  }
}
