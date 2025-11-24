package com.example.demo.service;

import com.example.demo.Entitiy.Foyer;
import com.example.demo.repository.FoyerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoyerServiceImpl implements IFoyerService {

    private final FoyerRepository foyerRepository;

    public FoyerServiceImpl(FoyerRepository foyerRepository) {
        this.foyerRepository = foyerRepository;
    }

    @Override
    public Foyer addFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public Foyer updateFoyer(Long id, Foyer foyer) {}


    @Override
    public Foyer deleteFoyer(Long id) {
        Foyer foyer = foyerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Foyer introuvable avec ID : " + id));
        foyerRepository.delete(foyer);
        return foyer;
    }

    @Override
    public List<Foyer> getAllFoyers() {
        return (List<Foyer>) foyerRepository.findAll();
    }
    @Override
    public Foyer getFoyerById(Long id) {
        Foyer foyer = foyerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Foyer introuvable avec ID : " + id));
        return foyer;
    }
}
