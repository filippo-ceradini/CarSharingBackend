package com.example.carsharing.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;


@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String street;
    @Column
    private String city;
    @Column
    private String zip;
    @Column
    private Boolean approved;
    @Column
    private Integer ranking;

    @OneToMany(mappedBy = "member")
    @JsonIgnore
    private Collection<Reservation> reservation;

    public Member() {
    }

    public Member(String firstName, String lastName, String street, String city, String zip, Boolean approved, Integer ranking) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.approved = approved;
        this.ranking = ranking;
    }

    public Member(Long id, String firstName, String lastName, String street, String city, String zip, Boolean approved, Integer ranking) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.approved = approved;
        this.ranking = ranking;
    }
}

