package com.example.demo.controllers;

import com.example.demo.Entitiy.Bloc;
import com.example.demo.service.IBlocService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Tag(
        name = "Gestion des Blocs",
        description = "Permet d’ajouter, modifier, supprimer et consulter les blocs du foyer."
)
@RestController
@RequestMapping("/api/blocs")
public class BlocController {

    @Autowired
    private IBlocService blocService;

    @GetMapping
    public List<Bloc> getAllBlocs() {
        return blocService.retrieveBlocs();
    }

    @GetMapping("/{id}")
    public Bloc getBlocById(@PathVariable Long id) {
        return blocService.retrieveBloc(id);
    }

    @PostMapping
    public Bloc createBloc(@RequestBody Bloc bloc) {
        return blocService.addBloc(bloc);
    }

    @PutMapping("/{id}")
    public Bloc updateBloc(@PathVariable Long id, @RequestBody Bloc bloc) {
        bloc.setId(id);
        return blocService.updateBloc(bloc);
    }

    @DeleteMapping("/{id}")
    public void deleteBloc(@PathVariable Long id) {
        blocService.removeBloc(id);
    }

    @PutMapping("/{idBloc}/affecter-chambres")
    public Bloc affecterChambresABloc(@PathVariable Long idBloc, @RequestBody List<Long> numChambres) {
        return blocService.affecterChambresABloc(numChambres, idBloc);
    }

}