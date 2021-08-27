package com.gepardec.training.microprofile.basic.health;

import com.gepardec.training.microprofile.basic.health.questionnaire.Questionnaire;
import com.gepardec.training.microprofile.basic.health.taskchecker.QuestionThree;
import com.gepardec.training.microprofile.basic.health.taskchecker.TaskChecker;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Named
@ApplicationScoped
public class HealthState {

    Questionnaire questionnaire = new Questionnaire();
    Map<Integer, TaskChecker> taskCheckers = new HashMap<>();
    Map<Integer, String> givenResponsesAndTheAnswers = new HashMap<>();

    public HealthState() {
        taskCheckers
                .put(3, new QuestionThree());
    }

    public Response takeUserResponse(Integer questionKey, Integer response) {
        givenResponsesAndTheAnswers
                .put(questionKey, questionnaire
                        .getAnswerForResponse(questionKey, response));
        return Response.noContent().build();
    }

    @SuppressWarnings("unused")
    public String questionText(Integer questionKey) {
        return questionnaire.getQuestionText(questionKey);
    }

    @SuppressWarnings("unused")
    public String answer(Integer questionKey) {
        return givenResponsesAndTheAnswers.getOrDefault(questionKey, "No Answer yet");
    }

    public void checkTaskDone(Integer questionKey, Object taskObject) {
        takeUserResponse(questionKey, taskCheckers.get(questionKey).check(questionKey,taskObject));
    }
}
