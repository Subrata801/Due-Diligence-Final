/**
 * 
 */
package com.bankMitra.model.clientManagement.request;

import java.io.Serializable;

/**
 * @author BankMitra
 *
 */
public class EmployeeUploadArray implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 763732170027435939L;

	private String unitType;
	
	private String unitName;
	
    private String ifscCode;
	
    private String employeeName;
	
    private String employeeID;
    
    private Long mobileNum;
    
	private String  employeeDesignation;
	
	private String status;

	/**
	 * @return the mobileNum
	 */
	public Long getMobileNum() {
		return mobileNum;
	}

	/**
	 * @param mobileNum the mobileNum to set
	 */
	public void setMobileNum(Long mobileNum) {
		this.mobileNum = mobileNum;
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
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}

	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	/**
	 * @return the employeeID
	 */
	public String getEmployeeID() {
		return employeeID;
	}

	/**
	 * @param employeeID the employeeID to set
	 */
	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	/**
	 * @return the employeeDesignation
	 */
	public String getEmployeeDesignation() {
		return employeeDesignation;
	}

	/**
	 * @param employeeDesignation the employeeDesignation to set
	 */
	public void setEmployeeDesignation(String employeeDesignation) {
		this.employeeDesignation = employeeDesignation;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
}
