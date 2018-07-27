package com.mindit.forum.controllers;


import com.mindit.forum.dto.AnswerDTO;
import com.mindit.forum.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AnswerController {


    @Autowired
    private AnswerService answerService;


    @RequestMapping(value = "/answer", method = RequestMethod.PUT)
    public ResponseEntity addAns(@RequestBody AnswerDTO answerDTO){
        Boolean ok = answerService.addAns(answerDTO);
        if (ok == true)
            return new ResponseEntity(ok, HttpStatus.OK);
        else return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/getAnswer", method = RequestMethod.GET)
    public ResponseEntity getAllAnswers(@RequestParam int questId){
        List<AnswerDTO> a = answerService.getAllAnswers(questId);
        if(a.size() == 0)
            return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
        else return new ResponseEntity(a,HttpStatus.OK);
    }


}
