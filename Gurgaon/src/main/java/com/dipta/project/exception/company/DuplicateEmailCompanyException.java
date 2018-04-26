package com.dipta.project.exception.company;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dipta.project.dto.common.ResponseMessageDTO;
import com.dipta.project.exception.base.AbstractBaseException;

@ControllerAdvice
public class DuplicateEmailCompanyException  extends AbstractBaseException {

	private static final long serialVersionUID = -5040686139600071248L;

	public DuplicateEmailCompanyException() {
		super("Probablity : Email id already exist for a user or company in the system.");
	}
	
	public DuplicateEmailCompanyException(String message) {
		super(message);
	}
	
	@ExceptionHandler(DuplicateEmailCompanyException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(
			HttpServletRequest req, Exception e) {
		// TODO Auto-generated method stub
		 return getHTTPResponse(req, e);
	}

}
