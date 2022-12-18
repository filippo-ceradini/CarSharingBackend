package com.example.carsharing.model;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate reservationDate;

    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate rentalDate;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    public Reservation() { }

    public Reservation(Car car, Member member, LocalDate reservationDate, LocalDate rentalDate) {
        this.car = car;
        this.member = member;
        this.reservationDate = reservationDate;
        this.rentalDate = rentalDate;
    }
}
