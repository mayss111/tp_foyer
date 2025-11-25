package com.example.demo.service;
import com.example.demo.Entitiy.Chambre;
import com.example.demo.repository.ChambreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.Entitiy.Bloc;
import com.example.demo.repository.BlocRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlocServiceImpl implements IBlocService {
    private final BlocRepository blocRepository;

    public BlocServiceImpl(BlocRepository blocRepository) {
        this.blocRepository = blocRepository;
    }

    @Autowired
    private ChambreRepository chambreRepository;

    @Override
    public List<Bloc> retrieveBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc updateBloc(Long id, Bloc bloc) {
        return null;
    }

    @Override
    public void deleteBloc(Long id) {

    }

    @Override
    public List<Bloc> getAllBlocs() {
        return List.of();
    }

    @Override
    public Bloc getBlocById(Long id) {
        return null;
    }

    @Override
    public Bloc retrieveBloc(Long idBloc) {
        return blocRepository.findById(idBloc).orElse(null);
    }

    @Override
    public void removeBloc(Long idBloc) {
        blocRepository.deleteById(idBloc);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambres, Long idBloc) {
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);
        if (bloc != null) {
            List<Chambre> chambres = chambreRepository.findAllById(numChambres);
            for (Chambre chambre : chambres) {
                chambre.setBloc(bloc);
            }
            chambreRepository.saveAll(chambres);
        }
        return bloc;
    }
}