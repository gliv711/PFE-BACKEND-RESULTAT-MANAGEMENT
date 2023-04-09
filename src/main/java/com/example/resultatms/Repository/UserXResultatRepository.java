package com.example.resultatms.Repository;

import com.example.resultatms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserXResultatRepository extends JpaRepository<User,Long> {
}
