package com.mindit.forum.dao.impl;

import com.mindit.forum.dao.QuestionDAO;
import com.mindit.forum.dto.QuestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


@Repository
public class JdbcQuestionDAO implements QuestionDAO {

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void addQuest(QuestionDTO quest) {
        String sqlInsert = "" +
                "INSERT INTO question(quest_text) VALUES( " +
                "    :questText " +
                ")";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("questText", quest.getQuestText());

        jdbcTemplate.update(sqlInsert, namedParameters);

    }

    @Override
    public List<QuestionDTO> getAllQuestions(){

        String sqlSelect = "" +
                "SELECT " +
                "   * " +
                "FROM question ";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();

        return jdbcTemplate.execute(sqlSelect, namedParameters, preparedStatement -> {

            ResultSet rs = preparedStatement.executeQuery();
            List<QuestionDTO> results = new ArrayList<>();
            while(rs.next()) {
                QuestionDTO quest = new QuestionDTO();
                int a =  rs.getInt("quest_id");
                String s = rs.getString("quest_text");
                quest.setQuestId(a);
                quest.setQuestText(s);
                results.add(quest);
            }
            return results;

        });
    }
}
