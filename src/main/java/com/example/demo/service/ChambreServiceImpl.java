package com.example.demo.service;

import com.example.demo.Entitiy.Chambre;
import com.example.demo.Entitiy.Typechambre;
import com.example.demo.repository.ChambreRepository;
import com.example.demo.repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChambreServiceImpl implements IChambreService {

    @Autowired
    private ChambreRepository chambreRepository;

    @Autowired
    private UniversiteRepository universiteRepository;

    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public void deleteChambre(Long idChambre) {

    }

    @Override
    public Chambre updateChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    @Override
    public List<Chambre> allChambres() {
        return List.of();
    }

    @Override
    public List<Chambre> findBlocById(long idBloc) {
        return List.of();
    }

    @Override
    public Chambre retrieveChambre(Long idChambre) {
        return chambreRepository.findById(idChambre).orElse(null);
    }

    @Override
    public List<Chambre> getChambresParNomUniversite(String nomUniversite) {
        return chambreRepository.findChambresByNomUniversite(nomUniversite);
    }

    @Override
    public List<Chambre> getChambresParBlocEtType(Long idBloc, Typechambre typeC) {
        // Solution avec keywords
        return (List<Chambre>) chambreRepository.findByBlocIdBlocAndTypeC(idBloc, typeC);
        // Ou avec JPQL
        // return chambreRepository.findChambresByBlocAndType(idBloc, typeC);
    }

    @Override
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(String nomUniversite, Typechambre type) {
        return (List<Chambre>) chambreRepository.findChambresNonReservees(nomUniversite, type);
    }
}