package com.mindit.forum.dao;

import com.mindit.forum.dto.AnswerDTO;

import java.util.List;

public interface AnswerDAO {

    void addAns(AnswerDTO answerDTO);
    List<AnswerDTO> getAllAnswers(int id);
    void deleteAnswer(AnswerDTO answerDTO);
    void updateAnswer(AnswerDTO answerDTO);
    List<AnswerDTO> searchAns(String input);
}
