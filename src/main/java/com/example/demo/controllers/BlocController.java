package com.example.demo.controllers;

import com.example.demo.Entitiy.Bloc;
import com.example.demo.service.BlocServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@Tag(
        name = "Gestion des Blocs",
        description = "Permet d’ajouter, modifier, supprimer et consulter les blocs du foyer."
)
@RestController
@RequestMapping("/blocs")
public class BlocController {

    private final BlocServiceImpl blocService;

    // ✅ Constructeur explicite pour l’injection du service
    // ✅ Injection par constructeur
    public BlocController(BlocServiceImpl blocService) {
        this.blocService = blocService;
    }

    // CREATE
    @Operation(
            summary = "Ajouter un bloc",
            description = "Crée un nouveau bloc dans la base de données."
    )
    @PostMapping
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blocService.addBloc(bloc);
    }

    // UPDATE
    @Operation(
            summary = "Modifier un bloc",
            description = "Met à jour les informations d’un bloc existant."
    )
    @PutMapping("/{id}")
    public Bloc updateBloc(@PathVariable Long id, @RequestBody Bloc bloc) {
        return blocService.updateBloc(id, bloc);
    }

    // DELETE
    @Operation(
            summary = "Supprimer un bloc",
            description = "Supprime un bloc de la base à partir de son identifiant."
    )
    @DeleteMapping("/{id}")
    public void deleteBloc(@PathVariable Long id) {
        blocService.deleteBloc(id);
    }

    // READ - ALL
    @Operation(
            summary = "Lister tous les blocs",
            description = "Retourne la liste complète des blocs enregistrés dans le système."
    )
    @GetMapping
    public List<Bloc> getAllBlocs() {
        return blocService.getAllBlocs();
    }

    // READ - ONE
    @Operation(
            summary = "Récupérer un bloc par ID",
            description = "Retourne les informations d’un bloc à partir de son identifiant."
    )
    @GetMapping("/{id}")
    public Bloc getBlocById(@PathVariable Long id) {
        return blocService.getBlocById(id);
    }
}