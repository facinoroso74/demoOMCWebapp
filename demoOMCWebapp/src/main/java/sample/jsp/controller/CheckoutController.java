package sample.jsp.controller;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.eclipse.jdt.internal.compiler.problem.ShouldNotImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import sample.jsp.vo.Cart;
import sample.jsp.vo.ShoesItem;

@Controller
public class CheckoutController {

	@Autowired
	private HttpServletRequest context;

	@RequestMapping(value = "/checkout.html", method = RequestMethod.POST)
	public ModelAndView checkout(Map<String, Object> model) {
//		model.put("time", new Date());
//		model.put("message", this.message);
		Map<String,String[]> map = context.getParameterMap();
		
		Cart cart = buildCartFromRequest(map);
		
		System.out.println(cart);

		//model.put("Cart", cart);
		cart.setSubtotale1("111111");
		cart.setSubtotale2("222222");
		
		return new ModelAndView("checkout2" , "cart", cart);
		
		//return "checkout2";
		
//		throw new RuntimeException("");
	}

	private Cart buildCartFromRequest(Map<String,String[]> map) {
		Cart cart=new Cart();
		Set<String> keys = map.keySet();
		ShoesItem shoesItem=null;
		
		for (Iterator<String> iterator = keys.iterator(); iterator.hasNext();) {
				
			String parameterName = (String) iterator.next();
			System.out.println(parameterName + "=" + map.get(parameterName)[0]);
			
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
