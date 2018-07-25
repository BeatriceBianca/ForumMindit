package com.mindit.forum.dao;

import com.mindit.forum.dto.QuestionDTO;

import java.util.List;
import java.util.Optional;

public interface QuestionDAO {

    List<QuestionDTO> bringQuestions();
    List<String> getAnswers(int id);
}
