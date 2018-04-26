package com.dipta.project.exception.file;

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
public class DataNotSupportedException extends AbstractBaseException {
	
	private static final long serialVersionUID = -6924986693453053425L;
	public DataNotSupportedException() {
		super();
	}
	
	public DataNotSupportedException(String message) {
		super(message);
	}
	@ExceptionHandler(DataNotSupportedException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(HttpServletRequest req, Exception e){
		return getHTTPResponse(req, e);
	}
}