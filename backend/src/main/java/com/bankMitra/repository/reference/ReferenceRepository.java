package com.bankMitra.repository.reference;


import java.util.List;

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
import com.bankMitra.model.reference.ZO;

/**
 * @author BankMitra
 *
 */
public interface ReferenceRepository  {

	List<SecurityQuestions> getListOfSecurityQuestions();

	List<Language> getListOfLanguages();

	List<RiskType> getListOfRiskTypes();

	List<ApplicantType> getListOfApplicantTypes();

	List<BorrowerType> getListOfBorrowerTypes();

	List<CreditSector> getListOfCreditScoreTypes();

	List<Profession> getListOfProfessions();

	List<UserRoles> getListOfRoles(Integer clientTypeId);

	List<SubscriptionType> getListOfSubscriptionTypes(Integer productTypeId);

	List<SubscriptionSubType> getListOfSubscriptionSubTypes(Integer subscriptionType);

	List<SecurityType> getListOfSecurityTypes();
	
	List<MessageCode> getListOfMessageCode();

	List<HeaderKey> getListOfHeaderKeys();

	List<AuditFirm> getListOfAuditFirms();

	List<Banks> getListOfBanks();

	List<ClientGroup> getListOfClientGroup(Integer clientId);

	List<ClientType> getListOfClientType();

	List<HO> getListOfHO(Integer clientId);

	List<CPC> getListOfCPC(Integer clientId, Integer zoId);

	List<ZO> getListOfZO(Integer clientId, Integer hoId);

	List<UnitType> getListOfUnitTypes();

}
