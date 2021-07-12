package com.gepardec.training.microprofile.basic.health.questionaire;

import java.util.HashMap;
import java.util.Map;

public class Questionaire {
    Map<Integer, Question<Integer, String>> questions = new HashMap<>();

    public Questionaire() {
        var responsesAndAnswers = new HashMap<Integer, String>();
        responsesAndAnswers.put(1, "Yes!");
        responsesAndAnswers.put(2, "No");
        questions.put(1,
                      new Question<>("Does this work?",
                                     responsesAndAnswers));

        responsesAndAnswers = new HashMap<>();
        responsesAndAnswers.put(1, "YesYes!");
        responsesAndAnswers.put(2, "NoNo");
        questions.put(2,
                      new Question<>("Does this still work?",
                                     responsesAndAnswers));
    }

    public String getQuestion(Integer questionKey) {
        return questions.get(questionKey).getQuestionText();
    }

    public String getAnswerForResponse(Integer questionKey, Integer response) {
       return questions.get(questionKey).getAnswer(response);
    }
}
