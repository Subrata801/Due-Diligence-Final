/**
 * 
 */
package com.bankMitra.model.admin;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author BankMitra
 *
 */
public class ImportTemplateRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3274722312991971617L;

	private Integer templateId;
	
	private Integer ddId;
	
	private Integer clientTypeId;
	
	private Integer creditScoreTypeId;
	
	private Integer riskTypeId;

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
	 * @return the creditScoreTypeId
	 */
	public Integer getCreditScoreTypeId() {
		return creditScoreTypeId;
	}

	/**
	 * @param creditScoreTypeId the creditScoreTypeId to set
	 */
	public void setCreditScoreTypeId(Integer creditScoreTypeId) {
		this.creditScoreTypeId = creditScoreTypeId;
	}

	/**
	 * @return the riskTypeId
	 */
	public Integer getRiskTypeId() {
		return riskTypeId;
	}

	/**
	 * @param riskTypeId the riskTypeId to set
	 */
	public void setRiskTypeId(Integer riskTypeId) {
		this.riskTypeId = riskTypeId;
	}

	/**
	 * @return the templateId
	 */
	public Integer getTemplateId() {
		return templateId;
	}

	/**
	 * @param templateId the templateId to set
	 */
	public void setTemplateId(Integer templateId) {
		this.templateId = templateId;
	}

	/**
	 * @return the ddId
	 */
	public Integer getDdId() {
		return ddId;
	}

	/**
	 * @param ddId the ddId to set
	 */
	public void setDdId(Integer ddId) {
		this.ddId = ddId;
	}
	
}


