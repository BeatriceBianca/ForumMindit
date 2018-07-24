package com.mindit.forum.service.impl;

import com.mindit.forum.dao.QuestionDAO;
import com.mindit.forum.dto.QuestionDTO;
import com.mindit.forum.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDAO questionDAO;

    public Boolean addQuest(QuestionDTO question){

        questionDAO.addQuest(question);
        return true;
    }

    public List<QuestionDTO> getAllQuestions(){
        return questionDAO.getAllQuestions();
    }
}
