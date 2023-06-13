package com.example.resultatms.Entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import java.util.List;



@NoArgsConstructor
@AllArgsConstructor
@ToString
public class QA {
    private List<Question> qs;
    private List<Long> answers ;
}
