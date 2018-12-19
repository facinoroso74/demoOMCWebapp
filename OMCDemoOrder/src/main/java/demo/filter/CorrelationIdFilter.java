package demo.filter;

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

import demo.constants.OMCConstants;


public class CorrelationIdFilter implements Filter {

	private static final Logger log = LogManager.getLogger(CorrelationIdFilter.class);


    public void init(FilterConfig filterConfig) throws ServletException {
    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        final HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String currentCorrId = httpServletRequest.getHeader(OMCConstants.CORRELATION_ID);
        
        log.info("currentCorrId="+currentCorrId);
        if(currentCorrId==null)
        	currentCorrId = MDC.get("correlationId");
        
//        if (currentCorrId == null) {
//            currentCorrId = UUID.randomUUID().toString();
//            log.info("No correlationId found in Header. Generated : " + currentCorrId);
//        } else {
//        	log.info("Found correlationId in Header : " + currentCorrId);
//        }

        //RequestCorrelation.setId(currentCorrId);
        MDC.put("correlationId", currentCorrId);

        filterChain.doFilter(httpServletRequest, servletResponse);
    }


    @Override
    public void destroy() {
    }

    
}
