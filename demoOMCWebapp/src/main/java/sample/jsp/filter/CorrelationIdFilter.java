package sample.jsp.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.MDC;

public class CorrelationIdFilter implements Filter {

	private static final Logger log = LogManager.getLogger(CorrelationIdFilter.class);


    public void init(FilterConfig filterConfig) throws ServletException {
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        final HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        if(MDC.get("sessionId")==null) {
	        String sessionId = httpServletRequest.getSession().getId();
	        MDC.put("sessionId", sessionId);
        }
        filterChain.doFilter(httpServletRequest, servletResponse);
    }


    @Override
    public void destroy() {
    }

    
}
