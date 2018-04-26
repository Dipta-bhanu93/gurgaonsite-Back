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
public class ProjectDoesNotExistsException  extends AbstractBaseException {
	
	private static final long serialVersionUID = -2671386385875781177L;
	public ProjectDoesNotExistsException() {
		super();
	}
	
	public ProjectDoesNotExistsException(String message) {
		super(message);
	}
	@ExceptionHandler(ProjectDoesNotExistsException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(HttpServletRequest req, Exception e){
		return getHTTPResponse(req, e);
	}
}