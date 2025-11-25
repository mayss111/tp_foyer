package com.example.demo.repository;

import com.example.demo.Entitiy.Chambre;
import com.example.demo.Entitiy.Typechambre;
import jakarta.persistence.*;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    // Pour la méthode avec keywords
    List<Chambre> findByBlocIdBlocAndTypeC(Long idBloc, Typechambre typeC);

    // Pour la méthode avec JPQL
    @Query("SELECT c FROM Chambre c WHERE c.bloc.idBloc = :idBloc AND c.typechambre = :typeC")
    List<Chambre> findChambresByBlocAndType(@Param("idBloc") Long idBloc, @Param("typeC") Typechambre typeC);

    // Pour les chambres non réservées
    @Query("SELECT c FROM Chambre c WHERE c.bloc.foyer.universite.nomUniversite = :nomUniversite AND c.typechambre = :type AND c NOT IN (SELECT r.chambre FROM Reservation r WHERE r.estValid = true)")
    List<Chambre> findChambresNonReservees(@Param("nomUniversite") String nomUniversite, @Param("type") Typechambre type);

    java.util.List<Chambre> findChambresByNomUniversite(String nomUniversite);
}
