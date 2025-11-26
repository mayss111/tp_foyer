package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "universite")
public class Universite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUniversite;

    @Column(unique = true)
    private String nomUniversite;

    private String adresse;

    // ✅ RELATION AVEC FOYER - CORRIGÉE
    @OneToOne
    @JoinColumn(name = "foyer_id")
    private Foyer foyer;

    // CONSTRUCTEURS
    public Universite() {}

    // GETTERS/SETTERS
    public Long getIdUniversite() { return idUniversite; }
    public void setIdUniversite(Long idUniversite) { this.idUniversite = idUniversite; }

    public String getNomUniversite() { return nomUniversite; }
    public void setNomUniversite(String nomUniversite) { this.nomUniversite = nomUniversite; }

    public String getAdresse() { return adresse; }
    public void setAdresse(String adresse) { this.adresse = adresse; }

    public Foyer getFoyer() { return foyer; }
    public void setFoyer(Foyer foyer) { this.foyer = foyer; }
}