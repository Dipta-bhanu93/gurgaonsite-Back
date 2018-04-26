package com.dipta.project.user;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dipta.project.exception.common.EmailException;
import com.dipta.project.exception.common.ObjectNotSupportedException;
import com.dipta.project.exception.common.ProcessFailedException;
import com.dipta.project.exception.user.LoginIDFormatException;
import com.dipta.project.exception.user.LoginIDRegisteredException;
import com.dipta.project.exception.user.RegistrationFailedException;
import com.dipta.project.maintenance.user.IUserMaintenance;

@Controller
@Slf4j
@RequestMapping(value = "/user")
@PropertySource("classpath:applicationclient.properties")
public class UserMaintenanceController {
	
	@Autowired
	IUserMaintenance userMaintenance;
	
	@Autowired
	private Environment env;
	
	
	/**
	 * To activate a user, if not already activated
	 * @param email
	 * @param activationKey
	 * @return
	 * @throws ProcessFailedException
	 * @throws LoginIDFormatException
	 * @throws LoginIDRegisteredException
	 * @throws ObjectNotSupportedException
	 * @throws EmailException
	 * @throws RegistrationFailedException
	 * @throws IOException 
	 */
	@RequestMapping(value = "/registrationConfirm", method = RequestMethod.GET)
	public void activateUser(@RequestParam("email")  String email, @RequestParam("activationKey") String activationKey, HttpServletRequest req, HttpServletResponse res) throws  ProcessFailedException, LoginIDFormatException, LoginIDRegisteredException, ObjectNotSupportedException, EmailException, RegistrationFailedException, IOException  {
		log.info("Remote Address"+req.getRemoteAddr()); //10.1.0.18
		log.info("Remote Host"+req.getRemoteHost());  //10.1.0.18
		if(!(userMaintenance.checkActivationEnabled(email)) ){
				userMaintenance.activateUser(email);
				res.sendRedirect(env.getProperty("CLIENT_REG_CONFIRM_SUCCESS_URL"));
			}else{
				res.sendRedirect(env.getProperty("CLIENT_REG_CONFIRM_FAIL_URL"));
		}
	 }

	

}
