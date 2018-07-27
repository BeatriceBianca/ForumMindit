package com.mindit.forum.service.impl;

import com.mindit.forum.dao.QuestionDAO;
import com.mindit.forum.dto.AnswerDTO;
import com.mindit.forum.dto.QuestionDTO;
import com.mindit.forum.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDAO questionDAO;

    public Boolean addQuest(QuestionDTO question) {

        questionDAO.addQuest(question);
        return true;
    }

    public List<QuestionDTO> getAllQuestions() {
        return questionDAO.getAllQuestions();
    }

    public List<QuestionDTO> getUserQuestions(String userName) {
        return questionDAO.getUserQuestions(userName);
    }


    public List<QuestionDTO> bringQuestions() {

        return questionDAO.bringQuestions();
    }

    public List<String> getAnswers(int id) {

        return questionDAO.getAnswers(id);
    }

    public List<QuestionDTO> getMyQuestions(String username){
        return questionDAO.getMyQuestions(username);
    }

    public List<QuestionDTO> search(String input){
        return questionDAO.search(input);
    }

}
