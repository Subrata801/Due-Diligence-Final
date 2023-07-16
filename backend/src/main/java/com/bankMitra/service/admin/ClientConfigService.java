/**
 * 
 */
package com.bankMitra.service.admin;

import java.util.List;

import javax.validation.Valid;

import com.bankMitra.exception.APIException;
import com.bankMitra.model.admin.BankDetails;
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
public interface ClientConfigService {

	ClientConfigResponse createClient(@Valid ClientConfigRequest clientConfigRequest) throws APIException;

	ClientConfigResponse addBankDetails(@Valid ClientAuditFirmBankRequest auditBankDetailRequest) throws APIException;

	ClientLoanSchemeResponse createNewLoanScheme(@Valid List<ClientLoanSchemeRequest> loanSchemeRequest, String userName) throws APIException;

	ClientLoanSchemeResponse deleteClientLoanScheme(@Valid ClientLoanSchemeRequest loanSchemeRequest) throws APIException;

	ClientLoanVariantResponse deleteLoanVariant(@Valid ClientConfigRequest loanVariantRequest) throws APIException;

	ClientSubscriptionResponse updateClientSubscription(@Valid ClientSubscriptionRequest clientSubscriptionRequest)  throws APIException;

	ClientSubscriptionResponse createClientSubscription(@Valid ClientNewSubscriptionRequest clientSubscriptionRequest) throws APIException;

	List<ClientSubscriptionHistoryResponse> getClientSubscriptionHistory(String clientId) throws APIException;

	List<ClientResponse> getListOfClients(@Valid ClientConfigRequest clientConfigRequest) throws APIException;

	List<ClientLoanSchemeResponse> getListOfLoanSchemes(@Valid ClientLoanSchemeRequest loanSchemeRequest) throws APIException;

	ClientSubscriptionResponse getClientSubscription(String clientId) throws APIException;

	List<ClientCustomizeTemplateResponse> getClientCustomizeTemplate(Integer clientId, Integer clientTypeId) throws APIException;

	ClientCustomizeTemplateResponse createNewClientTemplate(@Valid ClientTemplateRequest clientTemplateRequest) throws APIException;

	List<ClientModuleHeaderResponse> getClientModuleHeader(Integer ddId, String moduleName) throws APIException;

	List<ClientDueDeligenceResponse> getClientDueDeligence(ClientDueDeligenceRequest clientDueDeligenceRequest) throws APIException;

	ClientDueDeligenceResponse saveClientDueDeligence(ClientDueDeligenceRequest clientDueDeligenceRequest) throws APIException;

	ClientLoanVariantResponse createNewLoanVariant(ClientConfigRequest loanVariantRequest, String userName)
			throws APIException;

	ClientResponse getClientInformation(@Valid ClientConfigRequest clientConfigRequest) throws APIException;

	List<ClientBankResponse> getBankDetails(@Valid ClientConfigRequest clientConfigRequest) throws APIException;

	List<ClientLoanVariantResponse> getClientLoanVariant(@Valid ClientConfigRequest clientConfigRequest)  throws APIException;

	List<RegistrationClientResponse> getListOfClientByClientTypeId(@Valid ClientConfigRequest clientConfigRequest)  throws APIException;

	ClientDueDeligenceResponse deleteDueDeligence(@Valid ClientDeleteDueDeligenceRequest dueDeligenceRequest)  throws APIException;

	Long getNewDueDeligence(Integer ddId) throws APIException;

	ClientBankResponse deleteClientBank(@Valid DeleteBankDetails bankRequest) throws APIException;

	List<ActiveClient> getListOfActiveClients() throws APIException;

	
}
