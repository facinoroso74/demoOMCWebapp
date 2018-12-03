package sample.jsp.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4433338736876242239L;
	
	private String subtotal;
	private String userName;
	private String password;
	
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

	public String getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(String subtotal) {
		this.subtotal = subtotal;
	}
	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Cart [shoesItems=" + shoesItems + "]";
	}

}
