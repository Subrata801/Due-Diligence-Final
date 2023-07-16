/**
 * 
 */
package com.bankMitra.model.admin.response;

import java.util.Date;

/**
 * @author BankMitra
 *
 */
public class ClientSubscriptionHistoryResponse {
	
	private String subscriptionName;
	
	private Integer price;
	
	private Integer gst;
	
	private Integer tax;
	
	private Integer totalAmount;
	
	private Date startDate;
	
	private Date endDate;
	
	private String messageCode;
	
	private String messageDescription;

	/**
	 * @return the subscriptionName
	 */
	public String getSubscriptionName() {
		return subscriptionName;
	}

	/**
	 * @param subscriptionName the subscriptionName to set
	 */
	public void setSubscriptionName(String subscriptionName) {
		this.subscriptionName = subscriptionName;
	}

	/**
	 * @return the price
	 */
	public Integer getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Integer price) {
		this.price = price;
	}

	/**
	 * @return the gst
	 */
	public Integer getGst() {
		return gst;
	}

	/**
	 * @param gst the gst to set
	 */
	public void setGst(Integer gst) {
		this.gst = gst;
	}

	/**
	 * @return the tax
	 */
	public Integer getTax() {
		return tax;
	}

	/**
	 * @param tax the tax to set
	 */
	public void setTax(Integer tax) {
		this.tax = tax;
	}

	/**
	 * @return the totalAmount
	 */
	public Integer getTotalAmount() {
		return totalAmount;
	}

	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the messageCode
	 */
	public String getMessageCode() {
		return messageCode;
	}

	/**
	 * @param messageCode the messageCode to set
	 */
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	/**
	 * @return the messageDescription
	 */
	public String getMessageDescription() {
		return messageDescription;
	}

	/**
	 * @param messageDescription the messageDescription to set
	 */
	public void setMessageDescription(String messageDescription) {
		this.messageDescription = messageDescription;
	}
	
}
