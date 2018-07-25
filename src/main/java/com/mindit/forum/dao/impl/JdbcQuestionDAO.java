package com.mindit.forum.dao.impl;

import com.mindit.forum.dao.QuestionDAO;
import com.mindit.forum.dto.QuestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class JdbcQuestionDAO implements QuestionDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<QuestionDTO> bringQuestions(){

        String sqlSelect = "" +
                "SELECT " +
                "    quest_id, " +
                "    quest_text " +
                "FROM question ";


        try {

            List<Map<String, Object>> rows = jdbcTemplate.queryForList(sqlSelect);
            List<QuestionDTO> listOfQuestions = new ArrayList<QuestionDTO>();
            for(Map row:rows) {
                QuestionDTO question = new QuestionDTO();
                question.setId((int)(row.get("quest_id")));
                question.setQuestText((String)(row.get("quest_text")));
                listOfQuestions.add(question);}
            return listOfQuestions;

        } catch (EmptyResultDataAccessException ignored) {
        }

    return null;
   }



   @Override
   public List<String> getAnswers(int id){

       /*MapSqlParameterSource parameters = new MapSqlParameterSource();
       parameters.addValue("id", id);*/

       String sqlSelect = "" +
               "SELECT " +
               "    ans_text " +
               "FROM answer " +
               "WHERE q_id = " + id;



       try {

           List<Map<String, Object>> rows = jdbcTemplate.queryForList(sqlSelect);
           List<String> listOfAnswers = new ArrayList<>();
           for(Map row:rows) {
               String answer = (String) (row.get("ans_text"));
               listOfAnswers.add(answer);
           }
           return listOfAnswers;

       } catch (EmptyResultDataAccessException ignored) {
       }

        return null;
   }



}
