/** 
 * AccessService.java Created: Sep 24, 2016 JavierAngelH
 */

package com.roraimalabs.surveys.service;

import java.text.ParseException;

import com.roraimalabs.surveys.domain.RecordType;

/**
 * AccessService - 
 *
 */
public interface AccessService {
	
	void saveRecords(long id, String jsonString, RecordType type)  throws ParseException;

}
