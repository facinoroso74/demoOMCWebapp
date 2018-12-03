package sample.jsp.vo;

import java.io.Serializable;

public class Order implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7716980665211987650L;
	Long customerOrder;
	String customerId;
	Long shipmentId;
	String shoesSerialNumbers;
	String shoesAmounts;
	String total;
	String status;
	String transactionID;
	
	
	public Long getCustomerOrder() {
		return customerOrder;
	}
	public void setCustomerOrder(Long customerOrder) {
		this.customerOrder = customerOrder;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	
	public String getShoesSerialNumbers() {
		return shoesSerialNumbers;
	}
	public void setShoesSerialNumbers(String shoesSerialNumbers) {
		this.shoesSerialNumbers = shoesSerialNumbers;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public Long getShipmentId() {
		return shipmentId;
	}
	public void setShipmentId(Long shipmentId) {
		this.shipmentId = shipmentId;
	}
	public String getTransactionID() {
		return transactionID;
	}
	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}
	
	
	
	public String getShoesAmounts() {
		return shoesAmounts;
	}
	public void setShoesAmounts(String shoesAmounts) {
		this.shoesAmounts = shoesAmounts;
	}
	@Override
	public String toString() {
		return "Order [customerOrder=" + customerOrder + ", customerId=" + customerId + ", shipmentId=" + shipmentId
				+ ", shoesSerialNumbers=" + shoesSerialNumbers + ", shoesAmounts=" + shoesAmounts + ", total=" + total
				+ ", status=" + status + ", transactionID=" + transactionID + "]";
	}
	
	
}

