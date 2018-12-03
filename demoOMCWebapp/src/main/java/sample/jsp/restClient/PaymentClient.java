package sample.jsp.restClient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import sample.jsp.config.RestServiceConfiguration;
import sample.jsp.vo.Payment;

@Component("paymentClient")
public class PaymentClient {

    @Autowired
	private RestServiceConfiguration restServiceConfiguration;
    
    private static final Logger log = LogManager.getLogger(PaymentClient.class);
	
	public PaymentClient() {
	}
	
	public Payment makePayment(Payment payment) {
		
		log.info("calling... the Payment Rest Service for order creation." + payment +"..."+restServiceConfiguration.getPaymentEndPoint());
		RestTemplate restTemplate= new RestTemplate();
		final HttpEntity<Payment> request = new HttpEntity<>(payment);
		
        final Payment paymentCreated = restTemplate.postForObject(restServiceConfiguration.getPaymentEndPoint(), request, Payment.class);
        		
		log.info("calling... the Payment Rest Service for order creation...DONE");
		
		return paymentCreated;
	} 
	
}
