package com.example.resultatms.Repository;

import com.example.resultatms.Entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result,Long> {

    List<Result> findByDomain(String domain);
}
