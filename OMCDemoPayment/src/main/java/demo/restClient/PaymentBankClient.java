package demo.restClient;

import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jboss.logging.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import demo.config.RestServiceConfiguration;
import demo.vo.Payment;

@Component("paymentBankClient")
public class PaymentBankClient {

    @Autowired
	private RestServiceConfiguration restServiceConfiguration;
    
    private static final Logger log = LogManager.getLogger(PaymentBankClient.class);
	
	public PaymentBankClient() {
	}
	
	public Payment makeBankPayment(Payment payment) {

		String currentCorrId = UUID.randomUUID().toString();
		MDC.put("correlationId", currentCorrId);
		
		
		log.info("calling... the Payment Rest Service for order creation." + payment +"..."+restServiceConfiguration.getPaymentEndPoint());
		RestTemplate restTemplate= new RestTemplate();
		final HttpEntity<Payment> request = new HttpEntity<>(payment);
		
//		ResponseEntity<Payment> response
//		  = restTemplate.exchange(
//				  restServiceConfiguration.getPaymentEndPoint(), 
//				  HttpMethod.POST,
//				  new HttpEntity<String>(CorrellationIdUtility.getHttpHeadersWithCorrId()),
//				  Payment.class);
		
        final Payment paymentCreated = restTemplate.postForObject(restServiceConfiguration.getPaymentEndPoint(), request, Payment.class);
        		
		log.info("calling... the Payment Rest Service for order creation...DONE");
		
		return paymentCreated;
	} 
	
}
