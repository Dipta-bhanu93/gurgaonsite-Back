package com.dipta.project.dto.email;

import com.dipta.project.dto.email.base.AbstractBaseEmail;

/**
 * @author Saurabh.Agarwal
 */
public class EmailDTO extends AbstractBaseEmail{
	public EmailDTO(String event,String to,String cc,String body,String[] attachments,String[] attachmentsName) {
		super(event,to,cc,body,attachments,attachmentsName);
	}
}
