package com.example.demo.controllers;

import com.example.demo.Entity.Universite;
import com.example.demo.service.IFoyerService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entity.Foyer;

import java.util.List;
@Tag(
        name = "Gestion des Foyers",
        description = "Endpoints pour la création, la mise à jour, la suppression et la consultation des foyers."
)

@RestController
@RequestMapping("/api/foyers")
public class FoyerController {
    @Autowired
    private IFoyerService foyerService;

    @GetMapping
    public List<Foyer> getAllFoyers() {
        return foyerService.retrieveAllFoyers();
    }

    @GetMapping("/{id}")
    public Foyer getFoyerById(@PathVariable Long id) {
        return foyerService.retrieveFoyer(id);
    }

    @PostMapping
    public Foyer createFoyer(@RequestBody Foyer foyer) {
        return foyerService.addFoyer(foyer);
    }

    @PutMapping("/{id}")
    public Foyer updateFoyer(@PathVariable Long id, @RequestBody Foyer foyer) {
        foyer.setId(id);
        return foyerService.updateFoyer(foyer);
    }

    @DeleteMapping("/{id}")
    public void deleteFoyer(@PathVariable Long id) {
        foyerService.removeFoyer(id);
    }

    @PutMapping("/{idFoyer}/affecter-universite")
    public Universite affecterFoyerAUniversite(@PathVariable Long idFoyer, @RequestParam String nomUniversite) {
        return foyerService.affecterFoyerAUniversite(idFoyer, nomUniversite);
    }

    @PutMapping("/desaffecter-universite/{idUniversite}")
    public Universite desaffecterFoyerAUniversite(@PathVariable Long idUniversite) {
        return foyerService.desaffecterFoyerAUniversite(idUniversite);
    }

    @PostMapping("/ajouter-et-affecter/{idUniversite}")
    public Foyer ajouterFoyerEtAffecterAUniversite(@RequestBody Foyer foyer, @PathVariable Long idUniversite) {
        return foyerService.ajouterFoyerEtAffecterAUniversite(foyer, idUniversite);
    }
}