package com.example.demo.service;

import com.example.demo.Entitiy.Foyer;

import java.util.List;

public interface IFoyerService {
    Foyer addFoyer(Foyer foyer);
    Foyer updateFoyer(Long id,Foyer foyer);
    Foyer deleteFoyer(Long id);
    List<Foyer> getAllFoyers();
    Foyer getFoyerById(Long id);
}
