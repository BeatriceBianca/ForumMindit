package com.mindit.forum.controllers;


import com.mindit.forum.dto.AnswerDTO;
import com.mindit.forum.dto.QuestionDTO;
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

    @RequestMapping(value = "/delete/ans", method = RequestMethod.POST)
    public ResponseEntity deleteAnswer(@RequestBody AnswerDTO answerDTO){

        Boolean ok = answerService.deleteAnswer(answerDTO);
        if(ok == true)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        else return new ResponseEntity(null, HttpStatus.BAD_REQUEST);

    }

    @RequestMapping(value = "/update/ans", method = RequestMethod.POST)
    public ResponseEntity updateAnswer(@RequestBody AnswerDTO answerDTO) {

        Boolean ok = answerService.updateAnswer(answerDTO);
        if (ok == true)
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        else return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
    }


    @RequestMapping(value = "/searchAns", method = RequestMethod.GET)
    public ResponseEntity searchAns(@RequestParam(value="input") String input){
        List<AnswerDTO> result = answerService.searchAns(input);
        if(result.size() == 0)
            return new ResponseEntity(null,HttpStatus.BAD_REQUEST);
        else return new ResponseEntity(result,HttpStatus.OK);

    }

}
