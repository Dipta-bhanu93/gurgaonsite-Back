package com.dipta.project.configuration;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

/**
 * Csrf Filter to enable csrf protection.
 * This custom filter is needed to interact with AngularJs client
 * as AngularJs uses XSRF-TOKEN, but Spring Security default token name
 * is CSRF-TOKEN.
 * This filter merely swaps the token names as required by AngularJs.
 *
 * @author Vinay.Kumar1
 *
 */

public class CoDCsrfHeaderFilter extends OncePerRequestFilter {

	@Override
	  protected void doFilterInternal(HttpServletRequest request,
	      HttpServletResponse response, FilterChain filterChain)
	      throws ServletException, IOException {
	    CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class
	        .getName());
	    if (csrf != null) {
	      Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
	      String token = csrf.getToken();
	      if (cookie==null || token!=null && !token.equals(cookie.getValue())) {
	        cookie = new Cookie("XSRF-TOKEN", token);
	        cookie.setPath("/");
	        response.addCookie(cookie);
	      }
	    }
	    filterChain.doFilter(request, response);
	  }
}
