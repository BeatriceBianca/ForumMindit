package com.mindit.forum.dao;

import com.mindit.forum.dto.QuestionDTO;

import java.util.List;

public interface QuestionDAO {

    void addQuest(QuestionDTO quest);
    List<QuestionDTO> getAllQuestions();
}
