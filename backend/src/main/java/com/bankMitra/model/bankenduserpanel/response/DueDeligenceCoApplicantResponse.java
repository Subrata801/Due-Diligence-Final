/**
 * 
 */
package com.bankMitra.model.bankenduserpanel.response;

import java.io.Serializable;
import java.util.List;

/**
 * @author BankMitra
 *
 */
public class DueDeligenceCoApplicantResponse implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 615525540353871906L;
	private boolean selectedCoApplicant;
	private String profile;
	private String coapplicantName;
	private String coappDesignation;
	
	private String coapplicant;
	private String coapplicant1;
	private String coapplicant2;
	private String coapplicant3;
	private String coapplicant4;
	private String coapplicantdesignation;
	private String coapplicant1designation;
	private String coapplicant2designation;
	private String coapplicant3designation;
	private String coapplicant4designation;
	private String guarantor;
	private String guarantor1;
	private String guarantor2;
	private String guarantor3;
	private String guarantor4;
	private Integer securityid;
	private Integer securitytypeid;
	private List<MoveableProperty> moveableProperty;
	
	private Integer security_SubType_shares;
	private Integer security_SubType_stockOfGoods;
	private Integer security_SubType_bookDebts;
	private Integer security_SubType_receivables;
	private Integer security_SubType_machinery;
	private Integer security_SubType_vechile;
	private Integer security_SubType_bankDeposit;
	private Integer security_SubType_bonds;
	private Integer security_SubType_lip;
	private Integer security_SubType_gold;
	private String messageCode;
	
	private String messageDescription;

	/**
	 * @return the selectedCoApplicant
	 */
	public boolean getSelectedCoApplicant() {
		return selectedCoApplicant;
	}

	/**
	 * @param selectedCoApplicant the selectedCoApplicant to set
	 */
	public void setSelectedCoApplicant(boolean selectedCoApplicant) {
		this.selectedCoApplicant = selectedCoApplicant;
	}

	/**
	 * @return the security_SubType_shares
	 */
	public Integer getSecurity_SubType_shares() {
		return security_SubType_shares;
	}

	/**
	 * @param security_SubType_shares the security_SubType_shares to set
	 */
	public void setSecurity_SubType_shares(Integer security_SubType_shares) {
		this.security_SubType_shares = security_SubType_shares;
	}

	/**
	 * @return the security_SubType_stockOfGoods
	 */
	public Integer getSecurity_SubType_stockOfGoods() {
		return security_SubType_stockOfGoods;
	}

	/**
	 * @param security_SubType_stockOfGoods the security_SubType_stockOfGoods to set
	 */
	public void setSecurity_SubType_stockOfGoods(Integer security_SubType_stockOfGoods) {
		this.security_SubType_stockOfGoods = security_SubType_stockOfGoods;
	}

	/**
	 * @return the security_SubType_bookDebts
	 */
	public Integer getSecurity_SubType_bookDebts() {
		return security_SubType_bookDebts;
	}

	/**
	 * @param security_SubType_bookDebts the security_SubType_bookDebts to set
	 */
	public void setSecurity_SubType_bookDebts(Integer security_SubType_bookDebts) {
		this.security_SubType_bookDebts = security_SubType_bookDebts;
	}

	/**
	 * @return the security_SubType_receivables
	 */
	public Integer getSecurity_SubType_receivables() {
		return security_SubType_receivables;
	}

	/**
	 * @param security_SubType_receivables the security_SubType_receivables to set
	 */
	public void setSecurity_SubType_receivables(Integer security_SubType_receivables) {
		this.security_SubType_receivables = security_SubType_receivables;
	}

	/**
	 * @return the security_SubType_machinery
	 */
	public Integer getSecurity_SubType_machinery() {
		return security_SubType_machinery;
	}

	/**
	 * @param security_SubType_machinery the security_SubType_machinery to set
	 */
	public void setSecurity_SubType_machinery(Integer security_SubType_machinery) {
		this.security_SubType_machinery = security_SubType_machinery;
	}

	/**
	 * @return the security_SubType_vechile
	 */
	public Integer getSecurity_SubType_vechile() {
		return security_SubType_vechile;
	}

	/**
	 * @param security_SubType_vechile the security_SubType_vechile to set
	 */
	public void setSecurity_SubType_vechile(Integer security_SubType_vechile) {
		this.security_SubType_vechile = security_SubType_vechile;
	}

	/**
	 * @return the security_SubType_bankDeposit
	 */
	public Integer getSecurity_SubType_bankDeposit() {
		return security_SubType_bankDeposit;
	}

	/**
	 * @param security_SubType_bankDeposit the security_SubType_bankDeposit to set
	 */
	public void setSecurity_SubType_bankDeposit(Integer security_SubType_bankDeposit) {
		this.security_SubType_bankDeposit = security_SubType_bankDeposit;
	}

	/**
	 * @return the security_SubType_bonds
	 */
	public Integer getSecurity_SubType_bonds() {
		return security_SubType_bonds;
	}

	/**
	 * @param security_SubType_bonds the security_SubType_bonds to set
	 */
	public void setSecurity_SubType_bonds(Integer security_SubType_bonds) {
		this.security_SubType_bonds = security_SubType_bonds;
	}

	/**
	 * @return the security_SubType_lip
	 */
	public Integer getSecurity_SubType_lip() {
		return security_SubType_lip;
	}

	/**
	 * @param security_SubType_lip the security_SubType_lip to set
	 */
	public void setSecurity_SubType_lip(Integer security_SubType_lip) {
		this.security_SubType_lip = security_SubType_lip;
	}

	/**
	 * @return the security_SubType_gold
	 */
	public Integer getSecurity_SubType_gold() {
		return security_SubType_gold;
	}

	/**
	 * @param security_SubType_gold the security_SubType_gold to set
	 */
	public void setSecurity_SubType_gold(Integer security_SubType_gold) {
		this.security_SubType_gold = security_SubType_gold;
	}

	/**
	 * @return the profile
	 */
	public String getProfile() {
		return profile;
	}

	/**
	 * @param profile the profile to set
	 */
	public void setProfile(String profile) {
		this.profile = profile;
	}

	/**
	 * @return the coapplicantName
	 */
	public String getCoapplicantName() {
		return coapplicantName;
	}

	/**
	 * @param coapplicantName the coapplicantName to set
	 */
	public void setCoapplicantName(String coapplicantName) {
		this.coapplicantName = coapplicantName;
	}

	/**
	 * @return the coappDesignation
	 */
	public String getCoappDesignation() {
		return coappDesignation;
	}

	/**
	 * @param coappDesignation the coappDesignation to set
	 */
	public void setCoappDesignation(String coappDesignation) {
		this.coappDesignation = coappDesignation;
	}

	/**
	 * @return the coapplicant
	 */
	public String getCoapplicant() {
		return coapplicant;
	}

	/**
	 * @param coapplicant the coapplicant to set
	 */
	public void setCoapplicant(String coapplicant) {
		this.coapplicant = coapplicant;
	}

	/**
	 * @return the coapplicant1
	 */
	public String getCoapplicant1() {
		return coapplicant1;
	}

	/**
	 * @param coapplicant1 the coapplicant1 to set
	 */
	public void setCoapplicant1(String coapplicant1) {
		this.coapplicant1 = coapplicant1;
	}

	/**
	 * @return the coapplicant2
	 */
	public String getCoapplicant2() {
		return coapplicant2;
	}

	/**
	 * @param coapplicant2 the coapplicant2 to set
	 */
	public void setCoapplicant2(String coapplicant2) {
		this.coapplicant2 = coapplicant2;
	}

	/**
	 * @return the coapplicant3
	 */
	public String getCoapplicant3() {
		return coapplicant3;
	}

	/**
	 * @param coapplicant3 the coapplicant3 to set
	 */
	public void setCoapplicant3(String coapplicant3) {
		this.coapplicant3 = coapplicant3;
	}

	/**
	 * @return the coapplicant4
	 */
	public String getCoapplicant4() {
		return coapplicant4;
	}

	/**
	 * @param coapplicant4 the coapplicant4 to set
	 */
	public void setCoapplicant4(String coapplicant4) {
		this.coapplicant4 = coapplicant4;
	}

	/**
	 * @return the coapplicantdesignation
	 */
	public String getCoapplicantdesignation() {
		return coapplicantdesignation;
	}

	/**
	 * @param coapplicantdesignation the coapplicantdesignation to set
	 */
	public void setCoapplicantdesignation(String coapplicantdesignation) {
		this.coapplicantdesignation = coapplicantdesignation;
	}

	/**
	 * @return the coapplicant1designation
	 */
	public String getCoapplicant1designation() {
		return coapplicant1designation;
	}

	/**
	 * @param coapplicant1designation the coapplicant1designation to set
	 */
	public void setCoapplicant1designation(String coapplicant1designation) {
		this.coapplicant1designation = coapplicant1designation;
	}

	/**
	 * @return the coapplicant2designation
	 */
	public String getCoapplicant2designation() {
		return coapplicant2designation;
	}

	/**
	 * @param coapplicant2designation the coapplicant2designation to set
	 */
	public void setCoapplicant2designation(String coapplicant2designation) {
		this.coapplicant2designation = coapplicant2designation;
	}

	/**
	 * @return the coapplicant3designation
	 */
	public String getCoapplicant3designation() {
		return coapplicant3designation;
	}

	/**
	 * @param coapplicant3designation the coapplicant3designation to set
	 */
	public void setCoapplicant3designation(String coapplicant3designation) {
		this.coapplicant3designation = coapplicant3designation;
	}

	/**
	 * @return the coapplicant4designation
	 */
	public String getCoapplicant4designation() {
		return coapplicant4designation;
	}

	/**
	 * @param coapplicant4designation the coapplicant4designation to set
	 */
	public void setCoapplicant4designation(String coapplicant4designation) {
		this.coapplicant4designation = coapplicant4designation;
	}

	/**
	 * @return the guarantor
	 */
	public String getGuarantor() {
		return guarantor;
	}

	/**
	 * @param guarantor the guarantor to set
	 */
	public void setGuarantor(String guarantor) {
		this.guarantor = guarantor;
	}

	/**
	 * @return the guarantor1
	 */
	public String getGuarantor1() {
		return guarantor1;
	}

	/**
	 * @param guarantor1 the guarantor1 to set
	 */
	public void setGuarantor1(String guarantor1) {
		this.guarantor1 = guarantor1;
	}

	/**
	 * @return the guarantor2
	 */
	public String getGuarantor2() {
		return guarantor2;
	}

	/**
	 * @param guarantor2 the guarantor2 to set
	 */
	public void setGuarantor2(String guarantor2) {
		this.guarantor2 = guarantor2;
	}

	/**
	 * @return the guarantor3
	 */
	public String getGuarantor3() {
		return guarantor3;
	}

	/**
	 * @param guarantor3 the guarantor3 to set
	 */
	public void setGuarantor3(String guarantor3) {
		this.guarantor3 = guarantor3;
	}

	/**
	 * @return the guarantor4
	 */
	public String getGuarantor4() {
		return guarantor4;
	}

	/**
	 * @param guarantor4 the guarantor4 to set
	 */
	public void setGuarantor4(String guarantor4) {
		this.guarantor4 = guarantor4;
	}

	/**
	 * @return the securityid
	 */
	public Integer getSecurityid() {
		return securityid;
	}

	/**
	 * @param securityid the securityid to set
	 */
	public void setSecurityid(Integer securityid) {
		this.securityid = securityid;
	}

	/**
	 * @return the securitytypeid
	 */
	public Integer getSecuritytypeid() {
		return securitytypeid;
	}

	/**
	 * @param securitytypeid the securitytypeid to set
	 */
	public void setSecuritytypeid(Integer securitytypeid) {
		this.securitytypeid = securitytypeid;
	}

	/**
	 * @return the moveableProperty
	 */
	public List<MoveableProperty> getMoveableProperty() {
		return moveableProperty;
	}

	/**
	 * @param moveableProperty the moveableProperty to set
	 */
	public void setMoveableProperty(List<MoveableProperty> moveableProperty) {
		this.moveableProperty = moveableProperty;
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
