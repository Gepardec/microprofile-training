package com.gepardec.training.microprofile.basic.health;

import com.gepardec.training.microprofile.basic.health.qra.QuestionResponseAnswer;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named
@ApplicationScoped
public class HealthState {

    QuestionResponseAnswer questionaire = new QuestionResponseAnswer();

     Map<Integer,String> givenResponsesAndTheAnswers= new HashMap<>();

     public String respond(Integer questionKey,Integer response)  {
         givenResponsesAndTheAnswers
                 .putIfAbsent(questionKey, questionaire
                         .getAnswerForResponse(questionKey, response));
         return "index";
     }

     public String question(Integer questionKey) {
         return questionaire.getQuestion(questionKey);
     }

    public String answer(Integer questionKey) {
        return givenResponsesAndTheAnswers.getOrDefault(questionKey,"No Answer yet");
    }
}
