/** 
 * JdbcResultDAO.java Created: Sep 24, 2016 JavierAngelH
 */

package com.roraimalabs.surveys.dao;

import java.util.Date;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * JdbcResultDAO - 
 *
 */
@Repository
@Transactional
public class JdbcResultDAO implements ResultsDAO {
	
	
	private JdbcTemplate jdbcTemplate;

	@Autowired(required = true)
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	

	@Override
	public void insertSurveyResult(Date date, int idSurvey, String idQuestion, String idAnswer) {
		 this.jdbcTemplate.update(QUERY_INSERT_SURVEY_RESULT, date, idSurvey, idQuestion, idAnswer);

	}

	
	@Override
	public void insertObservationResult(Date date, int idObservation, String idQuestion, String idAnswer) {
		 this.jdbcTemplate.update(QUERY_INSERT_OBSERVATION_RESULT, date, idObservation, idQuestion, idAnswer);
		
	}

}
