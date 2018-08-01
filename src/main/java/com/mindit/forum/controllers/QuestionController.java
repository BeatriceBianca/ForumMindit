package com.mindit.forum.controllers;


import com.mindit.forum.dto.AnswerDTO;
import com.mindit.forum.dto.QuestionDTO;
import com.mindit.forum.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/question", method = RequestMethod.PUT)
    public ResponseEntity addQuest(@RequestBody QuestionDTO questionDTO){
        Boolean ok = questionService.addQuest(questionDTO);
        if (ok == true)
            return new ResponseEntity(ok, HttpStatus.OK);
        else return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/allquest", method = RequestMethod.GET)
    public ResponseEntity find(){
        List<QuestionDTO> q = questionService.getAllQuestions();
        if(q.size() == 0)
            return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
        else return new ResponseEntity(q,HttpStatus.OK);
    }

    @RequestMapping(value = "/userquest", method = RequestMethod.GET)
    public ResponseEntity getUserQuestions(@RequestParam String userName){
        List<QuestionDTO> q = questionService.getUserQuestions(userName);
        if(q.size() == 0)
            return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
        else return new ResponseEntity(q,HttpStatus.OK);
    }

    @RequestMapping(value="/questions", method = RequestMethod.GET)
    public ResponseEntity bringQuestions(){

        List<QuestionDTO> questionsList = questionService.bringQuestions();

        return new ResponseEntity(questionsList,HttpStatus.OK);
    }

    @RequestMapping(value="/answers",method = RequestMethod.GET)
    public ResponseEntity getAnswers(@RequestParam(value="id") int id){

        List<AnswerDTO> answersList = questionService.getAnswers(id);
        if(answersList.size() == 0)
            return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
            else
        return new ResponseEntity(answersList,HttpStatus.OK);

    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ResponseEntity deleteQuestion(@RequestBody QuestionDTO questionDTO){

        Boolean ok = questionService.deleteQuestion(questionDTO);
        if(ok == true)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        else return new ResponseEntity(null, HttpStatus.BAD_REQUEST);

    }

    @RequestMapping(value = "/updateQuest", method = RequestMethod.POST)
    public ResponseEntity updateQuestion(@RequestBody QuestionDTO questionDTO) {

        Boolean ok = questionService.updateQuestion(questionDTO);
        if (ok == true)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        else return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/myQuestions", method = RequestMethod.GET)
    public ResponseEntity getMyQuestions(@RequestParam(value="username") String username){
        List<QuestionDTO> myQuestions = questionService.getMyQuestions(username);
        if(myQuestions.size() == 0)
            return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
        else return new ResponseEntity(myQuestions,HttpStatus.OK);
    }

    @RequestMapping(value = "/searchQuest", method = RequestMethod.GET)
    public ResponseEntity searchQuest(@RequestParam(value="input") String input){
        List<QuestionDTO> result = questionService.searchQuest(input);
        if(result.size() == 0)
            return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
        else return new ResponseEntity(result,HttpStatus.OK);

    }


    @RequestMapping(value = "/getQuestion", method = RequestMethod.GET)
    public ResponseEntity getQuestion(@RequestParam(value="id") int id){
        QuestionDTO question = questionService.getQuestion(id);
         return new ResponseEntity(question,HttpStatus.OK);

    }



}
