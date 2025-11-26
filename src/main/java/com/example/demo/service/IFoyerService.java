package com.example.demo.service;

import com.example.demo.Entity.Foyer;
import com.example.demo.Entity.Universite;

import java.util.List;

public interface IFoyerService {
    List<Foyer> retrieveAllFoyers();

    Foyer addFoyer(Foyer foyer);
    Foyer updateFoyer(Long id,Foyer foyer);
    Foyer deleteFoyer(Long id);
    List<Foyer> getAllFoyers();
    Foyer getFoyerById(Long id);

    Foyer updateFoyer(Foyer f);

    Foyer retrieveFoyer(Long idFoyer);

    void removeFoyer(Long idFoyer);

    Universite affecterFoyerAUniversite(Long idFoyer, String nomUniversite);

    Universite desaffecterFoyerAUniversite(Long idUniversite);

    Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, Long idUniversite);
}
