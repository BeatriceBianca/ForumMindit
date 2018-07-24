package com.mindit.forum.dto;

public class QuestionDTO {

    private int questId;
    private String questText;

    public int getQuestId() {
        return questId;
    }

    public void setQuestId(int questId) {
        this.questId = questId;
    }

    public String getQuestText() {
        return questText;
    }

    public void setQuestText(String questText) {
        this.questText = questText;
    }

    public QuestionDTO(int questId, String questText) {
        this.questId = questId;
        this.questText = questText;
    }

    public QuestionDTO(){}
}
