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
public class CompanyRegisteredException extends AbstractBaseException{

	private static final long serialVersionUID = 2328781803425851042L;

	public CompanyRegisteredException() {
		super("Probablity : Company For user already exists in the system.");
	}
	
	public CompanyRegisteredException(String message) {
		super(message);
	}
	
	@ExceptionHandler(CompanyRegisteredException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(
			HttpServletRequest req, Exception e) {
		// TODO Auto-generated method stub
		 return getHTTPResponse(req, e);
	}

}

