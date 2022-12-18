package com.example.carsharing.service;

import com.example.carsharing.model.Car;
import com.example.carsharing.model.Member;
import com.example.carsharing.model.Reservation;
import com.example.carsharing.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public Reservation findById(Long id) {
        return reservationRepository.findById(id).orElse(null);
    }

    public Reservation save(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    public void deleteById(Long id) {
        reservationRepository.deleteById(id);
    }

    @Transactional
    public void updatedReservation(Long id, Reservation updatedReservation) {
        Reservation reservation = (Reservation) reservationRepository.findAllById(id).orElseThrow(() -> new IllegalStateException("Reservation with ID " +id +" does not exist in the Database."));
        if(id.equals(reservation.getId())){
            reservationRepository.save(updatedReservation);
        }
    }

    public Boolean checkIfAvailable(Reservation reservation) {
        return reservationRepository.findByCarAndRentalDate(reservation.getCar(), reservation.getRentalDate()).isEmpty();
    }

}
