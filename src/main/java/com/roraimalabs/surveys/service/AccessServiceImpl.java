/** 
 * AccessServiceImpl.java Created: Sep 24, 2016 JavierAngelH
 */

package com.roraimalabs.surveys.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roraimalabs.surveys.dao.ResultsDAO;
import com.roraimalabs.surveys.domain.RecordType;

/**
 * AccessServiceImpl -
 *
 */
@Service
public class AccessServiceImpl implements AccessService {

	@Autowired
	ResultsDAO resultsDAO;

	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/M/yyyy HH:mm");

	/**
	 * @throws ParseException
	 * @see com.roraimalabs.surveys.service.AccessService#saveRecords(long,
	 *      java.lang.String)
	 */
	@Override
	public void saveRecords(long id, String jsonString, RecordType type) throws ParseException {
		JSONObject objects = new JSONObject(jsonString);
		System.out.println(objects);

		Iterator<?> keys = objects.keys();

		String dateString = objects.getString("DATE");
		Date date = dateFormat.parse(dateString);

		if (type.getRecordType() == 1) {

			while (keys.hasNext()) {
				String questionId = (String) keys.next();
				String answerId = (String) objects.get(questionId);
				resultsDAO.insertSurveyResult(date, 1, questionId, answerId);
			}
		} else if (type.getRecordType() == 2) {
			while (keys.hasNext()) {
				String questionId = (String) keys.next();
				String answerId = (String) objects.get(questionId);
				resultsDAO.insertObservationResult(date, 1, questionId, answerId);

			}
		}

	}

}
