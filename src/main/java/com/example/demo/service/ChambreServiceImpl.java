package com.example.demo.service;

import com.example.demo.Entitiy.Chambre;
import com.example.demo.repository.ChambreRepository;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChambreServiceImpl  implements IChambreService {

    ChambreRepository chambreRepository;
    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);

    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return  chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> allChambres() {
        return    chambreRepository.findAll();
    }

}
