package sample.jsp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sample.jsp.restClient.OrderClient;
import sample.jsp.restClient.ShipmentClient;
import sample.jsp.vo.Shipment;

@Controller
public class PaymentController {
	
	private static final Logger log = LogManager.getLogger(PaymentController.class);

	
	@Autowired
	private ShipmentClient shipmentClient;
	
	@Autowired
	private OrderClient orderClient;
	
	@RequestMapping(value = "/payment.html", method = RequestMethod.POST)
	//public ModelAndView goToPayment(Map<String, Object> model) {	
	
	public ModelAndView goToPayment(@ModelAttribute("shipment") Shipment shipment) {
					
		//crea lo shipment
		//aggiorna l'order e cambia lo stato 
		//redirect to payment
		
		log.info(shipment);
		Shipment shipmentNew = shipmentClient.createShipment(shipment);
		
		log.info("----------------updating the Order------------------------------");
		
		orderClient.updateOrder(Long.valueOf(shipment.getCustomerOrderId()),shipmentNew.getId());
		
		log.info("----------------updating the Order DONE--------------------------");
		
		String orderId=shipment.getCustomerOrderId();
		
		log.info("OrderId:["+orderId+"]");
		
		//aggiorna l'ordine con l'indirizzo e rimanda l'ID dell'ordine per il pagamento
		
		return new ModelAndView("payment2" , "orderId", orderId);
		
	}
	
}
