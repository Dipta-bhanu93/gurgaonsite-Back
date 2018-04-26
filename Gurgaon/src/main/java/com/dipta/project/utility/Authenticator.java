package com.dipta.project.utility;

import java.sql.Timestamp;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dipta.project.dao.user.IAuthenticatorDao;
import com.dipta.project.dao.user.orm.AuthenticatorDaoImpl;
import com.dipta.project.domain.user.AuthenticationDomain;
import com.dipta.project.dto.lei.LEIDTO;
import com.dipta.project.exception.common.ProcessFailedException;

import com.dipta.project.utility.constants.ApplicationConstants;

/**
 * 
 * @author Saurabh.Agarwal
 *
 */
public class Authenticator {
	private static final String HEADERTOKENKEY = PropertyUtility.getValueString(ApplicationConstants.CONFIGURATIONSBUNDLE.getValue(), ApplicationConstants.SESSIONTOKEN.getValue(),null);
	long sessionDuration = 600000;
	
	private HttpServletRequest request = null;
//	private HttpServletResponse response = null;
	private String token = null;
	
	public Authenticator(HttpServletRequest request ) {
		token =  CommonUtils.getUniqueToken();
		this.request = request;
	}
	public Authenticator(String token,HttpServletRequest request ) {
		this.token = token;
		this.request = request;
	}
	
	public Authenticator() {
		
	}
	
//	public Authenticator(HttpServletRequest request,HttpServletResponse response){
//		this.request=request;
//		this.response=response;
//		token = getToken();
//	}
	public boolean login(String loginID) throws ProcessFailedException{
		String ipAddress = request.getRemoteAddr();
		Timestamp issueTime = CommonUtils.getCurrentTimestamp();
		Timestamp expiryDate = CommonUtils.getFutureTimestamp(sessionDuration); 
		AuthenticationDomain authenticationData = null;
		IAuthenticatorDao dao = new AuthenticatorDaoImpl();
		
		authenticationData = new AuthenticationDomain();
		authenticationData.setToken(token);
		authenticationData.setLoginId(loginID);
		authenticationData.setIpAddress(ipAddress);
		authenticationData.setIssueDate(issueTime);
		authenticationData.setExpiryDate(expiryDate);
		authenticationData.setExpiryDetail("Not Expired");
		authenticationData.setInvalidated("N");
		dao.login(authenticationData);
		
		return true;
	}
	
	public boolean authenticate() throws ProcessFailedException{
		IAuthenticatorDao dao = new AuthenticatorDaoImpl();
		Timestamp currentTime = CommonUtils.getCurrentTimestamp();
		
		if(dao.authenticate(token, currentTime)!=null){
			updateExpiry();
			return true;
		}
		else{
			return false;
		}
	}
	
	public String getLoginId(){
		IAuthenticatorDao dao = new AuthenticatorDaoImpl();
		Timestamp currentTime = CommonUtils.getCurrentTimestamp();
		AuthenticationDomain authData = null;
		
		if((authData=dao.authenticate(token, currentTime))!=null)
			return authData.getLoginId();
		else
			return null;
	}
	
	public boolean logout() throws ProcessFailedException{
		IAuthenticatorDao dao = new AuthenticatorDaoImpl();
		Timestamp currentTime = CommonUtils.getCurrentTimestamp();
		AuthenticationDomain authData = null;
		
		if((authData=dao.authenticate(token, currentTime))!=null){
			authData.setInvalidated("Y");
			authData.setInvalidateTime(currentTime);
			authData.setInvalidateDetail("User requested to logout");
			
			return dao.update(authData);
		}
		else{
			return false;
		}
		
	}
	
	public String getToken(){
//		String token = request.getHeader(HEADERTOKENKEY);
		return token;
	}
	
		
	private void updateExpiry() throws ProcessFailedException{
		IAuthenticatorDao dao = new AuthenticatorDaoImpl();
		dao.updateExpiry(getToken());
	}
	
	public String getLoginId(String token) throws ProcessFailedException{
		
		IAuthenticatorDao dao = new AuthenticatorDaoImpl();
		return dao.get(token).getLoginId();
	}
}