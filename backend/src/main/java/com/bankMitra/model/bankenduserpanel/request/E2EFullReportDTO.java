package com.bankMitra.model.bankenduserpanel.request;

public class E2EFullReportDTO {

	E2EFullReportHeader header;
	E2EFullReportTable table;
	E2EFullReportFooter footer;
	public E2EFullReportHeader getHeader() {
		return header;
	}
	public void setHeader(E2EFullReportHeader header) {
		this.header = header;
	}
	public E2EFullReportTable getTable() {
		return table;
	}
	public void setTable(E2EFullReportTable table) {
		this.table = table;
	}
	public E2EFullReportFooter getFooter() {
		return footer;
	}
	public void setFooter(E2EFullReportFooter footer) {
		this.footer = footer;
	}
	
	
}
