/**
 * ResultsDAO.java Created: Sep 24, 2016 JavierAngelH
 */

package com.roraimalabs.surveys.dao;

import java.util.Date;

/**
 * ResultsDAO -
 *
 */
public interface ResultsDAO {

	String QUERY_INSERT_SURVEY_RESULT = "INSERT INTO \"SURVEY_RESULT\" ("
			+ "\"SURVEY_DATE\", \"ID_SURVEY\", \"ID_QUESTION\", \"ID_ANSWER\")VALUES (?,?,?,?);";
	String QUERY_INSERT_OBSERVATION_RESULT = "INSERT INTO \"OBSERVATION_RESULT\" ("
			+ "\"OBSERVATION_DATE\", \"ID_OBSERVATION\", \"ID_QUESTION\", \"ID_ANSWER\")VALUES (?,?,?,?);";

	void insertSurveyResult(Date date, int idSurvey, String idQuestion, String idAnswer);

	void insertObservationResult(Date date, int idObservation, String idQuestion, String idAnswer);

}
