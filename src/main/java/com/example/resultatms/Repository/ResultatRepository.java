package com.example.resultatms.Repository;

import com.example.resultatms.entities.Resultat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultatRepository extends JpaRepository<Resultat,Long> {
}
