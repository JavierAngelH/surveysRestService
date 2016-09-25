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

	@Override
	public void saveRecords(long id, String jsonString, RecordType type) throws ParseException {
		JSONObject objects = new JSONObject(jsonString);

		String dateString = objects.getString("DATE");
		Date date = this.dateFormat.parse(dateString);

		objects.remove("DATE");
		Iterator<?> keys = objects.keys();

		if (type.getRecordType() == 1) {

			while (keys.hasNext()) {
				String questionId = (String) keys.next();
				String answerId = (String) objects.get(questionId);
				if (answerId.equals("undefined")) {
					answerId = "";
				}
				this.resultsDAO.insertSurveyResult(date, (int) id, questionId, answerId);
			}
		} else if (type.getRecordType() == 2) {
			while (keys.hasNext()) {
				String questionId = (String) keys.next();
				String answerId = (String) objects.get(questionId);
				if (answerId.equals("undefined")) {
					answerId = "";
				}
				this.resultsDAO.insertObservationResult(date, (int) id, questionId, answerId);

			}
		}

	}

}
