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
public class FileDoesNotExistException extends AbstractBaseException {
	
	private static final long serialVersionUID = 6256339666848292568L;
	public FileDoesNotExistException() {
		super();
	}
	
	public FileDoesNotExistException(String message) {
		super(message);
	}
	@ExceptionHandler(FileDoesNotExistException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(HttpServletRequest req, Exception e){
		return getHTTPResponse(req, e);
	}
}
