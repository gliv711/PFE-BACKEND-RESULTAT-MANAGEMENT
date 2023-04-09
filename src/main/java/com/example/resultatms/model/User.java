package com.example.resultatms.model;


import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor @AllArgsConstructor
public class User {
    private Long id ;
    private String nom ;
    private String prenom;
    private String email ;
    private String mdp ;
    private String type;


}
