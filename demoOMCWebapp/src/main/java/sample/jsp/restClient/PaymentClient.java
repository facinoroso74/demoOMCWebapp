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
import sample.jsp.vo.Order;
import sample.jsp.vo.Payment;

@Component("paymentClient")
public class PaymentClient {

    @Autowired
	private RestServiceConfiguration restServiceConfiguration;
    
    private static final Logger log = LogManager.getLogger(PaymentClient.class);
	
	public PaymentClient() {
	}
	
	private RestTemplate restTemplate= new RestTemplate();
	
	
	public Payment makePayment(Payment payment) {
		
		String currentCorrId = UUID.randomUUID().toString();
		MDC.put("correlationId", currentCorrId);
				
		log.info("calling... the Payment Rest Service for payment creation." + payment +"..."+restServiceConfiguration.getPaymentEndPoint());
		
		final HttpEntity<Payment> request = new HttpEntity<>(payment);
		
//		ResponseEntity<Payment> paymentCreated
//		  = restTemplate.exchange(
//				  restServiceConfiguration.getPaymentEndPoint(), 
//				  HttpMethod.POST,
//				  request,
//				  Payment.class);
		
		final Payment paymentCreated = restTemplate.postForObject(restServiceConfiguration.getPaymentEndPoint(), request, Payment.class);
        		
		log.info("calling... the Payment Rest Service for order creation...DONE");
		
		return paymentCreated;
		
	} 
	
}
