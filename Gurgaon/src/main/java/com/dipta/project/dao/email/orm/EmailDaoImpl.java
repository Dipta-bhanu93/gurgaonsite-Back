/**
 * 
 */
package com.dipta.project.dao.email.orm;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.criterion.Restrictions;

import com.dipta.project.dao.base.orm.AbstractBaseDao;
import com.dipta.project.dao.email.IEmailDao;
import com.dipta.project.domain.email.EmailContentDomain;
import com.dipta.project.dto.email.EmailInfoDTO;
import com.dipta.project.exception.common.ObjectNotSupportedException;
import com.dipta.project.exception.common.ProcessFailedException;
import com.dipta.project.utility.CommonUtils;

/**
 * @author Aditya.Julka
 *
 */
public class EmailDaoImpl  extends AbstractBaseDao  implements IEmailDao {

	public EmailDaoImpl(Long tenantId) {
		super(tenantId);
		// TODO Auto-generated constructor stub
	}

	public EmailDaoImpl(String userEmail) {
		super(userEmail);
	}
	
	public static final String CLASSNAME = "EmailDaoImpl";
	
	
	@Override
	public Long getClientId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmailInfoDTO save(EmailInfoDTO emailObj)
			throws ObjectNotSupportedException, ProcessFailedException {
		EmailContentDomain result=new EmailContentDomain();
		try {
			beginTransaction();
			EmailContentDomain domain=CommonUtils.convertObject(emailObj, EmailContentDomain.class);
			result=(EmailContentDomain) hibernatePersistenceManager.save(domain);
		} catch (Exception e) {
			rollBack();
			return null;
		}finally{
			endTransaction();
		}
		return CommonUtils.convertObject(result, EmailInfoDTO.class);
	}

	@Override
	public List<EmailInfoDTO> getEmailDetails()
			throws ObjectNotSupportedException, ProcessFailedException {
		List<EmailInfoDTO> emailList=new ArrayList<>();
		try{
			beginTransaction();
			Timestamp time=new Timestamp(new Date().getTime()-(5L * 60L * 1000L));
			List<EmailContentDomain> list=(List<EmailContentDomain>) hibernatePersistenceManager
					.createCriteria(EmailContentDomain.class)
					.add(Restrictions.
//							sqlRestriction("DATE_MODIFIED >=?",time,StandardBasicTypes.TIMESTAMP))
							or(Restrictions.le("modifiedDate",time),Restrictions.isNull("modifiedDate") ))
					.add(Restrictions.le("retryCount", 2))
					.list();
			for(EmailContentDomain obj:list){
				emailList.add(CommonUtils.convertObject(obj, EmailInfoDTO.class));
				}
			}catch(Exception e){
			return emailList;
		}finally{
			endTransaction();
		}
		return emailList;
	}

	@Override
	public List<EmailInfoDTO> getEmailDetails(Long ClientId)
			throws ObjectNotSupportedException, ProcessFailedException {
		List<EmailInfoDTO> emailList=new ArrayList<>();
		try{
			beginTransaction();
			List<EmailContentDomain> list=hibernatePersistenceManager
					.createCriteria(EmailContentDomain.class)
					.add(Restrictions.
							eq("clientid",ClientId))
					.list();
			for(EmailContentDomain obj:list){
				emailList.add(CommonUtils.convertObject(obj, EmailInfoDTO.class));
				}
			}catch(Exception e){
			return emailList;
		}finally{
			endTransaction();
		}
		return emailList;
	}

	@Override
	public boolean deleteEmail(EmailInfoDTO emailObj)
			throws ObjectNotSupportedException, ProcessFailedException {
		boolean flag=false;
		try{
			beginTransaction();
			EmailContentDomain domain=CommonUtils.convertObject(emailObj, EmailContentDomain.class);
			hibernatePersistenceManager.delete(domain);
			flag=true;
		}catch(Exception e){
			return flag;
		}finally{
			endTransaction();
		}
		return flag;
	}

	@Override
	public boolean retryCount(EmailInfoDTO emailObj) throws ObjectNotSupportedException,
			ProcessFailedException {
		boolean flag=false;
		try{
			beginTransaction();
			EmailContentDomain domain=CommonUtils.convertObject(emailObj, EmailContentDomain.class);
			domain.setRetryCount((emailObj.getRetryCount()+1));
			domain.setModifiedDate(new Timestamp(new Date().getTime()));
			hibernatePersistenceManager.saveOrUpdate(domain);
			flag=true;
		}catch(Exception e){
			return flag;
		}finally{
			endTransaction();
		}
		return flag;
	}



}