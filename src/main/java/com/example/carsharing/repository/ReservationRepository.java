package com.example.carsharing.repository;

import com.example.carsharing.model.Car;
import com.example.carsharing.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Object> findAllById(Long id);
    Optional<Object> findByCarAndRentalDate(Car car, LocalDate date);
}
