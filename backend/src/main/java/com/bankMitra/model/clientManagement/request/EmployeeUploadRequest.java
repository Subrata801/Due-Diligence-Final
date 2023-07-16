/**
 * 
 */
package com.bankMitra.model.clientManagement.request;

import java.io.Serializable;
import java.util.List;

/**
 * @author BankMitra
 *
 */
public class EmployeeUploadRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 763732170027435939L;

	private Integer clientId;
	
	private List<EmployeeUploadArray> employeeUploadList;

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
	 * @return the employeeUploadList
	 */
	public List<EmployeeUploadArray> getEmployeeUploadList() {
		return employeeUploadList;
	}

	/**
	 * @param employeeUploadList the employeeUploadList to set
	 */
	public void setEmployeeUploadList(List<EmployeeUploadArray> employeeUploadList) {
		this.employeeUploadList = employeeUploadList;
	}

}
