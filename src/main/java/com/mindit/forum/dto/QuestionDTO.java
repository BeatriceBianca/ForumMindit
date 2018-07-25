package com.mindit.forum.dto;

public class QuestionDTO {

    private int questId;
    private String userName;
    private String questText;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

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

    public QuestionDTO(int questId, String userName, String questText) {
        this.questId = questId;
        this.userName = userName;
        this.questText = questText;
    }

    public QuestionDTO(){}
}
