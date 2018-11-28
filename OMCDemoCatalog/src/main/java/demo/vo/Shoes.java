package demo.vo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "SHOES")
public class Shoes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5886381252212107730L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long serialNumber;
	
	@Column
	String productName;
	@Column
	String imageId;
	@Column
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
