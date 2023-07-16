package com.bankMitra.model.bankenduserpanel.response;

public class ReportData {

	private String header1Desc;
	private String header2Desc;
	private String header3Desc;
	private String header4Desc;
	private String ddData;
	private String response;
	public String getHeader1Desc() {
		return header1Desc;
	}
	public void setHeader1Desc(String header1Desc) {
		this.header1Desc = header1Desc;
	}
	public String getHeader2Desc() {
		return header2Desc;
	}
	public void setHeader2Desc(String header2Desc) {
		this.header2Desc = header2Desc;
	}
	public String getHeader3Desc() {
		return header3Desc;
	}
	public void setHeader3Desc(String header3Desc) {
		this.header3Desc = header3Desc;
	}
	public String getHeader4Desc() {
		return header4Desc;
	}
	public void setHeader4Desc(String header4Desc) {
		this.header4Desc = header4Desc;
	}
	public String getDdData() {
		return ddData;
	}
	public void setDdData(String ddData) {
		this.ddData = ddData;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	@Override
	public String toString() {
		return "ReportData [header1Desc=" + header1Desc + ", header2Desc=" + header2Desc + ", header3Desc="
				+ header3Desc + ", header4Desc=" + header4Desc + ", ddData=" + ddData + ", response=" + response + "]";
	}
	
}
