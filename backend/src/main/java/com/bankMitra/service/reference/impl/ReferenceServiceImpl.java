/**
 * 
 */
package com.bankMitra.service.reference.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
import com.bankMitra.model.reference.ZO;
import com.bankMitra.repository.reference.ReferenceRepository;
import com.bankMitra.service.reference.ReferenceService;
import com.bankMitra.util.APIConstant;

import lombok.extern.slf4j.Slf4j;

/**
 * @author BankMitra
 *
 */
@Service
@Slf4j
public class ReferenceServiceImpl implements ReferenceService {

	@Autowired
	ReferenceRepository refRepository;
	
	/* (non-Javadoc)
	 * @see com.bankMitra.service.reference.ReferenceService#getListOfSecurityQuestions()
	 */
	@Override
	@Transactional(readOnly=true)
	public List<SecurityQuestions> getListOfSecurityQuestions() throws ResourceNotFoundException {
		List<SecurityQuestions> securityQuestions = null;
		try {
			securityQuestions = refRepository.getListOfSecurityQuestions();
		} catch (DataAccessException ex) {
			throw new ResourceNotFoundException(APIConstant.ERROR_CODE_SECURITYQUEST,ex.getMessage());
		}
		if(!Optional.ofNullable(securityQuestions).isPresent() || securityQuestions.isEmpty() )
			securityQuestions = new ArrayList<SecurityQuestions>();
		
		return securityQuestions;
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.service.reference.ReferenceService#getListOfLanguages()
	 */
	@Override
	@Transactional(readOnly=true)
	public List<Language> getListOfLanguages() throws ResourceNotFoundException {
		List<Language> languages = null;
		try {
			languages = refRepository.getListOfLanguages();
		} catch (DataAccessException ex) {
			throw new ResourceNotFoundException(APIConstant.ERROR_CODE_LANGUAGES,ex.getMessage());
		}
		if(!Optional.ofNullable(languages).isPresent() || languages.isEmpty() )
			languages = new ArrayList<Language>();
		
		return languages;
	}


	/* (non-Javadoc)
	 * @see com.bankMitra.service.reference.ReferenceService#getListOfRiskTypes()
	 */
	@Override
	@Transactional(readOnly=true)
	public List<RiskType> getListOfRiskTypes() throws ResourceNotFoundException {
		List<RiskType> riskTypes = null;
		try {
			riskTypes = refRepository.getListOfRiskTypes();
		} catch (DataAccessException ex) {
			throw new ResourceNotFoundException(APIConstant.ERROR_CODE_RISKTYPES,ex.getMessage());
		}
		if(!Optional.ofNullable(riskTypes).isPresent() || riskTypes.isEmpty() )
			riskTypes = new ArrayList<RiskType>();
		
		return riskTypes;
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.service.reference.ReferenceService#getListOfApplicantTypes()
	 */
	@Override
	@Transactional(readOnly=true)
	public List<ApplicantType> getListOfApplicantTypes() throws ResourceNotFoundException {
		List<ApplicantType> applicantTypes = null;
		try {
			applicantTypes = refRepository.getListOfApplicantTypes();
		} catch (DataAccessException ex) {
			throw new ResourceNotFoundException(APIConstant.ERROR_CODE_APPLICANTTYPES,ex.getMessage());
		}
		if(!Optional.ofNullable(applicantTypes).isPresent() || applicantTypes.isEmpty() )
			applicantTypes = new ArrayList<ApplicantType>();
		
		return applicantTypes;
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.service.reference.ReferenceService#getListOfBorrowerTypes()
	 */
	@Override
	@Transactional(readOnly=true)
	public List<BorrowerType> getListOfBorrowerTypes() throws ResourceNotFoundException {
		List<BorrowerType> borrowerTypes = null;
		try {
			borrowerTypes = refRepository.getListOfBorrowerTypes();
		} catch (DataAccessException ex) {
			throw new ResourceNotFoundException(APIConstant.ERROR_CODE_BORROWERTYPES,ex.getMessage());
		}
		if(!Optional.ofNullable(borrowerTypes).isPresent() || borrowerTypes.isEmpty() )
			borrowerTypes = new ArrayList<BorrowerType>();
		
		return borrowerTypes;
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.service.reference.ReferenceService#getListOfCreditScoreTypes()
	 */
	@Override
	@Transactional(readOnly=true)
	public List<CreditSector> getListOfCreditScoreTypes() throws ResourceNotFoundException {
		List<CreditSector> creditScoreTypes = null;
		try {
			creditScoreTypes = refRepository.getListOfCreditScoreTypes();
		} catch (DataAccessException ex) {
			throw new ResourceNotFoundException(APIConstant.ERROR_CODE_CREDITSCORETYPES,ex.getMessage());
		}
		if(!Optional.ofNullable(creditScoreTypes).isPresent() || creditScoreTypes.isEmpty() )
			creditScoreTypes = new ArrayList<CreditSector>();
		
		return creditScoreTypes;
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.service.reference.ReferenceService#getListOfProfessions()
	 */
	@Override
	@Transactional(readOnly=true)
	public List<Profession> getListOfProfessions() throws ResourceNotFoundException {
		List<Profession> profession = null;
		try {
			profession = refRepository.getListOfProfessions();
		} catch (DataAccessException ex) {
			throw new ResourceNotFoundException(APIConstant.ERROR_CODE_PROFESSIONS,ex.getMessage());
		}
		if(!Optional.ofNullable(profession).isPresent() || profession.isEmpty() )
			profession = new ArrayList<Profession>();
		
		return profession;
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.service.reference.ReferenceService#getListOfRoles()
	 */
	@Override
	@Transactional(readOnly=true)
	public List<UserRoles> getListOfRoles(Integer clientTypeId) throws ResourceNotFoundException {
		List<UserRoles> userRoles = null;
		try {
			userRoles = refRepository.getListOfRoles(clientTypeId);
		} catch (DataAccessException ex) {
			throw new ResourceNotFoundException(APIConstant.ERROR_CODE_USERROLES,ex.getMessage());
		}
		if(!Optional.ofNullable(userRoles).isPresent() || userRoles.isEmpty() )
			userRoles = new ArrayList<UserRoles>();
		
		return userRoles;
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.service.reference.ReferenceService#getListOfSubscriptionTypes()
	 */
	@Override
	@Transactional(readOnly=true)
	public List<SubscriptionType> getListOfSubscriptionTypes(Integer productTypeId) throws ResourceNotFoundException {
		List<SubscriptionType> subscriptionTypes = null;
		try {
			subscriptionTypes = refRepository.getListOfSubscriptionTypes(productTypeId);
		} catch (DataAccessException ex) {
			throw new ResourceNotFoundException(APIConstant.ERROR_CODE_SUBSCRIPTIONTYPE,ex.getMessage());
		}
		if(!Optional.ofNullable(subscriptionTypes).isPresent() || subscriptionTypes.isEmpty() )
			subscriptionTypes = new ArrayList<SubscriptionType>();
		
		return subscriptionTypes;
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.service.reference.ReferenceService#getListOfSubscriptionSubTypes()
	 */
	@Override
	@Transactional(readOnly=true)
	public List<SubscriptionSubType> getListOfSubscriptionSubTypes(Integer subscriptionType) throws ResourceNotFoundException {
		List<SubscriptionSubType> subscriptionSubTypes = null;
		try {
			subscriptionSubTypes = refRepository.getListOfSubscriptionSubTypes(subscriptionType);
		} catch (DataAccessException ex) {
			throw new ResourceNotFoundException(APIConstant.ERROR_CODE_SUBSCRIPTIONSUBTYPE,ex.getMessage());
		}
		if(!Optional.ofNullable(subscriptionSubTypes).isPresent() || subscriptionSubTypes.isEmpty() )
			subscriptionSubTypes = new ArrayList<SubscriptionSubType>();
		
		return subscriptionSubTypes;
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.service.reference.ReferenceService#getListOfSecurityTypes()
	 */
	@Override
	@Transactional(readOnly=true)
	public List<SecurityType> getListOfSecurityTypes() throws ResourceNotFoundException {
		List<SecurityType> securityTypes = null;
		try {
			securityTypes = refRepository.getListOfSecurityTypes();
		} catch (DataAccessException ex) {
			throw new ResourceNotFoundException(APIConstant.ERROR_CODE_SECURITYTYPE,ex.getMessage());
		}
		if(!Optional.ofNullable(securityTypes).isPresent() || securityTypes.isEmpty() )
			securityTypes = new ArrayList<SecurityType>();
		
		return securityTypes;
	}

	@Override
	@Transactional(readOnly=true)
	public List<MessageCode> getListOfMessageCode() throws ResourceNotFoundException {
		List<MessageCode> msg = null;
		try {
			msg = refRepository.getListOfMessageCode();
		} catch (DataAccessException ex) {
			throw new ResourceNotFoundException(APIConstant.ERROR_CODE_MESSSAGECODE,ex.getMessage());
		}
		if(!Optional.ofNullable(msg).isPresent() || msg.isEmpty() )
			msg = new ArrayList<MessageCode>();
		
		return msg;
	}

	@Override
	@Transactional(readOnly=true)
	public List<HeaderKey> getListOfHeaderKeys() throws ResourceNotFoundException {
		List<HeaderKey> headerKeys = null;
		try {
			headerKeys = refRepository.getListOfHeaderKeys();
		} catch (DataAccessException ex) {
			throw new ResourceNotFoundException(APIConstant.ERROR_CODE_MESSSAGECODE,ex.getMessage());
		}
		if(!Optional.ofNullable(headerKeys).isPresent() || headerKeys.isEmpty() )
			headerKeys = new ArrayList<HeaderKey>();
		
		return headerKeys;
	}

	@Override
	@Transactional(readOnly=true)
	public List<AuditFirm> getListOfAuditFirms() throws ResourceNotFoundException {
		List<AuditFirm> auditFirms = null;
		try {
			auditFirms = refRepository.getListOfAuditFirms();
		} catch (DataAccessException ex) {
			throw new ResourceNotFoundException(APIConstant.ERROR_CODE_MESSSAGECODE,ex.getMessage());
		}
		if(!Optional.ofNullable(auditFirms).isPresent() || auditFirms.isEmpty() )
			auditFirms = new ArrayList<AuditFirm>();
		
		return auditFirms;
	}

	@Override
	@Transactional(readOnly=true)
	public List<Banks> getListOfBanks() throws ResourceNotFoundException {
		List<Banks> banks = null;
		try {
			banks = refRepository.getListOfBanks();
		} catch (DataAccessException ex) {
			throw new ResourceNotFoundException(APIConstant.ERROR_CODE_MESSSAGECODE,ex.getMessage());
		}
		if(!Optional.ofNullable(banks).isPresent() || banks.isEmpty() )
			banks = new ArrayList<Banks>();
		
		return banks;
	}

	@Override
	public List<ClientGroup> getListOfClientGroup(Integer clientId) throws ResourceNotFoundException {
		List<ClientGroup> clientGroupList = null;
		try {
			clientGroupList = refRepository.getListOfClientGroup(clientId);
		} catch (DataAccessException ex) {
			throw new ResourceNotFoundException(APIConstant.ERROR_CODE_MESSSAGECODE,ex.getMessage());
		}
		if(!Optional.ofNullable(clientGroupList).isPresent() || clientGroupList.isEmpty() )
			clientGroupList = new ArrayList<ClientGroup>();
		
		return clientGroupList;
	}

	@Override
	public List<ClientType> getListOfClientType() throws ResourceNotFoundException {
		List<ClientType> clientTypeList = null;
		try {
			clientTypeList = refRepository.getListOfClientType();
		} catch (DataAccessException ex) {
			throw new ResourceNotFoundException(APIConstant.ERROR_CODE_MESSSAGECODE,ex.getMessage());
		}
		if(!Optional.ofNullable(clientTypeList).isPresent() || clientTypeList.isEmpty() )
			clientTypeList = new ArrayList<ClientType>();
		
		return clientTypeList;
	}

	@Override
	public List<HO> getListOfHO(Integer clientId) throws ResourceNotFoundException {
		List<HO> hoList = null;
		try {
			hoList = refRepository.getListOfHO(clientId);
		} catch (DataAccessException ex) {
			throw new ResourceNotFoundException(APIConstant.ERROR_CODE_MESSSAGECODE,ex.getMessage());
		}
		if(!Optional.ofNullable(hoList).isPresent() || hoList.isEmpty() )
			hoList = new ArrayList<HO>();
		
		return hoList;
	}

	@Override
	public List<CPC> getListOfCPC(Integer clientId, Integer zoId) throws ResourceNotFoundException {
		List<CPC> cpcList = null;
		try {
			cpcList = refRepository.getListOfCPC(clientId,zoId);
		} catch (DataAccessException ex) {
			throw new ResourceNotFoundException(APIConstant.ERROR_CODE_MESSSAGECODE,ex.getMessage());
		}
		if(!Optional.ofNullable(cpcList).isPresent() || cpcList.isEmpty() )
			cpcList = new ArrayList<CPC>();
		
		return cpcList;
	}

	@Override
	public List<ZO> getListOfZO(Integer clientId, Integer hoId) throws ResourceNotFoundException {
		List<ZO> zoList = null;
		try {
			zoList = refRepository.getListOfZO(clientId,hoId);
		} catch (DataAccessException ex) {
			throw new ResourceNotFoundException(APIConstant.ERROR_CODE_MESSSAGECODE,ex.getMessage());
		}
		if(!Optional.ofNullable(zoList).isPresent() || zoList.isEmpty() )
			zoList = new ArrayList<ZO>();
		
		return zoList;
	}

	@Override
	public List<UnitType> getListOfUnitTypes() throws ResourceNotFoundException {
		List<UnitType> unitTypeList = null;
		try {
			unitTypeList = refRepository.getListOfUnitTypes();
		} catch (DataAccessException ex) {
			throw new ResourceNotFoundException(APIConstant.ERROR_CODE_MESSSAGECODE,ex.getMessage());
		}
		if(!Optional.ofNullable(unitTypeList).isPresent() || unitTypeList.isEmpty() )
			unitTypeList = new ArrayList<UnitType>();
		
		return unitTypeList;
	}


}
