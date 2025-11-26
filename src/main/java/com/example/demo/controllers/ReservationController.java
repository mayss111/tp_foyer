package com.example.demo.controllers;

import com.example.demo.Entity.Reservation;
import com.example.demo.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private IReservationService reservationService;

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.retrieveAllReservation();
    }
    @GetMapping("/{id}")
    public Reservation getReservationById(@PathVariable String id) {
        return reservationService.retrieveReservation(id);
    }

    @PutMapping("/{id}")
    public Reservation updateReservation(@PathVariable String id, @RequestBody Reservation reservation) {
        reservation.setIdReservation(id);
        return reservationService.updateReservation(reservation);
    }

    @PostMapping("/ajouter/{idChambre}/{cinEtudiant}")
    public Reservation ajouterReservation(@PathVariable Long idChambre, @PathVariable Long cinEtudiant) {
        return reservationService.ajouterReservation(idChambre, cinEtudiant);
    }

    @PutMapping("/annuler/{cinEtudiant}")
    public Reservation annulerReservation(@PathVariable Long cinEtudiant) {
        return reservationService.annulerReservation(cinEtudiant);
    }

    @GetMapping("/recherche")
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(@RequestParam String anneeUniversitaire, @RequestParam String nomUniversite) {
        return reservationService.getReservationParAnneeUniversitaireEtNomUniversite(anneeUniversitaire , nomUniversite);
    }
}