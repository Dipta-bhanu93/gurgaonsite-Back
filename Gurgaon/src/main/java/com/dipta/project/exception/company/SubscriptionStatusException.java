package com.dipta.project.exception.company;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dipta.project.dto.common.ResponseMessageDTO;
import com.dipta.project.exception.common.ProcessFailedException;


@ControllerAdvice
public class SubscriptionStatusException extends ProcessFailedException {
	
	private static final long serialVersionUID = 4245284123973003425L;

	public SubscriptionStatusException() {
		super("Not able to retrieve subscription status.");
	}
	
	public SubscriptionStatusException(String message) {
		super(message);
	}
	
	@ExceptionHandler(SubscriptionStatusException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(
			HttpServletRequest req, Exception e) {
		// TODO Auto-generated method stub
		 return getHTTPResponse(req, e);
	}
}
