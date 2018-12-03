package sample.jsp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import sample.jsp.restClient.CatalogClient;
import sample.jsp.vo.Catalog;
import sample.jsp.vo.Shoes;

@Controller
public class ShopController {

	@Autowired
	private CatalogClient catalogClient;
	
	private static final Logger log = LogManager.getLogger(ShopController.class);

	@GetMapping(value = "/shop.html")
	public ModelAndView checkout() {
		
		Shoes[] shoesArray = catalogClient.getAllShoes();
		
		for (int i = 0; i < shoesArray.length; i++) {
			shoesArray[i].setImageId("images/"+shoesArray[i].getImageId());
			shoesArray[i].setPrice(shoesArray[i].getPrice().substring(1, shoesArray[i].getPrice().length()));
		}
		
		for (int i = 0; i < shoesArray.length; i++) {
			log.debug(shoesArray[i]);
		}
				
		Catalog catalog = new Catalog();
		catalog.setShoesArray(shoesArray);
				
		return new ModelAndView("shop2" , "catalog", catalog);
		
	}
	
}
