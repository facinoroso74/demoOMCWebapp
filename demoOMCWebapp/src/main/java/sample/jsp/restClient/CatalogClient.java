package sample.jsp.restClient;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import sample.jsp.config.RestServiceConfiguration;
import sample.jsp.vo.Shoes;

@Component("catalogClient")
public class CatalogClient {

    @Autowired
	private RestServiceConfiguration restServiceConfiguration;
    private static final Logger log = LogManager.getLogger(CatalogClient.class);
	private RestTemplate restTemplate = new RestTemplate();
    
	public CatalogClient() {
	}
	
	public Shoes[] getAllShoes() {
		
		String currentCorrId = UUID.randomUUID().toString();
		MDC.put("correlationId", currentCorrId);
		
		log.info("calling... the Catalog Rest Service AllShoes...");
		
		//String fooResourceUrl = "http://localhost:8181/shoes/";
		        
		ResponseEntity<Shoes[]> response
		  = restTemplate.exchange(
				  restServiceConfiguration.getCatalogEndPoint(), 
				  HttpMethod.GET,
				  new HttpEntity<String>(CorrellationIdUtility.getHttpHeadersWithCorrId()),
				  Shoes[].class);
		
		log.info("calling... the Catalog Rest Service AllShoes...DONE");
		return response.getBody();
	}
	
	public Shoes getShoes(String productName) {
		
		String currentCorrId = UUID.randomUUID().toString();
		MDC.put("correlationId", currentCorrId);
		log.info("calling... the Catalog Rest Service getShoeBuProductName...");

		ResponseEntity<Shoes> response
		  = restTemplate.exchange(
				  restServiceConfiguration.getCatalogEndPoint()+ "/"+ productName,
				  HttpMethod.GET,
				  new HttpEntity<String>(CorrellationIdUtility.getHttpHeadersWithCorrId()),
				  Shoes.class);
		
		log.info("calling... the Catalog Rest Service getShoeBuProductName...DONE");
		return response.getBody();
	}
	
}
