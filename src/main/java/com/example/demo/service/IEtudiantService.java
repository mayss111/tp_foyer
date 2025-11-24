package com.example.demo.service;

import com.example.demo.Entitiy.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant addEtudiant(Etudiant etudiant);

    void deleteEtudiant(Long id);

    List<Etudiant> getAllEtudiants();
    Etudiant getEtudiantById(int id);
    void deleteEtudiantById(int id);
    Etudiant updateEtudiant(Long id ,Etudiant etudiant);

    Etudiant getEtudiantById(Long id);
}
