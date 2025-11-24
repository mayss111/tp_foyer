package tn.esprit.tp1.controller;

import com.example.demo.service.FoyerServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Entitiy.Foyer;

import java.util.List;
@Tag(
        name = "Gestion des Foyers",
        description = "Endpoints pour la création, la mise à jour, la suppression et la consultation des foyers."
)
@RestController
@RequestMapping("/foyers")
public class FoyerController {

    private final FoyerServiceImpl foyerService;

    // ✅ Constructeur explicite
    public FoyerController(FoyerServiceImpl foyerService) {
        this.foyerService = foyerService;
    }

    // CREATE
    @Operation(
            summary = "Ajouter un foyer",
            description = "Crée un nouveau foyer et l’enregistre dans la base de données."
    )
    @PostMapping
    public Foyer addFoyer(@RequestBody Foyer foyer) {
        return foyerService.addFoyer(foyer);
    }

    // UPDATE
    @Operation(
            summary = "Mettre à jour un foyer",
            description = "Modifie les informations d’un foyer existant à partir de son ID."
    )
    @PutMapping("/{id}")
    public Foyer updateFoyer(@PathVariable Long id, @RequestBody Foyer foyer) {
        return foyerService.updateFoyer(id, foyer);
    }
    @Operation(
            summary = "Supprimer un foyer",
            description = "Supprime un foyer en utilisant son identifiant."
    )
    // DELETE
    @DeleteMapping("/{id}")
    public void deleteFoyer(@PathVariable Long id) {
        foyerService.deleteFoyer(id);
    }

    // READ - ALL
    @Operation(
            summary = "Lister tous les foyers",
            description = "Retourne la liste complète des foyers enregistrés."
    )
    @GetMapping
    public List<Foyer> getAllFoyers() {
        return foyerService.getAllFoyers();
    }

    // READ - ONE
    @Operation(
            summary = "Récupérer un foyer par ID",
            description = "Retourne les détails d’un foyer spécifique à partir de son identifiant."
    )
    @GetMapping("/{id}")
    public Foyer getFoyerById(@PathVariable Long id) {
        return foyerService.getFoyerById(id);
    }
}