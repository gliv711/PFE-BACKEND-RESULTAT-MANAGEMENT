package com.example.resultatms.services;

import com.example.resultatms.entities.Resultat;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ResultatService {

    Resultat getResultatwithUser(Long idRes);
    public List<Resultat> getAllResultat();
}
