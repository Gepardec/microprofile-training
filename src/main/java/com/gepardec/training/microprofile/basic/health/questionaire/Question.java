package com.gepardec.training.microprofile.basic.health.questionaire;

import java.util.Map;

class Question<R, A> {

    public String getContent() {
        return content;
    }

    String content;
    Map<R, A> responsesAndAnswers;

    public Question(String content, Map<R, A> responsesAndAnswers) {
        this.content = content;
        this.responsesAndAnswers = responsesAndAnswers;
    }

    public String answer(R response) {
        return responsesAndAnswers.get(response).toString();
    }

}
