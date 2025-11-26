package com.example.demo.repository;

import com.example.demo.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
    // Compter les réservations actives par chambre
    @Query("SELECT COUNT(r) FROM Reservation r WHERE r.chambre.idchambre = :idChambre AND r.estValid= true")
    long countReservationsActivesByChambre(@Param("idChambre") Long idChambre);

    // Trouver une réservation active par cin étudiant
    @Query("SELECT r FROM Reservation r JOIN r.etudiants e WHERE e.cin = :cin AND r.estValid = true")
    Reservation findActiveReservationByEtudiantCin(@Param("cin") Long cin);
}