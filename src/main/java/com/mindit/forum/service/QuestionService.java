package com.mindit.forum.service;

import com.mindit.forum.dto.QuestionDTO;

import java.util.List;
import java.util.Optional;

public interface QuestionService {

    List<QuestionDTO> bringQuestions();
    List<String> getAnswers(int id);
}
