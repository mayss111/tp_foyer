package com.example.demo.controllers;
import com.example.demo.service.UniversiteServiceImpl;
import com.example.demo.Entitiy.Universite;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Entity
@Getter
@Setter
@Tag(
        name = "Gestion des Universités",
        description = "CRUD complet pour la gestion des universités"
)
@RestController
@RequestMapping("/universites")
public class UniversiteController {

    private final UniversiteServiceImpl universiteService;

    public UniversiteController(UniversiteServiceImpl universiteService) {
        this.universiteService = universiteService;
    }

    // CREATE
    @Operation(summary = "Ajouter une université", description = "Crée une nouvelle université dans la base de données")
    @PostMapping
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteService.addUniversite(universite);
    }

    // UPDATE
    @Operation(summary = "Modifier une université", description = "Met à jour les informations d'une université existante")
    @PutMapping("/{id}")
    public Universite updateUniversite(@PathVariable Long id, @RequestBody Universite universite) {
        return universiteService.updateUniversite(id, universite);
    }

    @Operation(summary = "Supprimer une université", description = "Supprime une université à partir de son identifiant")
    // DELETE
    @DeleteMapping("/{id}")
    public void deleteUniversite(@PathVariable Long id) {
        universiteService.deleteUniversite(id);
    }

    // READ - ALL
    @Operation(summary = "Lister toutes les universités", description = "Retourne la liste complète des universités")
    @GetMapping
    public List<Universite> getAllUniversites() {
        return universiteService.getAllUniversites();
    }

    // READ - ONE
    @Operation(summary = "Récupérer une université par ID", description = "Retourne les informations d'une université à partir de son identifiant")
    @GetMapping("/{id}")
    public Universite getUniversiteById(@PathVariable Long id) {
        return universiteService.getUniversiteById(id);
    }
}