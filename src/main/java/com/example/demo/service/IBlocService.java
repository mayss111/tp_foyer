package com.example.demo.service;

import com.example.demo.Entitiy.Bloc;

import java.util.List;

public interface IBlocService {
    Bloc addBloc(Bloc bloc);

    Bloc updateBloc(Long id, Bloc bloc);

    void deleteBloc(Long id);

    List<Bloc> getAllBlocs();

    Bloc getBlocById(Long id);
}
