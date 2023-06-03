package com.example.resultatms.SubmissionController;

import com.example.resultatms.Entity.Answer;
import com.example.resultatms.Entity.Question;
import com.example.resultatms.Entity.Result;
import com.example.resultatms.Repository.AnswerRepository;
import com.example.resultatms.services.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ResultController {
    @Autowired
    private ResultService surveySubmissionService ;
    @Autowired
    private AnswerRepository answerRepository;



    @PostMapping("/results/") @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Map<String, Object> requestBody) {
        // Extract the necessary data from the request body
        String email = (String) requestBody.get("email");
        String domain = (String) requestBody.get("domain");
        List<Map<String, String>> resultList = (List<Map<String, String>>) requestBody.get("resultList");

        // Create a new Result object
        Result result = new Result();
        result.setEmail(email);
        result.setDomain(domain);

        // Create a new list of Question objects
        List<Question> questions = new ArrayList<>();

        // Iterate over the resultList
        for (Map<String, String> resultItem : resultList) {
            // Extract the question and answer from the resultItem
            String questionText = resultItem.get("question");
            String answerText = resultItem.get("answer");

            // Create a new Question object
            Question question = new Question();
            question.setQuestion(questionText);

            // Create a new list of Answer objects
            List<Answer> answers = new ArrayList<>();

            // Create a new Answer object
            Answer answer = new Answer();
            answer.setAnswer(answerText);

            // Add the Answer object to the list of answers
            answers.add(answer);

            // Set the list of answers in the Question object
            question.setAnswers(answers);

            // Add the Question object to the list of questions
            questions.add(question);
        }

        // Set the list of questions in the Result object
        result.setQuestions(questions);

        surveySubmissionService.save(result);
    }

    @GetMapping("/results/all")
    public List<Result> getAll(){
        return surveySubmissionService.getAll();
    }

    @GetMapping("/answers/{id}")
    public ResponseEntity<Answer> getAnswerFromApi(@PathVariable("id") Long id ){
        RestTemplate restTemplate = new RestTemplate();
        String surveyManagementUrl = "http://localhost:8888/SURVEY-MANAGEMENT/api/answers/{id}";
        ResponseEntity<Answer> response = restTemplate.exchange(
                surveyManagementUrl,
                HttpMethod.GET,
                null,
                Answer.class,
                id
        );
        return response;
    }
    @GetMapping("/questions/{id}")
    public ResponseEntity<Question> getQuestionFromApi(@PathVariable("id") Long id ){
        RestTemplate restTemplate = new RestTemplate();
        String surveyManagementUrl = "http://localhost:8888/SURVEY-MANAGEMENT/api/questions/{id}";
        ResponseEntity<Question> response = restTemplate.exchange(
                surveyManagementUrl,
                HttpMethod.GET,
                null,
                Question.class,
                id
        );
        return response;
    }

}
