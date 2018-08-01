package com.mindit.forum.dao;

import com.mindit.forum.dto.AnswerDTO;
import com.mindit.forum.dto.QuestionDTO;

import java.util.List;


public interface QuestionDAO {

    List<QuestionDTO> bringQuestions();
    List<AnswerDTO> getAnswers(int id);

    void addQuest(QuestionDTO quest);
    List<QuestionDTO> getAllQuestions();
    List<QuestionDTO> getUserQuestions(String userName);
    void deleteQuestion(QuestionDTO questionDTO);
    void updateQuestion(QuestionDTO questionDTO);
    List<QuestionDTO> getMyQuestions(String username);
    List<QuestionDTO> searchQuest(String input);
    QuestionDTO getQuestion(int id);
}
