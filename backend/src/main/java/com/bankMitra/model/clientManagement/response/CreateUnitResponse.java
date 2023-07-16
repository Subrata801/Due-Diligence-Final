/**
 * 
 */
package com.bankMitra.model.clientManagement.response;

import java.io.Serializable;
import java.util.Date;

/**
 * @author BankMitra
 *
 */
public class CreateUnitResponse implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8558651600485195374L;

	private Integer clientGroupId;
	
	private Integer unitCPC;
	
	private Integer unitZone;
	
	private Integer unitHO;
	
	private Integer clientId;
	
	private String unitType;
	
	private String unitName;
	
	private String ifscCode;
	
	private String unitAddress;
	
	private String city;
	
	private Integer pincode;
	
	private String state;
	
	private String unitStatus;
	
	private Date lastUpdatedDate;
	
	private String messageDescription;
	
	private String messageCode;
	
	private String createdBy;
	
	private String clientGroupType;

	public String getClientGroupType() {
		return clientGroupType;
	}

	public void setClientGroupType(String clientGroupType) {
		this.clientGroupType = clientGroupType;
	}

	/**
	 * @return the unitCPC
	 */
	public Integer getUnitCPC() {
		return unitCPC;
	}

	/**
	 * @param unitCPC the unitCPC to set
	 */
	public void setUnitCPC(Integer unitCPC) {
		this.unitCPC = unitCPC;
	}

	/**
	 * @return the unitZone
	 */
	public Integer getUnitZone() {
		return unitZone;
	}

	/**
	 * @param unitZone the unitZone to set
	 */
	public void setUnitZone(Integer unitZone) {
		this.unitZone = unitZone;
	}

	/**
	 * @return the unitHO
	 */
	public Integer getUnitHO() {
		return unitHO;
	}

	/**
	 * @param unitHO the unitHO to set
	 */
	public void setUnitHO(Integer unitHO) {
		this.unitHO = unitHO;
	}

	/**
	 * @return the clientId
	 */
	public Integer getClientId() {
		return clientId;
	}

	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}


	/**
	 * @return the clientGroupId
	 */
	public Integer getClientGroupId() {
		return clientGroupId;
	}

	/**
	 * @param clientGroupId the clientGroupId to set
	 */
	public void setClientGroupId(Integer clientGroupId) {
		this.clientGroupId = clientGroupId;
	}

	/**
	 * @return the lastUpdatedDate
	 */
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	/**
	 * @param lastUpdatedDate the lastUpdatedDate to set
	 */
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}


	/**
	 * @return the unitType
	 */
	public String getUnitType() {
		return unitType;
	}

	/**
	 * @param unitType the unitType to set
	 */
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}

	/**
	 * @return the unitName
	 */
	public String getUnitName() {
		return unitName;
	}

	/**
	 * @param unitName the unitName to set
	 */
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	/**
	 * @return the ifscCode
	 */
	public String getIfscCode() {
		return ifscCode;
	}

	/**
	 * @param ifscCode the ifscCode to set
	 */
	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

	/**
	 * @return the unitAddress
	 */
	public String getUnitAddress() {
		return unitAddress;
	}

	/**
	 * @param unitAddress the unitAddress to set
	 */
	public void setUnitAddress(String unitAddress) {
		this.unitAddress = unitAddress;
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
	 * @return the pincode
	 */
	public Integer getPincode() {
		return pincode;
	}

	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
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
	 * @return the unitStatus
	 */
	public String getUnitStatus() {
		return unitStatus;
	}

	/**
	 * @param unitStatus the unitStatus to set
	 */
	public void setUnitStatus(String unitStatus) {
		this.unitStatus = unitStatus;
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

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
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

}
