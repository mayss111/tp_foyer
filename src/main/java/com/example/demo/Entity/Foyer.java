package com.example.demo.Entity;

import com.example.demo.Entity.Bloc;
import com.example.demo.Entity.Universite;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "foyer")
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFoyer;

    private String nomFoyer;
    private Long capaciteFoyer;

    // ✅ RELATION AVEC UNIVERSITE - CORRIGÉE
    @OneToOne(mappedBy = "foyer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Universite universite;

    // ✅ RELATION AVEC BLOCS - CORRIGÉE
    @OneToMany(mappedBy = "foyer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Bloc> blocs = new HashSet<>();

    // CONSTRUCTEURS
    public Foyer() {}

    // GETTERS/SETTERS
    public Long getIdFoyer() { return idFoyer; }
    public void setIdFoyer(Long idFoyer) { this.idFoyer = idFoyer; }

    public String getNomFoyer() { return nomFoyer; }
    public void setNomFoyer(String nomFoyer) { this.nomFoyer = nomFoyer; }

    public Long getCapaciteFoyer() { return capaciteFoyer; }
    public void setCapaciteFoyer(Long capaciteFoyer) { this.capaciteFoyer = capaciteFoyer; }

    public Universite getUniversite() { return universite; }
    public void setUniversite(Universite universite) { this.universite = universite; }

    public Set<Bloc> getBlocs() { return blocs; }
    public void setBlocs(Set<Bloc> blocs) { this.blocs = blocs; }

    public void setId(Long id) {
    }
}