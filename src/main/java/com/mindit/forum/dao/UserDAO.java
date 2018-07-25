package com.mindit.forum.dao;


import com.mindit.forum.dto.UserDTO;

import java.util.Optional;

public interface UserDAO {

    Optional<UserDTO> getUserByUserName(String userName);

}
