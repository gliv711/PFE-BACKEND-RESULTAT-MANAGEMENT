package com.example.resultatms.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "answer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String answer;
    private boolean status;

    @ManyToOne
    @JsonIgnore
    private Question question;
}