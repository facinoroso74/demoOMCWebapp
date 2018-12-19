package sample.jsp.restClient;

import java.util.UUID;

import javax.swing.plaf.BorderUIResource.EmptyBorderUIResource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import sample.jsp.config.RestServiceConfiguration;
import sample.jsp.vo.Order;

@Component("orderClient")
public class OrderClient {

    @Autowired
	private RestServiceConfiguration restServiceConfiguration;
    
    private static final Logger log = LogManager.getLogger(OrderClient.class);
	
	public OrderClient() {
	}
	
	private RestTemplate restTemplate= new RestTemplate();
	
	public Order createOrder(Order order) {
		String currentCorrId = UUID.randomUUID().toString();
		MDC.put("correlationId", currentCorrId);
				
		log.info("calling... the Order Rest Service for order creation." + order +"..."+restServiceConfiguration.getOrderEndPoint());
		
//		final HttpEntity<Order> request = new HttpEntity<>(order);
//		
		
		HttpHeaders headers = CorrellationIdUtility.getHttpHeadersWithCorrId();
        HttpEntity<Order> entity = new HttpEntity<Order>(order, headers);

        
		ResponseEntity<Order> orderCreated
		  = restTemplate.exchange(
				  restServiceConfiguration.getOrderEndPoint(), 
				  HttpMethod.POST,
				  entity,
				  Order.class);
	
//		HttpHeaders headers = CorrellationIdUtility.getHttpHeadersWithCorrId();
//        HttpEntity<Order> entity = new HttpEntity<Order>(order, headers);
//        restTemplate.postForLocation(restServiceConfiguration.getOrderEndPoint(), entity);
//        
	 		
		log.info("calling... the Order Rest Service for order creation...DONE");
		
		return orderCreated.getBody();
		
	} 
	
	public Order getOrder(Long customerOrder) {
		
		String currentCorrId = UUID.randomUUID().toString();
		MDC.put("correlationId", currentCorrId);
		
		log.info("calling... the Order Rest Service getOrder by CustomerOrder:"+customerOrder+"...");
		
		ResponseEntity<Order> orderRetrieved
		  = restTemplate.exchange(
				  restServiceConfiguration.getOrderEndPoint() + "/" + customerOrder, 
				  HttpMethod.GET,
				  new HttpEntity<String>(CorrellationIdUtility.getHttpHeadersWithCorrId()),
				  Order.class);
				
//		ResponseEntity<Order> response
//		  = restTemplate.getForEntity(restServiceConfiguration.getOrderEndPoint() + "/"+ customerOrder, Order.class);
		
	
		log.info("calling... the Catalog Rest Service getOrder...DONE");
		return orderRetrieved.getBody();
	}


	public void updateOrder(Long orderId,Long shipmentId) {

		Order order = getOrder(orderId);
		log.info("order retrieved:["+order+"]");
		order.setShipmentId(shipmentId);
		
		String currentCorrId = UUID.randomUUID().toString();
		MDC.put("correlationId", currentCorrId);
		
        //final HttpEntity<Order> requestUpdate = new HttpEntity<>(order);
        HttpHeaders headers = CorrellationIdUtility.getHttpHeadersWithCorrId();
        HttpEntity<Order> entity = new HttpEntity<Order>(order, headers);
        
        restTemplate.exchange(
        			restServiceConfiguration.getOrderEndPoint() + "/"+ orderId, 
        			HttpMethod.PUT, 
        			entity, 
        			Void.class);
      
        log.info("order updated:["+order+"]");
        
	}
	
	public void updateOrderWithTransactionId(Order order) {

//		 final HttpEntity<Order> requestUpdate = new HttpEntity<>(order);
        
//		  restTemplate.exchange(restServiceConfiguration.getOrderEndPoint() + "/"+ order.getCustomerOrder(), HttpMethod.PUT, requestUpdate, Void.class);

//        HttpHeaders headers = CorrellationIdUtility.getHttpHeadersWithCorrId();
//        HttpEntity<Order> entity = new HttpEntity<Order>(order, headers);
//        restTemplate.postForLocation("http://example.com", entity);

        log.info("order updated:["+order+"] with the TransactionID...");
        
        String currentCorrId = UUID.randomUUID().toString();
		MDC.put("correlationId", currentCorrId);
		
        HttpHeaders headers = CorrellationIdUtility.getHttpHeadersWithCorrId();
        HttpEntity<Order> entity = new HttpEntity<Order>(order, headers);
        
        restTemplate.exchange(
        			restServiceConfiguration.getOrderEndPoint() + "/"+ order.getCustomerId(), 
        			HttpMethod.PUT, 
        			entity, 
        			Void.class);
        
        log.info("order updated:["+order+"] with the TransactionID...DONE");
	}
	
	
}
