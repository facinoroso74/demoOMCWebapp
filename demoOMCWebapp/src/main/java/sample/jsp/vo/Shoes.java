package sample.jsp.vo;

import java.io.Serializable;



public class Shoes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2504086911979525506L;
	Long serialNumber;
	String productName;
	String imageId;
	String price;
	
	public Long getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(Long serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getImageId() {
		return imageId;
	}
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Shoes [serialNumber=" + serialNumber + ", productName=" + productName + ", imageId=" + imageId
				+ ", price=" + price + "]";
	}
	
	
}
