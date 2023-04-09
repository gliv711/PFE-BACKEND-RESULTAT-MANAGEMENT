package com.example.resultatms.services;

import com.example.resultatms.entities.Resultat;

import java.util.List;

public interface ResultatService {

    Resultat getResultatwithUser(Long idRes);
    public List<Resultat> getAllResultat();
}
