package com.example.demo.service;

import com.example.demo.Entitiy.Bloc;

import java.util.List;

public interface IBlocService {
    List<Bloc> retrieveBlocs();

    Bloc updateBloc(Bloc bloc);

    Bloc addBloc(Bloc bloc);

    Bloc updateBloc(Long id, Bloc bloc);

    void deleteBloc(Long id);

    List<Bloc> getAllBlocs();

    Bloc getBlocById(Long id);

    Bloc retrieveBloc(Long idBloc);

    void removeBloc(Long idBloc);

    Bloc affecterChambresABloc(List<Long> numChambres, Long idBloc);
}
