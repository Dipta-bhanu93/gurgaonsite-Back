package com.dipta.project.exception.project;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dipta.project.dto.common.ResponseMessageDTO;
import com.dipta.project.exception.base.AbstractBaseException;
import com.dipta.project.exception.common.ObjectNotSupportedException;

/**
 * 
 * @author saurabh.agarwal
 *
 */
@ControllerAdvice
public class ProjectConfigNotFoundException extends AbstractBaseException{

	private static final long serialVersionUID = -7453416172206935310L;
	public ProjectConfigNotFoundException() {
		super("No configuratrion found for the project(s)");
	}
	
	public ProjectConfigNotFoundException(String message) {
		super(message);
	}
	@ExceptionHandler(ProjectConfigNotFoundException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(HttpServletRequest req, Exception e){
		return getHTTPResponse(req, e);
	}

}

