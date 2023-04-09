package com.example.resultatms.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString

public class Survey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String question;
    private String field;
}
