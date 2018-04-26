package com.dipta.project.exception.company;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dipta.project.dto.common.ResponseMessageDTO;
import com.dipta.project.exception.base.AbstractBaseException;


@ControllerAdvice
public class SubscriptionException extends AbstractBaseException {
	
	private static final long serialVersionUID = 4245284123973003425L;

	public SubscriptionException() {
		super("Subscription failed due to some unknown error message.");
	}
	
	public SubscriptionException(String message) {
		super(message);
	}
	
	@ExceptionHandler(SubscriptionException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(
			HttpServletRequest req, Exception e) {
		// TODO Auto-generated method stub
		 return getHTTPResponse(req, e);
	}
}
