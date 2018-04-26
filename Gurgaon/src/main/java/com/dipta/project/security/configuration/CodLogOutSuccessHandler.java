package com.dipta.project.security.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.dipta.project.utility.CommonUtils;
import com.dipta.project.utility.constants.HttpStatusCodes;

@Component("codLogOutSuccessHandler")
public class CodLogOutSuccessHandler implements LogoutSuccessHandler{

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

		CommonUtils.prepareErrorResponse(request, response, HttpStatusCodes.LOGOUTSUCCESS.getCode(), "Logged out successfully.", false);
	}

}
