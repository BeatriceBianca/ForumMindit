package com.mindit.forum.dao.impl;

import com.mindit.forum.dao.UserDAO;
import com.mindit.forum.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Repository
public class JdbcUserDAO implements UserDAO{

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;


//    @Override
//    public Optional<UserDTO> getUserByUserName(String userName) {
//        String sqlSelect = "" +
//                "SELECT " +
//                "    ID_USER, " +
//                "    USER_NAME, " +
//                "    FIRST_NAME, " +
//                "    LAST_NAME, " +
//                "    PASSWORD, " +
//                "    PHONE_NUMBER, " +
//                "    ADDRESS " +
//                "FROM BA_USERS users " +
//                "INNER JOIN BA_USER_TYPES userTypes " +
//                "   ON users.ID_TYPE = userTypes.ID_TYPE " +
//                "WHERE USER_NAME = :userName ";
//
//        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
//        namedParameters.addValue("userName", userName);
//
//        UserDTO userDTO = null;
//        try {
//            userDTO = namedJdbcTemplate.queryForObject(sqlSelect, namedParameters, new UserDTOMapper());
//        } catch (EmptyResultDataAccessException ignored) {
//
//        }
//
//        return Optional.ofNullable(userDTO);
//
//    }
//
//    class UserDTOMapper implements RowMapper<UserDTO> {
//        @Override
//        public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
//            UserDTO user = new UserDTO();
//            user.setId(rs.getInt("ID_USER"));
//            user.setUserName(rs.getString("USER_NAME"));
//            user.setFirstName(rs.getString("FIRST_NAME"));
//            user.setLastName(rs.getString("LAST_NAME"));
//            return user;
//        }
//    }

    @Override
    public void registerUser(UserDTO user){
        String sqlInsert = "" +
                "INSERT INTO user(first_name, last_name,username, password) VALUES( " +
                "    :firstName, " +
                "    :lastName, " +
                "    :userName, " +
                "    :password " +
                ")";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("userName", user.getUserName());
        namedParameters.addValue("firstName", user.getFirstName());
        namedParameters.addValue("lastName", user.getLastName());
        namedParameters.addValue("password", user.getPassword());

        jdbcTemplate.update(sqlInsert, namedParameters);
    }

    @Override
    public Optional<UserDTO> getUserByUserNameAndPassword(String userName, String password){
        String sqlSelect = "" +
                "SELECT " +
                "    user_id, " +
                "    first_name, " +
                "    last_name, " +
                "    username, " +
                "    password " +
                "FROM user u " +
                "WHERE username = :userName "+
                "AND password = :password";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("userName", userName);
        namedParameters.addValue("password", password);

        UserDTO userDTO = null;
        try {
            userDTO = jdbcTemplate.queryForObject(sqlSelect, namedParameters, new UserDTOMapper());
        } catch (EmptyResultDataAccessException ignored) {

        }

        return Optional.ofNullable(userDTO);
    }

    class UserDTOMapper implements RowMapper<UserDTO> {
        @Override
        public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserDTO user = new UserDTO();
            user.setId(rs.getInt("user_id"));
            user.setUserName(rs.getString("username"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setPassword(rs.getString("password"));
            return user;
        }
    }

}
