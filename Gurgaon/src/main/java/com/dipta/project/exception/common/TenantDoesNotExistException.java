package com.dipta.project.exception.common;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dipta.project.dto.common.ResponseMessageDTO;
import com.dipta.project.exception.base.AbstractBaseException;

@ControllerAdvice
public class TenantDoesNotExistException  extends AbstractBaseException{
	
	private static final long serialVersionUID = -7257837587146041679L;
	public TenantDoesNotExistException() {
		super("Tenant does not exists.");
	}
	
	public TenantDoesNotExistException(String message) {
		super(message);
	}
	@ExceptionHandler(TenantDoesNotExistException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(HttpServletRequest req, Exception e){
		return getHTTPResponse(req, e);
	}
}
