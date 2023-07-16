/**
 * 
 */
package com.bankMitra.model.admin.response;

import java.util.Map;

/**
 * @author BankMitra
 *
 */
public class ClientModuleHeaderResponse {
	
	private Integer  ddSequence;
	
	private Integer  ddId;
	
	private String header1;
	
	private String header1Description;
	
    private String header2;
	
	private String header2Description;
	
    private String header3;
	
	private String header3Description;

    private String header4;
	
	private String header4Description;
	
	private String messageCode;
	
	private String messageDescription;
	
	private Map<String,String> headerMap;

	/**
	 * @return the ddSequence
	 */
	public Integer getDdSequence() {
		return ddSequence;
	}

	/**
	 * @param ddSequence the ddSequence to set
	 */
	public void setDdSequence(Integer ddSequence) {
		this.ddSequence = ddSequence;
	}

	/**
	 * @return the headerMap
	 */
	public Map<String, String> getHeaderMap() {
		return headerMap;
	}

	/**
	 * @param headerMap the headerMap to set
	 */
	public void setHeaderMap(Map<String, String> headerMap) {
		this.headerMap = headerMap;
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

	/**
	 * @return the header1
	 */
	public String getHeader1() {
		return header1;
	}

	/**
	 * @param header1 the header1 to set
	 */
	public void setHeader1(String header1) {
		this.header1 = header1;
	}

	/**
	 * @return the header1Description
	 */
	public String getHeader1Description() {
		return header1Description;
	}

	/**
	 * @param header1Description the header1Description to set
	 */
	public void setHeader1Description(String header1Description) {
		this.header1Description = header1Description;
	}

	/**
	 * @return the header2
	 */
	public String getHeader2() {
		return header2;
	}

	/**
	 * @param header2 the header2 to set
	 */
	public void setHeader2(String header2) {
		this.header2 = header2;
	}

	/**
	 * @return the header2Description
	 */
	public String getHeader2Description() {
		return header2Description;
	}

	/**
	 * @param header2Description the header2Description to set
	 */
	public void setHeader2Description(String header2Description) {
		this.header2Description = header2Description;
	}

	/**
	 * @return the header3
	 */
	public String getHeader3() {
		return header3;
	}

	/**
	 * @param header3 the header3 to set
	 */
	public void setHeader3(String header3) {
		this.header3 = header3;
	}

	/**
	 * @return the header3Description
	 */
	public String getHeader3Description() {
		return header3Description;
	}

	/**
	 * @param header3Description the header3Description to set
	 */
	public void setHeader3Description(String header3Description) {
		this.header3Description = header3Description;
	}

	/**
	 * @return the header4
	 */
	public String getHeader4() {
		return header4;
	}

	/**
	 * @param header4 the header4 to set
	 */
	public void setHeader4(String header4) {
		this.header4 = header4;
	}

	/**
	 * @return the header4Description
	 */
	public String getHeader4Description() {
		return header4Description;
	}

	/**
	 * @param header4Description the header4Description to set
	 */
	public void setHeader4Description(String header4Description) {
		this.header4Description = header4Description;
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
