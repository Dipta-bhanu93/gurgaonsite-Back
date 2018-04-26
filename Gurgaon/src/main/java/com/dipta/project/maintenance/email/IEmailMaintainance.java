/**
 * 
 */
package com.dipta.project.maintenance.email;

import java.util.List;

import com.dipta.project.dto.email.EmailContentDto;
import com.dipta.project.dto.email.EmailInfoDTO;
import com.dipta.project.dto.email.UnsentMailListDto;
import com.dipta.project.dto.user.UserDTO;
import com.dipta.project.exception.common.ObjectNotSupportedException;
import com.dipta.project.exception.common.ProcessFailedException;


/**
 * @author Aditya.Julka
 *
 */
public interface IEmailMaintainance {

	public String reSendEmail(EmailContentDto con);
	
	public EmailInfoDTO saveEmail(EmailContentDto con,String exception,UserDTO user) throws ObjectNotSupportedException, ProcessFailedException;
	
	public List<UnsentMailListDto> getEmailList(Long clientId);
	
	
	public List<UnsentMailListDto> tryReSendEmail(Long clientId) throws  Exception ;

	List<UnsentMailListDto> getEmailList();
	
}
