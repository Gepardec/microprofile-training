package com.gepardec.training.microprofile.basic.health.questionnaire;

import java.util.Map;

class Question<R, A> {
    String questionText;
    Map<R, A> responsesAndAnswers;

    public Question(String question, Map<R, A> responsesAndAnswers) {
        this.questionText = question;
        this.responsesAndAnswers = responsesAndAnswers;
    }

    public String getQuestionText() {
        return questionText;
    }

    public A getAnswer(R response) {
        return responsesAndAnswers.get(response);
    }

}
