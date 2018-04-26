/**
 * 
 */
package com.dipta.project.exception.workflow;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.dipta.project.dto.common.ResponseMessageDTO;
import com.dipta.project.exception.base.AbstractBaseException;


/**
 * @author Ashish.Patel
 *
 */
@ControllerAdvice
public class DuplicateWorkFlowNameException extends AbstractBaseException {

	private static final long serialVersionUID = 1L;

	public DuplicateWorkFlowNameException() {
		super("This workFlow name already exist. Please try another name");
	}
	
	public DuplicateWorkFlowNameException(String message) {
		super(message);
	}
	
	@ExceptionHandler(DuplicateWorkFlowNameException.class)
	public ResponseEntity<ResponseMessageDTO> exceptionHttpCall(
			HttpServletRequest req, Exception e) {
		// TODO Auto-generated method stub
		return getHTTPResponse(req, e);
	}

}
