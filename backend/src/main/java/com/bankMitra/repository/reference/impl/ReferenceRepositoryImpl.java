/**
 * 
 */
package com.bankMitra.repository.reference.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
import com.bankMitra.util.APIConstant;

/**
 * @author BankMitra
 *
 */
@Repository
public class ReferenceRepositoryImpl implements ReferenceRepository {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	private static final String GET_CLIENTTYPE_LIST = "SELECT client_type_id, client_name FROM bmadmin.bmclienttype ORDER BY client_type_id ASC";
	
	private static final String GET_SECURITYQUESTION_LIST = "select security_question_id,security_question from bmadmin.bmsecurityquestions";
	
	private static final String GET_LANGUAGE_LIST = "select language_id,language_name from bmadmin.bmlanguage";
	
	private static final String GET_RISKTYPE_LIST = "select risk_type_id,risk_type_name from bmadmin.bmrisktype";

	private static final String GET_APLLICATIONTYPE_LIST = "select applicant_type_id,applicant_type from bmadmin.bmapplicanttype";

	private static final String GET_BORROWERTYPE_LIST = "select borrower_type_id,borrower_type_name from bmadmin.bmborrowertype";

	private static final String GET_CREDITSECTOR_LIST = "select credit_sector_id,client_sector_desc from bmadmin.bmcreditsectortype;";

	private static final String GET_PROFESSION_LIST = "select profession_id,profession_name from bmadmin.bmprofession";

	private static final String GET_ROLES_LIST = "select user_role_id,client_type_id,user_role_name from bmadmin.bmuserroles where client_type_id = ? order by user_role_name";
	
	private static final String GET_HO_LIST = "Select client_group_id,client_id,client_group_name from bmadmin.bmclientgroup where client_group_type_id in (1) and client_id = ?";
	
	private static final String GET_ZO_LIST = "Select client_group_id,client_id,client_group_name from bmadmin.bmclientgroup where client_group_type_id in (2) and client_id = ? and ho_client_group_id = ?";
	
	private static final String GET_CPC_LIST = "Select client_group_id,client_id,client_group_name from bmadmin.bmclientgroup where client_group_type_id in (3) and client_id = ? and zo_client_group_id = ?";

	private static final String GET_SUBSCRIPTIONTYPE_LIST = "select subscription_type_id,subscription_type from bmadmin.bmsubscriptiontype where product_id = ?";

	private static final String GET_SUBSCRIPTIONSUBTYPE_LIST = "select subscription_type_id,subscription_sub_type_id,subscription_sub_type_name from bmadmin.bmsubscriptionsubtype where subscription_type_id = ?";

	private static final String GET_SECURITYTYPE_LIST = "select security_type_id,security_type_name from bmadmin.bmsecuritytype";
	
	private static final String GET_MESSAGECODE_LIST = "select return_code,message from bmadmin.bmmessage";

	private static final String GET_HEADERKEY_LIST = null;

	private static final String GET_AUDITFIRM_LIST = "select client_id,client_name from  bmadmin.bmclient "
			+ "where client_type_id = (select client_type_id from bmadmin.bmclienttype where upper(client_name) ='AUDIT FIRM')";

	private static final String GET_BANK_LIST = "select client_id,client_name from   bmadmin.bmclient "
			+ "where client_type_id = (select client_type_id from bmadmin.bmclienttype where upper(client_name) ='BANK')";

	private static final String GET_CLIENTGROUP_LIST = "SELECT client_group_id,client_id,client_group_type_id,client_group_name "
			+ " FROM bmadmin.bmclientgroup where client_id = ? order by client_group_name";
	
	/* (non-Javadoc)
	 * @see com.bankMitra.repository.reference.ReferenceRepository#getListOfSecurityQuestions()
	 */
	@Override
	public List<SecurityQuestions> getListOfSecurityQuestions() {
		return jdbcTemplate.query(GET_SECURITYQUESTION_LIST,new SecurityQuestionRowMapper());
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.repository.reference.ReferenceRepository#getListOfLanguages()
	 */
	@Override
	public List<Language> getListOfLanguages() {
		return jdbcTemplate.query(GET_LANGUAGE_LIST,new LanguageRowMapper());
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.repository.reference.ReferenceRepository#getListOfRiskTypes()
	 */
	@Override
	public List<RiskType> getListOfRiskTypes() {
		return jdbcTemplate.query(GET_RISKTYPE_LIST,new RiskTypeRowMapper());
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.repository.reference.ReferenceRepository#getListOfApplicantTypes()
	 */
	@Override
	public List<ApplicantType> getListOfApplicantTypes() {
		return jdbcTemplate.query(GET_APLLICATIONTYPE_LIST,new ApplicationTypeRowMapper());
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.repository.reference.ReferenceRepository#getListOfBorrowerTypes()
	 */
	@Override
	public List<BorrowerType> getListOfBorrowerTypes() {
		return jdbcTemplate.query(GET_BORROWERTYPE_LIST,new BorrowerTypeRowMapper());
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.repository.reference.ReferenceRepository#getListOfCreditScoreTypes()
	 */
	@Override
	public List<CreditSector> getListOfCreditScoreTypes() {
		return jdbcTemplate.query(GET_CREDITSECTOR_LIST,new CreditScoreTypeRowMapper());
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.repository.reference.ReferenceRepository#getListOfProfessions()
	 */
	@Override
	public List<Profession> getListOfProfessions() {
		return jdbcTemplate.query(GET_PROFESSION_LIST,new ProfessionRowMapper());
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.repository.reference.ReferenceRepository#getListOfRoles()
	 */
	@Override
	public List<UserRoles> getListOfRoles(Integer clientTypeId) {
		return jdbcTemplate.query(GET_ROLES_LIST,new Object[]{clientTypeId},new RoleRowMapper());
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.repository.reference.ReferenceRepository#getListOfSubscriptionTypes()
	 */
	@Override
	public List<SubscriptionType> getListOfSubscriptionTypes(Integer productTypeId) {
		return jdbcTemplate.query(GET_SUBSCRIPTIONTYPE_LIST,new Object[]{productTypeId},new SubscriptionTypeRowMapper());
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.repository.reference.ReferenceRepository#getListOfSubscriptionSubTypes()
	 */
	@Override
	public List<SubscriptionSubType> getListOfSubscriptionSubTypes(Integer subscriptionType) {
		return jdbcTemplate.query(GET_SUBSCRIPTIONSUBTYPE_LIST,new Object[]{subscriptionType},new SubsciptionSubTypeRowMapper());
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.repository.reference.ReferenceRepository#getListOfSecurityTypes()
	 */
	@Override
	public List<SecurityType> getListOfSecurityTypes() {
		return jdbcTemplate.query(GET_SECURITYTYPE_LIST,new SecurityTypeRowMapper());
	}

	@Override
	public List<MessageCode> getListOfMessageCode() {
		return jdbcTemplate.query(GET_MESSAGECODE_LIST,new MessageRowMapper());
	}

	@Override
	public List<HeaderKey> getListOfHeaderKeys() {
		return jdbcTemplate.query(GET_HEADERKEY_LIST,new HeaderKeyRowMapper());
	}

	@Override
	public List<AuditFirm> getListOfAuditFirms() {
		return jdbcTemplate.query(GET_AUDITFIRM_LIST,new AuditFirmRowMapper());
	}

	@Override
	public List<Banks> getListOfBanks() {
		return jdbcTemplate.query(GET_BANK_LIST,new BankRowMapper());
	}

	@Override
	public List<ClientGroup> getListOfClientGroup(Integer clientId) {
		return jdbcTemplate.query(GET_CLIENTGROUP_LIST,
				new Object[]{clientId},new ClientGroupRowMapper());
	}

	@Override
	public List<ClientType> getListOfClientType() {
		return jdbcTemplate.query(GET_CLIENTTYPE_LIST,new ClientTypeRowMapper());
	}

	@Override
	public List<HO> getListOfHO(Integer clientId) {
		return jdbcTemplate.query(GET_HO_LIST,new Object[]{clientId},new HoRowMapper());
	}

	@Override
	public List<ZO> getListOfZO(Integer clientId, Integer hoId) {
		return jdbcTemplate.query(GET_ZO_LIST,new Object[]{clientId,hoId},new ZoRowMapper());
	}
	
	@Override
	public List<CPC> getListOfCPC(Integer clientId, Integer zoId) {
		return jdbcTemplate.query(GET_CPC_LIST,new Object[]{clientId,zoId},new CPCRowMapper());
	}

	@Override
	public List<UnitType> getListOfUnitTypes() {
		return jdbcTemplate.query(APIConstant.QUERY_GET_UNIT_TYPES,new UnitTypeRowMapper());
	}
}
