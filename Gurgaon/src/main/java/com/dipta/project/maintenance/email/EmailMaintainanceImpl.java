/**
 * 
 */
package com.dipta.project.maintenance.email;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.springframework.stereotype.Service;

import com.dipta.project.dao.base.DaoManager;
import com.dipta.project.dao.email.IEmailDao;
import com.dipta.project.dao.user.IUserDao;
import com.dipta.project.dto.email.EmailContentDto;
import com.dipta.project.dto.email.EmailInfoDTO;
import com.dipta.project.dto.email.UnsentMailListDto;
import com.dipta.project.dto.user.UserDTO;
import com.dipta.project.exception.common.ObjectNotSupportedException;
import com.dipta.project.exception.common.ProcessFailedException;
import com.dipta.project.utility.CommonUtils;
import com.dipta.project.utility.PropertyUtility;
import com.dipta.project.utility.constants.ApplicationConstants;
import com.dipta.project.utility.email.SendMail;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Aditya.Julka
 *
 */
@Slf4j
@Service
public class EmailMaintainanceImpl implements IEmailMaintainance {

	

	
	@Override
	public String reSendEmail(EmailContentDto emailContentDto) {
		String result=SendMail.sendMail(emailContentDto);
		return result;
		}

	@Override
	public EmailInfoDTO saveEmail(EmailContentDto emailContentDto, String exception, UserDTO user) throws ObjectNotSupportedException, ProcessFailedException {
		
		IEmailDao dao=DaoManager.EMAIL.getDao(ApplicationConstants.SUPERUSEREMAIL.getValue(),IEmailDao.class);
//		IEmailDao dao=new EmailDaoImpl("aditya.julka@xoriant.com");
//				DaoManager.DASHBOARD.getDao("aditya.julka@xoriant.com",EmailDaoImpl.class);
//		UserDaoImpl dao1=DaoManager.DASHBOARD.getDao("aditya.julka@xoriant.com",UserDaoImpl.class);
//		user=dao1.findBySignInId("aditya.julka@xoriant.com", true);
//		user.setEmail("aditya.julka@xoriant.com");
			EmailInfoDTO domain=new EmailInfoDTO(user.getId(),user.getCompanyId(), CommonUtils.getXMLFromObject(emailContentDto), exception, 0);
			return dao.save(domain);
		
//		EmailDomainDTO domain=new EmailDomainDTO(123L,123L, CommonUtils.getXMLFromObject(con), exception, 0);
		
		
		
		
	}

	@Override
	public List<UnsentMailListDto> getEmailList() {
		IEmailDao dao=DaoManager.EMAIL.getDao(ApplicationConstants.SUPERUSEREMAIL.getValue(),IEmailDao.class);
		IUserDao userdao=DaoManager.USER.getDao(ApplicationConstants.SUPERUSEREMAIL.getValue(),IUserDao.class);
		List<UnsentMailListDto> emailList=new ArrayList<>();
		try {
			List<EmailInfoDTO> list=dao.getEmailDetails();
			for(EmailInfoDTO mailObj:list){
				String mailsubject=PropertyUtility.getValueString(ApplicationConstants.EMAILBUNDLE.getValue(),
									CommonUtils.getObjectFromXML(mailObj.getEmailContent(), EmailContentDto.class).getEvent()+"_FROM" ,"");
				emailList.add(new UnsentMailListDto(
						mailObj.getClientid(),
						userdao.getUserEmailIdForClientId(mailObj.getClientid()),
						mailsubject,
						mailObj.getCreatedDate()
						));
				
			}
			} catch (ObjectNotSupportedException | ProcessFailedException | JAXBException e) {
			log.error("EmailMaintainanceImpl::getEmailList "+e.getMessage());
		}
		return emailList;
		
	}

	


	public List<UnsentMailListDto> tryReSendEmail(Long clientId) throws Exception {
		IEmailDao dao=DaoManager.EMAIL.getDao(ApplicationConstants.SUPERUSEREMAIL.getValue(),IEmailDao.class);
		List<EmailInfoDTO> list=new ArrayList<>();
		list=dao.getEmailDetails();
			for(EmailInfoDTO dtoObj:list){
				resendMail(dtoObj);
			}
			List<UnsentMailListDto> emailList=getEmailList();
			return emailList; 
		}
	
	public boolean resendMail(EmailInfoDTO emailInfoDTO) throws Exception{
		
		IEmailDao dao=DaoManager.EMAIL.getDao(ApplicationConstants.SUPERUSEREMAIL.getValue(),IEmailDao.class);
		boolean flag=false;
		emailInfoDTO.setException(reSendEmail(CommonUtils.getObjectFromXML(emailInfoDTO.getEmailContent(), EmailContentDto.class)));
		if(emailInfoDTO.getException()!=null){
			dao.retryCount(emailInfoDTO);
			
		}else{
			flag =true;
			dao.deleteEmail(emailInfoDTO);
		}
		
		return flag;
		
	}

	@Override
	public List<UnsentMailListDto> getEmailList(Long clientId) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	

}