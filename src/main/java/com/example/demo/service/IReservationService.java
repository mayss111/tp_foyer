package com.example.demo.service;

import com.example.demo.Entitiy.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation addReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation);
    void deleteReservation(Long id);
    Reservation getReservationById(Long id);
    List<Reservation> getAllReservations();

    List<Reservation> getAllReservation();
}
