package com.bankMitra.model.reference;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author BankMitra
 *
 */

//@Entity
//@Table(	name = "bmclient",schema="bmadmin")
public class Client implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "Client Id")
	private Long clientId;
	
	@ApiModelProperty(notes = "Client Type Id")
	private Integer clientTypeId;

	@ApiModelProperty(notes = "Client Name")
	private String clientName;

	@ApiModelProperty(notes = "Subscription Id")
	private Integer subscriptionId;
	
	@ApiModelProperty(notes = "Address")
	private String address;
	
	@ApiModelProperty(notes = "City")
	private String city;
	
	@ApiModelProperty(notes = "Pin Code")
	private Integer pinCode;
	
	@ApiModelProperty(notes = "State")
	private String state;
	
	@ApiModelProperty(notes = "GST Number")
	private String gstNum;
	
	@ApiModelProperty(notes = "Primary POC")
	private String primaryPoc;
	
	@ApiModelProperty(notes = "Primary POC Designation")
	private String primaryPocDesignation;
	
	@ApiModelProperty(notes = "Primary POC Number")
	private Integer primaryPocNumber;
	
	@ApiModelProperty(notes = "Secondary POC")
	private String secondaryPoc;
	
	@ApiModelProperty(notes = "Secondary POC Designation")
	private String secondaryPocDesignation;
	
	@ApiModelProperty(notes = "Secondary POC Number")
	private Integer secondaryPocNumber;
	
	@ApiModelProperty(notes = "Client Start Date")
	private Date clientStartDate;
	
	@ApiModelProperty(notes = "Subscription Start Date")
	private Date subscriptionStartDate;
	
	@ApiModelProperty(notes = "Subscription End Date")
	private Date subscriptionEndDate;

	/**
	 * @return the clientId
	 */
	public Long getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	/**
	 * @return the clientTypeId
	 */
	public Integer getClientTypeId() {
		return clientTypeId;
	}

	/**
	 * @param clientTypeId the clientTypeId to set
	 */
	public void setClientTypeId(Integer clientTypeId) {
		this.clientTypeId = clientTypeId;
	}

	/**
	 * @return the clientName
	 */
	public String getClientName() {
		return clientName;
	}

	/**
	 * @param clientName the clientName to set
	 */
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	/**
	 * @return the subscriptionId
	 */
	public Integer getSubscriptionId() {
		return subscriptionId;
	}

	/**
	 * @param subscriptionId the subscriptionId to set
	 */
	public void setSubscriptionId(Integer subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the pinCode
	 */
	public Integer getPinCode() {
		return pinCode;
	}

	/**
	 * @param pinCode the pinCode to set
	 */
	public void setPinCode(Integer pinCode) {
		this.pinCode = pinCode;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the gstNum
	 */
	public String getGstNum() {
		return gstNum;
	}

	/**
	 * @param gstNum the gstNum to set
	 */
	public void setGstNum(String gstNum) {
		this.gstNum = gstNum;
	}

	/**
	 * @return the primaryPoc
	 */
	public String getPrimaryPoc() {
		return primaryPoc;
	}

	/**
	 * @param primaryPoc the primaryPoc to set
	 */
	public void setPrimaryPoc(String primaryPoc) {
		this.primaryPoc = primaryPoc;
	}

	/**
	 * @return the primaryPocDesignation
	 */
	public String getPrimaryPocDesignation() {
		return primaryPocDesignation;
	}

	/**
	 * @param primaryPocDesignation the primaryPocDesignation to set
	 */
	public void setPrimaryPocDesignation(String primaryPocDesignation) {
		this.primaryPocDesignation = primaryPocDesignation;
	}

	/**
	 * @return the primaryPocNumber
	 */
	public Integer getPrimaryPocNumber() {
		return primaryPocNumber;
	}

	/**
	 * @param primaryPocNumber the primaryPocNumber to set
	 */
	public void setPrimaryPocNumber(Integer primaryPocNumber) {
		this.primaryPocNumber = primaryPocNumber;
	}

	/**
	 * @return the secondaryPoc
	 */
	public String getSecondaryPoc() {
		return secondaryPoc;
	}

	/**
	 * @param secondaryPoc the secondaryPoc to set
	 */
	public void setSecondaryPoc(String secondaryPoc) {
		this.secondaryPoc = secondaryPoc;
	}

	/**
	 * @return the secondaryPocDesignation
	 */
	public String getSecondaryPocDesignation() {
		return secondaryPocDesignation;
	}

	/**
	 * @param secondaryPocDesignation the secondaryPocDesignation to set
	 */
	public void setSecondaryPocDesignation(String secondaryPocDesignation) {
		this.secondaryPocDesignation = secondaryPocDesignation;
	}

	/**
	 * @return the secondaryPocNumber
	 */
	public Integer getSecondaryPocNumber() {
		return secondaryPocNumber;
	}

	/**
	 * @param secondaryPocNumber the secondaryPocNumber to set
	 */
	public void setSecondaryPocNumber(Integer secondaryPocNumber) {
		this.secondaryPocNumber = secondaryPocNumber;
	}

	/**
	 * @return the clientStartDate
	 */
	public Date getClientStartDate() {
		return clientStartDate;
	}

	/**
	 * @param clientStartDate the clientStartDate to set
	 */
	public void setClientStartDate(Date clientStartDate) {
		this.clientStartDate = clientStartDate;
	}

	/**
	 * @return the subscriptionStartDate
	 */
	public Date getSubscriptionStartDate() {
		return subscriptionStartDate;
	}

	/**
	 * @param subscriptionStartDate the subscriptionStartDate to set
	 */
	public void setSubscriptionStartDate(Date subscriptionStartDate) {
		this.subscriptionStartDate = subscriptionStartDate;
	}

	/**
	 * @return the subscriptionEndDate
	 */
	public Date getSubscriptionEndDate() {
		return subscriptionEndDate;
	}

	/**
	 * @param subscriptionEndDate the subscriptionEndDate to set
	 */
	public void setSubscriptionEndDate(Date subscriptionEndDate) {
		this.subscriptionEndDate = subscriptionEndDate;
	}
	
}
