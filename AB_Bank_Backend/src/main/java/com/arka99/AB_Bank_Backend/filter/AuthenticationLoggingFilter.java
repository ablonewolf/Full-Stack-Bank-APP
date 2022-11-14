package com.arka99.AB_Bank_Backend.filter;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Logger;

public class AuthenticationLoggingFilter implements Filter {

    private final Logger logger = Logger.getLogger(AuthenticationLoggingFilter.class.getName());
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication!=null) {
            logger.info("User " + authentication.getName() + " has been successfully authenticated with this authorities " + authentication.getAuthorities().toString());
        }
//        invoking the next filter using dofilter method of the filterchain
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
