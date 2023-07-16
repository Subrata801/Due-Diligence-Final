/**
 * 
 *//*
package com.bankMitra.configuration;

*//**
 * @author BankMitra
 *
 *//*
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CorsFilter implements Filter {
 
    private final Logger log = LoggerFactory.getLogger(CorsFilter.class);
 
    public CorsFilter() {
        log.info("SimpleCORSFilter init");
    }
 
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
 
        //HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
 
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin,Content-Type, Accept, X-Requested-With");
        response.setHeader("Access-Control-Request-Headers", "Origin,Content-Type, Accept, X-Requested-With");
 
        chain.doFilter(req, res);
    }
 
    public void init(FilterConfig filterConfig) {
    }
 
    public void destroy() {
    }
}
*/