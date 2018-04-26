package com.dipta.project.dao.user;

import java.sql.Timestamp;

import com.dipta.project.domain.user.AuthenticationDomain;
import com.dipta.project.exception.common.ProcessFailedException;

/**
 * 
 * @author Saurabh.Agarwal
 *
 */
public interface IAuthenticatorDao {
	public boolean login(AuthenticationDomain authData) throws ProcessFailedException;
	public AuthenticationDomain authenticate(String token,Timestamp currentTime);
	public boolean update(AuthenticationDomain authData) throws ProcessFailedException ;
	public void updateExpiry(String token) throws ProcessFailedException;
	public AuthenticationDomain get(String token) throws ProcessFailedException;
	
}
