/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.response;

import java.io.Serializable;
import java.util.List;

/**
 * @author Bank Maitra
 *
 */
public class SubstituteUserApplicationResponse implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4997751067406952731L;

	private String bankName;
	private String branchName;
	private String ifscCode;
	private String moduleName;
	private List<SubstituteUserM1ApplicationDetails> substitutem1ApplicationDetails;
	private List<SubstituteUserM2ApplicationDetails> substitutem2ApplicationDetails;
	private List<SubstituteUserM3ApplicationDetails> substitutem3ApplicationDetails;
	private List<SubstituteUserM4ApplicationDetails> substitutem4ApplicationDetails;
	private List<SubstituteUserM5ApplicationDetails> substitutem5ApplicationDetails;
	private String createdBy;
    private String messageCode;
	
	private String messageDescription;
	
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
	 * @return the substitutem1ApplicationDetails
	 */
	public List<SubstituteUserM1ApplicationDetails> getSubstitutem1ApplicationDetails() {
		return substitutem1ApplicationDetails;
	}
	/**
	 * @param substitutem1ApplicationDetails the substitutem1ApplicationDetails to set
	 */
	public void setSubstitutem1ApplicationDetails(List<SubstituteUserM1ApplicationDetails> substitutem1ApplicationDetails) {
		this.substitutem1ApplicationDetails = substitutem1ApplicationDetails;
	}
	/**
	 * @return the substitutem2ApplicationDetails
	 */
	public List<SubstituteUserM2ApplicationDetails> getSubstitutem2ApplicationDetails() {
		return substitutem2ApplicationDetails;
	}
	/**
	 * @param substitutem2ApplicationDetails the substitutem2ApplicationDetails to set
	 */
	public void setSubstitutem2ApplicationDetails(List<SubstituteUserM2ApplicationDetails> substitutem2ApplicationDetails) {
		this.substitutem2ApplicationDetails = substitutem2ApplicationDetails;
	}
	/**
	 * @return the substitutem3ApplicationDetails
	 */
	public List<SubstituteUserM3ApplicationDetails> getSubstitutem3ApplicationDetails() {
		return substitutem3ApplicationDetails;
	}
	/**
	 * @param substitutem3ApplicationDetails the substitutem3ApplicationDetails to set
	 */
	public void setSubstitutem3ApplicationDetails(List<SubstituteUserM3ApplicationDetails> substitutem3ApplicationDetails) {
		this.substitutem3ApplicationDetails = substitutem3ApplicationDetails;
	}
	/**
	 * @return the substitutem4ApplicationDetails
	 */
	public List<SubstituteUserM4ApplicationDetails> getSubstitutem4ApplicationDetails() {
		return substitutem4ApplicationDetails;
	}
	/**
	 * @param substitutem4ApplicationDetails the substitutem4ApplicationDetails to set
	 */
	public void setSubstitutem4ApplicationDetails(List<SubstituteUserM4ApplicationDetails> substitutem4ApplicationDetails) {
		this.substitutem4ApplicationDetails = substitutem4ApplicationDetails;
	}
	/**
	 * @return the substitutem5ApplicationDetails
	 */
	public List<SubstituteUserM5ApplicationDetails> getSubstitutem5ApplicationDetails() {
		return substitutem5ApplicationDetails;
	}
	/**
	 * @param substitutem5ApplicationDetails the substitutem5ApplicationDetails to set
	 */
	public void setSubstitutem5ApplicationDetails(List<SubstituteUserM5ApplicationDetails> substitutem5ApplicationDetails) {
		this.substitutem5ApplicationDetails = substitutem5ApplicationDetails;
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
