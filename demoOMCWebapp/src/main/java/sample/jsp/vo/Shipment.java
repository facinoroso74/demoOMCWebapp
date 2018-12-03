package sample.jsp.vo;

import java.io.Serializable;

public class Shipment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 288977886838454511L;
	private Long id;
	private String fullName;
	private String mobileNumber;
	private String address;
	private String city;
	private String userId;
	private String customerOrderId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCustomerOrderId() {
		return customerOrderId;
	}
	public void setCustomerOrderId(String customerOrderId) {
		this.customerOrderId = customerOrderId;
	}
	
	@Override
	public String toString() {
		return "Shipment [id=" + id + ", fullName=" + fullName + ", mobileNumber=" + mobileNumber + ", address="
				+ address + ", city=" + city + ", userId=" + userId + ", customerOrderId=" + customerOrderId + "]";
	}
	
	
}
