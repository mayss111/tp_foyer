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
    @OneToMany(mappedBy = "foyer", cascade = CascadeType.ALL)
    private Set<Bloc> blocs = new HashSet<>();;
    private Foyer foyer;

    public void setId(Long id) {
    }
    public void setUniversite(Universite universite) {
        this.universite = universite;
    }
    public void setCapaciteFoyer(long capaciteFoyer) {
        this.capaciteFoyer = capaciteFoyer;
    }

    public void setNomFoyer(String nomFoyer) {
        this.nomFoyer = nomFoyer;
    }

    public long getCapaciteFoyer() {
        return capaciteFoyer;
    }
    public String getNomFoyer() {
        return nomFoyer;
    }
    public Universite getUniversite() {
        return universite;
    }
    public Set<Bloc> getBlocs() {
        return blocs;
    }

    public long getIdFoyer() {
        return idFoyer;
    }

    public Foyer getFoyer(Foyer foyer) {
        return this.foyer;
    }
}
