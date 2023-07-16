/**
 * 
 */
package com.bankMitra.service.reference;

import java.util.List;

import com.bankMitra.exception.ResourceNotFoundException;
import com.bankMitra.model.reference.ApplicantType;
import com.bankMitra.model.reference.AuditFirm;
import com.bankMitra.model.reference.Banks;
import com.bankMitra.model.reference.BorrowerType;
import com.bankMitra.model.reference.CPC;
import com.bankMitra.model.reference.ClientGroup;
import com.bankMitra.model.reference.ClientType;
import com.bankMitra.model.reference.CreditSector;
import com.bankMitra.model.reference.HO;
import com.bankMitra.model.reference.HeaderKey;
import com.bankMitra.model.reference.Language;
import com.bankMitra.model.reference.MessageCode;
import com.bankMitra.model.reference.Profession;
import com.bankMitra.model.reference.RiskType;
import com.bankMitra.model.reference.SecurityQuestions;
import com.bankMitra.model.reference.SecurityType;
import com.bankMitra.model.reference.SubscriptionSubType;
import com.bankMitra.model.reference.SubscriptionType;
import com.bankMitra.model.reference.UnitType;
import com.bankMitra.model.reference.UserRoles;

/**
 * @author BankMitra
 *
 */
public interface ReferenceService {

	List<SecurityQuestions> getListOfSecurityQuestions() throws ResourceNotFoundException;

	List<Language> getListOfLanguages() throws ResourceNotFoundException;

	List<RiskType> getListOfRiskTypes() throws ResourceNotFoundException;

	List<ApplicantType> getListOfApplicantTypes() throws ResourceNotFoundException;

	List<BorrowerType> getListOfBorrowerTypes() throws ResourceNotFoundException;

	List<CreditSector> getListOfCreditScoreTypes() throws ResourceNotFoundException;

	List<Profession> getListOfProfessions() throws ResourceNotFoundException;

	List<UserRoles> getListOfRoles(Integer userTypeId) throws ResourceNotFoundException;

	List<SubscriptionType> getListOfSubscriptionTypes(Integer productTypeId) throws ResourceNotFoundException;

	List<SubscriptionSubType> getListOfSubscriptionSubTypes(Integer subscriptionType) throws ResourceNotFoundException;

	List<SecurityType> getListOfSecurityTypes() throws ResourceNotFoundException;
	
	List<MessageCode> getListOfMessageCode() throws ResourceNotFoundException;

	List<HeaderKey> getListOfHeaderKeys() throws ResourceNotFoundException;

	List<AuditFirm> getListOfAuditFirms() throws ResourceNotFoundException;

	List<Banks> getListOfBanks() throws ResourceNotFoundException;

	List<ClientGroup> getListOfClientGroup(Integer clientId) throws ResourceNotFoundException;

	List<ClientType> getListOfClientType()  throws ResourceNotFoundException;

	List<HO> getListOfHO(Integer clientId) throws ResourceNotFoundException;

	List<CPC> getListOfCPC(Integer clientId, Integer zoId) throws ResourceNotFoundException;

	List<com.bankMitra.model.reference.ZO> getListOfZO(Integer clientId, Integer hoId) throws ResourceNotFoundException;

	List<UnitType> getListOfUnitTypes() throws ResourceNotFoundException;

}
