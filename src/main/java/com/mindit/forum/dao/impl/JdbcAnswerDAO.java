package com.mindit.forum.dao.impl;

import com.mindit.forum.dao.AnswerDAO;
import com.mindit.forum.dto.AnswerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


@Repository
public class JdbcAnswerDAO implements AnswerDAO {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void addAns(AnswerDTO answerDTO) {
        String sqlInsert = "" +
                "INSERT INTO answer(q_id, username, ans_text) VALUES( " +
                "    :qId, " +
                "    :userName, " +
                "    :ansText " +
                ")";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("qId", answerDTO.getqId());
        namedParameters.addValue("userName", answerDTO.getUserName());
        namedParameters.addValue("ansText", answerDTO.getAnsText());

        jdbcTemplate.update(sqlInsert, namedParameters);
    }

    @Override
    public List<AnswerDTO> getAllAnswers(int id){

        String sqlSelect = "" +
                "SELECT " +
                "   * " +
                "FROM answer " +
                "WHERE q_id = :id";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("id", id);

        return jdbcTemplate.execute(sqlSelect, namedParameters, preparedStatement -> {

            ResultSet rs = preparedStatement.executeQuery();
            List<AnswerDTO> results = new ArrayList<>();
            while(rs.next()) {
                AnswerDTO ans = new AnswerDTO();

                ans.setAnsId(rs.getInt("ans_id"));
                ans.setqId(rs.getInt("q_id"));
                ans.setUserName(rs.getString("username"));
                ans.setAnsText(rs.getString("ans_text"));
                results.add(ans);
            }
            return results;
        });
    }


}
