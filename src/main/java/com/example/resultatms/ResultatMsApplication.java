package com.example.resultatms;

import com.example.resultatms.Entity.Answer;
import com.example.resultatms.Entity.Question;
import com.example.resultatms.Entity.Result;
import com.example.resultatms.Repository.AnswerRepository;
import com.example.resultatms.Repository.QuestionRepository;
import com.example.resultatms.Repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ResultatMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResultatMsApplication.class, args);
	}

	@Autowired
	private ResultRepository resultRepository;

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	@Bean
	CommandLineRunner commandLineRunner() {
		return args -> {

		};
	}
}
