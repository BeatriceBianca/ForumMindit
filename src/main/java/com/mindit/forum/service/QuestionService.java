package com.mindit.forum.service;

import com.mindit.forum.dto.QuestionDTO;

import java.util.List;

public interface QuestionService {

    Boolean addQuest(QuestionDTO question);
    List<QuestionDTO> getAllQuestions();
    List<QuestionDTO> getUserQuestions(String userName);
}
