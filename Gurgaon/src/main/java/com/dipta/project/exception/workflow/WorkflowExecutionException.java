package com.dipta.project.exception.workflow;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dipta.project.dto.common.ResponseMessageDTO;
import com.dipta.project.exception.base.AbstractBaseException;

/**
 * @author Savita.Khurana
 *
 */
@ControllerAdvice
public class WorkflowExecutionException extends AbstractBaseException {

	private static final long serialVersionUID = 1L;

	public WorkflowExecutionException() {
		super("There is error while workflow execution. Please try after sometime.");
	}
	
	public WorkflowExecutionException(String message) {
		super(message);
	}
	
	@ExceptionHandler(WorkflowExecutionException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(
			HttpServletRequest req, Exception e) {
		// TODO Auto-generated method stub
		return getHTTPResponse(req, e);
	}

}

