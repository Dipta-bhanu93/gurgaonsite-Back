package com.dipta.project.exception.company;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dipta.project.dto.common.ResponseMessageDTO;
import com.dipta.project.exception.base.AbstractBaseException;

/**
 * 
 * @author Saurabh Agarwal
 *
 */
@ControllerAdvice
public class DuplicateCompanyException extends AbstractBaseException{

	private static final long serialVersionUID = -5040686139600071248L;

	public DuplicateCompanyException() {
		super("Probablity : Company with same name already exists in the system.");
	}
	
	public DuplicateCompanyException(String message) {
		super(message);
	}
	
	@ExceptionHandler(DuplicateCompanyException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(
			HttpServletRequest req, Exception e) {
		// TODO Auto-generated method stub
		 return getHTTPResponse(req, e);
	}

}
