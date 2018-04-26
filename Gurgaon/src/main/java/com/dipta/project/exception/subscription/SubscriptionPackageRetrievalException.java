package com.dipta.project.exception.subscription;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dipta.project.dto.common.ResponseMessageDTO;
import com.dipta.project.exception.common.ProcessFailedException;
import com.dipta.project.exception.project.DuplicateProjectException;

public class SubscriptionPackageRetrievalException extends ProcessFailedException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1446839370621106553L;

	public SubscriptionPackageRetrievalException() {
		super("Package retrieval failed.");
	}
	
	public SubscriptionPackageRetrievalException(String message) {
		super(message);
	}
	
	@ExceptionHandler(DuplicateProjectException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(
			HttpServletRequest req, Exception e) {
		// TODO Auto-generated method stub
		 return getHTTPResponse(req, e);
	}
	
	
	
}
