package com.dipta.project.exception.project;

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
public class ProjectIdNotSupportedException extends AbstractBaseException {
	
	private static final long serialVersionUID = -7706827238154933662L;
	public ProjectIdNotSupportedException() {
		super();
	}
	
	public ProjectIdNotSupportedException(String message) {
		super(message);
	}
	@ExceptionHandler(ProjectIdNotSupportedException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(HttpServletRequest req, Exception e){
		return getHTTPResponse(req, e);
	}
}
