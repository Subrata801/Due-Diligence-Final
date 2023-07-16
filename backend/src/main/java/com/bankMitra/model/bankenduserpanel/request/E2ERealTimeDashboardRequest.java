/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.request;

import java.io.Serializable;
import java.util.List;

import com.bankMitra.model.bankenduserpanel.response.M1MonitoringDetails;

/**
 * @author Bank Maitra
 *
 */
public class E2ERealTimeDashboardRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4997751067406952731L;

	private String zoneName;
	private String cpcName;
	private String branchName;
	private String ifscCode;
	private String moduleName;
	private String clientId;
	private String clientGroupId;
	private String userName;
	private List<M1MonitoringDetails> m1MonitoringDetails;
	//private List<M2MonitoringDetails> m2MonitoringDetails;
	//private List<M3MonitoringDetails> m3MonitoringDetails;
	//private List<M4MonitoringDetails> m4MonitoringDetails;
	//private List<M5MonitoringDetails> m5MonitoringDetails;
	private String createdBy;
	
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
	 * @return the clientId
	 */
	public String getClientId() {
		return clientId;
	}
	/**
	 * @param clientId the clientId to set
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	/**
	 * @return the clientGroupId
	 */
	public String getClientGroupId() {
		return clientGroupId;
	}
	/**
	 * @param clientGroupId the clientGroupId to set
	 */
	public void setClientGroupId(String clientGroupId) {
		this.clientGroupId = clientGroupId;
	}
	/**
	 * @return the zoneName
	 */
	public String getZoneName() {
		return zoneName;
	}
	/**
	 * @param zoneName the zoneName to set
	 */
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	/**
	 * @return the cpcName
	 */
	public String getCpcName() {
		return cpcName;
	}
	/**
	 * @param cpcName the cpcName to set
	 */
	public void setCpcName(String cpcName) {
		this.cpcName = cpcName;
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
	 * @return the m1MonitoringDetails
	 */
	public List<M1MonitoringDetails> getM1MonitoringDetails() {
		return m1MonitoringDetails;
	}
	/**
	 * @param m1MonitoringDetails the m1MonitoringDetails to set
	 */
	public void setM1MonitoringDetails(List<M1MonitoringDetails> m1MonitoringDetails) {
		this.m1MonitoringDetails = m1MonitoringDetails;
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

}
