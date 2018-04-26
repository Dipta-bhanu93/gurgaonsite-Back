package com.dipta.project.exception.scheduler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dipta.project.dto.common.ResponseMessageDTO;
import com.dipta.project.exception.base.AbstractBaseException;

/**
 * 
 * @author saurabh.agarwal
 *
 */
@ControllerAdvice
public class AlreadyScheduledException extends AbstractBaseException{

	private static final long serialVersionUID = -2737186357005963975L;
	public AlreadyScheduledException() {
		super("Scheduling already exists.");
	}
	
	public AlreadyScheduledException(String message) {
		super(message);
	}
	@ExceptionHandler(AlreadyScheduledException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(HttpServletRequest req, Exception e){
		return getHTTPResponse(req, e);
	}

}

