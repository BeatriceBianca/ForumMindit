package com.mindit.forum.service;

import com.mindit.forum.dto.AnswerDTO;

import java.util.List;

public interface AnswerService {

    Boolean addAns(AnswerDTO answerDTO);
    List<AnswerDTO> getAllAnswers(int id);
    Boolean deleteAnswer(AnswerDTO answerDTO);
    Boolean updateAnswer(AnswerDTO answerDTO);
    List<AnswerDTO> searchAns(String input);

}
