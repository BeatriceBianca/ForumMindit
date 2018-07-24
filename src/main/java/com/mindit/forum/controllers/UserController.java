package com.mindit.forum.controllers;

import com.mindit.forum.dto.UserDTO;
import com.mindit.forum.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.PUT)
    public ResponseEntity registerUser(@RequestBody UserDTO userDTO){
        Boolean ok =  userService.registerUser(userDTO);
        if (ok == true)
        return new ResponseEntity(ok, HttpStatus.OK);
        else return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity login(@RequestParam String userName, @RequestParam String password){
        UserDTO userDTO = userService.getUserByUserNameAndPassword(userName, password);
        if(userDTO == null) {
            return new ResponseEntity(null, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity(userDTO, HttpStatus.OK);
        }
    }
}


