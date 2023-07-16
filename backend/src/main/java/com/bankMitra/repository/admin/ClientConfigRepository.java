/**
 * 
 */
package com.bankMitra.repository.admin;

import java.util.List;

import javax.validation.Valid;

import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.admin.ClientAuditFirmBankRequest;
import com.bankMitra.model.admin.ClientConfigRequest;
import com.bankMitra.model.admin.ClientDeleteDueDeligenceRequest;
import com.bankMitra.model.admin.ClientDueDeligenceRequest;
import com.bankMitra.model.admin.ClientLoanSchemeRequest;
import com.bankMitra.model.admin.ClientLoanVariantRequest;
import com.bankMitra.model.admin.ClientNewSubscriptionRequest;
import com.bankMitra.model.admin.ClientSubscriptionRequest;
import com.bankMitra.model.admin.ClientTemplateRequest;
import com.bankMitra.model.admin.DeleteBankDetails;
import com.bankMitra.model.admin.response.ActiveClient;
import com.bankMitra.model.admin.response.ClientBankResponse;
import com.bankMitra.model.admin.response.ClientConfigResponse;
import com.bankMitra.model.admin.response.ClientCustomizeTemplateResponse;
import com.bankMitra.model.admin.response.ClientDueDeligenceResponse;
import com.bankMitra.model.admin.response.ClientLoanSchemeResponse;
import com.bankMitra.model.admin.response.ClientLoanVariantResponse;
import com.bankMitra.model.admin.response.ClientModuleHeaderResponse;
import com.bankMitra.model.admin.response.ClientResponse;
import com.bankMitra.model.admin.response.ClientSubscriptionHistoryResponse;
import com.bankMitra.model.admin.response.ClientSubscriptionResponse;
import com.bankMitra.model.admin.response.RegistrationClientResponse;

/**
 * @author BankMitra
 *
 */
public interface ClientConfigRepository {

	ClientConfigResponse createClient(@Valid ClientConfigRequest clientConfigRequest) throws DataAccessException;

	ClientLoanSchemeResponse createClientLoanScheme(@Valid List<ClientLoanSchemeRequest> loanSchemeRequest, String userName)  throws DataAccessException;

	ClientLoanSchemeResponse deleteClientLoanScheme(ClientLoanSchemeRequest loanSchemeRequest) throws DataAccessException;

	ClientLoanVariantResponse createClientLoanVariant(ClientConfigRequest loanVariantRequest,
			String userName) throws DataAccessException;

	ClientLoanVariantResponse deleteClientLoanVariant(ClientConfigRequest loanVariantRequest) throws DataAccessException;

	ClientSubscriptionResponse updateClientSubscription(ClientSubscriptionRequest clientSubscriptionRequest) throws DataAccessException;

	ClientSubscriptionResponse createClientSubscription(ClientNewSubscriptionRequest clientSubscriptionRequest) throws DataAccessException;

	List<ClientSubscriptionHistoryResponse> getClientSubscriptionHistory(String clientId) throws DataAccessException;

	List<ClientResponse> getListOfClients(ClientConfigRequest clientConfigRequest) throws DataAccessException;

	List<ClientLoanSchemeResponse> getListOfLoanSchemes(ClientLoanSchemeRequest loanSchemeRequest) throws DataAccessException;

	ClientSubscriptionResponse getClientSubscription(String clientId) throws DataAccessException;

	List<ClientCustomizeTemplateResponse> getClientCustomizeTemplate(Integer clientId, Integer clientTypeId) throws DataAccessException;

	ClientCustomizeTemplateResponse createNewClientTemplate(ClientTemplateRequest clientTemplateRequest) throws DataAccessException;

	List<ClientModuleHeaderResponse> getClientModuleHeader(Integer ddId,String moduleName) throws DataAccessException;

	List<ClientDueDeligenceResponse> getClientDueDeligence(ClientDueDeligenceRequest clientDueDeligenceRequest) throws DataAccessException;

	ClientDueDeligenceResponse saveClientDueDeligence(ClientDueDeligenceRequest clientDueDeligenceRequest) throws DataAccessException;

	ClientConfigResponse addBankDetails(ClientAuditFirmBankRequest auditBankDetailRequest) throws DataAccessException;

	ClientResponse getClientInformation(ClientConfigRequest clientConfigRequest) throws DataAccessException;

	List<ClientBankResponse> getBankDetails(ClientConfigRequest clientConfigRequest) throws DataAccessException;

	List<ClientLoanVariantResponse> getClientLoanVariant(ClientConfigRequest clientConfigRequest) throws DataAccessException;

	List<RegistrationClientResponse> getListOfClientByClientTypeId(ClientConfigRequest clientConfigRequest) throws DataAccessException;

	int deleteDueDeligence(ClientDeleteDueDeligenceRequest dueDeligenceRequest) throws DataAccessException;

	Long getNewClientDueDeligence(Integer ddId) throws DataAccessException;

	public ClientBankResponse deleteClientBank(DeleteBankDetails bankRequest) throws DataAccessException;

	List<ActiveClient> getListOfActiveClients() throws DataAccessException;

}
