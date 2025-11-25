package com.example.demo.service;

import com.example.demo.Entitiy.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite addUniversite(Universite universite);
    Universite updateUniversite(Universite universite);

    Universite updateUniversite(Long id, Universite universite);

    void deleteUniversite(Long id);
    Universite getUniversite(Long id);
    List<Universite> getUniversites();

    List<Universite> getAllUniversites();

    Universite getUniversiteById(Long id);
}
