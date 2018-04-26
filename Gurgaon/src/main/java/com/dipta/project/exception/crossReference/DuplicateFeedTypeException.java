package com.dipta.project.exception.crossReference;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dipta.project.dto.common.ResponseMessageDTO;
import com.dipta.project.exception.base.AbstractBaseException;

/**
 * @author Ashish.Patel
 *
 */
@ControllerAdvice
public class DuplicateFeedTypeException extends AbstractBaseException {

	private static final long serialVersionUID = 1L;

	public DuplicateFeedTypeException() {
		super("This Feed Type already exist. Please try another name");
	}
	
	public DuplicateFeedTypeException(String message) {
		super(message);
	}
	
	@ExceptionHandler(DuplicateFeedTypeException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(
			HttpServletRequest req, Exception e) {
		// TODO Auto-generated method stub
		return getHTTPResponse(req, e);
	}

}
