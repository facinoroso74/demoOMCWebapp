package sample.jsp.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CheckoutController {


	@RequestMapping(value = "/checkout.html", method = RequestMethod.POST)
	public String checkout(Map<String, Object> model) {
//		model.put("time", new Date());
//		model.put("message", this.message);
		System.out.println("lllllllllllllllllllll");
		System.out.println(model.toString());
		System.out.println("mmmmmmmmmmmmmmmmmmmmm");
		
		return "checkout2";
//		throw new RuntimeException("");
	}

}
