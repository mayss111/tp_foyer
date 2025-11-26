package com.example.demo.service;

import com.example.demo.Entity.Chambre;
import com.example.demo.Entity.Etudiant;
import com.example.demo.Entity.Reservation;
import com.example.demo.repository.ChambreRepository;
import com.example.demo.repository.EtudiantRepository;
import com.example.demo.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements IReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ChambreRepository chambreRepository;

    @Autowired
    private EtudiantRepository etudiantRepository;

    @Override
    public List<Reservation> retrieveAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation addReservation(Reservation reservation) {
        return null;
    }

    @Override
    public Reservation updateReservation(Reservation res) {
        return reservationRepository.save(res);
    }

    @Override
    public void deleteReservation(Long id) {

    }

    @Override
    public Reservation getReservationById(Long id) {
        return null;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return List.of();
    }

    @Override
    public List<Reservation> getAllReservation() {
        return List.of();
    }

    @Override
    public Reservation retrieveReservation(String idReservation) {
        return reservationRepository.findById(idReservation).orElse(null);
    }

    @Override
    public Reservation ajouterReservation(Long idChambre, Long cinEtudiant) {
        Chambre chambre = chambreRepository.findById(idChambre).orElse(null);
        Etudiant etudiant = etudiantRepository.findByCin(cinEtudiant);

        if (chambre != null && etudiant != null) {
            // Vérifier la capacité
            long reservationsActives = reservationRepository.countReservationsActivesByChambre(idChambre);
            long capacite = chambre.getTypeC().getCapacite();
            if (reservationsActives < capacite) {
                // Créer l'ID de réservation
                String idReservation = chambre.getNumeroChambre() + "-" + chambre.getBloc().getNomBloc() + "-" + new SimpleDateFormat("yyyy").format(new Date());
                Reservation reservation = new Reservation();
                reservation.setIdReservation(idReservation);
                reservation.setEstValide(true);
                reservation.setAnneeUniversitaire(new Date());
                reservation.setChambre(chambre);
                reservation.getEtudiants().add(etudiant);
                return reservationRepository.save(reservation);
            }
        }
        return null;
    }

    @Override
    public Reservation annulerReservation(Long cinEtudiant) {
        Reservation reservation = reservationRepository.findActiveReservationByEtudiantCin(cinEtudiant);
        if (reservation != null) {
            reservation.setEstValide(false);
            return reservationRepository.save(reservation);
        }
        return null;
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(Date anneeUniversitaire, String nomUniversite) {
        return List.of();
    }

    @Override
    public List<Reservation> getReservationParAnneeUniversitaireEtNomUniversite(String anneeUniversitaire, String nomUniversite) {
        // Implémentation simple - vous devrez peut-être ajuster la requête
        return reservationRepository.findAll().stream()
                .filter(r -> r.getAnneeUniversitaire().equals(anneeUniversitaire) &&
                        r.getChambre().getBloc().getFoyer().getUniversite().getNomUniversite().equals(nomUniversite))
                .collect(Collectors.toList());
    }
}