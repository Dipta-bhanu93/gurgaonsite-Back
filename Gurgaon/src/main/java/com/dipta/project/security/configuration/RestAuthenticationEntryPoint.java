package com.dipta.project.security.configuration;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component( "restAuthenticationEntryPoint" )
public class RestAuthenticationEntryPoint  implements AuthenticationEntryPoint {
	
	
	
	 @Override
	   public void commence( HttpServletRequest request, HttpServletResponse response, 
	    AuthenticationException authException ) throws IOException{
	    response.sendError( HttpServletResponse.SC_FORBIDDEN, "Unauthorized" );
	      
	      
	  	/*response.setContentType("application/json");
		String respJson = "{\"login\":\"FAILURE\"}";
		response.getWriter().print(respJson.toString());
	    response.getWriter().flush();*/
	   }
}
