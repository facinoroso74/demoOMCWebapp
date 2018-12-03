package sample.jsp.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sample.jsp.restClient.CatalogClient;
import sample.jsp.restClient.OrderClient;
import sample.jsp.restClient.PaymentClient;
import sample.jsp.vo.Cart;
import sample.jsp.vo.Order;
import sample.jsp.vo.Payment;
import sample.jsp.vo.Shoes;
import sample.jsp.vo.ShoesItem;

@Controller
public class PaymentControllerDone {

	@Autowired
	private PaymentClient paymentClient;
	
	@Autowired
	private OrderClient orderClient;
	
	
	@Autowired
	private CatalogClient catalogClient;
	
	@Autowired
	private HttpServletRequest context;
	
	private static final Logger log = LogManager.getLogger(PaymentControllerDone.class);

	@RequestMapping(value = "/paymentDone.html", method = RequestMethod.POST)
	public ModelAndView goToPayment(Map<String, Object> model) {	
		
		Map<String,String[]> map = context.getParameterMap();
		
		Set<String> keys = map.keySet();
		
		for (Iterator<String> iterator = keys.iterator(); iterator.hasNext();) {
			
			String parameterName = (String) iterator.next();
			
			log.info(parameterName + "=" + map.get(parameterName)[0]);
		}
		
		Payment payment = new Payment();
		payment.setCardNumber(map.get("name")[0]);
		payment.setCardType("MASTERCARD");
		payment.setCustomerOrderId(Long.valueOf(map.get("customerOrderId")[0]));
		payment.setExpirationDate(map.get("expiration-month-and-year")[0]);
		payment.setNameOnCard(map.get("number")[0]);
		payment.setPaymentDate(new Timestamp(System.currentTimeMillis()));
		payment.setSecurityCode(map.get("security-code")[0]);
		
//		name=Michele Pantaleone
//		cardNumber=1111
//		security-code=123
//		expiration-month-and-year=11 / 22
//		customerOrderId=26
			
		log.info("Payment to make:["+payment+"]");
		Payment paymentNew = paymentClient.makePayment(payment);
		
		Order order=orderClient.getOrder(paymentNew.getCustomerOrderId());
		order.setTransactionID(String.valueOf(paymentNew.getSerialNumber()));
		orderClient.updateOrderWithTransactionId(order);
		
//		Shoes[] shoesArray = catalogClient.getAllShoes();
//		
//		for (int i = 0; i < shoesArray.length; i++) {
//			shoesArray[i].setImageId("images/"+shoesArray[i].getImageId());
//			shoesArray[i].setPrice(shoesArray[i].getPrice().substring(1, shoesArray[i].getPrice().length()));
//		}
//		
//		for (int i = 0; i < shoesArray.length; i++) {
//			log.debug(shoesArray[i]);
//		}
		
		//serve avere gli estremi del pagamento e l'id dell'ordine
		
		//effettuare il pagamento tramite chiamata rest
		//Payment Rest Service
		//prelevare l'ordine effettuato dal servizio dopo aver effettuato il pagamento invocando il rest service con l'order ID
//		Order order= new Order();
		
		Cart cart=new Cart();
		cart.setSubtotal(order.getTotal());
		
		String[] shoesProductNameArray = order.getShoesSerialNumbers().split(";");
		String[] shoesAmountsArray = order.getShoesAmounts().split(";");
		List<ShoesItem> shoesItems = new ArrayList<ShoesItem>();
		
		for (int i = 0; i < shoesProductNameArray.length; i++) {
			
			ShoesItem shoesItem = new ShoesItem();
			shoesItem.setAmount(shoesAmountsArray[i]);
			shoesItem.setShoe_item(shoesProductNameArray[i]);
			shoesItems.add(shoesItem);
			
		}
		log.info("shoesItem:["+shoesItems+"]");
		
		cart.setShoesItems(shoesItems);
		
		return new ModelAndView("paymentDone" , "cart", cart);
		
	}
	
}
