package com.gepardec.training.microprofile.basic.health.questionnaire;

import java.util.HashMap;
import java.util.Map;

public class Questionnaire {
    Map<Integer, Question<Integer, String>> questions = new HashMap<>();

    public Questionnaire() {
        var responsesAndAnswers = new HashMap<Integer, String>();
        responsesAndAnswers
                .put(1, "Actually only the REST endpoints are specified. " +
                        "They can be served on any port. " +
                        "Some Applications Servers expose them on the application port; " +
                        "some can be configured; " +
                        "and wildfly exposes them on the management port. ");
        responsesAndAnswers
                .put(2, "Try the other answer. ");
        questions.put(1,
                      new Question<>("Look for the /health endpoint at the application port and the wildfly management port. " +
                                             "Is this within the specification?",

                                     responsesAndAnswers));

        responsesAndAnswers = new HashMap<>();
        responsesAndAnswers.put(1, "No");
        responsesAndAnswers
                .put(2, "On wildfly its not supported right now. " +
                        "Probably because there are some issues: " +
                        "The server starts with vendor health checks an the app demands them off. " +
                        "Just one of the deployed apps demands vendor health checks off. ");
        questions.put(2,
                      new Question<>("The spec states that vendor specific health checks can be disabled via mp-config. " +
                                             "Can you do that on wildfly?",
                                     responsesAndAnswers));

        responsesAndAnswers = new HashMap<>();
        responsesAndAnswers.put(1, "Well done!");
        responsesAndAnswers.put(2, "Still \"DOWN\"");
        questions.put(3,
                      new Question<>("Two HealthChecks are \"DOWN\" fix it.",
                                     responsesAndAnswers));
    }

    public String getQuestionText(Integer questionKey) {
        return questions.get(questionKey).getQuestionText();
    }

    public String getAnswerForResponse(Integer questionKey, Integer response) {
        return questions.get(questionKey).getAnswer(response);
    }
}
