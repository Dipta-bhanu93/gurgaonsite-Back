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
public class ObjectNotSupportedException extends AbstractBaseException{

	private static final long serialVersionUID = -7453416172206935310L;
	public ObjectNotSupportedException() {
		super();
	}
	
	public ObjectNotSupportedException(String message) {
		super(message);
	}
	@ExceptionHandler(ObjectNotSupportedException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(HttpServletRequest req, Exception e){
		return getHTTPResponse(req, e);
	}

}
