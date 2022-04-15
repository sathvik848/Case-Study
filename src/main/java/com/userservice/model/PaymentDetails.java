package com.userservice.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class PaymentDetails {

	@Id
	private int orderId;
	private float amount;
	private String paymentStatus;
	private String txId;

	/*
	 * @Transient public static final String SEQUENCE_NAME = "users_sequence";
	 */

	public PaymentDetails(int orderId, float amount, String paymentStatus, String txId) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
		this.txId = txId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getTxId() {
		return txId;
	}

	public void setTxId(String txId) {
		this.txId = txId;
	}

	/*
	 * public static String getSequenceName() { return SEQUENCE_NAME;
	 * 
	 * }
	 */
	@Override
	public String toString() {
		return "PaymentDetails [orderId=" + orderId + ", amount=" + amount + ", paymentStatus=" + paymentStatus
				+ ", txId=" + txId + "]";
	}
	/*
	 * public void setId(long sequenceNumber) { // TODO Auto-generated method stub
	 * 
	 * }
	 * 
	 */

}
