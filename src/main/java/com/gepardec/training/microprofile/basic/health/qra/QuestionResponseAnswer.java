package com.gepardec.training.microprofile.basic.health.qra;

import java.util.HashMap;
import java.util.Map;

public class QuestionResponseAnswer {
    Map<Integer, Question<Integer, String>> questions = new HashMap<>();

    public QuestionResponseAnswer() {
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

    public String getAnswerForResponse(Integer questionKey, Integer response) {
       return questions.get(questionKey).answer(response);
    }

    public String getQuestion(Integer questionKey) {
    return questions.get(questionKey).getContent();
    }
}
