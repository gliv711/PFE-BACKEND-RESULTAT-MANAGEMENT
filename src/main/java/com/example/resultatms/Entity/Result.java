package com.example.resultatms.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "survey_result")
@Data
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String domain;
    private String email ;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "result_id")
    private List<Question> questions;
    private int score ;
}
