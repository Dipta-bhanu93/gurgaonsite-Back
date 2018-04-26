package com.dipta.project.exception.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dipta.project.dto.common.ResponseMessageDTO;
import com.dipta.project.exception.base.AbstractBaseException;

/**
 * 
 * @author Saurabh.Agarwal
 *
 */
@ControllerAdvice
public class InvalidKeyException extends AbstractBaseException{

	private static final long serialVersionUID = 2442626413144704509L;
	public InvalidKeyException() {
		super();
	}
	
	public InvalidKeyException(String message) {
		super(message);
	}
	@ExceptionHandler(InvalidKeyException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(HttpServletRequest req, Exception e){
		return getHTTPResponse(req, e);
	}
}