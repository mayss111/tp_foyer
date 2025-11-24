package com.example.demo.Entitiy;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

@ToString
public class Reservation{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idReservation;
    String anneReservation;
    boolean estValid;
    @ManyToMany
    List<Etudiant> etudiants ;
}
