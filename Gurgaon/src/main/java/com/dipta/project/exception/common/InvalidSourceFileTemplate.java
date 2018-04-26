package com.dipta.project.exception.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dipta.project.dto.common.ResponseMessageDTO;
import com.dipta.project.exception.base.AbstractBaseException;

/**
 * 
 * @author Saurabh.Agarwal
 *
 */
@ControllerAdvice
public class InvalidSourceFileTemplate extends AbstractBaseException{
	private static final long serialVersionUID = 3177413526753238654L;
	public InvalidSourceFileTemplate() {
		super("Invalid source file tamplate");
	}
	
	public InvalidSourceFileTemplate(String message) {
		super(message);
	}
	@ExceptionHandler({InvalidSourceFileTemplate.class})
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(HttpServletRequest req, Exception e){
		return getHTTPResponse(req, e);
	}
}