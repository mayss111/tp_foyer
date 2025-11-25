package com.example.demo.service;

import com.example.demo.Entitiy.Chambre;
import com.example.demo.Entitiy.Typechambre;

import java.util.List;

public interface IChambreService {
    Chambre addChambre(Chambre chambre);

    void deleteChambre(Long idChambre);

    Chambre updateChambre(Chambre chambre);

    List<Chambre> allChambres();

    List<Chambre> findBlocById(long idBloc);

    List<Chambre> retrieveAllChambres();

    Chambre retrieveChambre(Long id);

    List<Chambre> getChambresParNomUniversite(String nomUniversite);

    List<Chambre> getChambresParBlocEtType(Long idBloc, Typechambre typeC);

    List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, Typechambre type);
}


