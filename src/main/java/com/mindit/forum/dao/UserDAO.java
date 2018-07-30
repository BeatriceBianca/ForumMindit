package com.mindit.forum.dao;


import com.mindit.forum.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserDAO {

    void registerUser(UserDTO user);
    Optional<UserDTO> getUserByUserNameAndPassword(String userName, String password);
    Optional<UserDTO> getUserByUserName(String userName);

}
