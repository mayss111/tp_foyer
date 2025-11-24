package com.example.demo.Entitiy;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

@ToString
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idFoyer;
    String nomFoyer;
    long capaciteFoyer;
    @OneToOne(mappedBy = "foyer")
    Universite  universite;
    @OneToMany(mappedBy = "foyer")
    List<Bloc> bloc ;
}
