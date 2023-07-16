/**
 * 
 */
package com.bankMitra.service.admin.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankMitra.exception.APIException;
import com.bankMitra.exception.DataAccessException;
import com.bankMitra.exception.ResourceNotFoundException;
import com.bankMitra.model.admin.ClientAuditFirmBankRequest;
import com.bankMitra.model.admin.ClientConfigRequest;
import com.bankMitra.model.admin.ClientDeleteDueDeligenceRequest;
import com.bankMitra.model.admin.ClientDueDeligenceRequest;
import com.bankMitra.model.admin.ClientLoanSchemeRequest;
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
import com.bankMitra.model.reference.MessageCode;
import com.bankMitra.model.reference.SecurityQuestions;
import com.bankMitra.repository.admin.ClientConfigRepository;
import com.bankMitra.service.admin.ClientConfigService;
import com.bankMitra.service.reference.ReferenceService;
import com.bankMitra.util.APIConstant;

/**
 * @author bankMitra
 *
 */
@Service
public class ClientConfigServiceImpl implements ClientConfigService {

	@Autowired
	ClientConfigRepository clientConfigRepository;
	
	@Autowired
	ReferenceService refService;
	
	
	/* (non-Javadoc)
	 * @see com.bankMitra.service.admin.ClientConfigService#createClient(com.bankMitra.model.admin.ClientConfigRequest)
	 */
	@Override
	@Transactional
	public ClientConfigResponse createClient(@Valid ClientConfigRequest clientConfigRequest) throws APIException {
		ClientConfigResponse clientConfigResponse = null;
		try {
			clientConfigResponse  =  clientConfigRepository.createClient(clientConfigRequest);
			final String dbResponseCode = clientConfigResponse.getMessageCode();
			MessageCode filteredMsgData = getMessageDescription(dbResponseCode);
			if(null!=filteredMsgData){
				clientConfigResponse.setMessageCode(filteredMsgData.getMessageCode());
				clientConfigResponse.setMessageDescription(filteredMsgData.getMessageDescription());
			}
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_CREATE_SUBSCRIPTION_FAILURE);
		}
		return clientConfigResponse;
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.service.admin.ClientConfigService#addBankDetails(com.bankMitra.model.admin.BankDetails)
	 */
	@Override
	@Transactional
	public ClientConfigResponse addBankDetails(@Valid ClientAuditFirmBankRequest auditBankDetailRequest) throws APIException {
		ClientConfigResponse clientConfigResponse = null;
		try {
			clientConfigResponse  =  clientConfigRepository.addBankDetails(auditBankDetailRequest);
			final String dbResponseCode = clientConfigResponse.getMessageCode();
			MessageCode filteredMsgData = getMessageDescription(dbResponseCode);
			if(null!=filteredMsgData){
				clientConfigResponse.setMessageCode(filteredMsgData.getMessageCode());
				clientConfigResponse.setMessageDescription(filteredMsgData.getMessageDescription());
			}
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_ADD_BANK_FAILURE);
		}
		return clientConfigResponse;
	}

	/* (non-Javadoc)
	 * @see com.bankMitra.service.admin.ClientConfigService#createNewLoanScheme(com.bankMitra.model.admin.ClientLoanSchemeRequest)
	 */
	@Override
	@Transactional
	public ClientLoanSchemeResponse createNewLoanScheme(@Valid List<ClientLoanSchemeRequest> loanSchemeRequest,String userName)
			throws APIException {
		ClientLoanSchemeResponse clientLoanSchemeResponse = null;
		try {
			clientLoanSchemeResponse  =  clientConfigRepository.createClientLoanScheme(loanSchemeRequest,userName);
			final String dbResponseCode = clientLoanSchemeResponse.getMessageCode();
			MessageCode filteredMsgData = getMessageDescription(dbResponseCode);
			if(null!=filteredMsgData){
				clientLoanSchemeResponse.setMessageCode(filteredMsgData.getMessageCode());
				clientLoanSchemeResponse.setMessageDescription(filteredMsgData.getMessageDescription());
			}
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_CREATE_LOAN_SCHEME_FAILURE);
		}
		return clientLoanSchemeResponse;
	}

	@Override
	@Transactional
	public ClientLoanVariantResponse createNewLoanVariant(ClientConfigRequest loanVariantRequest,String userName) throws APIException {
		ClientLoanVariantResponse clientLoanVariantResponse = null;
		try {
			clientLoanVariantResponse  =  clientConfigRepository.createClientLoanVariant(loanVariantRequest,userName);
			final String dbResponseCode = clientLoanVariantResponse.getMessageCode();
			MessageCode filteredMsgData = getMessageDescription(dbResponseCode);
			if(null!=filteredMsgData){
				clientLoanVariantResponse.setMessageCode(filteredMsgData.getMessageCode());
				clientLoanVariantResponse.setMessageDescription(filteredMsgData.getMessageDescription());
			}
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_CREATE_LOAN_VARIANT_FAILURE);
		}
		return clientLoanVariantResponse;
	}
	
	private MessageCode getMessageDescription(String dbResponseCode) throws ResourceNotFoundException {
		MessageCode msgOutPut = null;
		List<MessageCode> msgCodes = refService.getListOfMessageCode();
		for(MessageCode msg : msgCodes) {
			if(msg.getMessageCode().equalsIgnoreCase(dbResponseCode)) {
				msgOutPut =  msg;
				break;
			}
		}
		return msgOutPut;
	}

	@Override
	@Transactional
	public ClientLoanSchemeResponse deleteClientLoanScheme(ClientLoanSchemeRequest loanSchemeRequest) throws APIException {
		ClientLoanSchemeResponse clientLoanSchemeResponse = null;
		try {
			clientLoanSchemeResponse  =  clientConfigRepository.deleteClientLoanScheme(loanSchemeRequest);
			final String dbResponseCode = clientLoanSchemeResponse.getMessageCode();
			MessageCode filteredMsgData = getMessageDescription(dbResponseCode);
			if(null!=filteredMsgData){
				clientLoanSchemeResponse.setMessageCode(filteredMsgData.getMessageCode());
				clientLoanSchemeResponse.setMessageDescription(filteredMsgData.getMessageDescription());
			}
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_DELETE_LOAN_SCHEME_FAILURE);
		}
		return clientLoanSchemeResponse;
	}

	@Override
	@Transactional
	public ClientLoanVariantResponse deleteLoanVariant(ClientConfigRequest loanVariantRequest) throws APIException {
		ClientLoanVariantResponse clientLoanVariantResponse = null;
		try {
			clientLoanVariantResponse  =  clientConfigRepository.deleteClientLoanVariant(loanVariantRequest);
			final String dbResponseCode = clientLoanVariantResponse.getMessageCode();
			MessageCode filteredMsgData = getMessageDescription(dbResponseCode);
			if(null!=filteredMsgData){
				clientLoanVariantResponse.setMessageCode(filteredMsgData.getMessageCode());
				clientLoanVariantResponse.setMessageDescription(filteredMsgData.getMessageDescription());
			}
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (ResourceNotFoundException e) {
			throw new APIException(APIConstant.MSG_DELETE_LOAN_VARIANT_FAILURE);
		}
		return clientLoanVariantResponse;
	}

	@Override
	@Transactional
	public ClientSubscriptionResponse updateClientSubscription(ClientSubscriptionRequest clientSubscriptionRequest)
			throws APIException {
		ClientSubscriptionResponse clientSubscriptionResponse = null;
		try {
			clientSubscriptionResponse  =  clientConfigRepository.updateClientSubscription(clientSubscriptionRequest);
			final String dbResponseCode = clientSubscriptionResponse.getMessageCode();
			MessageCode filteredMsgData = getMessageDescription(dbResponseCode);
			if(null!=filteredMsgData){
				clientSubscriptionResponse.setMessageCode(filteredMsgData.getMessageCode());
				clientSubscriptionResponse.setMessageDescription(filteredMsgData.getMessageDescription());
			}
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_UPDATE_CLIENT_SUBSCRIPTION_FAILURE);
		}
		return clientSubscriptionResponse;
	}

	@Override
	@Transactional
	public ClientSubscriptionResponse createClientSubscription(ClientNewSubscriptionRequest clientSubscriptionRequest)
			throws APIException {
		ClientSubscriptionResponse clientSubscriptionResponse = null;
		try {
			clientSubscriptionResponse  =  clientConfigRepository.createClientSubscription(clientSubscriptionRequest);
			final String dbResponseCode = clientSubscriptionResponse.getMessageCode();
			MessageCode filteredMsgData = getMessageDescription(dbResponseCode);
			if(null!=filteredMsgData){
				clientSubscriptionResponse.setMessageCode(filteredMsgData.getMessageCode());
				clientSubscriptionResponse.setMessageDescription(filteredMsgData.getMessageDescription());
			}
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (ResourceNotFoundException e) {
			throw new APIException(APIConstant.MSG_UPDATE_CLIENT_SUBSCRIPTION_FAILURE);
		}
		return clientSubscriptionResponse;
	}

	@Override
	@Transactional(readOnly=true)
	public List<ClientSubscriptionHistoryResponse> getClientSubscriptionHistory(String clientId) throws APIException {
		List<ClientSubscriptionHistoryResponse> listOfSubscription = null;
		try {
			listOfSubscription = clientConfigRepository.getClientSubscriptionHistory(clientId);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_CLIENT_SUBSCRIPTION_HISTORY_FAILURE);
		}
		return listOfSubscription;
	}

	@Override
	@Transactional(readOnly=true)
	public List<ClientResponse> getListOfClients(ClientConfigRequest clientConfigRequest) throws APIException {
		List<ClientResponse> listOfClients = null;
		try {
			listOfClients = clientConfigRepository.getListOfClients(clientConfigRequest);
		} catch (DataAccessException e) {
			throw new APIException(APIConstant.MSG_GET_CLIENT_LIST_FAILURE,e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_CLIENT_LIST_FAILURE,e.getMessage());
		}
		return listOfClients;
	}

	@Override
	@Transactional(readOnly=true)
	public List<ClientLoanSchemeResponse> getListOfLoanSchemes(ClientLoanSchemeRequest loanSchemeRequest)
			throws APIException {
		List<ClientLoanSchemeResponse> listOfLoanSchemes = null;
		try {
			listOfLoanSchemes = clientConfigRepository.getListOfLoanSchemes(loanSchemeRequest);
		} catch (DataAccessException e) {
			throw new APIException(APIConstant.MSG_GET_GET_LOAN_SCHEMES_FAILURE,e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_GET_LOAN_SCHEMES_FAILURE,e.getMessage());
		}
		return listOfLoanSchemes;
	}

	@Override
	@Transactional(readOnly=true)
	public ClientSubscriptionResponse getClientSubscription(String clientId) throws APIException {
		ClientSubscriptionResponse clienSubscriptionDetails = null;
		try {
			clienSubscriptionDetails = clientConfigRepository.getClientSubscription(clientId);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_CLIENT_SUBSCRIPTION_FAILURE,e.getMessage());
		}
		return clienSubscriptionDetails;
	}

	@Override
	@Transactional(readOnly=true)
	public List<ClientCustomizeTemplateResponse> getClientCustomizeTemplate(Integer clientId,Integer clientTypeId) throws APIException {
		List<ClientCustomizeTemplateResponse> clientCustomizeTemplateList = null;
		try {
			clientCustomizeTemplateList = clientConfigRepository.getClientCustomizeTemplate(clientId,clientTypeId);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_GET_CLIENT_TEMPLATE_FAILURE);
		}
		return clientCustomizeTemplateList;
	}

	@Override
	@Transactional
	public ClientCustomizeTemplateResponse createNewClientTemplate(ClientTemplateRequest clientTemplateRequest)
			throws APIException {
		ClientCustomizeTemplateResponse clientCustomizeTemplateResponse = null;
		try {
			clientCustomizeTemplateResponse  =  clientConfigRepository.createNewClientTemplate(clientTemplateRequest);
			final String dbResponseCode = clientCustomizeTemplateResponse.getMessageCode();
			MessageCode filteredMsgData = getMessageDescription(dbResponseCode);
			if(null!=filteredMsgData){
				clientCustomizeTemplateResponse.setMessageCode(filteredMsgData.getMessageCode());
				clientCustomizeTemplateResponse.setMessageDescription(filteredMsgData.getMessageDescription());
			}
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_CREATE_CLIENT_NEWVERSION_TEMPLATE_FAILURE);
		}
		return clientCustomizeTemplateResponse;
	}

	@Override
	@Transactional(readOnly=true)
	public List<ClientModuleHeaderResponse> getClientModuleHeader(Integer ddId,String moduleName) throws APIException {
		List<ClientModuleHeaderResponse> clientModuleHeaderList = null;
		List<ClientModuleHeaderResponse> clientModuleHeaderMapList = new ArrayList<ClientModuleHeaderResponse>();
		Map<String,String> headerMap = new LinkedHashMap<String,String>();
		ClientModuleHeaderResponse headerResp = new ClientModuleHeaderResponse();
		try {
			clientModuleHeaderList = clientConfigRepository.getClientModuleHeader(ddId,moduleName);
			for(ClientModuleHeaderResponse resp :clientModuleHeaderList) {
				String header1Desc = resp.getHeader1Description()!=null?resp.getHeader1Description()+" ":"";
				String header2Desc = resp.getHeader2Description()!=null?resp.getHeader2Description()+" ":"";
				String header3Desc = resp.getHeader3Description()!=null?resp.getHeader3Description()+" ":"";
				String header4Desc = resp.getHeader4Description()!=null?resp.getHeader4Description():"";
				headerMap.put(resp.getDdSequence()+"_"+ddId+"_"+resp.getHeader1()+"_"+resp.getHeader2()+"_"+resp.getHeader3()+"_"+resp.getHeader4(),
						header1Desc+header2Desc+header3Desc+header4Desc);
				headerResp.setHeaderMap(headerMap);
				headerResp.setDdSequence(resp.getDdSequence());
				headerResp.setDdId(ddId);
				clientModuleHeaderMapList.add(headerResp);
			}
			
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_GET_CLIENT_MODULE_HEADER_FAILURE);
		}
		return clientModuleHeaderMapList;
	}

	@Override
	@Transactional(readOnly=true)
	public List<ClientDueDeligenceResponse> getClientDueDeligence(ClientDueDeligenceRequest clientDueDeligenceRequest) throws APIException {
		List<ClientDueDeligenceResponse> clientDueDeligence = null;
		try {
			clientDueDeligence = clientConfigRepository.getClientDueDeligence(clientDueDeligenceRequest);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_GET_CLIENT_DUEDELIGENCE_FAILURE);
		}
		return clientDueDeligence;
	}

	@Override
	@Transactional
	public ClientDueDeligenceResponse saveClientDueDeligence(ClientDueDeligenceRequest clientDueDeligenceRequest)
			throws APIException {
		ClientDueDeligenceResponse clientDueDeligenceResponse = null;
		try {
			clientDueDeligenceResponse  =  clientConfigRepository.saveClientDueDeligence(clientDueDeligenceRequest);
			final String dbResponseCode = clientDueDeligenceResponse.getMessageCode();
			MessageCode filteredMsgData = getMessageDescription(dbResponseCode);
			if(null!=filteredMsgData){
				clientDueDeligenceResponse.setMessageCode(filteredMsgData.getMessageCode());
				clientDueDeligenceResponse.setMessageDescription(filteredMsgData.getMessageDescription());
			}
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (ResourceNotFoundException e) {
			throw new APIException(APIConstant.MSG_UPDATE_CLIENT_DUE_DELIGENCE);
		}
		return clientDueDeligenceResponse;
	}

	@Override
	@Transactional(readOnly=true)
	public ClientResponse getClientInformation(ClientConfigRequest clientConfigRequest) throws APIException {
		ClientResponse clientDetails = null;
		try {
			clientDetails = clientConfigRepository.getClientInformation(clientConfigRequest);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_GET_CLIENT_DETAIL_FAILURE);
		}
		return clientDetails;
	}

	@Override
	@Transactional(readOnly=true)
	public List<ClientBankResponse> getBankDetails(ClientConfigRequest clientConfigRequest) throws APIException {
		List<ClientBankResponse> clientBankDetails = null;
		try {
			clientBankDetails = clientConfigRepository.getBankDetails(clientConfigRequest);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_GET_CLIENT_BANK_DETAIL_FAILURE);
		}
		return clientBankDetails;
	}

	@Override
	@Transactional(readOnly=true)
	public List<ClientLoanVariantResponse> getClientLoanVariant(ClientConfigRequest clientConfigRequest)
			throws APIException {
		List<ClientLoanVariantResponse> clientLoanVariantDetails = null;
		try {
			clientLoanVariantDetails = clientConfigRepository.getClientLoanVariant(clientConfigRequest);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_GET_CLIENT_LOAN_VARIANT_FAILURE);
		}
		return clientLoanVariantDetails;
	}

	@Override
	@Transactional(readOnly=true)
	public List<RegistrationClientResponse> getListOfClientByClientTypeId(ClientConfigRequest clientConfigRequest)
			throws APIException {
		List<RegistrationClientResponse> listOfClients = null;
		try {
			listOfClients = clientConfigRepository.getListOfClientByClientTypeId(clientConfigRequest);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_CLIENT_LIST_FAILURE);
		}
		return listOfClients;
	}

	@Override
	@Transactional
	public ClientDueDeligenceResponse deleteDueDeligence(ClientDeleteDueDeligenceRequest dueDeligenceRequest)
			throws APIException {
		ClientDueDeligenceResponse clientDueDeligenceResponse = null;
		try {
			int deleteStatus = clientConfigRepository.deleteDueDeligence(dueDeligenceRequest);
			
			if(deleteStatus >0){
				clientDueDeligenceResponse = new ClientDueDeligenceResponse();
				clientDueDeligenceResponse.setMessageCode(APIConstant.SUCCESS_CODE);
				clientDueDeligenceResponse.setMessageDescription(APIConstant.SUCCESS_CODE);
			}
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_DELETE_DUE_DELIGENCE_FAILURE);
		}
		return clientDueDeligenceResponse;
	}

	@Override
	@Transactional(readOnly=true)
	public Long getNewDueDeligence(Integer ddId) throws APIException {
		Long ddSequence = null;
		try {
			ddSequence = clientConfigRepository.getNewClientDueDeligence(ddId);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_NEW_DUE_DELIGENCE_FAILURE);
		}
		return ddSequence;
	}

	@Override
	@Transactional
	public ClientBankResponse deleteClientBank(DeleteBankDetails bankRequest) throws APIException {
		ClientBankResponse deleteBankResponse = null;
		try {
			deleteBankResponse  =  clientConfigRepository.deleteClientBank(bankRequest);
			final String dbResponseCode = deleteBankResponse.getMessageCode();
			MessageCode filteredMsgData = getMessageDescription(dbResponseCode);
			if(null!=filteredMsgData){
				deleteBankResponse.setMessageCode(filteredMsgData.getMessageCode());
				deleteBankResponse.setMessageDescription(filteredMsgData.getMessageDescription());
			}
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_DELETE_BANK_FAILURE);
		}
		return deleteBankResponse;
	}

	
	@Override
	@Transactional(readOnly=true)
	public List<ActiveClient> getListOfActiveClients() throws APIException {
		List<ActiveClient> activeCLientList = null;
		try {
			activeCLientList = clientConfigRepository.getListOfActiveClients();
		} catch (DataAccessException ex) {
			throw new APIException(ex.getMessage());
		}
		if(!Optional.ofNullable(activeCLientList).isPresent() || activeCLientList.isEmpty() )
			activeCLientList = new ArrayList<ActiveClient>();
		
		return activeCLientList;
	}

}
