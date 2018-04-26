package com.dipta.project.dao.email;

import java.util.List;

import com.dipta.project.dao.base.DaoBaseInterface;
import com.dipta.project.dto.email.EmailInfoDTO;
import com.dipta.project.exception.common.ObjectNotSupportedException;
import com.dipta.project.exception.common.ProcessFailedException;

public interface IEmailDao  extends DaoBaseInterface {
	
	public EmailInfoDTO save(EmailInfoDTO emailObj) throws ObjectNotSupportedException, ProcessFailedException;
	public List<EmailInfoDTO> getEmailDetails()  throws ObjectNotSupportedException,ProcessFailedException;
	public List<EmailInfoDTO> getEmailDetails(Long ClientId)  throws ObjectNotSupportedException,ProcessFailedException;
	public boolean deleteEmail(EmailInfoDTO emailObj)	throws ObjectNotSupportedException, ProcessFailedException;
	public boolean retryCount(EmailInfoDTO emailObj) throws ObjectNotSupportedException,ProcessFailedException;
	
	
}
