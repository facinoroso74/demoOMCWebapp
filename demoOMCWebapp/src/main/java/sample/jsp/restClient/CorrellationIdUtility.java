package sample.jsp.restClient;

import org.slf4j.MDC;
import org.springframework.http.HttpHeaders;

import sample.jsp.constants.OMCConstants;

public class CorrellationIdUtility {

	public static HttpHeaders getHttpHeadersWithCorrId() {
		
		HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(OMCConstants.CORRELATION_ID,MDC.get("correlationId"));
        return httpHeaders;
	}
}
