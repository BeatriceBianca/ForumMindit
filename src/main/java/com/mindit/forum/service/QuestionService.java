package com.mindit.forum.service;

import com.mindit.forum.dto.AnswerDTO;
import com.mindit.forum.dto.QuestionDTO;
import java.util.List;


public interface QuestionService {

    List<QuestionDTO> bringQuestions();
    List<String> getAnswers(int id);
    Boolean addQuest(QuestionDTO question);
    List<QuestionDTO> getAllQuestions();
    List<QuestionDTO> getUserQuestions(String userName);
    Boolean deleteQuestion(QuestionDTO questionDTO);
    Boolean updateQuestion(QuestionDTO questionDTO);
    List<QuestionDTO> getMyQuestions(String username);
    List<QuestionDTO> search(String input);
}
