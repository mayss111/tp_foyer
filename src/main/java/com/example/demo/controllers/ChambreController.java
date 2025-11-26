package com.example.demo.controllers;
import com.example.demo.Entity.Chambre;
import com.example.demo.Entity.Typechambre;
import com.example.demo.service.IChambreService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@Tag(
        name="gestion chambre",
        description="CRUD complet pour la gestion des chambres et leur lien avec les blocs")
@RestController
@RequestMapping("/api/chambres")
public class ChambreController {

    @Autowired
    private IChambreService chambreService;

    @GetMapping
    public List<Chambre> getAllChambres() {
        return chambreService.retrieveAllChambres();
    }

    @GetMapping("/{id}")
    public Chambre getChambreById(@PathVariable Long id) {
        return chambreService.retrieveChambre(id);
    }

    @PostMapping
    public Chambre createChambre(@RequestBody Chambre chambre) {
        return chambreService.addChambre(chambre);
    }

    @PutMapping("/{id}")
    public Chambre updateChambre(@PathVariable Long id, @RequestBody Chambre chambre) {
        chambre.setIdChambre(id);
        return chambreService.updateChambre(chambre);
    }

    @GetMapping("/universite/{nomUniversite}")
    public List<Chambre> getChambresParNomUniversite(@PathVariable String nomUniversite) {
        return chambreService.getChambresParNomUniversite(nomUniversite);
    }

    @GetMapping("/bloc/{idBloc}/type/{typeC}")
    public List<Chambre> getChambresParBlocEtType(@PathVariable Long idBloc, @PathVariable Typechambre typeC) {
        return chambreService.getChambresParBlocEtType(idBloc, typeC);
    }

    @GetMapping("/non-reservees/universite/{nomUniversite}/type/{type}")
    public List<Chambre> getChambresNonReserveParNomUniversiteEtTypeChambre(@PathVariable String nomUniversite, @PathVariable Typechambre type) {
        return chambreService.getChambresNonReserveParNomUniversiteEtTypeChambre(nomUniversite, type);
    }
}