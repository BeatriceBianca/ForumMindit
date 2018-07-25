package com.mindit.forum.controller;

import com.mindit.forum.dto.QuestionDTO;
import com.mindit.forum.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    private QuestionService questionService;


    @RequestMapping(value="/questions", method = RequestMethod.GET)
    public ResponseEntity bringQuestions(){

        List<QuestionDTO> questionsList = questionService.bringQuestions();

        return new ResponseEntity(questionsList,HttpStatus.OK);
    }

    @RequestMapping(value="/answers",method = RequestMethod.GET)
    public ResponseEntity getAnswers(@RequestParam(value="id") int id){

        List<String> answersList = questionService.getAnswers(id);

        return new ResponseEntity(answersList,HttpStatus.OK);

    }

}
