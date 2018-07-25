package com.mindit.forum.dto;

public class AnswerDTO {

    private int ansId;
    private int qId;
    private String userName;
    private String ansText;

    public int getAnsId() {
        return ansId;
    }

    public void setAnsId(int ansId) {
        this.ansId = ansId;
    }

    public int getqId() {
        return qId;
    }

    public void setqId(int qId) {
        this.qId = qId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAnsText() {
        return ansText;
    }

    public void setAnsText(String ansText) {
        this.ansText = ansText;
    }

    public AnswerDTO(int ansId, int qId, String userName, String ansText) {
        this.ansId = ansId;
        this.qId = qId;
        this.userName = userName;
        this.ansText = ansText;
    }

    public AnswerDTO() {}
}
