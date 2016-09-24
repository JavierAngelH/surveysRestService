/** 
 * SaveController.java Created: Sep 24, 2016 JavierAngelH
 */

package com.roraima.surveys;


import java.util.Iterator;

import org.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



/**
 * SaveController - 
 *
 */
@RestController
public class SaveController {

	    @RequestMapping("/save")
	    public String getSurvey(@RequestParam(value="id") long id, @RequestParam(value="survey") String survey) {
	    	System.out.println("id es " + id);
	    	System.out.println("survey es " + survey);
	    	
			JSONObject objects = new JSONObject(survey);
			System.out.println(objects);
			
			Iterator<?> keys = objects.keys();

			while (keys.hasNext()) {
				String key = (String) keys.next();
				System.out.println("key=" + key);
				System.out.println("value=" + objects.get(key));
				
			}


	    	return "success";
	    }
}
