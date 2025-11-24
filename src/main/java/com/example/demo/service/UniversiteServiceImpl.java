package com.example.demo.service;

import com.example.demo.Entitiy.Universite;
import com.example.demo.repository.UniversiteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UniversiteServiceImpl implements IUniversiteService {

    private final UniversiteRepository universiteRepository;

    public UniversiteServiceImpl(UniversiteRepository universiteRepository) {
        this.universiteRepository = universiteRepository;
    }

    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite updateUniversite(Long id, Universite universite) {
        Universite existingUniversite = universiteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Université introuvable avec ID : " + id));

        if (universite.getNomUniversite() != null)
            existingUniversite.setNomUniversite(universite.getNomUniversite());

        if (universite.getAdresse() != null)
            existingUniversite.setAdresse(universite.getAdresse());

        return universiteRepository.save(existingUniversite);
    }

    @Override
    public void deleteUniversite(Long id) {
        if (!universiteRepository.existsById(id)) {
            throw new RuntimeException("Université introuvable avec ID : " + id);
        }
        universiteRepository.deleteById(id);
    }

    @Override
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite getUniversiteById(Long id) {
        return universiteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Université introuvable avec ID : " + id));
    }
}