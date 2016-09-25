/** 
 * SaveController.java Created: Sep 24, 2016 JavierAngelH
 */

package com.roraimalabs.surveys.controller;


import java.text.ParseException;
import java.util.Iterator;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.roraimalabs.surveys.domain.RecordType;
import com.roraimalabs.surveys.service.AccessService;



/**
 * SaveController - 
 *
 */
@RestController
public class SaveController {
	
	@Autowired
	AccessService accessService;

	    @RequestMapping("/saveSurvey")
	    public String getSurvey(@RequestParam(value="id") long id, @RequestParam(value="survey") String survey) throws ParseException {
	    	
	    	accessService.saveRecords(id, survey, RecordType.SURVEY);
	    	
	   	return "success";
	    }
	    
	    @RequestMapping("/saveObservation")
	    public String getObservation(@RequestParam(value="id") long id, @RequestParam(value="observation") String observation) throws ParseException {
	    	
	    	accessService.saveRecords(id, observation, RecordType.OBSERVATION);

	   	return "success";
	    }

}
