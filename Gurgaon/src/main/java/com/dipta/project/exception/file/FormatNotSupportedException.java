package com.dipta.project.exception.file;

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
public class FormatNotSupportedException extends AbstractBaseException {
	
	private static final long serialVersionUID = 5444303615937906532L;
	public FormatNotSupportedException() {
		super();
	}
	
	public FormatNotSupportedException(String message) {
		super(message);
	}
	@ExceptionHandler(FormatNotSupportedException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(HttpServletRequest req, Exception e){
		return getHTTPResponse(req, e);
	}
}
