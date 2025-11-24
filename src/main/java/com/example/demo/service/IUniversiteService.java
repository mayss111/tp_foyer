package com.example.demo.service;

import com.example.demo.Entitiy.Universite;

import java.util.List;

public interface IUniversiteService {
    Universite addUniversite(Universite universite);
    Universite updateUniversite(Universite universite);
    void deleteUniversite(Long id);
    Universite getUniversite(Long id);
    List<Universite> getUniversites();
}
