package com.example.resultatms.services;

import com.example.resultatms.Repository.ResultatRepository;
import com.example.resultatms.entities.Resultat;
import com.example.resultatms.openfeign.UserRestClient;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ResultatServiceImpl implements ResultatService {

    @Autowired
    UserRestClient userRestClient;

    @Autowired
    ResultatRepository resultatRepository ;


    @Override
    public Resultat getResultatwithUser(Long idRes) {
        return null;
    }

    public List<Resultat> getAllResultat(){

        return resultatRepository.findAll();
    }
}
