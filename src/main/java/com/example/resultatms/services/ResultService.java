package com.example.resultatms.services;


import com.example.resultatms.Entity.Result;

import java.util.List;

public interface ResultService {

    void save(Result surveySubmission) ;

    List<Result> getAll() ;
    long count();

    List<Result> getEmailfromSurveys(String domain);
}
