package sample.jsp.restClient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	public CatalogClient() {
	}
	
	public Shoes[] getAllShoes() {
		
		log.info("calling... the Catalog Rest Service AllShoes...");
		RestTemplate restTemplate = new RestTemplate();
		//String fooResourceUrl = "http://localhost:8181/shoes/";
		
		ResponseEntity<Shoes[]> response
		  = restTemplate.getForEntity(restServiceConfiguration.getCatalogEndPoint(), Shoes[].class);
		//assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		log.info("calling... the Catalog Rest Service AllShoes...DONE");
		return response.getBody();
	}
	
	public Shoes getShoes(String productName) {
		log.info("calling... the Catalog Rest Service getShoeBuProductName...");
		RestTemplate restTemplate = new RestTemplate();
		//String fooResourceUrl = "http://localhost:8181/shoes/";
		ResponseEntity<Shoes> response
		  = restTemplate.getForEntity(restServiceConfiguration.getCatalogEndPoint() + "/"+ productName, Shoes.class);
		//assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		log.info("calling... the Catalog Rest Service getShoeBuProductName...DONE");
		return response.getBody();
	}
	
}
