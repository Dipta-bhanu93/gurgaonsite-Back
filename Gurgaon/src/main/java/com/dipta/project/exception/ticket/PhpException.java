/**
 * 
 */
package com.dipta.project.exception.ticket;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dipta.project.dto.common.ResponseMessageDTO;
import com.dipta.project.exception.base.AbstractBaseException;

@ControllerAdvice
public class PhpException extends AbstractBaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PhpException() {
		super();
	}
	public PhpException(String message) {
		super(message);
	}

	
	@ExceptionHandler(PhpException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(
			HttpServletRequest req, Exception e) {
		return getHTTPResponse(req, e);
		}

}