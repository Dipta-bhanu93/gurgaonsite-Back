package com.dipta.project.exception;

import lombok.Getter;


public enum ExceptionConstantEnum {
	
	EXCEED_LIMIT("Server has reached the maximum allowed requests for the day."),
	INVALID_REQUEST_PARAM("Invalid input. Accesstoken with non-null Input cannot be processed at same time. use Accesstoken to get past results only and remove any new input."),
	INVALID_TOKEN("Access Forbidden 403!!"),
	EXPIRED_TOKEN("Access Forbidden 403!!");	
 
	
	private ExceptionConstantEnum(String exceptionDescription ){
		this.exceptionDescription = exceptionDescription;
	}
	


	@Getter
    private final String exceptionDescription;

	
    
    
}