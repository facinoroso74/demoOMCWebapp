package sample.jsp.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sample.jsp.restClient.OrderClient;
import sample.jsp.vo.Cart;
import sample.jsp.vo.Order;
import sample.jsp.vo.ShoesItem;

@Controller
public class ShipmentController {
//
//	@Autowired
//	private HttpServletRequest context;

	@Autowired
	private OrderClient orderClient;
	
	private static final Logger log = LogManager.getLogger(ShipmentController.class);

	@RequestMapping(value = "/shipment.html", method = RequestMethod.POST)
	//public ModelAndView goToPayment(Map<String, Object> model) {	
	public ModelAndView goToPayment(@ModelAttribute("cart") Cart cart) {
		
		//salvare il cart sul DB tramite una chiamata ad un rest service e inviare l'id dell'ordine 
		//Order Rest Service
		//alla pagina successiva
		log.info(cart);
		
		Order order = new Order();
		List<ShoesItem> shoesItemList= cart.getShoesItems();
		
		order.setCustomerId("SonoIo");
		//order.setShipmentId(shipmentId);
		order.setTotal(cart.getSubtotal());
		
		StringBuffer shoesProductName = new StringBuffer();
		StringBuffer shoesAmounts= new StringBuffer();
		
		for (Iterator<ShoesItem> iterator = shoesItemList.iterator(); iterator.hasNext();) {
			ShoesItem shoesItem = (ShoesItem) iterator.next();
			shoesProductName.append(shoesItem.getShoe_item()).append(";");
			shoesAmounts.append(shoesItem.getAmount()).append(";");
		}
		
		order.setShoesSerialNumbers(shoesProductName.toString());
		order.setShoesAmounts(shoesAmounts.toString());
		order.setStatus("PENDING");
		
		Order orderCreated = orderClient.createOrder(order);
		
		Map<String, String> model = new HashMap<String, String>();
		model.put("orderId", String.valueOf(orderCreated.getCustomerOrder()));
		model.put("customerId", String.valueOf(orderCreated.getCustomerId()));
		
		return new ModelAndView("shipment" , model);
		
	}
	
}
