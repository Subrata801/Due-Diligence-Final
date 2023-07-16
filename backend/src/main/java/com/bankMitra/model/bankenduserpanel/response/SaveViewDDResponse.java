package com.bankMitra.model.bankenduserpanel.response;

public class SaveViewDDResponse {
	private static final long serialVersionUID = -8558651600485195374L;

	private String messageCode;
	
	private String messageDescription;

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getMessageDescription() {
		return messageDescription;
	}

	public void setMessageDescription(String messageDescription) {
		this.messageDescription = messageDescription;
	}

	@Override
	public String toString() {
		return "SaveViewDDResponse [messageCode=" + messageCode + ", messageDescription=" + messageDescription + "]";
	}
	
}
