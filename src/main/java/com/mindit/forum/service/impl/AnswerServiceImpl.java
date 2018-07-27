package com.mindit.forum.service.impl;

import com.mindit.forum.dao.AnswerDAO;
import com.mindit.forum.dto.AnswerDTO;
import com.mindit.forum.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerDAO answerDAO;

    public Boolean addAns(AnswerDTO answerDTO){
        answerDAO.addAns(answerDTO);
        return true;
    }

    public List<AnswerDTO> getAllAnswers(int id){

        return answerDAO.getAllAnswers(id);
    }

}
