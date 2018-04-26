package com.dipta.project.exception.user;

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
public class LoginIDRegisteredException extends AbstractBaseException {

	private static final long serialVersionUID = -5858868713458438738L;
	
	public LoginIDRegisteredException() {
		super();
	}
	
	public LoginIDRegisteredException(String message) {
		super(message);
	}
	@ExceptionHandler(LoginIDRegisteredException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(HttpServletRequest req, Exception e){
	 return getHTTPResponse(req, e);
	}
}