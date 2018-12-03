package sample.jsp.vo;

import java.io.Serializable;
import java.sql.Timestamp;


public class Payment implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -6621527030119112708L;
	Long serialNumber;
	String nameOnCard;
	String cardType;
	String cardNumber;
	String securityCode;
	String expirationDate;
	Timestamp paymentDate;
	Long customerOrderId;

	public Long getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Long serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Timestamp getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Timestamp paymentDate) {
		this.paymentDate = paymentDate;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

	public Long getCustomerOrderId() {
		return customerOrderId;
	}

	public void setCustomerOrderId(Long customerOrderId) {
		this.customerOrderId = customerOrderId;
	}

	@Override
	public String toString() {
		return "Payment [serialNumber=" + serialNumber + ", nameOnCard=" + nameOnCard + ", cardType=" + cardType
				+ ", cardNumber=" + cardNumber + ", securityCode=" + securityCode + ", expirationDate=" + expirationDate
				+ ", paymentDate=" + paymentDate + ", customerOrderId=" + customerOrderId + "]";
	}

	
	
}
