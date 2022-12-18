package com.example.carsharing.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Collection;


@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String brand;
    @Column
    private String model;
    @Column
    private Double pricePerDay;
    @Column
    private Double bestDiscount;

    @OneToMany(mappedBy = "car")
    @JsonIgnore
    private Collection<Reservation> reservation;

    public Car() {
    }

    public Car(Long id, String brand, String model, Double pricePerDay, Double bestDiscount) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.bestDiscount = bestDiscount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(Double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public Double getBestDiscount() {
        return bestDiscount;
    }

    public void setBestDiscount(Double bestDiscount) {
        this.bestDiscount = bestDiscount;
    }
}
