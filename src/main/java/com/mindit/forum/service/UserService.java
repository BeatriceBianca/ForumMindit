package com.mindit.forum.service;

import com.mindit.forum.dto.UserDTO;

public interface UserService {

    Boolean registerUser(UserDTO userDTO);
    UserDTO getUserByUserNameAndPassword(String userName, String password);
    UserDTO getUserByUserName(String userName);
}
