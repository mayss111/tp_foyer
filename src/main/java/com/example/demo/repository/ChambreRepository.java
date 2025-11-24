package com.example.demo.repository;

import com.example.demo.Entitiy.Chambre;
import org.hibernate.mapping.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ChambreRepository extends JpaRepository<Chambre, Long> {

}
