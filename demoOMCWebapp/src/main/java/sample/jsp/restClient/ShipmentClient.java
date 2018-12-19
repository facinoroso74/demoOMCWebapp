package sample.jsp.restClient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import sample.jsp.config.RestServiceConfiguration;
import sample.jsp.vo.Shipment;

@Component("shipmentClient")
public class ShipmentClient {

    @Autowired
	private RestServiceConfiguration restServiceConfiguration;
    
    private static final Logger log = LogManager.getLogger(ShipmentClient.class);
	
	public ShipmentClient() {
	}
	
	public Shipment createShipment(Shipment shipment) {
		
		log.info("calling... the Shipment Rest Service for order creation." + shipment +"..."+restServiceConfiguration.getShipmentEndPoint());
		RestTemplate restTemplate= new RestTemplate();
		final HttpEntity<Shipment> request = new HttpEntity<>(shipment);
		
        final Shipment shipmentCreated = restTemplate.postForObject(restServiceConfiguration.getShipmentEndPoint(), request, Shipment.class);
        
		
		log.info("calling... the Shipment Rest Service for order creation...DONE");
		
		return shipmentCreated;
		
	} 
	
}
