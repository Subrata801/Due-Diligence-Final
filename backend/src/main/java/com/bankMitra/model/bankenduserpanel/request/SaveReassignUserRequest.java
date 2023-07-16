package com.bankMitra.model.bankenduserpanel.request;

public class SaveReassignUserRequest {
	private String userName;
	private String e2e;
	private String branchMaker;
	private String unitChecker;
	private String sanctionedAuthority;
	private String isCancel;
	private String cancelReason;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getE2e() {
		return e2e;
	}
	public void setE2e(String e2e) {
		this.e2e = e2e;
	}
	public String getBranchMaker() {
		return branchMaker;
	}
	public void setBranchMaker(String branchMaker) {
		this.branchMaker = branchMaker;
	}
	public String getUnitChecker() {
		return unitChecker;
	}
	public void setUnitChecker(String unitChecker) {
		this.unitChecker = unitChecker;
	}
	public String getSanctionedAuthority() {
		return sanctionedAuthority;
	}
	public void setSanctionedAuthority(String sanctionedAuthority) {
		this.sanctionedAuthority = sanctionedAuthority;
	}
	public String getIsCancel() {
		return isCancel;
	}
	public void setIsCancel(String isCancel) {
		this.isCancel = isCancel;
	}
	public String getCancelReason() {
		return cancelReason;
	}
	public void setCancelReason(String cancelReason) {
		this.cancelReason = cancelReason;
	}
	
	
}
