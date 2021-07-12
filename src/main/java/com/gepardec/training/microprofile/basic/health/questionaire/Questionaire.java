package com.gepardec.training.microprofile.basic.health.questionaire;

import java.util.HashMap;
import java.util.Map;

public class Questionaire {
    Map<Integer, Question<Integer, String>> questions = new HashMap<>();

    public Questionaire() {
        var responsesAndAnswers = new HashMap<Integer, String>();
        responsesAndAnswers.put(1, "Our Wildfly is configured to use one port for the server stuff and one for the application. " +
                "Per specification the health status is \"DOWN\" when a single HealthCheck fails. " +
                "So this makes some sense and is actually okay.");
        responsesAndAnswers.put(2, "Actually everything seems to be working as intended.");
        questions.put(1,
                      new Question<>("Is this okay?",
                                     responsesAndAnswers));

        responsesAndAnswers = new HashMap<>();
        responsesAndAnswers.put(1, "No");
        responsesAndAnswers.put(2, "NoNo");
        questions.put(2,
                      new Question<>("In theory we could disable the default healthchecks, its bugged right now",
                                     responsesAndAnswers));

        responsesAndAnswers = new HashMap<>();
        responsesAndAnswers.put(1, "Works");
        responsesAndAnswers.put(2, "Seems broken");
        questions.put(3,
                      new Question<>("One healtchcheck is \"DOWN\" fix it",
                                     responsesAndAnswers));
    }

    public String getQuestionText(Integer questionKey) {
        return questions.get(questionKey).getQuestionText();
    }

    public String getAnswerForResponse(Integer questionKey, Integer response) {
       return questions.get(questionKey).getAnswer(response);
    }
}
