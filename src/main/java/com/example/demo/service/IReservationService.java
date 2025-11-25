package com.example.demo.service;

import com.example.demo.Entitiy.Reservation;

import java.util.Date;
import java.util.List;

public interface IReservationService {
    Reservation addReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation);
    void deleteReservation(Long id);
    Reservation getReservationById(Long id);
    List<Reservation> getAllReservations();

    List<Reservation> getAllReservation();

    List<Reservation> retrieveAllReservation();

    Reservation retrieveReservation(String id);

    Reservation ajouterReservation(Long idChambre, Long cinEtudiant);

    Reservation annulerReservation(Long cinEtudiant);

    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversitaire, String nomUniversite);

    List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(String anneeUniversitaire, String nomUniversite);}

