package com.mindit.forum.dto;

import java.util.List;

public class QuestionDTO {

    private int id;
    private String questText;


    public QuestionDTO() {};

    public QuestionDTO(int id, String questText) {
        this.id = id;
        this.questText = questText;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestText() {
        return questText;
    }

    public void setQuestText(String questText) {
        this.questText = questText;
    }
}
