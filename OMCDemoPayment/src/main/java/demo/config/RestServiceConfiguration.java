package demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component("restServiceConfiguration")
public class RestServiceConfiguration {

	//PAYMENT
	@Value("${payment.protocolBackend}")
	private String paymentProtocolBackend="http";
	
	@Value("${payment.addressBackend}")
	private String paymentAddressBackend="localhost";
	
	@Value("${payment.portBackend}")
	private String paymentPortBackend="8484";
	
	private String paymentEndPoint;
	
	private boolean initialized=false;
	
	private void init() {
		
		if(!initialized) {
			StringBuffer buffPayment=new StringBuffer();
			buffPayment.append(paymentProtocolBackend).append("://").append(paymentAddressBackend).append(":").append(paymentPortBackend).append("/payment/");
			paymentEndPoint =  buffPayment.toString();
		}
	}
	
	public RestServiceConfiguration() {
	}
	
	public String getPaymentEndPoint() {
		init();
		return paymentEndPoint;
	}
		
}
