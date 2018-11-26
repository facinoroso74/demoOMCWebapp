package sample.jsp.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4433338736876242239L;
	
	private String subtotale1="11111111111";
	private String subtotale2="22222222222";
	
	private List<ShoesItem> shoesItems=new ArrayList<ShoesItem>();

	public List<ShoesItem> getShoesItems() {
		return shoesItems;
	}

	public void setShoesItems(List<ShoesItem> shoesItems) {
		this.shoesItems = shoesItems;
	}
	
	public void addShoesItem(ShoesItem shoesItem) {
		shoesItems.add(shoesItem);
	}

	@Override
	public String toString() {
		return "Cart [shoesItems=" + shoesItems + "]";
	}

	public String getSubtotale1() {
		return subtotale1;
	}

	public void setSubtotale1(String subtotale1) {
		this.subtotale1 = subtotale1;
	}

	public String getSubtotale2() {
		return subtotale2;
	}

	public void setSubtotale2(String subtotale2) {
		this.subtotale2 = subtotale2;
	}


	
}
