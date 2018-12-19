package sample.jsp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component("restServiceConfiguration")
public class RestServiceConfiguration {
	
//	@Value("${catalog.prova}")
//	private String prova;
//	
	@Value("${catalog.protocolBackend}")
	private String catalogProtocolBackend;
	
	@Value("${catalog.addressBackend}")
	private String catalogAddressBackend;
	
	@Value("${catalog.portBackend}")
	private String catalogPortBackend;
	
	
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
	private boolean initialized=false;
	
	private void initConfiguration() {
		if(!initialized) {
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
	}
	
	public RestServiceConfiguration() {
	}
	
	public String getCatalogEndPoint() {
		initConfiguration();
//		System.out.println("--------------prova-----------:["+catalogProtocolBackend+"]");
		return catalogEndPoint;
		
	}

	public String getOrderEndPoint() {
		initConfiguration();
		return orderEndPoint;
	}

	public String getPaymentEndPoint() {
		initConfiguration();
		return paymentEndPoint;
	}

	public String getShipmentEndPoint() {
		initConfiguration();
		return shipmentEndPoint;
	}
		
}
