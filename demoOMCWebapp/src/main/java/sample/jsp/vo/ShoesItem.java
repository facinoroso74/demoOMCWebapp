package sample.jsp.vo;

import java.io.Serializable;

public class ShoesItem implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6155639728726377269L;
	private String quantity;
	private String shoe_item;
	private String amount;
	private String shipping1;
	private String shipping2;
	
	public ShoesItem() {
		
	}
			
	public ShoesItem(String quantity, String shoe_item, String amount, String shipping1, String shipping2) {
		super();
		this.quantity = quantity;
		this.shoe_item = shoe_item;
		this.amount = amount;
		this.shipping1 = shipping1;
		this.shipping2 = shipping2;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getShoe_item() {
		return shoe_item;
	}

	public void setShoe_item(String shoe_item) {
		this.shoe_item = shoe_item;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getShipping1() {
		return shipping1;
	}

	public void setShipping1(String shipping1) {
		this.shipping1 = shipping1;
	}

	public String getShipping2() {
		return shipping2;
	}

	public void setShipping2(String shipping2) {
		this.shipping2 = shipping2;
	}

	@Override
	public String toString() {
		return "ShoesItem [quantity=" + quantity + ", shoe_item=" + shoe_item + ", amount=" + amount + ", shipping1="
				+ shipping1 + ", shipping2=" + shipping2 + "]\n";
	}


}
