package com.example.resultatms.SubmissionController;

import com.example.resultatms.Entity.Answer;
import com.example.resultatms.Entity.QA;
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

import javax.ws.rs.Path;
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

    @GetMapping("/results/count")
    public long count(){
        return surveySubmissionService.count();
    }

   /* @PostMapping("/results")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Map<String, Object> requestBody) {
        // Extract the necessary data from the request body
        String email = (String) requestBody.get("email");
        String domain = (String) requestBody.get("domain");
        List<Map<String, Object>> questionList = (List<Map<String, Object>>) requestBody.get("questions");

        // Create a new Result object
        Result result = new Result();
        result.setEmail(email);
        result.setDomain(domain);

        // Create a new list of Question objects
        List<Question> questions = new ArrayList<>();

        // Check if questionList is not null before iterating
        if (questionList != null) {
            // Iterate over the questionList
            for (Map<String, Object> questionItem : questionList) {
                // Extract the question text and answers from the questionItem
                String questionText = (String) questionItem.get("question");
                List<String> answers = (List<String>) questionItem.get("answers");

                // Create a new Question object
                Question question = new Question();
                question.setQuestion(questionText);

                // Create a new list of Answer objects
                List<Answer> answerList = new ArrayList<>();

                // Iterate over the answers
                for (String answerText : answers) {
                    // Create a new Answer object
                    Answer answer = new Answer();
                    answer.setAnswer(answerText);

                    // Add the Answer object to the list of answers
                    answerList.add(answer);
                }

                // Set the list of answers in the Question object
                question.setAnswers(answerList);

                // Add the Question object to the list of questions
                questions.add(question);
            }
        } else {
            // Handle the case when questionList is null
            // For example, you can log an error message or throw an exception
            // Here, we're just printing an error message
            System.err.println("No question list found!");
        }

        // Set the list of questions in the Result object
        result.setQuestions(questions);

        // Call the surveySubmissionService to save the result
        surveySubmissionService.save(result);
    }*/

    @PostMapping("/results")
    public void saveResults(@RequestBody QA QA) {

        System.out.println(QA);

    }




    @GetMapping("/results/domain/{domain}")
    public List<Result> getAllMailsSurvey(@PathVariable("domain") String domain){
        return surveySubmissionService.getEmailfromSurveys(domain);
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

    @DeleteMapping("/results/{id}")
    public void deleteResult(@PathVariable("id") Long id ){
        this.surveySubmissionService.deleteResult(id);
    }
}
