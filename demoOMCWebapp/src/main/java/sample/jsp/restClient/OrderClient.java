package sample.jsp.restClient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
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
	
	
	public Order createOrder(Order order) {
					
		log.info("calling... the Order Rest Service for order creation." + order +"..."+restServiceConfiguration.getOrderEndPoint());
		RestTemplate restTemplate= new RestTemplate();
		final HttpEntity<Order> request = new HttpEntity<>(order);
		
        final Order orderCreated = restTemplate.postForObject(restServiceConfiguration.getOrderEndPoint(), request, Order.class);
        		
		log.info("calling... the Order Rest Service for order creation...DONE");
		
		return orderCreated;
		
	} 
	
	public Order getOrder(Long customerOrder) {
		log.info("calling... the Order Rest Service getOrder by CustomerOrder:"+customerOrder+"...");
		RestTemplate restTemplate = new RestTemplate();
		//String fooResourceUrl = "http://localhost:8181/shoes/";
		ResponseEntity<Order> response
		  = restTemplate.getForEntity(restServiceConfiguration.getOrderEndPoint() + "/"+ customerOrder, Order.class);
		//assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		log.info("calling... the Catalog Rest Service getOrder...DONE");
		return response.getBody();
	}


	public void updateOrder(Long orderId,Long shipmentId) {

		Order order = getOrder(orderId);
		log.info("order retrieved:["+order+"]");
		order.setShipmentId(shipmentId);
        final HttpEntity<Order> requestUpdate = new HttpEntity<>(order);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(restServiceConfiguration.getOrderEndPoint() + "/"+ orderId, HttpMethod.PUT, requestUpdate, Void.class);

	}
	
	public void updateOrderWithTransactionId(Order order) {

        final HttpEntity<Order> requestUpdate = new HttpEntity<>(order);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.exchange(restServiceConfiguration.getOrderEndPoint() + "/"+ order.getCustomerOrder(), HttpMethod.PUT, requestUpdate, Void.class);

	}
	
	
}
