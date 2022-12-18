package com.example.carsharing.common;

import com.example.carsharing.model.Car;
import com.example.carsharing.model.Member;
import com.example.carsharing.model.Reservation;
import com.example.carsharing.repository.CarRepository;
import com.example.carsharing.repository.MemberRepository;
import com.example.carsharing.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import javax.annotation.PostConstruct;
import java.net.ProxySelector;
import java.sql.Date;
import java.time.LocalDate;

@Configuration
public class InitialData {

    @Autowired
    CarRepository carRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @PostConstruct
    public void initializeData() {

        Car car1 = new Car(1L, "Ford", "Mustang", 60.0, 15.0);
        Car car2 = new Car(2L, "Chevrolet", "Corvette", 75.0, 20.0);
        Car car3 = new Car(3L, "Mazda", "MX-5", 50.0, 10.0);
        Car car4 = new Car(4L, "Nissan", "Altima", 45.0, 5.0);
        Car car5 = new Car(5L, "Hyundai", "Sonata", 40.0, 7.5);
        Car car6 = new Car(6L, "Kia", "Optima", 35.0, 5.0);
        Car car7 = new Car(7L, "Subaru", "Outback", 50.0, 10.0);
        Car car8 = new Car(8L, "Volkswagen", "Jetta", 45.0, 7.5);
        Car car9 = new Car(9L, "Toyota", "RAV4", 55.0, 15.0);
        Car car10 = new Car(10L, "Honda", "CR-V", 60.0, 20.0);
        carRepository.save(car1);
        carRepository.save(car2);
        carRepository.save(car3);
        carRepository.save(car4);
        carRepository.save(car5);
        carRepository.save(car6);
        carRepository.save(car7);
        carRepository.save(car8);
        carRepository.save(car9);
        carRepository.save(car10);

        Member member1 = new Member("John", "Doe", "123 Main St", "New York", "10001", true, 1);
        Member member2 = new Member("Jane", "Smith", "456 Park Ave", "Los Angeles", "90210", false, 2);
        Member member3 = new Member("Bob", "Johnson", "789 Pine St", "Chicago", "60606", true, 3);
        Member member4 = new Member("Alice", "Williams", "321 Maple St", "Houston", "77777", false, 4);
        Member member5 = new Member("Eve", "Jones", "159 Oak St", "Philadelphia", "19119", true, 5);
        Member member6 = new Member("Frank", "Brown", "753 Cedar St", "Phoenix", "85014", false, 6);
        Member member7 = new Member("Gina", "Garcia", "246 Birch St", "San Antonio", "78205", true, 7);
        Member member8 = new Member("Henry", "Lee", "369 Willow St", "San Diego", "92108", false, 8);
        Member member9 = new Member("Ivy", "Taylor", "159 Maple St", "Dallas", "75201", true, 9);
        Member member10 = new Member("Julia", "Roberts", "753 Pine St", "San Jose", "95112", false, 10);
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);
        memberRepository.save(member5);
        memberRepository.save(member6);
        memberRepository.save(member7);
        memberRepository.save(member8);
        memberRepository.save(member9);
        memberRepository.save(member10);


        Reservation reservation1 = new Reservation(car1, member1, LocalDate.of(2022, 1, 1), LocalDate.of(2022, 1, 5));
        Reservation reservation2 = new Reservation(car2, member2, LocalDate.of(2022, 2, 15), LocalDate.of(2022, 2, 20));
        Reservation reservation3 = new Reservation(car3, member3, LocalDate.of(2022, 3, 1), LocalDate.of(2022, 3, 5));
        Reservation reservation4 = new Reservation(car4, member4, LocalDate.of(2022, 4, 15), LocalDate.of(2022, 4, 20));
        Reservation reservation5 = new Reservation(car5, member5, LocalDate.of(2022, 5, 1), LocalDate.of(2022, 5, 5));
        Reservation reservation6 = new Reservation(car6, member6, LocalDate.of(2022, 6, 15), LocalDate.of(2022, 6, 20));
        Reservation reservation7 = new Reservation(car7, member7, LocalDate.of(2022, 7, 1), LocalDate.of(2022, 7, 5));
        Reservation reservation8 = new Reservation(car8, member8, LocalDate.of(2022, 8, 15), LocalDate.of(2022, 8, 20));
        Reservation reservation9 = new Reservation(car9, member9, LocalDate.of(2022, 9, 1), LocalDate.of(2022, 9, 5));
        Reservation reservation10 = new Reservation(car10, member10, LocalDate.of(2022, 10, 15), LocalDate.of(2022, 10, 20));
        reservationRepository.save(reservation1);
        reservationRepository.save(reservation2);
        reservationRepository.save(reservation3);
        reservationRepository.save(reservation4);
        reservationRepository.save(reservation5);
        reservationRepository.save(reservation6);
        reservationRepository.save(reservation7);
        reservationRepository.save(reservation8);
        reservationRepository.save(reservation9);
        reservationRepository.save(reservation10);



    }

}
