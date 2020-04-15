package com.socita.Employee;

import java.io.IOException;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.socita.Employee.entities.Token;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

public class SecurityFilter extends GenericFilterBean {

    TokenService tokenService;

    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
            throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;
        final String authHeader = request.getHeader("authorization");

        if (tokenService == null) {
            ServletContext servletContext = request.getServletContext();
            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
            tokenService = webApplicationContext.getBean(TokenService.class);
        }

        if (authHeader == null) {

            logger.info("No authorization header provided" );
            throw new ServletException("Missing or invalid Authorization header");
        }

        String requestURI = request.getRequestURI();
        logger.info("Request URI:"+ requestURI );

        if (requestURI.endsWith("employees")) {

            logger.info("Checking if ANY request token provided" );
            Token anyToken = tokenService.getTokenById("any");

            if (!authHeader.equalsIgnoreCase(anyToken.getToken())) {

                logger.info("Unauthorized ANY request token provided");
                throw new ServletException("Unauthorized request");
            }
        } else {

            try {
                logger.info("Checking authorization token provided against employee number");

                String[] spiltQueryString = requestURI.split("/");
                String employeeNumberFromQueryString = spiltQueryString[2];

                Token anyToken = tokenService.getTokenById(employeeNumberFromQueryString);

                if (!authHeader.equalsIgnoreCase(anyToken.getToken())) {
                    logger.info("Unauthorized ANY request token provided");
                    throw new ServletException("Unauthorized Token");
                }

            } catch (Exception e) {

                logger.info("Exception occurred while checking authorization:", e);
                throw new ServletException("Invalid Authorization Token");
            }
        }
        logger.info("Security check completed, processing request");
        chain.doFilter(req, res);

    }
}
