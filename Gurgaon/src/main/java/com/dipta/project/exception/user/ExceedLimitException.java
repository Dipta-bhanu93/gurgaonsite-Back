package com.dipta.project.exception.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dipta.project.dto.common.ResponseMessageDTO;
import com.dipta.project.exception.base.AbstractBaseException;
@ControllerAdvice
public class ExceedLimitException extends AbstractBaseException{

	private static final long serialVersionUID = 3334310467306018240L;
	
	public ExceedLimitException() {
		super();
	}
	
	public ExceedLimitException(String message) {
		super(message);
	}
	@ExceptionHandler(ExceedLimitException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(HttpServletRequest req, Exception e){
		return getHTTPResponse(req, e);
	}
}
