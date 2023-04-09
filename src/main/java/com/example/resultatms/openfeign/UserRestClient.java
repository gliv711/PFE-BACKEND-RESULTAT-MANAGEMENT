package com.example.resultatms.openfeign;

import com.example.resultatms.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient (name = "USER-SERVICE")
public interface UserRestClient {

    @GetMapping("/api/user/{id}")
    User getUserById(@PathVariable(name = "id") Long id );

    @GetMapping("/api/user/")
    List<User> getAllUsers();
}
