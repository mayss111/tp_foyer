package com.example.demo.service;

import com.example.demo.Entitiy.Chambre;
import java.util.List;

public interface IChambreService {
    Chambre addChambre(Chambre chambre);

    void deleteChambre(Long idChambre);

    Chambre updateChambre(Chambre chambre);

    List<Chambre> allChambres();

    List<Chambre> findBlocById(long idBloc);
}


