package com.example.demo.service;

import com.example.demo.Entitiy.Foyer;
import com.example.demo.Entitiy.Universite;
import com.example.demo.repository.FoyerRepository;
import com.example.demo.repository.UniversiteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FoyerServiceImpl implements IFoyerService {

    private final FoyerRepository foyerRepository;
    private final UniversiteRepository universiteRepository;

    // ✅ CORRECTION : Constructeur correct
    public FoyerServiceImpl(FoyerRepository foyerRepository, UniversiteRepository universiteRepository) {
        this.foyerRepository = foyerRepository;
        this.universiteRepository = universiteRepository;
    }

    @Override
    public List<Foyer> retrieveAllFoyers() {
        return (List<Foyer>) foyerRepository.findAll(); // ✅ Pas de cast
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return foyerRepository.save(f);
    }

    // ✅ CORRECTION : Supprimez cette méthode en double ou implémentez-la
    @Override
    public Foyer updateFoyer(Long id, Foyer foyer) {
        Foyer existingFoyer = foyerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Foyer non trouvé"));

        // Mettez à jour les champs
        existingFoyer.setNomFoyer(foyer.getNomFoyer());
        existingFoyer.setCapaciteFoyer(foyer.getCapaciteFoyer());

        return foyerRepository.save(existingFoyer);
    }

    // ✅ CORRECTION : Implémentez deleteFoyer
    @Override
    public Foyer deleteFoyer(Long id) {
        Foyer foyer = foyerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Foyer non trouvé"));
        foyerRepository.delete(foyer);
        return foyer;
    }

    @Override
    public List<Foyer> getAllFoyers() {
        return (List<Foyer>) foyerRepository.findAll();
        // ✅ Implémentation correcte
    }

    @Override
    public Foyer getFoyerById(Long id) {
        return foyerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Foyer non trouvé"));
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        // ✅ Vérifiez que le foyer existe avant de mettre à jour
        if (!foyerRepository.existsById(f.getIdFoyer())) {
            throw new RuntimeException("Foyer non trouvé avec ID: " + f.getIdFoyer());
        }
        return foyerRepository.save(f);
    }

    @Override
    public Foyer retrieveFoyer(Long idFoyer) {
        return foyerRepository.findById(idFoyer)
                .orElseThrow(() -> new RuntimeException("Foyer non trouvé"));
    }

    @Override
    public void removeFoyer(Long idFoyer) {
        foyerRepository.deleteById(idFoyer);
    }

    @Override
    public Universite affecterFoyerAUniversite(Long idFoyer, String nomUniversite) {
        Foyer foyer = foyerRepository.findById(idFoyer)
                .orElseThrow(() -> new RuntimeException("Foyer non trouvé"));

        Universite universite = universiteRepository.findByNomUniversite(nomUniversite);
        if (universite == null) {
            throw new RuntimeException("Université non trouvée: " + nomUniversite);
        }

        // ✅ CORRECTION : Utilisez les vrais setters
        universite.setFoyer(foyer);
        foyer.setUniversite(universite);

        return universiteRepository.save(universite);
    }

    @Override
    public Universite desaffecterFoyerAUniversite(Long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new RuntimeException("Université non trouvée"));

        // ✅ CORRECTION : Logique corrigée
        if (universite.getFoyer() != null) {
            Foyer foyer = universite.getFoyer();

            // Désaffecter des deux côtés
            universite.setFoyer(null);
            foyer.setUniversite(null);

            universiteRepository.save(universite);
            foyerRepository.save(foyer); // ✅ Sauvegarder aussi le foyer
        }

        return universite;
    }

    @Override
    public Foyer ajouterFoyerEtAffecterAUniversite(Foyer foyer, Long idUniversite) {
        // ✅ CORRECTION : Supprimez la ligne problématique
        Universite universite = universiteRepository.findById(idUniversite)
                .orElseThrow(() -> new RuntimeException("Université non trouvée"));

        // Sauvegarder le foyer d'abord
        Foyer savedFoyer = foyerRepository.save(foyer);

        // Établir la relation bidirectionnelle
        universite.setFoyer(savedFoyer);
        savedFoyer.setUniversite(universite);

        // Sauvegarder l'université (cascade si configuré)
        universiteRepository.save(universite);

        return savedFoyer;
    }
}