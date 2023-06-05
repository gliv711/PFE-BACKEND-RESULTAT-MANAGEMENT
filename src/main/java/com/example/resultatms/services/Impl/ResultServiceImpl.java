package com.example.resultatms.services.Impl;

import com.example.resultatms.Entity.Result;
import com.example.resultatms.Repository.ResultRepository;
import com.example.resultatms.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    private ResultRepository resultRepository ;




    @Override
    public void save(Result result) {
        resultRepository.save(result);

    }

    @Override
    public List<Result> getAll() {
        return resultRepository.findAll();
    }
    @Override
    public long count(){
        return resultRepository.count();
    }

    @Override
    public List<Result> getEmailfromSurveys(String domain) {
        return resultRepository.findByDomain(domain);
    }
}
