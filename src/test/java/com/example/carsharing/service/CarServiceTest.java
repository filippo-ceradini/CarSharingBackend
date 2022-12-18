package com.example.carsharing.service;

import com.example.carsharing.model.Car;
import com.example.carsharing.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {
    @Autowired
    private CarService carService;

    @Test
    public void testFindAll() {
        // Create some mock cars and save them to the repository


        Car car1 = new Car(1L, "Ford", "Mustang", 60.0, 15.0);
        Car car2 = new Car(2L, "Chevrolet", "Corvette", 75.0, 20.0);
        Car car3 = new Car(3L, "Mazda", "MX-5", 50.0, 10.0);

        // Test the findAll() method
        List<Car> cars = carService.findAll();

        // Verify that the findAll() method returns the correct list of cars
        assertEquals(2, cars.size());
        assertEquals(1L, cars.get(0).getId());
        assertEquals("Toyota", cars.get(0).getBrand());
        assertEquals("Camry", cars.get(0).getModel());
        assertEquals(2L, cars.get(1).getId());
        assertEquals("Honda", cars.get(1).getBrand());
        assertEquals("Accord", cars.get(1).getModel());
    }

    @Test
    public void testFindById() {
        // Create a mock car and save it to the repository
        Car car = new Car();
        car.setId(1L);
        car.setBrand("Toyota");
        car.setModel("Camry");
        car = carService.save(car);

        // Test the findById() method
        Car foundCar = carService.findById(car.getId());

        // Verify that the findById() method returns the correct car
        assertNotNull(foundCar);
        assertEquals(1L, foundCar.getId());
        assertEquals("Toyota", foundCar.getBrand());
        assertEquals("Camry", foundCar.getModel());
    }

}