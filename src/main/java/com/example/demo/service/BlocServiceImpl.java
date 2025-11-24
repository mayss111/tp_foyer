package com.example.demo.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.demo.Entitiy.Bloc;
import com.example.demo.repository.BlocRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlocServiceImpl implements IBlocService {

    private final BlocRepository blocRepository;

    @Override
    public Bloc addBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public Bloc updateBloc(Long id, Bloc bloc) {
        Bloc existingBloc = blocRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bloc introuvable avec ID : " + id));

        if (bloc.getNomBloc() == null) {
            existingBloc.setNomBloc(bloc.getNomBloc());
        }

        if (bloc.getFoyer() != null) {
            existingBloc.setFoyer(bloc.getFoyer());
        }

        return blocRepository.save(existingBloc);
    }

    @Override
    public void deleteBloc(Long id) {
        if (!blocRepository.existsById(id)) {
            throw new RuntimeException("Bloc introuvable avec ID : " + id);
        }
        blocRepository.deleteById(id);
    }

    @Override
    public List<Bloc> getAllBlocs() {
        return blocRepository.findAll();
    }

    @Override
    public Bloc getBlocById(Long id) {
        return blocRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bloc introuvable avec ID : " + id));
    }
}
