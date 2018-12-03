package demo.vo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "CUSTOMER_ORDER")
public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 231940927929914541L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long customerOrder;
	
	@Column
	String customerId;
	
	@Column
	Long shipmentId;
	
	@Column
	String shoesSerialNumbers;
	
	@Column
	String shoesAmounts;
	
	@Column
	String status;
	
	@Column
	String total;
	
	@Column
	String transactionID;
	
	@Column
	Timestamp dateOrder;
	
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

	public Long getShipmentId() {
		return shipmentId;
	}

	public void setShipmentId(Long shipmentId) {
		this.shipmentId = shipmentId;
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

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public Timestamp getDateOrder() {
		return dateOrder;
	}

	public void setDateOrder(Timestamp dateOrder) {
		this.dateOrder = dateOrder;
	}

	public String getShoesAmounts() {
		return shoesAmounts;
	}

	public void setShoesAmounts(String shoesAmounts) {
		this.shoesAmounts = shoesAmounts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
		result = prime * result + ((customerOrder == null) ? 0 : customerOrder.hashCode());
		result = prime * result + ((dateOrder == null) ? 0 : dateOrder.hashCode());
		result = prime * result + ((shipmentId == null) ? 0 : shipmentId.hashCode());
		result = prime * result + ((shoesAmounts == null) ? 0 : shoesAmounts.hashCode());
		result = prime * result + ((shoesSerialNumbers == null) ? 0 : shoesSerialNumbers.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		result = prime * result + ((transactionID == null) ? 0 : transactionID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (customerId == null) {
			if (other.customerId != null)
				return false;
		} else if (!customerId.equals(other.customerId))
			return false;
		if (customerOrder == null) {
			if (other.customerOrder != null)
				return false;
		} else if (!customerOrder.equals(other.customerOrder))
			return false;
		if (dateOrder == null) {
			if (other.dateOrder != null)
				return false;
		} else if (!dateOrder.equals(other.dateOrder))
			return false;
		if (shipmentId == null) {
			if (other.shipmentId != null)
				return false;
		} else if (!shipmentId.equals(other.shipmentId))
			return false;
		if (shoesAmounts == null) {
			if (other.shoesAmounts != null)
				return false;
		} else if (!shoesAmounts.equals(other.shoesAmounts))
			return false;
		if (shoesSerialNumbers == null) {
			if (other.shoesSerialNumbers != null)
				return false;
		} else if (!shoesSerialNumbers.equals(other.shoesSerialNumbers))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		if (transactionID == null) {
			if (other.transactionID != null)
				return false;
		} else if (!transactionID.equals(other.transactionID))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Order [customerOrder=" + customerOrder + ", customerId=" + customerId + ", shipmentId=" + shipmentId
				+ ", shoesSerialNumbers=" + shoesSerialNumbers + ", shoesAmounts=" + shoesAmounts + ", status=" + status
				+ ", total=" + total + ", transactionID=" + transactionID + ", dateOrder=" + dateOrder + "]";
	}


}

