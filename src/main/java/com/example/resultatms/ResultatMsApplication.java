package com.example.resultatms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ResultatMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResultatMsApplication.class, args);
	}

}
