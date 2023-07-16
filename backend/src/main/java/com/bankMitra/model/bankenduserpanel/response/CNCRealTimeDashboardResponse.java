/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.response;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.bankMitra.model.bankenduserpanel.response.CNCMonitoringDetails;
import com.bankMitra.model.bankenduserpanel.response.M1MonitoringDetails;

/**
 * @author Bank Maitra
 *
 */
public class CNCRealTimeDashboardResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4997751067406952731L;

	private Date dateField;
    private String cncNum;
	
	private String borrowerName;
    private String cifNumber;
	
	private String auditStatus;
    private String userName;
	
	private String applicationFinalStatus;
	private String bankName;
	private String branchName;
	private String ifscCode;
	private String moduleName;
	private List<CNCMonitoringDetails> cncMonitoringDetails;
	private String createdBy;
    private String messageCode;
	private String messageDescription;
	
	
	/**
	 * @return the dateField
	 */
	public Date getDateField() {
		return dateField;
	}
	/**
	 * @param dateField the dateField to set
	 */
	public void setDateField(Date dateField) {
		this.dateField = dateField;
	}
	/**
	 * @return the cncNum
	 */
	public String getCncNum() {
		return cncNum;
	}
	/**
	 * @param cncNum the cncNum to set
	 */
	public void setCncNum(String cncNum) {
		this.cncNum = cncNum;
	}
	/**
	 * @return the borrowerName
	 */
	public String getBorrowerName() {
		return borrowerName;
	}
	/**
	 * @param borrowerName the borrowerName to set
	 */
	public void setBorrowerName(String borrowerName) {
		this.borrowerName = borrowerName;
	}
	/**
	 * @return the cifNumber
	 */
	public String getCifNumber() {
		return cifNumber;
	}
	/**
	 * @param cifNumber the cifNumber to set
	 */
	public void setCifNumber(String cifNumber) {
		this.cifNumber = cifNumber;
	}
	/**
	 * @return the auditStatus
	 */
	public String getAuditStatus() {
		return auditStatus;
	}
	/**
	 * @param auditStatus the auditStatus to set
	 */
	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the applicationFinalStatus
	 */
	public String getApplicationFinalStatus() {
		return applicationFinalStatus;
	}
	/**
	 * @param applicationFinalStatus the applicationFinalStatus to set
	 */
	public void setApplicationFinalStatus(String applicationFinalStatus) {
		this.applicationFinalStatus = applicationFinalStatus;
	}
	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}
	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}
	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
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
	 * @return the moduleName
	 */
	public String getModuleName() {
		return moduleName;
	}
	/**
	 * @param moduleName the moduleName to set
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	/**
	 * @return the cncMonitoringDetails
	 */
	public List<CNCMonitoringDetails> getCncMonitoringDetails() {
		return cncMonitoringDetails;
	}
	/**
	 * @param cncMonitoringDetails the cncMonitoringDetails to set
	 */
	public void setCncMonitoringDetails(List<CNCMonitoringDetails> cncMonitoringDetails) {
		this.cncMonitoringDetails = cncMonitoringDetails;
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
