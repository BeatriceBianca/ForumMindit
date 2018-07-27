package com.mindit.forum.dao;

import com.mindit.forum.dto.QuestionDTO;

import java.util.List;


public interface QuestionDAO {

    List<QuestionDTO> bringQuestions();
    List<String> getAnswers(int id);

    void addQuest(QuestionDTO quest);
    List<QuestionDTO> getAllQuestions();
    List<QuestionDTO> getUserQuestions(String userName);
    void deleteQuestion(QuestionDTO questionDTO);
    void updateQuestion(QuestionDTO questionDTO);
    List<QuestionDTO> getMyQuestions(String username);
    List<QuestionDTO> search(String input);
}
