package com.dipta.project.exception.company;


import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dipta.project.dto.common.ResponseMessageDTO;
import com.dipta.project.exception.base.AbstractBaseException;

/**
 * 
 * @author Savita Khurana
 *
 */
@ControllerAdvice
public class PackageNotSubscribeddException extends AbstractBaseException{

	private static final long serialVersionUID = 2328781803425851042L;

	public PackageNotSubscribeddException() {
		super("Package not subscribed Exception.");
	}
	
	public PackageNotSubscribeddException(String message) {
		super(message);
	}
	
	@ExceptionHandler(PackageNotSubscribeddException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(
			HttpServletRequest req, Exception e) {
		// TODO Auto-generated method stub
		 return getHTTPResponse(req, e);
	}

}
