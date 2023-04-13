package com.example.resultatms.web;


import com.example.resultatms.entities.Resultat;
import com.example.resultatms.services.ResultatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ResultatController {
    @Autowired
    ResultatService resultatService ;


    @GetMapping("/api/Resultat")
    public Resultat getAllResultat(){
        return (Resultat) resultatService.getAllResultat();
    }
}
