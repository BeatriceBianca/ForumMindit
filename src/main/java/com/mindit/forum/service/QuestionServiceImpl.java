package com.mindit.forum.service;

import com.mindit.forum.dao.QuestionDAO;
import com.mindit.forum.dto.QuestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionDAO questionDAO;

    public List<QuestionDTO> bringQuestions(){

        return questionDAO.bringQuestions();
    }

    public List<String> getAnswers(int id){

        return questionDAO.getAnswers(id);
    }


}
