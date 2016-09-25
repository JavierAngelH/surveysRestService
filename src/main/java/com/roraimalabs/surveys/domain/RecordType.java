/** 
 * RecordType.java Created: Sep 24, 2016 JavierAngelH
 */

package com.roraimalabs.surveys.domain;

/**
 * RecordType - 
 *
 */
public enum RecordType {
	SURVEY(1),
	OBSERVATION(2);
	
	
    private final int type;

    private RecordType(int type) {
        this.type = type;
    }

    public int getRecordType() {
        return this.type;
    }

}
