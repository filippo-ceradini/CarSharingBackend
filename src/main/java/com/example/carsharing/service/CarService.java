package com.example.carsharing.service;

import com.example.carsharing.model.Car;
import com.example.carsharing.model.Car;
import com.example.carsharing.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car findById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Transactional
    public void updatedCar(Long id, Car updatedCar) {
        Car car = (Car) carRepository.findAllById(id).orElseThrow(() -> new IllegalStateException("Car with ID " +id +" does not exist in the Database."));
        if(id.equals(updatedCar.getId())){
            carRepository.save(updatedCar);
        }
    }

    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }
}
