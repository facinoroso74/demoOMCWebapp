package sample.jsp.controller;

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
import sample.jsp.vo.Cart;
import sample.jsp.vo.ShoesItem;

@Controller
public class CheckoutController {

	@Autowired
	private HttpServletRequest context;

	@Autowired
	private CatalogClient catalogClient;
	
	private static final Logger log = LogManager.getLogger(CheckoutController.class);
	
	@RequestMapping(value = "/checkout.html", method = RequestMethod.POST)
	public ModelAndView checkout(Map<String, Object> model) {
//	public ModelAndView checkout(@ModelAttribute("cart") Cart cart) {
				
		Map<String,String[]> map = context.getParameterMap();
//		
		Cart cart = buildCartFromRequest(map);
				
		List<ShoesItem> shoesItemList = cart.getShoesItems();
		log.info(cart.getSubtotal());
		log.info(cart.getUserName());
		log.info(cart.getPassword());
		int subtotal=0;
		
		for (Iterator<ShoesItem> iterator = shoesItemList.iterator(); iterator.hasNext();) {
			ShoesItem shoesItem = (ShoesItem) iterator.next();
			shoesItem.setImagePath("images/"+catalogClient.getShoes(shoesItem.getShoe_item()).getImageId());
			subtotal = subtotal + 
					Integer.parseInt(shoesItem.getAmount())*
					Integer.parseInt(shoesItem.getQuantity());
		}
		
		cart.setSubtotal("$"+String.valueOf(subtotal)+".00");
				
		log.info(cart);
		
		return new ModelAndView("checkout2" , "cart", cart);
		
	}

	private Cart buildCartFromRequest(Map<String,String[]> map) {
		Cart cart=new Cart();
		Set<String> keys = map.keySet();
		ShoesItem shoesItem=null;
		
		for (Iterator<String> iterator = keys.iterator(); iterator.hasNext();) {
				
			String parameterName = (String) iterator.next();
			
			log.debug(parameterName + "=" + map.get(parameterName)[0]);

			if(parameterName.indexOf("shoe_item")!=-1){
				String value=map.get(parameterName)[0];
				shoesItem.setShoe_item(value);
			}
						
			if(parameterName.indexOf("quantity")!=-1){
				shoesItem = new ShoesItem();
				String value=map.get(parameterName)[0];
				shoesItem.setQuantity(value);
			}
			
			if(parameterName.indexOf("amount")!=-1){
				String value=map.get(parameterName)[0];
				shoesItem.setAmount(value);
			}
			if(parameterName.indexOf("shipping1")!=-1){
				String value=map.get(parameterName)[0];
				shoesItem.setShipping1(value);
			}
			if(parameterName.indexOf("shipping2")!=-1){
				String value=map.get(parameterName)[0];
				shoesItem.setShipping2(value);
				cart.addShoesItem(shoesItem);
			}
			
		}
		return cart;
	}
	
}
