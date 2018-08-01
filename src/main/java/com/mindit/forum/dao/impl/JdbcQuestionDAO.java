package com.mindit.forum.dao.impl;

import com.mindit.forum.dao.QuestionDAO;
import com.mindit.forum.dto.AnswerDTO;
import com.mindit.forum.dto.QuestionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Repository
public class JdbcQuestionDAO implements QuestionDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<QuestionDTO> bringQuestions(){

        String sqlSelect = "SELECT quest_id, quest_text FROM question ORDER BY quest_id DESC LIMIT 3";

        try {

            List<Map<String, Object>> rows = jdbcTemplate.queryForList(sqlSelect);
            List<QuestionDTO> listOfQuestions = new ArrayList<QuestionDTO>();
            for(Map row:rows) {
                QuestionDTO question = new QuestionDTO();
                question.setQuestId((int)(row.get("quest_id")));
                question.setQuestText((String)(row.get("quest_text")));
                listOfQuestions.add(question);}
            return listOfQuestions;

        } catch (EmptyResultDataAccessException ignored) {
        }

    return null;
   }



   @Override
   public List<AnswerDTO> getAnswers(int id){

       String sqlSelect = "" +
               "SELECT " +
               "    * " +
               "FROM answer " +
               "WHERE q_id = " + id;

       MapSqlParameterSource namedParameters = new MapSqlParameterSource();

       return namedJdbcTemplate.execute(sqlSelect, namedParameters, preparedStatement ->{
           ResultSet rs = preparedStatement.executeQuery();
           List<AnswerDTO> results = new ArrayList<>();
           while(rs.next()) {
               AnswerDTO ans = new AnswerDTO();
               ans.setAnsId(rs.getInt("ans_id"));
               ans.setqId(rs.getInt("q_id"));
               ans.setUserName(rs.getString("username"));
               ans.setAnsText(rs.getString("ans_text"));
               ans.setDate(rs.getString("ans_date"));
               results.add(ans);
           }
           return results;

       });

   }



    @Autowired
    NamedParameterJdbcTemplate namedJdbcTemplate;

    @Override
    public void addQuest(QuestionDTO quest) {
        String sqlInsert = "" +
                "INSERT INTO question(username, quest_text) VALUES( " +
                "    :userName ,"+
                "    :questText " +
                ")";
        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        String a = quest.getQuestText();
        String b = quest.getUserName();
        namedParameters.addValue("questText", quest.getQuestText());
        namedParameters.addValue("userName", quest.getUserName());

        namedJdbcTemplate.update(sqlInsert, namedParameters);

    }

    @Override
    public List<QuestionDTO> getAllQuestions(){

        String sqlSelect = "" +
                "SELECT " +
                "   * " +
                "FROM question ";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();

        return namedJdbcTemplate.execute(sqlSelect, namedParameters, preparedStatement -> {

            ResultSet rs = preparedStatement.executeQuery();
            List<QuestionDTO> results = new ArrayList<>();
            while(rs.next()) {
                QuestionDTO quest = new QuestionDTO();
                int a =  rs.getInt("quest_id");
                String s = rs.getString("quest_text");
                quest.setQuestId(a);
                quest.setQuestText(s);
                quest.setUserName(rs.getString("userName"));
                results.add(quest);
            }
            return results;

        });
    }

    @Override
    public List<QuestionDTO> getUserQuestions(String userName){

        String sqlSelect = "" +
                "SELECT " +
                "   * " +
                "FROM question " +
                "WHERE username =  :userName";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("userName", userName);

        return namedJdbcTemplate.execute(sqlSelect, namedParameters, preparedStatement -> {
            ResultSet rs = preparedStatement.executeQuery();
            List<QuestionDTO> results = new ArrayList<>();
            while(rs.next()) {
                QuestionDTO quest = new QuestionDTO();
                quest.setQuestId(rs.getInt("quest_id"));
                quest.setQuestText(rs.getString("quest_text"));
                quest.setUserName(rs.getString("username"));
                results.add(quest);
            }
            return results;
        });

    }

    @Override
    public void deleteQuestion(QuestionDTO questionDTO){

        String sqlDelete = "" +
                "DELETE " +
                "FROM question "+
                "WHERE quest_id = :questId";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("questId", questionDTO.getQuestId());

        namedJdbcTemplate.update(sqlDelete, namedParameters);

    }

    @Override
    public void updateQuestion(QuestionDTO questionDTO){

        String sqlUpdate = "" +
                "UPDATE question " +
                "SET quest_text = :questText "+
                "WHERE quest_id = :questId";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("questId", questionDTO.getQuestId());
        namedParameters.addValue("questText", questionDTO.getQuestText());

        namedJdbcTemplate.update(sqlUpdate,namedParameters);
    }


    @Override
    public List<QuestionDTO> getMyQuestions(String userName){

        String sqlSelect = "" +
                "SELECT " +
                "    * " +
                "FROM question q, answer a " +
                " WHERE  a.q_id = q.quest_id " +
                " AND a.username = :userName ";

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();
        namedParameters.addValue("userName", userName);

        return namedJdbcTemplate.execute(sqlSelect, namedParameters, preparedStatement -> {
            ResultSet rs = preparedStatement.executeQuery();
            List<QuestionDTO> results = new ArrayList<>();
            while(rs.next()) {

                boolean ok = false;

                for( QuestionDTO q: results ){
                    if( q.getQuestId() == rs.getInt("quest_id") )
                    {
                        ok = true;

                        AnswerDTO ans = new AnswerDTO();
                        ans.setAnsId(rs.getInt("ans_id"));
                        ans.setqId(rs.getInt("q_id"));
                        ans.setUserName(rs.getString("username"));
                        ans.setAnsText(rs.getString("ans_text"));
                        q.getAnswers().add(ans);
                    }

                }

                if(ok == false) {
                    QuestionDTO quest = new QuestionDTO();
                    quest.setQuestId(rs.getInt("quest_id"));
                    quest.setQuestText(rs.getString("quest_text"));
                    quest.setUserName(rs.getString("username"));

                    AnswerDTO ans = new AnswerDTO();
                    ans.setAnsId(rs.getInt("ans_id"));
                    ans.setqId(rs.getInt("q_id"));
                    ans.setUserName(rs.getString("username"));
                    ans.setAnsText(rs.getString("ans_text"));
                    quest.getAnswers().add(ans);
                    results.add(quest);
                }


            }
            return results;
        });

    }


    @Override
    public List<QuestionDTO> searchQuest(String input){

        String sqlSelect = "" +
                "SELECT " +
                "    * " +
                "FROM question " +
                "WHERE quest_text " +
                "LIKE '%" + input +"%'";

        try {

            List<Map<String, Object>> rows = jdbcTemplate.queryForList(sqlSelect);
            List<QuestionDTO> result = new ArrayList<QuestionDTO>();
            for(Map row:rows) {
                QuestionDTO question = new QuestionDTO();
                question.setQuestId((int)(row.get("quest_id")));
                question.setUserName((String)(row.get("username")));
                question.setQuestText((String)(row.get("quest_text")));
                result.add(question);
            }
            return result;

        } catch (EmptyResultDataAccessException ignored) {
        }

        return null;

    }

    @Override
    public QuestionDTO getQuestion(int id){
        String sqlSelect = "" +
                "SELECT " +
                "    * " +
                "FROM question " +
                "WHERE quest_id = " + id;

        MapSqlParameterSource namedParameters = new MapSqlParameterSource();

        QuestionDTO questionDTO = null;
        try {
            questionDTO = namedJdbcTemplate.queryForObject(sqlSelect, namedParameters, new QuestionDTOMapper());
        } catch (EmptyResultDataAccessException ignored) {

        }

        return questionDTO;
    }

    class QuestionDTOMapper implements RowMapper<QuestionDTO> {
        @Override
        public QuestionDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            QuestionDTO question = new QuestionDTO();
            question.setQuestId(rs.getInt("quest_id"));
            question.setUserName( rs.getString("username"));
            question.setQuestText(rs.getString("quest_text"));
            return question;
        }
    }

}
