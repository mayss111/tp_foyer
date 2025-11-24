package com.example.demo.controllers;
import com.example.demo.Entitiy.Chambre;
import com.example.demo.service.IChambreService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@Tag(
        name="gestion chambre",
        description="CRUD complet pour la gestion des chambres et leur lien avec les blocs")
@RequestMapping("/chambre")
public class ChambreController {

    private final IChambreService chambreService;
    public ChambreController(IChambreService chambreService) {
        this.chambreService = chambreService;
    }

    @Operation(summary ="Ajouter une chambre",description = "Creer une nouvellle chamvbre dans  la base de données")
    @PostMapping
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return chambreService.addChambre(chambre);
    }
    @Operation(summary = " Modifier une chambre",description="Met a jour les informations d une existante")
    @PutMapping()
    public Chambre updateChambre(@RequestBody Chambre chambre) {
        return chambreService.updateChambre(chambre);
    }
    @Operation(summary = "Supprimer une chambre",description = "Supprime une chambre a partir de son id ")
    @DeleteMapping("/{id}")
    public void deleteChambre(@PathVariable long idchambre
    ) {
        chambreService.deleteChambre(idchambre);
    }
    @Operation(summary = "Lister toutes les chambres ",description = "Retourne la lise complete des chambres ")
    @GetMapping
    public List<Chambre> getAllChambre() {
        return chambreService.allChambres();
    }
    @Operation(summary = "Lister les chmbres d'un bloc", description="Retourne toutes les chambres appartenant a un bloc donné ")
    @GetMapping("/bloc/{idBloc")
    public List<Chambre> getChambresByBloc(@PathVariable long idBloc) {
        return chambreService.findBlocById(idBloc);

    }
}

