package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

@ToString
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String numReservation;
    String anneReservation;
    boolean estValid;
    @ManyToMany
    List<Etudiant> etudiants;
    @ManyToMany(mappedBy = "reservations")
    private Set<Etudiant> etudiant;

    @ManyToOne
    private Chambre chambre;

    public void setIdReservation(String id) {
    }

    public void setEstValide(boolean b) {
    }

    public void setAnneeUniversitaire(Date date) {
    }

    public Object getAnneeUniversitaire() {
        return null;
    }
    public Chambre getChambre() {
        return this.chambre;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public Set<Etudiant> getEtudiants() {
        return this.etudiant;

    }

    public Foyer getFoyer() {
        return getFoyer();
    }
}

