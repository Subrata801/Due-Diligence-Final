/**
 * 
 */
package com.bankMitra.model.clientManagement.request;

import java.io.Serializable;

/**
 * @author BankMitra
 *
 */
public class CreateUnitRequest implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8558651600485195374L;

	private Integer clientGroupId;
	
	private Integer clientId;

	private String unitType;
	
	private Integer unitHO;
	
	private Integer unitZone;
	
	private Integer unitCPC;
	
	private String unitName;
	
	private String searchKeyword;
	
	private String searchType;
	
	private boolean searchOption;
	
	private String ifscCode;
	
	private String unitAddress;
	
	private String city;
	
	private String pincode;
	
	private String state;
	
	private String unitStatus;
	
	private String messageDescription;
	
	private String createdBy;


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
	public String getPincode() {
		return pincode;
	}

	/**
	 * @param pincode the pincode to set
	 */
	public void setPincode(String pincode) {
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
	 * @return the searchKeyword
	 */
	public String getSearchKeyword() {
		return searchKeyword;
	}

	/**
	 * @param searchKeyword the searchKeyword to set
	 */
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	/**
	 * @return the searchType
	 */
	public String getSearchType() {
		return searchType;
	}

	/**
	 * @param searchType the searchType to set
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	/**
	 * @return the searchOption
	 */
	public boolean isSearchOption() {
		return searchOption;
	}

	/**
	 * @param searchOption the searchOption to set
	 */
	public void setSearchOption(boolean searchOption) {
		this.searchOption = searchOption;
	}

}
