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
public class ProjectCreationFailedException extends AbstractBaseException {
	
	private static final long serialVersionUID = 4245284123973003425L;

	public ProjectCreationFailedException() {
		super("Project creation failed due to some unknown error message.");
	}
	
	public ProjectCreationFailedException(String message) {
		super(message);
	}
	
	@ExceptionHandler(DuplicateProjectException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(
			HttpServletRequest req, Exception e) {
		// TODO Auto-generated method stub
		 return getHTTPResponse(req, e);
	}
}
