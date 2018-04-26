package com.dipta.project.exception.company;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dipta.project.dto.common.ResponseMessageDTO;
import com.dipta.project.exception.base.AbstractBaseException;

public class NDANotAcceptedException extends AbstractBaseException{

	private static final long serialVersionUID = 2328781803425851042L;

	public NDANotAcceptedException() {
		super("Package not subscribed Exception.");
	}
	
	public NDANotAcceptedException(String message) {
		super(message);
	}
	
	@ExceptionHandler(NDANotAcceptedException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(
			HttpServletRequest req, Exception e) {
		// TODO Auto-generated method stub
		 return getHTTPResponse(req, e);
	}
}
