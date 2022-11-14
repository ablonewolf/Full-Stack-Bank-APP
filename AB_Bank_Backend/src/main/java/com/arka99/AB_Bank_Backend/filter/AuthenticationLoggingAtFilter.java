package com.arka99.AB_Bank_Backend.filter;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Logger;

public class AuthenticationLoggingAtFilter implements Filter {

    private final Logger logger = Logger.getLogger(AuthenticationLoggingAtFilter.class.toString());
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("Authentication process in progress");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
