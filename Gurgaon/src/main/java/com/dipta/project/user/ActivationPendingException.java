package com.dipta.project.user;

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
public class ActivationPendingException   extends AbstractBaseException{

	private static final long serialVersionUID = 7034506275213809244L;
	public ActivationPendingException() {
		super();
	}
	
	public ActivationPendingException(String message) {
		super(message);
	}
	@ExceptionHandler(ActivationPendingException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(HttpServletRequest req, Exception e){
		return getHTTPResponse(req, e);
	}
}
