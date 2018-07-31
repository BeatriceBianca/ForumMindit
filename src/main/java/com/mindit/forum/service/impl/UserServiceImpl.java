package com.mindit.forum.service.impl;

import com.mindit.forum.dao.UserDAO;
import com.mindit.forum.dto.UserDTO;
import com.mindit.forum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public Boolean registerUser(UserDTO userDTO){

        userDAO.registerUser(userDTO);
        return true;
    }

    @Override
    public UserDTO getUserByUserNameAndPassword(String userName, String password){
        Optional<UserDTO> userDTO =  userDAO.getUserByUserNameAndPassword(userName, password);
        UserDTO user = null;
        if(userDTO.isPresent()) {
            user = userDTO.get();
            return user;
        }
        return null;
    }

    @Override
    public UserDTO getUserByUserName(String userName){
        Optional<UserDTO> userDTO = userDAO.getUserByUserName(userName);
        UserDTO user = null;
        if(userDTO.isPresent()){
            user = userDTO.get();
            return user;
        }
        return null;
    }
}
