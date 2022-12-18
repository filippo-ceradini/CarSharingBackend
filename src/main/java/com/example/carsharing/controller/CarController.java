package com.example.carsharing.controller;

import com.example.carsharing.model.Car;
import com.example.carsharing.model.Car;
import com.example.carsharing.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
@CrossOrigin
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public List<Car> findAll() {
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public Car findById(@PathVariable Long id) {
        return carService.findById(id);
    }

    @PostMapping
    public Car save(@RequestBody Car car) {
        return carService.save(car);
    }
    @PutMapping
    public void updateCar(@RequestBody Car car) {
        carService.updatedCar(car.getId(), car);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        carService.deleteById(id);
    }
}
