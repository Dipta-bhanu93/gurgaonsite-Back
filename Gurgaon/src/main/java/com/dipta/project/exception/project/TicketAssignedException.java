package com.dipta.project.exception.project;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dipta.project.dto.common.ResponseMessageDTO;
import com.dipta.project.exception.base.AbstractBaseException;

@ControllerAdvice
public class TicketAssignedException extends AbstractBaseException{
	
	private static final long serialVersionUID = 3238061144417004772L;
	public TicketAssignedException() {
		super("Project execution failed due to some ticket assignment.");
	}
	
	public TicketAssignedException(String message) {
		super(message);
	}
	@ExceptionHandler(TicketAssignedException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(
			HttpServletRequest req, Exception e) {
		// TODO Auto-generated method stub
		return getHTTPResponse(req, e);
	}

}
