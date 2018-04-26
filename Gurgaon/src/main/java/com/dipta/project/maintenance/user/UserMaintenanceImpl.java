package com.dipta.project.maintenance.user;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.dipta.project.dao.base.DaoManager;
import com.dipta.project.dao.base.orm.TenantPool;
import com.dipta.project.dao.user.IUserDao;
import com.dipta.project.dao.workflow.IWorkFlowDao;
import com.dipta.project.domain.user.UserDomain;
import com.dipta.project.dto.user.ApiProcessDto;
import com.dipta.project.dto.user.CodApiRequestDto;
import com.dipta.project.dto.user.RoleDTOCollection;
import com.dipta.project.dto.user.RolesDto;
import com.dipta.project.dto.user.StatusDTOCollection;
import com.dipta.project.dto.user.StatusDto;
import com.dipta.project.dto.user.UserDTO;
import com.dipta.project.dto.user.UserDTOCollection;
import com.dipta.project.dto.user.UserRolesDto;
import com.dipta.project.dto.user.UserStatusDto;
import com.dipta.project.exception.ExceptionConstantEnum;
import com.dipta.project.exception.common.EmailException;
import com.dipta.project.exception.common.InvalidFileException;
import com.dipta.project.exception.common.InvalidKeyException;
import com.dipta.project.exception.common.ObjectNotSupportedException;
import com.dipta.project.exception.common.ProcessFailedException;
import com.dipta.project.exception.file.DataNotSupportedException;
import com.dipta.project.exception.user.ActivationPendingException;
import com.dipta.project.exception.user.ConfirmNewPasswordException;
import com.dipta.project.exception.user.InvalidRequestException;
import com.dipta.project.exception.user.InvalidUserException;
import com.dipta.project.exception.user.LoginIDFormatException;
import com.dipta.project.exception.user.LoginIDRegisteredException;
import com.dipta.project.exception.user.OldPasswordException;
import com.dipta.project.exception.user.PasswordFormatException;
import com.dipta.project.exception.user.RegistrationFailedException;
import com.dipta.project.exception.user.SessionDoesNotExistException;
import com.dipta.project.security.configuration.CodSecurityProvider;
import com.dipta.project.security.configuration.RolesEnum;
import com.dipta.project.utility.AESEncryption;
import com.dipta.project.utility.CommonUtils;
import com.dipta.project.utility.MessageUtils;
import com.dipta.project.utility.PropertyUtility;
import com.dipta.project.utility.constants.ApplicationConstants;
import com.dipta.project.utility.constants.CommonConstants;
import com.dipta.project.utility.constants.EmailEvent;
import com.dipta.project.utility.constants.MessageKeyConstants;
import com.dipta.project.utility.constants.StatusConstants;
import com.dipta.project.utility.email.SendMail;

/**
 * 
 * @author Saurabh.Agarwal
 *
 */
@Service
@PropertySources({
    @PropertySource("classpath:application.properties"),
    @PropertySource("classpath:applicationclient.properties")
})
@Slf4j
public class UserMaintenanceImpl implements IUserMaintenance{
	private static final String TDSTYLE= "style='border:1px solid;padding:5px;'";

	private static final int NINTY_DAYS = 90;
	private static final int THIRTY_DAYS = 30;
	private static final String IMGLOC="/app/images/XorchatUsericon/";
	
	@Autowired
    Environment environment;
	
	
	@Autowired
	private Environment env;


	@Override
	public boolean changePassword(UserDTO loginDto) throws ConfirmNewPasswordException, OldPasswordException, PasswordFormatException, ObjectNotSupportedException, ProcessFailedException, EmailException {
		IUserDao dao = DaoManager.USER.getDao(loginDto.getEmail(),IUserDao.class);
		boolean isChangePassword =false;
		
		UserDTO persistedUser = dao.getUser(loginDto.getEmail(), false);
		if(CodSecurityProvider.matches(environment.getProperty("hashAlgo.bcrypt"),loginDto.getStatus().getPassword(), persistedUser.getStatus().getPassword())){
			
			if(loginDto.getStatus().getNewPassword().equals(loginDto.getStatus().getConfirmNewPassword())){
				/* encode the password with Bcrypt*/
				persistedUser.getStatus().setPassword(CodSecurityProvider.encode(environment.getProperty("hashAlgo.bcrypt"), loginDto.getStatus().getNewPassword()));
				persistedUser.getStatus().setStatusId(StatusConstants.NEW.getID());
				/*Commented below line as it was not encoding the password */
				/*persistedUser.getStatus().setPassword(loginDto.getStatus().getNewPassword());*/
				isChangePassword = dao.updatePasswordAndStatus(persistedUser);
				if(isChangePassword){
					String emailBody = MessageUtils.getMessage(MessageKeyConstants.USERCHANGEPASSWORD.getKey(), persistedUser.getFirstName(),loginDto.getStatus().getNewPassword());
					SendMail.sendMail(EmailEvent.USERCHANGEPASSWORD.getEvent(), persistedUser.getEmail(), null, emailBody, null,persistedUser);
//					SendMail.sendMail(EmailEvent.USERCHANGEPASSWORD.getEvent(), persistedUser.getEmail(), null, emailBody, null);
				
					
					
					// update password expiry date and date created if password is expired
					
					long daysBetween = persistedUser.getStatus().getDaysLeft();
					
					if(daysBetween <= 0){
						boolean res= dao.updateCreatedAndPasswordExpiryDate(loginDto.getEmail());
					}
					
					
					
				}
			}else{
				throw new ConfirmNewPasswordException("New password and confirm password does not match.");
			}
		}else{
			throw new OldPasswordException("old password does not match.");
		}

		return isChangePassword;
	}

	@Override
	public boolean exists(String emailId) throws LoginIDFormatException{
		IUserDao dao = DaoManager.USER.getDao(emailId,IUserDao.class);
		
		return dao.exists(emailId);
	}
	@Override
	public boolean validateDomainName(String loggedInUserId, String emailId)
			throws DataNotSupportedException {
		boolean flag=false;
		if(loggedInUserId!=null && emailId!=null){
			flag= getDomainName(loggedInUserId).equalsIgnoreCase(getDomainName(emailId));
		}else{
			throw new DataNotSupportedException("Input is null");
		}
		return flag;
	}
	private String getDomainName(String emailId){
		int lastIndex=emailId.lastIndexOf("@");
		String domainName=emailId.substring(lastIndex,emailId.length());
		return domainName;
	}
	
	@Override
	public boolean forgetPassword(UserDTO userDto) throws InvalidUserException, LoginIDFormatException, ObjectNotSupportedException, ProcessFailedException, EmailException, ActivationPendingException {
		IUserDao dao = DaoManager.USER.getDao(userDto.getEmail(),IUserDao.class);
		String temporaryPassword = null;
		boolean isChangePassword =false;
		
		if(dao.exists(userDto.getEmail())){
			temporaryPassword = CommonUtils.generatePassword();
			userDto = dao.getUser(userDto.getEmail(), false);
			if(userDto.getStatus().getStatusId()==StatusConstants.ACTIVATIONPENDING.getID()){
				throw new  ActivationPendingException();
			}
			userDto.getStatus().setStatusId(StatusConstants.CHANGEPASSWORDPENDING.getID());
			userDto.getStatus().setLastLogin(null);
			userDto.getStatus().setPassword(CodSecurityProvider.encode(environment.getProperty("hashAlgo.bcrypt"), temporaryPassword));
			isChangePassword = dao.updatePasswordAndStatus(userDto);
			String url =  env.getProperty("CLIENT_BASEURL");
			if(isChangePassword){
				String emailBody = MessageUtils.getMessage(MessageKeyConstants.LOGINFORGETPASSWORDBODY.getKey(),url, userDto.getFirstName(),userDto.getEmail(),temporaryPassword);
//				SendMail.sendMail(EmailEvent.USERFORGETPASSWORD.getEvent(), userDto.getEmail(), null, emailBody, null);
				SendMail.sendMail(EmailEvent.USERFORGETPASSWORD.getEvent(), userDto.getEmail(), null, emailBody, null,userDto);
			}else{
				throw new ProcessFailedException("Some unknown exception generated at the time of forget password");
			}
		}else{
			throw new InvalidUserException("User is not registered.");
		}
		return isChangePassword;

	}

	

	@Override
	public boolean logout(UserDTO loginDto) throws SessionDoesNotExistException , ObjectNotSupportedException{
		IUserDao dao = DaoManager.USER.getDao(loginDto.getEmail(),IUserDao.class);

		return dao.logout(loginDto);

	}

	
	@Override
	public boolean register(UserDTO userDto) throws RegistrationFailedException, ObjectNotSupportedException, EmailException, LoginIDRegisteredException, ProcessFailedException {
		IUserDao dao = DaoManager.USER.getDao(userDto.getEmail(),IUserDao.class);
		//start here
		String activation_key = CommonUtils.getUniqueToken();
		userDto.setActivationKey(activation_key);
		
		//end here
		
		
		String plainPassword = CommonUtils.generatePassword();
		String temporaryPassword = plainPassword;
		boolean registered = false;
		if(!dao.exists(userDto.getEmail())){
			userDto.setStatus(new UserStatusDto());
			
			if(userDto.getStatusMaster()!=null){
				// encode the password with Bcrypt
				userDto.getStatus().setPassword(CodSecurityProvider.encode(environment.getProperty("hashAlgo.bcrypt"), temporaryPassword));
				userDto.getStatus().setStatusId(StatusConstants.NEW.getID());  // to be commented
				// to set date created and password expiry date
				
				userDto.getStatus().setDateCreated(new java.sql.Timestamp(new Date().getTime()));
				Date expiryDate = CommonUtils.addDay(CommonUtils.toDate(userDto.getStatus().getDateCreated()),NINTY_DAYS);
				userDto.getStatus().setPasswordExpiry(new java.sql.Timestamp(expiryDate.getTime()));
				
				
			}else{
				userDto.getStatus().setPassword("not set");
				userDto.getStatus().setStatusId(StatusConstants.ACTIVATIONPENDING.getID());  // to be commented
			}
			registered = dao.register(userDto);
			
			String ccEmailAdd = null;
			String emailBody = null;
			String url = null;
			url = PropertyUtility.getValueString(ApplicationConstants.CONFIGURATIONSBUNDLE.getValue(), "BASEURL","http://localhost:8080/CdiOnDemand/");
			
			/*Registering new connections*/
			TenantPool.registerNewConnectionForUser(userDto.getEmail());
			
			
			if(registered){
				
				
				if(userDto.getStatusMaster()!=null){
					UserDomain userdomain = dao.userDomainById(Long.parseLong(userDto.getCreatedBy()));
					ccEmailAdd = userdomain.getEmail();
					emailBody = MessageUtils.getMessage(MessageKeyConstants.NEWREGISTRATIONBODY.getKey(), userDto.getFirstName(),env.getProperty("CLIENT_BASEURL"), userDto.getEmail(),plainPassword,RolesEnum.getRoleEnumById(userDto.getUserRole().getRoleId()).getRoleDescription());
					SendMail.sendMail(EmailEvent.USERREGISTERED.getEvent(), userDto.getEmail(), ccEmailAdd, emailBody, null,userDto);
//					SendMail.sendMail(EmailEvent.USERREGISTERED.getEvent(), userDto.getEmail(), ccEmailAdd, emailBody, null);
				}else{
					
					emailBody = MessageUtils.getMessage(MessageKeyConstants.NEWUSERACTIVATION.getKey(), userDto.getFirstName(),url, userDto.getEmail(),activation_key);
					SendMail.sendMail(EmailEvent.USERACTIVTAION.getEvent(), userDto.getEmail(), ccEmailAdd, emailBody, null,userDto);
//					SendMail.sendMail(EmailEvent.USERACTIVTAION.getEvent(), userDto.getEmail(), ccEmailAdd, emailBody, null)
				}
				
			
				
			}
		
		}else{
			throw new LoginIDRegisteredException("Already Registered");
		}
		
		/*Registering new connections*/
		//TenantPool.registerNewConnectionForUser(userDto.getEmail());
		return registered;
	}
	
	
	@Override
	public boolean apiRegistration(UserDTO userDto) throws Exception {
		IUserDao dao = DaoManager.USER.getDao(userDto.getEmail(),IUserDao.class);
		//start here
		//String activation_key = CommonUtils.getUniqueToken();
		//userDto.setActivationKey(activation_key);
		
		//end here
		
		
		String plainPassword = CommonUtils.generatePassword();
		String temporaryPassword = plainPassword;
		boolean registered = false;
		if(!dao.exists(userDto.getEmail())){
			userDto.setStatus(new UserStatusDto());
			
				// encode the password with Bcrypt
				userDto.getStatus().setPassword(CodSecurityProvider.encode(environment.getProperty("hashAlgo.bcrypt"), temporaryPassword));
				userDto.getStatus().setStatusId(StatusConstants.ACTIVE.getID());  // to be commented
				// to set date created and password expiry date
				
				userDto.getStatus().setDateCreated(new java.sql.Timestamp(new Date().getTime()));
				Date expiryDate = CommonUtils.addDay(CommonUtils.toDate(userDto.getStatus().getDateCreated()),THIRTY_DAYS);
				userDto.getStatus().setPasswordExpiry(new java.sql.Timestamp(expiryDate.getTime()));
				userDto.setCompanyId(Long.parseLong(PropertyUtility.getValueString(ApplicationConstants.CONFIGURATIONSBUNDLE.getValue(), "API_TENENT","9999")));
				
			registered = dao.apiRegister(userDto);
			if(registered){
					sendAPIUserRegistrationEmail(userDto);
			}
		
		}else{
			throw new LoginIDRegisteredException("Already Registered");
		}
		
		/*Registering new connections*/
		TenantPool.registerNewConnectionForUser(userDto.getEmail());
		return registered;
	}

	@Override
	public UserDTO getUser(String emailId, boolean loadRoles) throws ObjectNotSupportedException {
		IUserDao dao = DaoManager.USER.getDao(emailId,IUserDao.class);
		UserDTO userDto = dao.getUser(emailId, loadRoles);
		if(null != userDto && null != userDto.getUserRole()){
			String url = PropertyUtility.getValueString(ApplicationConstants.APPLICATIONCLIENT_BUNDLE.getValue(), "CLIENT_BASEURL","http://localhost:8080/CdiOnDemand");
			String image = "";
			switch(userDto.getUserRole().getType()){
				case "ADMIN":
					image = "AdminIcon.png";
					break;
				case "DATAANALYST":
					image = "DataAnalystIcon.png";
					break;
				case "EXSUPER":
					image = "ExSuperIcon.png";
					break;
				case "INSUPER":
					image = "InSuperIcon.png";
					break;
				case "QAANALYST":
					image = "QaAnalystIcon.png";
					break;
			}
			userDto.getUserRole().setXorchatIcon(url+IMGLOC+image);
		}
		return userDto;
	}
	

	/**
	 * get users for clientId/company id
	 * @throws ProcessFailedException 
	 */

	@Override
	public List<UserDTO> getUsersForClient(Long clientId, String loggedInuserId) throws LoginIDFormatException, ObjectNotSupportedException, ProcessFailedException{
		
		List<UserDTO> userDtos= new ArrayList<UserDTO>();
		IUserDao dao = DaoManager.USER.getDao(loggedInuserId,IUserDao.class);
		 userDtos = dao.getUsersForClient(clientId, null);
		return userDtos;
	}
	
	@Override
	public String getStatus(String emailId) {
		/*IUserDao dao = DaoManager.USER.getDao(IUserDao.class);
		UserDomain userDomain = dao.getUser(emailId);
		
		if(userDomain!=null){
			return userDomain.getStatus().getName();
		}else{
			return null;
		}*/
		return null;
	}

	/*@Override
	public UserDTO findById(int id) throws ObjectNotSupportedException {
		IUserDao dao = DaoManager.USER.getDao(IUserDao.class);
		UserDTO userDTO = dao.findById(id); 
		return userDTO;
	}*/

	
	
	@Override
	public UserDTO findBySignInId(String signInId) throws ObjectNotSupportedException {
		IUserDao dao = DaoManager.USER.getDao(signInId,IUserDao.class);
		return dao.findBySignInId(signInId, true); 
	}

	
		
	/*@Override
	public UserDTO getUserByProjectId(long projectId)
			throws ProjectIdNotSupportedException {
		IUserDao dao = DaoManager.USER.getDao(IUserDao.class);
		return dao.getUserByProjectId(projectId);
	}*/
	
	/*@Override
	public long getUserIdByProjectId(long projectId) {
		IUserDao dao = DaoManager.USER.getDao(IUserDao.class);
		return dao.getUserIdByProjectId(projectId); 
	}*/
	
	/**
	 * This method is used to login in api with given loginId nad password.
	 */
	@Override
	public boolean login(String loginId, String password) throws ProcessFailedException{
		IUserDao userDao = DaoManager.USER.getDao(loginId,IUserDao.class);
		userDao.login(loginId, password);
		
		return true;
	}
	
	@Override
	public boolean updateProfile(UserDTO userDto, String loggedInUser) throws  ObjectNotSupportedException, ProcessFailedException, EmailException {
		boolean isProfileUpdateSuccess = false;
		UserDTO beforeUserDto = getUser(userDto.getEmail(), true);
		
		IWorkFlowDao wfDao = DaoManager.WORKFLOWDAO.getDao(loggedInUser, IWorkFlowDao.class);
		boolean isWfUser = wfDao.isUserAssociatedWithWorkflow(userDto.getId());
		
		IUserDao dao = DaoManager.USER.getDao(loggedInUser,IUserDao.class);
		if (!isWfUser || (isWfUser
							&& CommonConstants.BLANK_STRING
								.equals(compareRoleFields("Role", beforeUserDto.getUserRole(), userDto.getUserRole())) 
							&& !StatusConstants.INACTIVE.getStatus().equals(userDto.getStatusMaster().getStatus())) ){
			isProfileUpdateSuccess =dao.updateUserProfile(userDto);
			if(isProfileUpdateSuccess){
				/*Updating connections for status change from Active to Inactive*/
				TenantPool.registerNewConnectionForUser(userDto.getEmail());
				/*Sending mail to User for Successful Profile updation*/
				String tbody = CommonConstants.BLANK_STRING;
				tbody = tbody + compareUserFields("First Name", beforeUserDto.getFirstName(), userDto.getFirstName());
				tbody = tbody + compareUserFields("Last Name", beforeUserDto.getLastName(), userDto.getLastName());
				tbody = tbody + compareUserFields("Mobile Number", beforeUserDto.getMobile(), userDto.getMobile());
				tbody = tbody + compareRoleFields("Role", beforeUserDto.getUserRole(), userDto.getUserRole());
				tbody = tbody + compareUserFields("Status", beforeUserDto.getStatusMaster().getStatus(), userDto.getStatusMaster().getStatus());
				if(!tbody.equals(CommonConstants.BLANK_STRING)){
					String emailBody = MessageUtils.getMessage(MessageKeyConstants.USER_PROFILEUPDATE_SUCCESS.getKey(), tbody);
					try {
						SendMail.sendMail(EmailEvent.USERPROFILEUPDATE.getEvent(), userDto.getEmail(), null , emailBody, null,userDto);
//						SendMail.sendMail(EmailEvent.USERPROFILEUPDATE.getEvent(), userDto.getEmail(), null , emailBody, null);
					} catch (EmailException e) {
						log.warn("Failure while sending profile updation mail to user");
					}
				}
			}
		}
		return isProfileUpdateSuccess;
	}
	
	
	/**
	 * This function compares user profile field and creates a row to be sent in mail for same
	 * @param field
	 * @param before
	 * @param after
	 * @return
	 */
	private String compareUserFields(String field, Object before, Object after){
		if(!before.equals(after)){
			return "<tr><td "+TDSTYLE+">"+field+"</td><td "+TDSTYLE+">"+before+"</td><td "+TDSTYLE+">"+after+"</td>";
		}
		return CommonConstants.BLANK_STRING;
	}
	
	/**
	 * This function compares user profile role id and creates a row with role desc to be sent in mail for same
	 * @param field
	 * @param before
	 * @param after
	 * @return
	 */
	private String compareRoleFields(String field, UserRolesDto before, UserRolesDto after){
		if(!before.getRoleId().equals(after.getRoleId())){
			return "<tr><td "+TDSTYLE+">"+field+"</td><td "+TDSTYLE+">"+before.getTypeDesc()+"</td><td "+TDSTYLE+">"+RolesEnum.getRoleEnumById(after.getRoleId()).getRoleDescription()+"</td>";
		}
		return CommonConstants.BLANK_STRING;
	}
	
	@Override
	public UserDTOCollection getUsersCreated(String emailId) throws ObjectNotSupportedException {
		IUserDao dao = DaoManager.USER.getDao(emailId,IUserDao.class);
		UserDTOCollection userDTOCollection = new UserDTOCollection();
		List<UserDTO> userDomain = dao.getUsersCreated(emailId);
		
		userDTOCollection.setUserDTOs(userDomain);
		return userDTOCollection;
	}
	
	@Override
	public StatusDTOCollection getStatusMaster() throws ObjectNotSupportedException {
		IUserDao dao = DaoManager.USER.getDao(ApplicationConstants.SUPERUSEREMAIL.getValue(),IUserDao.class);
		StatusDTOCollection statusDTOCollection = new StatusDTOCollection();
		List<StatusDto> statusDomains = dao.getStatusMasterList();
		statusDTOCollection.setStatusDTOs(statusDomains);
		return statusDTOCollection;
	}
	
	@Override
	public RoleDTOCollection getRoleMaster() throws ObjectNotSupportedException {
		IUserDao dao = DaoManager.USER.getDao(ApplicationConstants.SUPERUSEREMAIL.getValue(),IUserDao.class);
		RoleDTOCollection roleDTOCollection = new RoleDTOCollection();
		List<RolesDto> roleDomains = dao.getRoleMasterList();
		roleDTOCollection.setRoleDTOs(roleDomains);
		return roleDTOCollection;
	}

	
	@Override
	public boolean activateUser(String emailId)
			throws ProcessFailedException, ObjectNotSupportedException, EmailException, RegistrationFailedException {
		IUserDao dao = DaoManager.USER.getDao(ApplicationConstants.SUPERUSEREMAIL.getValue(),IUserDao.class);		
		UserDTO  userDto = new UserDTO();
		userDto = getUser(emailId, false);
		String plainPassword = CommonUtils.generatePassword();
		
		// encode the password with Bcrypt
		String encryptedPwd= CodSecurityProvider.encode(environment.getProperty("hashAlgo.bcrypt"), plainPassword);
		
//		boolean registrationConfirm = dao.activateUser(emailId,encryptedPwd,StatusConstants.NEW.getID());
		boolean registrationConfirm = dao.activateUser(emailId,encryptedPwd,StatusConstants.CHANGEPASSWORDPENDING.getID());
		//String 	url = PropertyUtility.getValueString(ApplicationConstants.CONFIGURATIONSBUNDLE.getValue(), "BASEURL","http://localhost:8080/CdiOnDemand/");
		String url =  env.getProperty("CLIENT_BASEURL");
		String ccEmailAdd = null;
		if(registrationConfirm){
				String emailBody = MessageUtils.getMessage(MessageKeyConstants.NEWREGISTRATIONBODY.getKey(), userDto.getFirstName(), url, userDto.getEmail(),plainPassword, userDto.getUserRole().getTypeDesc());
				SendMail.sendMail(EmailEvent.USERREGISTERED.getEvent(), userDto.getEmail(), ccEmailAdd, emailBody, null,userDto);
//				SendMail.sendMail(EmailEvent.USERREGISTERED.getEvent(), userDto.getEmail(), ccEmailAdd, emailBody, null);
				
			}
		
		return registrationConfirm;
	
	}

	@Override
	public boolean checkActivationEnabled(String emailId)
			throws LoginIDFormatException, ProcessFailedException, ObjectNotSupportedException {
		
		UserDTO userDTO = getUser(emailId, false);
		
		if(userDTO.getStatusMaster().getStatusId() == StatusConstants.ACTIVE.getID() || userDTO.getStatusMaster().getStatusId() == StatusConstants.NEW.getID())
			{return true;}
		else
			{return false;}
		
		}


	@Override
	public String getUserEmailIdForClientID(Long clientId, String loggedInuserId) throws LoginIDFormatException, ObjectNotSupportedException, ProcessFailedException{
		String emailId=null;
		IUserDao dao = DaoManager.USER.getDao(loggedInuserId,IUserDao.class);
		emailId = dao.getUserEmailIdForClientId(clientId);
		return emailId;
		
	}
	
	@Override
	public UserDTOCollection getUserListForXorChat(String emailId) throws ObjectNotSupportedException {
		IUserDao dao = DaoManager.USER.getDao(emailId,IUserDao.class);
		UserDTOCollection userDTOCollection = dao.getUserListForXorChat(emailId);
		return userDTOCollection;
	}

	@Override
	public void updatLastLogin(UserDTO userDTO) throws  ProcessFailedException, ObjectNotSupportedException {
		IUserDao dao = DaoManager.USER.getDao(ApplicationConstants.SUPERUSEREMAIL.getValue(),IUserDao.class);
		dao.updatLastLogin(userDTO);
		return ;
	}
	
	@Override
	public boolean sendAPIUserRegistrationEmail(UserDTO userDto) throws Exception {
        String ccEmailAdd = null;
        String emailBody = null;
        boolean sendMail = false;
        if(null != userDto.getEmail() && !userDto.getEmail().isEmpty()){
               IUserDao dao = DaoManager.USER.getDao(userDto.getEmail(),IUserDao.class);
               UserDomain userdomain = dao.userDomainById(dao.getUserID(userDto.getEmail()));
               if(null != userdomain){
                     if(null != userdomain.getStatus()){
                            String secureToken=AESEncryption.encryptText(userdomain.getEmail()+"@@@@"+userdomain.getStatus().getPassword());
                            emailBody = MessageUtils.getMessage(MessageKeyConstants.NEW_USER_EXPOSEMAIL.getKey(), userDto.getFirstName(),secureToken);
                            SendMail.sendMail(EmailEvent.NEWUSEREXPOSEMAIL.getEvent(), userDto.getEmail(), ccEmailAdd, emailBody, null,userDto);
                            log.info("Send API UserRegistration Email ::"+userDto.getEmail());
                            sendMail = true;
                     }
               }
        }
        return sendMail;
 }


	
 @Override
 public boolean isAPIuserAuthencated(CodApiRequestDto codApiRequestDto,boolean isFirstLevelAuth) throws InvalidUserException{
	 	// 
	    boolean isAPIuserAuthencated = false;
	 	if(isFirstLevelAuth && !(codApiRequestDto.getRegEmail()!=null && codApiRequestDto.getRegEmail().equalsIgnoreCase(codApiRequestDto.getEmail()))){
	 		 isAPIuserAuthencated = false;
	 	}else{
	 		 log.info("First Level Auth-->Pass ::"+codApiRequestDto.getRegEmail());
	 		 if(null != codApiRequestDto.getEmail() && !codApiRequestDto.getEmail().isEmpty() && null != codApiRequestDto.getPassword()){
	               IUserDao dao = DaoManager.USER.getDao(codApiRequestDto.getEmail(),IUserDao.class);
	               UserDomain userdomain = dao.userDomainById(dao.getUserID(codApiRequestDto.getEmail()));
	               if(userdomain.getStatus().getPassword().equals(codApiRequestDto.getPassword())){
	            	     log.info("Second Level Auth-->Pass ::"+codApiRequestDto.getRegEmail());
	                     isAPIuserAuthencated = true;
	               }
	        }
	 	}
	 	if(!isAPIuserAuthencated){
	 		throw new InvalidUserException(ExceptionConstantEnum.INVALID_TOKEN.getExceptionDescription());
	 	}
        return isAPIuserAuthencated;
 }
 
 @Override
 public boolean isRequestVerified(CodApiRequestDto codApiRequestDto) throws InvalidRequestException{
	 boolean isRequestVerified = true;
	 	if(codApiRequestDto.getCodApiRequests() ==null || codApiRequestDto.getCodApiRequests().size()== 0){
	 		isRequestVerified = false;
	 	}
	 	if(!isRequestVerified){
	 		throw new InvalidRequestException(ExceptionConstantEnum.INVALID_REQUEST_PARAM.getExceptionDescription());
	 	}	
     return isRequestVerified;
	   
 }

 @Override
 public long createApiUserAccessToken(CodApiRequestDto dto)throws ObjectNotSupportedException {
        IUserDao dao = DaoManager.USER.getDao(dto.getEmail(),IUserDao.class);
        return dao.createApiUserAccessToken(dto);
 }
 
 @Override
 public boolean updateApiUserAccessToken(CodApiRequestDto dto)throws ObjectNotSupportedException {
        IUserDao dao = DaoManager.USER.getDao(dto.getEmail(),IUserDao.class);
        return dao.updateApiUserAccessToken(dto);
 }
 
 @Override
 public boolean isProcessRunning(CodApiRequestDto dto){
        IUserDao dao = DaoManager.USER.getDao(dto.getEmail(),IUserDao.class);
        return dao.isProcessRunning(dto).getRequestStatus().equalsIgnoreCase(CommonConstants.API_REQUEST_STATUS);
 }
 
 @Override
 public boolean createApiRequestsLog(CodApiRequestDto dto) throws ObjectNotSupportedException{
        IUserDao dao = DaoManager.USER.getDao(dto.getEmail(),IUserDao.class);
        return dao.createApiRequestsLog(dto);
 }
 
 @Override
 public boolean isRequestPerDayReached(CodApiRequestDto dto) throws InvalidFileException, InvalidKeyException, InvalidUserException{
        IUserDao dao = DaoManager.USER.getDao(dto.getEmail(),IUserDao.class);
        boolean isExceed=dao.isRequestPerDayReached(dto,PropertyUtility.getValueString(ApplicationConstants.CONFIGURATIONSBUNDLE.getValue(), "API_REQUESTS_THRESHOLD"));
        if(isExceed){
        	throw new InvalidUserException(ExceptionConstantEnum.INVALID_TOKEN.getExceptionDescription());
        }
        return isExceed;
 }




	
	
}
