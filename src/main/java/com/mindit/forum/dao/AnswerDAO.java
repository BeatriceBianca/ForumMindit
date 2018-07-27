package com.mindit.forum.dao;

import com.mindit.forum.dto.AnswerDTO;

import java.util.List;

public interface AnswerDAO {

    void addAns(AnswerDTO answerDTO);
    List<AnswerDTO> getAllAnswers(int id);

}
