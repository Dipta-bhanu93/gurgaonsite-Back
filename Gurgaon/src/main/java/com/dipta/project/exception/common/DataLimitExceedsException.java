package com.dipta.project.exception.common;

import javax.servlet.http.HttpServletRequest;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dipta.project.dto.common.ResponseMessageDTO;
import com.dipta.project.exception.base.AbstractBaseException;


public class DataLimitExceedsException extends AbstractBaseException{
	private static final long serialVersionUID = 3177413526753238654L;
	public DataLimitExceedsException() {
		super("Data Limit Exceeds.");
	}
	
	public DataLimitExceedsException(String message) {
		super(message);
	}
	@ExceptionHandler(DataLimitExceedsException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(HttpServletRequest req, Exception e){
		return getHTTPResponse(req, e);
	}
}
