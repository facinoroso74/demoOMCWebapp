package sample.jsp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@Component("restServiceConfiguration")
public class RestServiceConfiguration {

	@Value("${catalog.protocolBackend}")
	private String catalogProtocolBackend="http";
	
	@Value("${catalog.addressBackend}")
	private String catalogAddressBackend="localhost";
	
	@Value("${catalog.portBackend}")
	private String catalogPortBackend="8181";
	
	
	//ORDER
	@Value("${order.protocolBackend}")
	private String orderProtocolBackend="http";
		
	@Value("${order.addressBackend}")
	private String orderAddressBackend="localhost";
	
	@Value("${order.portBackend}")
	private String orderPortBackend="8282";
	
	//SHIPMENT
	@Value("${shipment.protocolBackend}")
	private String shipmentProtocolBackend="http";
	
	@Value("${shipment.addressBackend}")
	private String shipmentAddressBackend="localhost";
	
	@Value("${shipment.portBackend}")
	private String shipmentPortBackend="8282";
		
	//PAYMENT
	@Value("${payment.protocolBackend}")
	private String paymentProtocolBackend="http";
	
	@Value("${payment.addressBackend}")
	private String paymentAddressBackend="localhost";
	
	@Value("${payment.portBackend}")
	private String paymentPortBackend="8383";
	
	
	
	
	private String catalogEndPoint;
	private String orderEndPoint;
	private String paymentEndPoint;
	private String shipmentEndPoint;
	
	public RestServiceConfiguration() {

		StringBuffer buffCatalog=new StringBuffer();
		buffCatalog.append(catalogProtocolBackend).append("://").append(catalogAddressBackend).append(":").append(catalogPortBackend).append("/shoes/");
		catalogEndPoint =  buffCatalog.toString();
		
		StringBuffer buffOrder=new StringBuffer();
		buffOrder.append(orderProtocolBackend).append("://").append(orderAddressBackend).append(":").append(orderPortBackend).append("/order/");
		orderEndPoint =  buffOrder.toString();
		
		StringBuffer buffPayment=new StringBuffer();
		buffPayment.append(paymentProtocolBackend).append("://").append(paymentAddressBackend).append(":").append(paymentPortBackend).append("/payment/");
		paymentEndPoint =  buffPayment.toString();
		
		StringBuffer buffShipment=new StringBuffer();
		buffShipment.append(shipmentProtocolBackend).append("://").append(shipmentAddressBackend).append(":").append(shipmentPortBackend).append("/shipment/");
		shipmentEndPoint =  buffShipment.toString();
		
	}
	
	public String getCatalogEndPoint() {
		return catalogEndPoint;
	}

	public String getOrderEndPoint() {
		return orderEndPoint;
	}

	public String getPaymentEndPoint() {
		return paymentEndPoint;
	}

	public String getShipmentEndPoint() {
		return shipmentEndPoint;
	}
		
}
