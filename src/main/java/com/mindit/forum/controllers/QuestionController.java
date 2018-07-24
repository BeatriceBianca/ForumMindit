package com.mindit.forum.controllers;


import com.mindit.forum.dto.QuestionDTO;
import com.mindit.forum.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
