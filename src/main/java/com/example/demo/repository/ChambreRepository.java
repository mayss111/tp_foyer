package com.example.demo.repository;

import com.example.demo.Entity.Chambre;
import com.example.demo.Entity.Typechambre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long> {

    // Méthode avec requête JPQL pour éviter l'interprétation par les mots-clés
    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.typeC = :typeC")
    List<Chambre> findByBlocIdBlocAndTypeC(@Param("idBloc") Long idBloc, @Param("typeC") Typechambre typeC);

    @Query("SELECT c FROM Chambre c JOIN c.bloc b JOIN b.foyer f JOIN f.universite u WHERE u.nomUniversite = :nomUniversite")
    List<Chambre> findChambresByNomUniversite(@Param("nomUniversite") String nomUniversite);

    // Correction : Utiliser @Query pour cette méthode également
    @Query("SELECT c FROM Chambre c JOIN c.bloc b JOIN b.foyer f JOIN f.universite u " +
            "WHERE u.nomUniversite = :nomUniversite AND c.typeC = :type " +
            "AND c NOT IN (SELECT r.chambre FROM Reservation r WHERE r.estValid= true)")
    List<Chambre> findChambresNonReservees(@Param("nomUniversite") String nomUniversite,
                                           @Param("type") Typechambre type);
}