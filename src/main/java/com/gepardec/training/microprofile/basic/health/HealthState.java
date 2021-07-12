package com.gepardec.training.microprofile.basic.health;

import com.gepardec.training.microprofile.basic.health.questionaire.Questionaire;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Named
@ApplicationScoped
public class HealthState {

    Questionaire questionaire = new Questionaire();

     Map<Integer,String> givenResponsesAndTheAnswers= new HashMap<>();

     public Response respond(Integer questionKey, Integer response)  {
         givenResponsesAndTheAnswers
                 .put(questionKey, questionaire
                         .getAnswerForResponse(questionKey, response));
         return Response.noContent().build();
     }

     public String question(Integer questionKey) {
         return questionaire.getQuestion(questionKey);
     }

    public String answer(Integer questionKey) {
        return givenResponsesAndTheAnswers.getOrDefault(questionKey,"No Answer yet");
    }
}
