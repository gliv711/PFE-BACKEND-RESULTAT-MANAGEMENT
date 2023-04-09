package com.example.resultatms.entities;



import com.example.resultatms.model.Survey;
import com.example.resultatms.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity @Data @AllArgsConstructor @ToString @NoArgsConstructor
public class Resultat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRes;
    @Transient
    private User info ;
    @Transient
    private List<Survey> questions ;
    @Transient
    private List<String> reponses ;

}
