package com.dipta.project.exception.acl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dipta.project.dto.common.ResponseMessageDTO;
import com.dipta.project.exception.base.AbstractBaseException;

public class AclUpdateException  extends  AbstractBaseException {

	private static final long serialVersionUID = 1L;

	public AclUpdateException() {
		super();
	}

	public AclUpdateException(String message){
		super(message);
	}

	@Override
	@ExceptionHandler(AclUpdateException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(HttpServletRequest req, Exception e) {
		return getHTTPResponse(req, e);
	}

}

