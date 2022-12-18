package com.example.carsharing.controller;

import com.example.carsharing.model.Reservation;
import com.example.carsharing.model.Reservation;
import com.example.carsharing.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@CrossOrigin
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public List<Reservation> findAll() {
        return reservationService.findAll();
    }

    @GetMapping("/{id}")
    public Reservation findById(@PathVariable Long id) {
        return reservationService.findById(id);
    }

    @PostMapping
    public Reservation save(@RequestBody Reservation reservation) {
        return reservationService.save(reservation);
    }

    @PostMapping("/free")
    public ResponseEntity<Boolean> checkCarAvailability(@RequestBody Reservation reservation) {
        Boolean availability = reservationService.checkIfAvailable(reservation);
        return new ResponseEntity<>(availability, HttpStatus.OK);
    }


    @PutMapping
    public void updateReservation(@RequestBody Reservation reservation) {
        reservationService.updatedReservation(reservation.getId(), reservation);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        reservationService.deleteById(id);
    }
}
