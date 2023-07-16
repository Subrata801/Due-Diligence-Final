/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.request;

import java.io.Serializable;
import java.util.List;

/**
 * @author Bank Maitra
 *
 */
public class ReassignUserApplicationRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4997751067406952731L;

	private String clientId;
	private String clientGroupId;
	private String hoClientGroupId;
	private String zoClientGroupId;
	private String cpcClientGroupId;
	
	private String bankName;
	private String branchName;
	private String ifscCode;
	private String moduleName;
	
	private String e2eNum;
    private String maker;
	private String checker;
	private String userName;
	private String sanctioningAuth;
	private String reasonOfCancellation;

	private List<UserM1ApplicationDetails> m1ApplicationDetails;
	private List<UserM2ApplicationDetails> m2ApplicationDetails;
	private List<UserM3ApplicationDetails> m3ApplicationDetails;
	private List<UserM4ApplicationDetails> m4ApplicationDetails;
	private List<UserM5ApplicationDetails> m5ApplicationDetails;
	private String createdBy;
	
	
	/**
	 * @return the hoClientGroupId
	 */
	public String getHoClientGroupId() {
		return hoClientGroupId;
	}
	/**
	 * @param hoClientGroupId the hoClientGroupId to set
	 */
	public void setHoClientGroupId(String hoClientGroupId) {
		this.hoClientGroupId = hoClientGroupId;
	}
	/**
	 * @return the zoClientGroupId
	 */
	public String getZoClientGroupId() {
		return zoClientGroupId;
	}
	/**
	 * @param zoClientGroupId the zoClientGroupId to set
	 */
	public void setZoClientGroupId(String zoClientGroupId) {
		this.zoClientGroupId = zoClientGroupId;
	}
	/**
	 * @return the cpcClientGroupId
	 */
	public String getCpcClientGroupId() {
		return cpcClientGroupId;
	}
	/**
	 * @param cpcClientGroupId the cpcClientGroupId to set
	 */
	public void setCpcClientGroupId(String cpcClientGroupId) {
		this.cpcClientGroupId = cpcClientGroupId;
	}
	/**
	 * @return the e2eNum
	 */
	public String getE2eNum() {
		return e2eNum;
	}
	/**
	 * @param e2eNum the e2eNum to set
	 */
	public void setE2eNum(String e2eNum) {
		this.e2eNum = e2eNum;
	}
	/**
	 * @return the maker
	 */
	public String getMaker() {
		return maker;
	}
	/**
	 * @param maker the maker to set
	 */
	public void setMaker(String maker) {
		this.maker = maker;
	}
	/**
	 * @return the checker
	 */
	public String getChecker() {
		return checker;
	}
	/**
	 * @param checker the checker to set
	 */
	public void setChecker(String checker) {
		this.checker = checker;
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
	 * @return the sanctioningAuth
	 */
	public String getSanctioningAuth() {
		return sanctioningAuth;
	}
	/**
	 * @param sanctioningAuth the sanctioningAuth to set
	 */
	public void setSanctioningAuth(String sanctioningAuth) {
		this.sanctioningAuth = sanctioningAuth;
	}
	/**
	 * @return the reasonOfCancellation
	 */
	public String getReasonOfCancellation() {
		return reasonOfCancellation;
	}
	/**
	 * @param reasonOfCancellation the reasonOfCancellation to set
	 */
	public void setReasonOfCancellation(String reasonOfCancellation) {
		this.reasonOfCancellation = reasonOfCancellation;
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
	 * @return the m1ApplicationDetails
	 */
	public List<UserM1ApplicationDetails> getM1ApplicationDetails() {
		return m1ApplicationDetails;
	}
	/**
	 * @param m1ApplicationDetails the m1ApplicationDetails to set
	 */
	public void setM1ApplicationDetails(List<UserM1ApplicationDetails> m1ApplicationDetails) {
		this.m1ApplicationDetails = m1ApplicationDetails;
	}
	/**
	 * @return the m2ApplicationDetails
	 */
	public List<UserM2ApplicationDetails> getM2ApplicationDetails() {
		return m2ApplicationDetails;
	}
	/**
	 * @param m2ApplicationDetails the m2ApplicationDetails to set
	 */
	public void setM2ApplicationDetails(List<UserM2ApplicationDetails> m2ApplicationDetails) {
		this.m2ApplicationDetails = m2ApplicationDetails;
	}
	/**
	 * @return the m3ApplicationDetails
	 */
	public List<UserM3ApplicationDetails> getM3ApplicationDetails() {
		return m3ApplicationDetails;
	}
	/**
	 * @param m3ApplicationDetails the m3ApplicationDetails to set
	 */
	public void setM3ApplicationDetails(List<UserM3ApplicationDetails> m3ApplicationDetails) {
		this.m3ApplicationDetails = m3ApplicationDetails;
	}
	/**
	 * @return the m4ApplicationDetails
	 */
	public List<UserM4ApplicationDetails> getM4ApplicationDetails() {
		return m4ApplicationDetails;
	}
	/**
	 * @param m4ApplicationDetails the m4ApplicationDetails to set
	 */
	public void setM4ApplicationDetails(List<UserM4ApplicationDetails> m4ApplicationDetails) {
		this.m4ApplicationDetails = m4ApplicationDetails;
	}
	/**
	 * @return the m5ApplicationDetails
	 */
	public List<UserM5ApplicationDetails> getM5ApplicationDetails() {
		return m5ApplicationDetails;
	}
	/**
	 * @param m5ApplicationDetails the m5ApplicationDetails to set
	 */
	public void setM5ApplicationDetails(List<UserM5ApplicationDetails> m5ApplicationDetails) {
		this.m5ApplicationDetails = m5ApplicationDetails;
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
