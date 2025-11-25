package com.example.demo.Entitiy;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

@Entity
public class Etudiant {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idEtudiant;
        private String nomE;
        private String prenomE;
        private String cin;
        private String ecole;
        private LocalDate dateNaissance;

        @ManyToMany(mappedBy = "etudiants")
        private List<Reservation> reservations;

    public Set<Reservation> getReservations() {
        return (Set<Reservation>) reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
    }
}



