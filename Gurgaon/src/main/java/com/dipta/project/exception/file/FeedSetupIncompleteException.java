package com.dipta.project.exception.file;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dipta.project.dto.common.ResponseMessageDTO;
import com.dipta.project.exception.base.AbstractBaseException;

/**
 * 
 * @author Vinay.Kumar1
 *
 */
@ControllerAdvice
public class FeedSetupIncompleteException extends AbstractBaseException {
	
	private static final long serialVersionUID = -95825035045161177L;
	public FeedSetupIncompleteException() {
		super();
	}
	
	public FeedSetupIncompleteException(String message) {
		super(message);
	}
	@ExceptionHandler(FeedSetupIncompleteException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(HttpServletRequest req, Exception e){
		return getHTTPResponse(req, e);
	}
}
