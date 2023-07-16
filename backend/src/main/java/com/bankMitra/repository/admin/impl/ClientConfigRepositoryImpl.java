/**
 * 
 */
package com.bankMitra.repository.admin.impl;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.bankMitra.exception.APIException;
import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.admin.Address;
import com.bankMitra.model.admin.BankDetails;
import com.bankMitra.model.admin.ClientAuditFirmBankRequest;
import com.bankMitra.model.admin.ClientConfigRequest;
import com.bankMitra.model.admin.ClientDeleteDueDeligenceRequest;
import com.bankMitra.model.admin.ClientDueDeligenceArray;
import com.bankMitra.model.admin.ClientDueDeligenceRequest;
import com.bankMitra.model.admin.ClientLoanSchemeRequest;
import com.bankMitra.model.admin.ClientLoanVariantRequest;
import com.bankMitra.model.admin.ClientNewSubscriptionRequest;
import com.bankMitra.model.admin.ClientSubscriptionRequest;
import com.bankMitra.model.admin.ClientTemplateRequest;
import com.bankMitra.model.admin.Contact;
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
import com.bankMitra.model.admin.response.SubscriptionModelResponse;
import com.bankMitra.model.user.User;
import com.bankMitra.repository.admin.ClientConfigRepository;
import com.bankMitra.repository.admin.rowmapper.ActiveClientRowMapper;
import com.bankMitra.repository.admin.rowmapper.ClientBankRowMapper;
import com.bankMitra.repository.admin.rowmapper.ClientBasicSubscriptionRowMapper;
import com.bankMitra.repository.admin.rowmapper.ClientConfigRowMapper;
import com.bankMitra.repository.admin.rowmapper.ClientCustomizeTemplateRowMapper;
import com.bankMitra.repository.admin.rowmapper.ClientDueDeligenceRowMapper;
import com.bankMitra.repository.admin.rowmapper.ClientInfoRowMapper;
import com.bankMitra.repository.admin.rowmapper.ClientListRowMapper;
import com.bankMitra.repository.admin.rowmapper.ClientModuleHeaderRowMapper;
import com.bankMitra.repository.admin.rowmapper.ClientRowMapper;
import com.bankMitra.repository.admin.rowmapper.ClientSubscriptionHistoryRowMapper;
import com.bankMitra.repository.admin.rowmapper.ClientSubscriptionRowMapper;
import com.bankMitra.repository.admin.rowmapper.ExistingClientLoanSchemeRowMapper;
import com.bankMitra.repository.admin.rowmapper.ExistingClientLoanVariantRowMapper;
import com.bankMitra.repository.admin.rowmapper.SubscriptionRowMapper;
import com.bankMitra.repository.reference.impl.SecurityQuestionRowMapper;
import com.bankMitra.util.APIConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author BankMitra
 *
 */
@Repository
public class ClientConfigRepositoryImpl implements ClientConfigRepository {

	private static final Logger logger = LoggerFactory.getLogger(ClientConfigRepositoryImpl.class);
	
	@Autowired
    private JdbcTemplate jdbcTemplate;


	@Override
	public ClientConfigResponse createClient(ClientConfigRequest clientConfigRequest) throws DataAccessException {
		ClientConfigResponse clientConfigResponse = null;
		Connection connection = null;
		String functionResult = null; 
		CallableStatement cs = null;
		try {
			String runFunction = "{ call bmadmin.funccreateclientbasic1(?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
			connection = jdbcTemplate.getDataSource().getConnection();
			cs = connection.prepareCall(runFunction);
			
			cs.setString(1, clientConfigRequest.getCreatedBy());
			if(clientConfigRequest.getClientId()>0)
				cs.setInt(2, clientConfigRequest.getClientId());
			else
				cs.setInt(2, -1);
			cs.setInt(3, clientConfigRequest.getClientTypeId());
			if(!StringUtils.isEmpty(clientConfigRequest.getLanguageId()))
				cs.setInt(4, clientConfigRequest.getLanguageId());
			else 
				cs.setInt(4, 0);
			cs.setString(5, clientConfigRequest.getClientName());
			cs.setString(6, clientConfigRequest.getClientPrefix());
			cs.setString(7, clientConfigRequest.getGstNum());
			
			int i = 0;
			if(null!=clientConfigRequest.getAddressInfo() && clientConfigRequest.getAddressInfo().size()>0) {
				String[] arrAddress =  new String[clientConfigRequest.getAddressInfo().size()];
				for(Address arr: clientConfigRequest.getAddressInfo()) {
					if(!StringUtils.isEmpty(arr.getPincode())) {
						String inputData = "("+"\""+arr.getAddress()+"\","
				        		+"\""+arr.getCity()+"\","
								+arr.getPincode()+","
								+arr.getState()+")";
						arrAddress[i] = inputData;
					} else {
						String inputData = "("+"\""+arr.getAddress()+"\","
				        		+"\""+arr.getCity()+"\","
								+0+","
								+arr.getState()+")";
						arrAddress[i] = inputData;
					}
					i++;
				}
				
				cs.setArray(8,connection.createArrayOf("bmadmin.obj_address",arrAddress));
			} else {
				cs.setArray(8,connection.createArrayOf("bmadmin.obj_address",new String[]{}));
			}
			int j = 0;
			if(null!=clientConfigRequest.getPrimaryContactInfo() && clientConfigRequest.getPrimaryContactInfo().size()>0) {
				String[] arrPrimaryContact =  new String[clientConfigRequest.getPrimaryContactInfo().size()];
				for(Contact arr: clientConfigRequest.getPrimaryContactInfo()) {
					if(!StringUtils.isEmpty(arr.getMobileNum())) {
						String inputData = "("+"\""+arr.getPointOfContact()+"\","
				        		+"\""+arr.getDesignation()+"\","
								+arr.getMobileNum()+","
								+arr.getOfficialEmailId()+")";
						arrPrimaryContact[j] = inputData;
					} else {
						String inputData = "("+"\""+arr.getPointOfContact()+"\","
				        		+"\""+arr.getDesignation()+"\","
								+0+","
								+arr.getOfficialEmailId()+")";
						arrPrimaryContact[j] = inputData;
					}
					j++;
				}
				
				cs.setArray(9,connection.createArrayOf(  
					      "bmadmin.obj_poc",arrPrimaryContact));
			} else {
				cs.setArray(9,connection.createArrayOf(  
					      "bmadmin.obj_poc",new String[]{}));
			}
			int k = 0;
			if(null!=clientConfigRequest.getSecondaryContactInfo() && clientConfigRequest.getSecondaryContactInfo().size()>0) {
				String[] arrSecondaryContact =  new String[clientConfigRequest.getSecondaryContactInfo().size()];
				for(Contact arr: clientConfigRequest.getSecondaryContactInfo()) {
					if(!StringUtils.isEmpty(arr.getMobileNum())) {
						String inputData = "("+"\""+arr.getPointOfContact()+"\","
				        		+"\""+arr.getDesignation()+"\","
								+arr.getMobileNum()+","
								+arr.getOfficialEmailId()+")";
						arrSecondaryContact[k] = inputData;
					} else {
						String inputData = "("+"\""+arr.getPointOfContact()+"\","
				        		+"\""+arr.getDesignation()+"\","
								+0+","
								+arr.getOfficialEmailId()+")";
						arrSecondaryContact[k] = inputData;
					}
					k++;
				}
				cs.setArray(10,connection.createArrayOf(  
					      "bmadmin.obj_poc",arrSecondaryContact));
			} else {
				cs.setArray(10,connection.createArrayOf(  
					      "bmadmin.obj_poc",new String[]{}));
			}
			cs.setString(11, clientConfigRequest.getClientLogoPath());
			if(null!=clientConfigRequest.getRiskTypeId())
				cs.setInt(12, Integer.parseInt(clientConfigRequest.getRiskTypeId()));
			else 
				cs.setInt(12, 0);
			cs.registerOutParameter(13, Types.INTEGER);
			cs.registerOutParameter(14, Types.VARCHAR);
			cs.executeUpdate();
			int clientId = cs.getInt(13);
			functionResult = cs.getString(14);
			logger.info("Client id returned after execution of function :",clientId);
			logger.info("Function result code returned after execution of function :",functionResult);
			clientConfigResponse = new ClientConfigResponse();
			clientConfigResponse.setMessageCode(functionResult);
			if(functionResult.equalsIgnoreCase(APIConstant.SUCCESS_CODE)) {
					List<ClientConfigResponse> clientReponse = getLatestClientId();
					clientConfigResponse.setClientId(clientReponse.get(0).getClientId());
			}
			return clientConfigResponse;
		} catch (SQLException e) {
			logger.error("unable to execute the function funccreateclientbasic",e);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} catch (Exception e) {
			logger.error("unable to execute the function funccreateclientbasic",e);
			throw new DataAccessException(APIConstant.MSG_CREATE_SUBSCRIPTION_FAILURE);
		} finally {
			try {
				if(null!= cs)
					cs.close();
				if(null!=connection)
					connection.close();
			} catch (SQLException e) {
				logger.error("Unable to close connection after calling function funccreateclientbasic");
			}
		}
	}


	private List<ClientConfigResponse> getLatestClientId() {
		return jdbcTemplate.query(APIConstant.QUERY_GET_LATEST_CLIENT_ID,new ClientConfigRowMapper());
	}


	@Override
	public ClientLoanSchemeResponse createClientLoanScheme(List<ClientLoanSchemeRequest> clientloanSchemeRequests,String createdBy)
			throws DataAccessException {
		ClientLoanSchemeResponse clientLoanSchemeResponse = null;
		Connection connection = null;
		String functionResult = null;
		CallableStatement cs =null;
		try {
			String runFunction = "{ ? = call bmadmin.funccreateclientloanscheme(?,?,?,?,?) }";
			connection = jdbcTemplate.getDataSource().getConnection();
			cs = connection.prepareCall(runFunction);
			for(ClientLoanSchemeRequest clientloanSchemeRequest :clientloanSchemeRequests ) {
				cs.registerOutParameter(1, Types.VARCHAR);
				cs.setString(2, createdBy);
				cs.setInt(3, clientloanSchemeRequest.getClientId());
				if(!StringUtils.isEmpty(clientloanSchemeRequest.getClientGroupId()) && clientloanSchemeRequest.getClientGroupId() >0)
					cs.setInt(4, clientloanSchemeRequest.getClientGroupId());
				else 
					cs.setInt(4, -1);
				if(!StringUtils.isEmpty(clientloanSchemeRequest.getLoanSchemeId()))
					cs.setInt(5, clientloanSchemeRequest.getLoanSchemeId());
				else
					cs.setInt(5, -1);
				cs.setString(6, clientloanSchemeRequest.getClientLoanSchemeName());
				cs.executeUpdate();
				functionResult = cs.getString(1);
				if(!APIConstant.SUCCESS_CODE.equalsIgnoreCase(functionResult)){
					//throw new DataAccessException(APIConstant.MSG_CREATE_LOAN_SCHEME_FAILURE+" for "+clientloanSchemeRequest.getLoanSchemeName());
					break;
				}
			}
			clientLoanSchemeResponse = new ClientLoanSchemeResponse();
			clientLoanSchemeResponse.setMessageCode(functionResult);
			return clientLoanSchemeResponse;
		} catch (SQLException e) {
			logger.error("unable to execute the function funccreateclientloanscheme :",e);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} catch (Exception e) {
			logger.error("unable to execute the function funccreateclientloanscheme :",e);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} finally {
			try {
				if(null!= cs)
					cs.close();
				if(null!=connection)
					connection.close();
			} catch (SQLException e) {
				logger.error("unable to close connection after execution of the function funccreateclientloanscheme :",e);
				throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
			}
		}
	}


	@Override
	public ClientLoanSchemeResponse deleteClientLoanScheme(ClientLoanSchemeRequest clientloanSchemeRequest) throws DataAccessException {
		ClientLoanSchemeResponse clientLoanSchemeResponse = null;
		Connection connection = null;
		String functionResult = null; 
		CallableStatement cs = null;
		ClientResponse clientDtl = null;
		Integer clientGroupId = null;
		try {
			/*List<ClientResponse> resultSet =  jdbcTemplate.query(APIConstant.QUERY_GET_CLIENT_DETAILS,
					new Object[]{clientloanSchemeRequest.getClientId()}, new ClientInfoRowMapper());
			if(!CollectionUtils.isEmpty(resultSet)) {
				clientDtl = resultSet.get(0);
				if(null!=clientDtl.getClientType()) {
					int clientTypeId = Integer.parseInt(clientDtl.getClientType());
					if(clientTypeId==3) {
					  List<ClientBankResponse> bankList = jdbcTemplate.query(APIConstant.QUERY_GET_CLIENT_BANK_DETAILS,
									new Object[]{clientloanSchemeRequest.getClientId()}, new ClientBankRowMapper());
					  clientGroupId = bankList.get(0).getClientGroupId();
					}
				}
			}*/
			String runFunction = "{ ? = call bmadmin.funcdeleteloanscheme(?,?,?) }";
			connection = jdbcTemplate.getDataSource().getConnection();
			cs = connection.prepareCall(runFunction);
			cs.registerOutParameter(1, Types.VARCHAR);
			for(ClientLoanSchemeRequest loanSchemeRequest : clientloanSchemeRequest.getLoanSchemeDetails()) {
				cs.registerOutParameter(1, Types.VARCHAR);
				cs.setInt(2, clientloanSchemeRequest.getClientId());
				
				if(null!=loanSchemeRequest.getClientGroupId() && loanSchemeRequest.getClientGroupId() >0)
					cs.setInt(3, loanSchemeRequest.getClientGroupId());
				else 
					cs.setInt(3, -1);
				cs.setInt(4, loanSchemeRequest.getLoanSchemeId());
				cs.executeUpdate();
				functionResult = cs.getString(1);
				logger.info("Result for funcdeleteloanscheme :"+functionResult+" for "+loanSchemeRequest.getLoanSchemeId());
				if(!APIConstant.SUCCESS_CODE.equalsIgnoreCase(functionResult)){
					throw new DataAccessException(APIConstant.MSG_DELETE_LOAN_SCHEME_FAILURE+" for "+loanSchemeRequest.getLoanSchemeId());
				}
			}
			clientLoanSchemeResponse = new ClientLoanSchemeResponse();
			clientLoanSchemeResponse.setMessageCode(functionResult);
			return clientLoanSchemeResponse;
		} catch (SQLException e) {
			logger.error("unable to execute the function funcdeleteloanscheme",e);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} catch (Exception e) {
			logger.error("unable to execute the function funcdeleteloanscheme",e);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} finally {
			try {
				if(null!= cs)
					cs.close();
				if(null!=connection)
					connection.close();
			} catch (SQLException e) {
				logger.error("unable to close connection after execution the function funcdeleteloanscheme",e);
				throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
			}
		}
	}


	@Override
	public ClientLoanVariantResponse createClientLoanVariant(ClientConfigRequest loanVariantRequests,
			String userName)	throws DataAccessException {
		ClientLoanVariantResponse clientLoanVariantResponse = null;
		Connection connection = null;
		String functionResult = null; 
		CallableStatement cs = null;
		try {
			String runFunction = "{ ? = call bmadmin.funcdefineclientloanvariant(?,?,?,?,?) }";
			connection = jdbcTemplate.getDataSource().getConnection();
			cs = connection.prepareCall(runFunction);
			for(ClientLoanVariantRequest loanVariantRequest : loanVariantRequests.getLoanSchemeVariantDetails()) {
				cs.registerOutParameter(1, Types.VARCHAR);
				//cs.setString(2, userName);
				cs.setInt(2, loanVariantRequests.getClientId());
				cs.setInt(3, -1);
				if(!StringUtils.isEmpty(loanVariantRequest.getLoanVariantId()))
					cs.setInt(4, loanVariantRequest.getLoanVariantId());
				else
					cs.setInt(4, -1);
				cs.setString(5, loanVariantRequest.getPreferredLoanVariantName());
				cs.setString(6, loanVariantRequest.getLoanVariantKeyword());
				cs.executeUpdate();
				functionResult = cs.getString(1);
				//System.out.println(functionResult);
				if(!APIConstant.SUCCESS_CODE.equalsIgnoreCase(functionResult)){
					throw new DataAccessException(APIConstant.MSG_CREATE_LOAN_VARIANT_FAILURE+" for "+loanVariantRequest.getLoanVariantKeyword());
				}
			}
			clientLoanVariantResponse = new ClientLoanVariantResponse();
			clientLoanVariantResponse.setMessageCode(functionResult);
			return clientLoanVariantResponse;
		} catch (SQLException e) {
			logger.error("unable to execute the function funcdefineclientloanvariant ",e);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} catch (Exception e) {
			logger.error("unable to execute the function funcdefineclientloanvariant ",e);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} finally {
			try {
				if(null!= cs)
					cs.close();
				if(null!=connection)
					connection.close();
			} catch (SQLException e) {
				logger.error("unable to close connection after execution of the function funcdefineclientloanvariant ",e);
				throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
			}
		}
	}


	@Override
	public ClientLoanVariantResponse deleteClientLoanVariant(ClientConfigRequest loanVariantRequests)
			throws DataAccessException {
		ClientLoanVariantResponse clientLoanVariantResponse = null;
		Connection connection = null;
		String functionResult = null; 
		CallableStatement cs = null;
		ClientResponse clientDtl = null;
		Integer clientGroupId = null;
		try {
			/*List<ClientResponse> resultSet =  jdbcTemplate.query(APIConstant.QUERY_GET_CLIENT_DETAILS,
					new Object[]{loanVariantRequests.getClientId()}, new ClientInfoRowMapper());
			if(!CollectionUtils.isEmpty(resultSet)) {
				clientDtl = resultSet.get(0);
				if(null!=clientDtl.getClientType()) {
					int clientTypeId = Integer.parseInt(clientDtl.getClientType());
					if(clientTypeId==3) {
					  List<ClientBankResponse> bankList = jdbcTemplate.query(APIConstant.QUERY_GET_CLIENT_BANK_DETAILS,
									new Object[]{loanVariantRequests.getClientId()}, new ClientBankRowMapper());
					  clientGroupId = bankList.get(0).getClientGroupId();
					}
				}
			}*/
			String runFunction = "{ ? = call bmadmin.funcdeleteloanvariant(?,?,?,?) }";
			connection = jdbcTemplate.getDataSource().getConnection();
			cs = connection.prepareCall(runFunction);
			for(ClientLoanVariantRequest loanVariantRequest : loanVariantRequests.getLoanSchemeVariantDetails()) {
				cs.registerOutParameter(1, Types.VARCHAR);
				cs.setInt(2, loanVariantRequests.getClientId());
				if(null!=loanVariantRequest.getClientGroupId() && loanVariantRequest.getClientGroupId() >0)
					cs.setInt(3, loanVariantRequest.getClientGroupId());
				else 
					cs.setInt(3, -1);
				cs.setInt(4, loanVariantRequest.getLoanVariantId());
				cs.setString(5, loanVariantRequest.getLoanVariantName());
				cs.executeUpdate();
				functionResult = cs.getString(1);
				//System.out.println(functionResult);
				if(!APIConstant.SUCCESS_CODE.equalsIgnoreCase(functionResult)){
					throw new DataAccessException(APIConstant.MSG_DELETE_LOAN_VARIANT_FAILURE+" for "+loanVariantRequest.getLoanVariantKeyword());
				}
			}
			clientLoanVariantResponse = new ClientLoanVariantResponse();
			clientLoanVariantResponse.setMessageCode(functionResult);
			return clientLoanVariantResponse;
		} catch (SQLException e) {
			logger.error("unable to execute the function funcdeleteloanvariant ",e);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} finally {
			try {
				if(null!= cs)
					cs.close();
				if(null!=connection)
					connection.close();
			} catch (SQLException e) {
				logger.error("unable to close connection after execution of the function funcdeleteloanvariant ",e);
				throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
			}
		}
	}


	@Override
	public ClientSubscriptionResponse updateClientSubscription(ClientSubscriptionRequest clientSubscriptionRequest)
			throws DataAccessException {
		ClientSubscriptionResponse clientSubscriptionResponse = null;
		List<ClientSubscriptionResponse> clientSubscriptionResponseList = null;
		Connection connection = null;
		String functionResult = null; 
		CallableStatement cs = null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		boolean isNewClientSubscription = false;
		try {
			if(null!=clientSubscriptionRequest && !StringUtils.isEmpty(clientSubscriptionRequest.getClientId())) {
				clientSubscriptionResponseList = jdbcTemplate.query(
					APIConstant.QUERY_CHECK_NEW_CLIENT_SUBSCRIPTION,
					new Object[]{clientSubscriptionRequest.getClientId()},
					new ClientBasicSubscriptionRowMapper());
			}  
		} catch (EmptyResultDataAccessException e) {
			isNewClientSubscription = true;
	    } 
		try {
			if(isNewClientSubscription || (null!=clientSubscriptionResponseList && clientSubscriptionResponseList.size()==0)) {
				/*String runFunction = "{ ? = call bmadmin.funccreateclientsubscription(?,?,?,?) }";
				connection = jdbcTemplate.getDataSource().getConnection();
				cs = connection.prepareCall(runFunction);
				cs.registerOutParameter(1, Types.VARCHAR);
				cs.setString(2, clientSubscriptionRequest.getCreatedBy());
				cs.setInt(3, clientSubscriptionRequest.getClientId());
				cs.setInt(4, 1);
				cs.setInt(5, clientSubscriptionRequest.getSubscriptionModelId());
	         	cs.executeUpdate();*/
	         	
	         	String runFunction = "{ ? = call bmadmin.funccreateclientsubscription1(?,?,?,?,?) }";
				connection = jdbcTemplate.getDataSource().getConnection();
				cs = connection.prepareCall(runFunction);
				cs.registerOutParameter(1, Types.VARCHAR);
				cs.setString(2, clientSubscriptionRequest.getCreatedBy());
				cs.setInt(3, clientSubscriptionRequest.getClientId());
				cs.setInt(4, 1);
				cs.setInt(5, clientSubscriptionRequest.getSubscriptionModelId());
				if(!StringUtils.isEmpty(clientSubscriptionRequest.getSubscriptionStartDate())) {
					SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
					java.sql.Date sqlPackageDate
					= new java.sql.Date(clientSubscriptionRequest.getSubscriptionStartDate().getTime());
					cs.setDate(6, sqlPackageDate);
            		
				} else {
					cs.setDate(6, null);
            	}
	         	cs.executeUpdate();
	         	
				functionResult = cs.getString(1);
				//System.out.println(functionResult);
				clientSubscriptionResponse = new ClientSubscriptionResponse();
				clientSubscriptionResponse.setMessageCode(functionResult);
				return clientSubscriptionResponse;
			} else {
				ClientSubscriptionResponse  clientSubscriptionData = null;
				boolean isExistingDataAvailable = false;
				if(!StringUtils.isEmpty(clientSubscriptionRequest.getTypeofrequest()) &&
						(clientSubscriptionRequest.getTypeofrequest().equalsIgnoreCase("basicDetails") || 
								clientSubscriptionRequest.getTypeofrequest().equalsIgnoreCase("renewDetails"))){
					clientSubscriptionData = getClientSubscription(String.valueOf(clientSubscriptionRequest.getClientId()));
					isExistingDataAvailable = true;
				}
				if( clientSubscriptionRequest.getTypeofrequest().equalsIgnoreCase("renewDetails")){
					String runFunction = "{ ? = call bmadmin.funccreateclientsubscription1(?,?,?,?,?) }";
					connection = jdbcTemplate.getDataSource().getConnection();
					cs = connection.prepareCall(runFunction);
					cs.registerOutParameter(1, Types.VARCHAR);
					cs.setString(2, clientSubscriptionRequest.getCreatedBy());
					cs.setInt(3, clientSubscriptionRequest.getClientId());
					cs.setInt(4, 0);
					cs.setInt(5, clientSubscriptionRequest.getSubscriptionModelId());
					if(!StringUtils.isEmpty(clientSubscriptionRequest.getSubscriptionStartDate())) {
						SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
						//Date date = DateFor.parse(String.valueOf(clientSubscriptionRequest.getSubscriptionStartDate()));
						//System.out.println("Date : "+date);
						java.sql.Date sqlPackageDate
						= new java.sql.Date(clientSubscriptionRequest.getSubscriptionStartDate().getTime());
						cs.setDate(6, sqlPackageDate);
	            		
					} else {
	            		long millis=System.currentTimeMillis();  
		                 java.sql.Date date=new java.sql.Date(millis); 
		            	 cs.setDate(6,date);
	            	}
		         	cs.executeUpdate();
					functionResult = cs.getString(1);
					clientSubscriptionResponse = new ClientSubscriptionResponse();
					clientSubscriptionResponse.setMessageCode(functionResult);
					return clientSubscriptionResponse;
				} else {
					String runFunction = "{ ? = call bmadmin.funcupdateclientsubscription(?,?,?,?,?,?,?,?,?,?) }";
					connection = jdbcTemplate.getDataSource().getConnection();
					cs = connection.prepareCall(runFunction);
					cs.registerOutParameter(1, Types.VARCHAR);
					cs.setString(2, clientSubscriptionRequest.getCreatedBy());
					cs.setInt(3, clientSubscriptionRequest.getClientId());
					if(StringUtils.isEmpty(clientSubscriptionRequest.getSubscriptionModelId()))
						cs.setInt(4, clientSubscriptionRequest.getSubscriptionId());
					else if (StringUtils.isEmpty(clientSubscriptionRequest.getSubscriptionModelId()) && isExistingDataAvailable && null!=clientSubscriptionData) {
						cs.setInt(4, clientSubscriptionData.getSubscriptionId());
					} else
						cs.setInt(4, clientSubscriptionRequest.getSubscriptionModelId());
					if(!StringUtils.isEmpty(clientSubscriptionRequest.getPrice()))
						cs.setInt(5, clientSubscriptionRequest.getPrice());
					else if (StringUtils.isEmpty(clientSubscriptionRequest.getPrice()) && isExistingDataAvailable
							&& null!=clientSubscriptionData && !StringUtils.isEmpty(clientSubscriptionData.getPricePackage())) {
						cs.setInt(5, clientSubscriptionData.getPricePackage());
					} else {
						cs.setInt(5, 0);
					}
					if(!StringUtils.isEmpty(clientSubscriptionRequest.getTax()))
						cs.setInt(6, clientSubscriptionRequest.getTax());
					else if (StringUtils.isEmpty(clientSubscriptionRequest.getTax()) && isExistingDataAvailable
							&& null!=clientSubscriptionData && !StringUtils.isEmpty(clientSubscriptionData.getTax())) {
						cs.setInt(6, clientSubscriptionData.getTax());
					} else 
						cs.setInt(6, 0);
					if(!StringUtils.isEmpty(clientSubscriptionRequest.getGst()))
						cs.setInt(7, clientSubscriptionRequest.getGst());
					else if (StringUtils.isEmpty(clientSubscriptionRequest.getGst()) && isExistingDataAvailable 
							&& null!=clientSubscriptionData && !StringUtils.isEmpty(clientSubscriptionData.getGst())) {
						cs.setInt(7, clientSubscriptionData.getGst());
					} else 
						cs.setInt(7, 0);
					if(!StringUtils.isEmpty(clientSubscriptionRequest.getTotalAmount()))
						cs.setInt(8, clientSubscriptionRequest.getTotalAmount());
					else if (StringUtils.isEmpty(clientSubscriptionRequest.getTotalAmount()) && isExistingDataAvailable 
							&& null!=clientSubscriptionData  && !StringUtils.isEmpty(clientSubscriptionData.getTotalAmount())) {
						cs.setInt(8, clientSubscriptionData.getTotalAmount());
					} else
						cs.setInt(8, 0);
		            
		            Date parsedSubscriptionStartDate = null;
		            Date parsedSubscriptionEndDate = null;
		            Date parsedRenewableDate = null;
		            if(!StringUtils.isEmpty(clientSubscriptionRequest.getSubscriptionStartDate())) {
		            	String subscriptionStartDate = dateFormat.format(clientSubscriptionRequest.getSubscriptionStartDate());
		            
			            parsedSubscriptionStartDate = dateFormat.parse(subscriptionStartDate);
			            java.sql.Date sqlsubscriptionDate = new java.sql.Date(parsedSubscriptionStartDate.getTime());
						cs.setDate(9,sqlsubscriptionDate);
		            } else if (StringUtils.isEmpty(clientSubscriptionRequest.getSubscriptionStartDate()) && isExistingDataAvailable && null!=clientSubscriptionData) {
		            	if(!StringUtils.isEmpty(clientSubscriptionData.getStartDate()))
		            		cs.setDate(9, java.sql.Date.valueOf(String.valueOf(clientSubscriptionData.getStartDate())));
		            	else {
		            		long millis=System.currentTimeMillis();  
			                 java.sql.Date date=new java.sql.Date(millis); 
			            	 cs.setDate(9,date);
		            	}
					} else {
		            	 long millis=System.currentTimeMillis();  
		                 java.sql.Date date=new java.sql.Date(millis); 
		            	 cs.setDate(9,date);
		            }
		            
		            if(!StringUtils.isEmpty(clientSubscriptionRequest.getSubscriptionEndDate())) {
		            	String subscriptionEndDate = dateFormat.format(clientSubscriptionRequest.getSubscriptionEndDate());
		            	parsedSubscriptionEndDate = dateFormat.parse(subscriptionEndDate);
		                java.sql.Date sqlsubscriptionEndDate = new java.sql.Date(parsedSubscriptionEndDate.getTime());
		    			cs.setDate(10,sqlsubscriptionEndDate);
		            } else if (StringUtils.isEmpty(clientSubscriptionRequest.getSubscriptionEndDate()) && isExistingDataAvailable && null!=clientSubscriptionData) {
						if(!StringUtils.isEmpty(clientSubscriptionData.getEndDate()))
		            		cs.setDate(10, java.sql.Date.valueOf(String.valueOf(clientSubscriptionData.getEndDate())));
		            	else {
		            		long millis=System.currentTimeMillis();  
			                java.sql.Date date=new java.sql.Date(millis);
			            	cs.setDate(10,new java.sql.Date(2025,01,01));
		            	}
					} else {
		            	long millis=System.currentTimeMillis();  
		                java.sql.Date date=new java.sql.Date(millis);
		            	cs.setDate(10,new java.sql.Date(2025,01,01));
		            }
		            if(!StringUtils.isEmpty(clientSubscriptionRequest.getRenewalReminderDate())) {
			            String renewableDate = dateFormat.format(clientSubscriptionRequest.getRenewalReminderDate());
			            parsedRenewableDate = dateFormat.parse(renewableDate);
			            java.sql.Date sqlRenewableDate = new java.sql.Date(parsedRenewableDate.getTime());
						cs.setDate(11, sqlRenewableDate);
		            } else if (StringUtils.isEmpty(clientSubscriptionRequest.getRenewalReminderDate()) && isExistingDataAvailable && null!=clientSubscriptionData) {
						if(!StringUtils.isEmpty(clientSubscriptionData.getRenewalReminderDate()))
							cs.setDate(11, java.sql.Date.valueOf(String.valueOf(clientSubscriptionData.getRenewalReminderDate())));
						else {
							long millis=System.currentTimeMillis();  
			                java.sql.Date date=new java.sql.Date(millis);
			            	cs.setDate(11,new java.sql.Date(2025,01,01));
						}
					} else {
		            	long millis=System.currentTimeMillis();  
		                java.sql.Date date=new java.sql.Date(millis);
		            	cs.setDate(11, new java.sql.Date(2025,01,01));
		            }
					cs.executeUpdate();
					functionResult = cs.getString(1);
					//System.out.println(functionResult);
					clientSubscriptionResponse = new ClientSubscriptionResponse();
					clientSubscriptionResponse.setMessageCode(functionResult);
					return clientSubscriptionResponse;
				}
			}
		} catch (SQLException e) {
			logger.error("Sql Exception :"+e.getMessage());
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} catch (Exception e1) {
			logger.error("Failed to execute  funcupdateclientsubscription :"+e1.getMessage());
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} finally {
			try {
				if(null!= cs)
					cs.close();
				if(null!=connection)
					connection.close();
			} catch (SQLException e) {
				logger.error("Failed to close connection after execution of funcupdateclientsubscription :"+e.getMessage());
				throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
			}
		}
	}


	@Override
	public ClientSubscriptionResponse createClientSubscription(ClientNewSubscriptionRequest clientSubscriptionRequest)
			throws DataAccessException {
		ClientSubscriptionResponse clientSubscriptionResponse = null;
		Connection connection = null;
		String functionResult = null; 
		CallableStatement cs = null;
		try {
			/*String runFunction = "{ ? = call bmadmin.funccreateclientsubscription(?,?,?,?) }";
			connection = jdbcTemplate.getDataSource().getConnection();
			cs = connection.prepareCall(runFunction);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setString(2, clientSubscriptionRequest.getCreatedBy());
			cs.setInt(3, clientSubscriptionRequest.getClientId());
			if(!StringUtils.isEmpty(clientSubscriptionRequest.getSubscriptionId()))
				cs.setInt(4, 1);
			else 
				cs.setInt(4, 0);
			cs.setInt(5, clientSubscriptionRequest.getSubscriptionModelId());
         	cs.executeUpdate();*/
         	
         	String runFunction = "{ ? = call bmadmin.funccreateclientsubscription1(?,?,?,?,?) }";
			connection = jdbcTemplate.getDataSource().getConnection();
			cs = connection.prepareCall(runFunction);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setString(2, clientSubscriptionRequest.getCreatedBy());
			cs.setInt(3, clientSubscriptionRequest.getClientId());
			if(!StringUtils.isEmpty(clientSubscriptionRequest.getSubscriptionId()))
				cs.setInt(4, 1);
			else 
				cs.setInt(4, 0);
			cs.setInt(5, clientSubscriptionRequest.getSubscriptionModelId());
			cs.setDate(6, null);
         	cs.executeUpdate();
         	
			functionResult = cs.getString(1);
			//System.out.println(functionResult);
			clientSubscriptionResponse = new ClientSubscriptionResponse();
			clientSubscriptionResponse.setMessageCode(functionResult);
			return clientSubscriptionResponse;
		} catch (SQLException e) {
			logger.error("Sql Exception while creating client subscription for functioncall of funccreateclientsubscription :"+e.getMessage());
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} catch (Exception e1) {
			logger.error("Exception while creating client subscription for functioncall of funccreateclientsubscription :"+e1.getMessage());
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} finally {
			try {
				if(null!= cs)
					cs.close();
				if(null!=connection)
					connection.close();
			} catch (SQLException e) {
				logger.error("Unable to close connection after executing function funccreateclientsubscription",e);
				throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
			}
		}
	}


	@Override
	public List<ClientSubscriptionHistoryResponse> getClientSubscriptionHistory(String clientId)
			throws DataAccessException {
		try {
			if(null!=clientId && !StringUtils.isEmpty(clientId)) {
				return jdbcTemplate.query(APIConstant.QUERY_GET_CLIENT_SUBSCRIPTION_HISTORY,
						new Object[]{Integer.parseInt(clientId)}, new ClientSubscriptionHistoryRowMapper());
			}  else {
				return new ArrayList<ClientSubscriptionHistoryResponse>();
			}
		} catch (Exception ex) {
			logger.error("Exception while getting client subscription history :" + ex.getMessage());
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		}
	}


	@Override
	public List<ClientResponse> getListOfClients(ClientConfigRequest clientConfigRequest) throws DataAccessException {
		try {
			if(null!=clientConfigRequest && !StringUtils.isEmpty(clientConfigRequest.getClientId()) && 
					!StringUtils.isEmpty(clientConfigRequest.getV1TemplateStatus())){
				return jdbcTemplate.query(APIConstant.QUERY_GET_CLIENT_BY_V1_TEMPLATE_AND_CLIENTID,
						new Object[]{clientConfigRequest.getClientId(),
								clientConfigRequest.getV1TemplateStatus()}, new ClientRowMapper());
			} else if(null!=clientConfigRequest &&	!StringUtils.isEmpty(clientConfigRequest.getV1TemplateStatus())){
				return jdbcTemplate.query(APIConstant.QUERY_GET_CLIENT_BY_V1_TEMPLATE,
						new Object[]{clientConfigRequest.getV1TemplateStatus()}, new ClientRowMapper());
			} else if(null!=clientConfigRequest && !StringUtils.isEmpty(clientConfigRequest.getClientTypeId()) && 
					!StringUtils.isEmpty(clientConfigRequest.getClientName()) && 
					!StringUtils.isEmpty(clientConfigRequest.getSubscriptionId()) && 
					!StringUtils.isEmpty(clientConfigRequest.getCity()) &&
					!StringUtils.isEmpty(clientConfigRequest.getState())){
				return jdbcTemplate.query(APIConstant.QUERY_GET_CLIENT_BY_ALL_CRITERIA,
						new Object[]{clientConfigRequest.getClientTypeId(),clientConfigRequest.getClientName(),
								clientConfigRequest.getSubscriptionId(),clientConfigRequest.getCity(),
								clientConfigRequest.getState()}, new ClientRowMapper());
			}  else if(null!=clientConfigRequest && !StringUtils.isEmpty(clientConfigRequest.getClientTypeId()) && 
					!StringUtils.isEmpty(clientConfigRequest.getClientName()) && 
					!StringUtils.isEmpty(clientConfigRequest.getSubscriptionId())) {
				return jdbcTemplate.query(APIConstant.QUERY_GET_CLIENT_BY_CLIENTTYPE_CLIENTNM_SUBSCRIPTION,
						new Object[]{clientConfigRequest.getClientTypeId(),clientConfigRequest.getClientName(),
								clientConfigRequest.getSubscriptionId()}, new ClientRowMapper());
			}  else if(null!=clientConfigRequest && !StringUtils.isEmpty(clientConfigRequest.getClientTypeId()) && 
					!StringUtils.isEmpty(clientConfigRequest.getClientName())){
				return jdbcTemplate.query(APIConstant.QUERY_GET_CLIENT_BY_CLIENTNM_CLIENTTYPE,
						new Object[]{clientConfigRequest.getClientTypeId(),clientConfigRequest.getClientName()}, new ClientRowMapper());
			}  else if(null!=clientConfigRequest && !StringUtils.isEmpty(clientConfigRequest.getClientTypeId()) && 
					!StringUtils.isEmpty(clientConfigRequest.getSubscriptionId())){
				return jdbcTemplate.query(APIConstant.QUERY_GET_CLIENT_BY_CLIENTTYPE_SUBSCRIPTION,
						new Object[]{clientConfigRequest.getClientTypeId(),clientConfigRequest.getSubscriptionId()}, new ClientRowMapper());
			}  else if(null!=clientConfigRequest && !StringUtils.isEmpty(clientConfigRequest.getClientTypeId())){
				return jdbcTemplate.query(APIConstant.QUERY_GET_CLIENT_BY_CLIENTTYPE,
						new Object[]{clientConfigRequest.getClientTypeId()}, new ClientRowMapper());
			}  else if(null!=clientConfigRequest && !StringUtils.isEmpty(clientConfigRequest.getClientName())){
				return jdbcTemplate.query(APIConstant.QUERY_GET_CLIENT_BY_CLIENTNM,
						new Object[]{clientConfigRequest.getClientName()}, new ClientRowMapper());
			}  else if(null!=clientConfigRequest && !StringUtils.isEmpty(clientConfigRequest.getClientId())){
				return jdbcTemplate.query(APIConstant.QUERY_GET_CLIENT_BY_CLIENTID,
						new Object[]{clientConfigRequest.getClientId()}, new ClientRowMapper());
			}
		} catch (Exception ex) {
			logger.error("Exception while getting client subscription history :" + ex.getMessage());
			throw new DataAccessException(APIConstant.ERROR_CODE_GET_CLIENT_SUBSCRIPTION_HISTORY);
		}
		return null;
	}


	@Override
	public List<ClientLoanSchemeResponse> getListOfLoanSchemes(ClientLoanSchemeRequest loanSchemeRequest)
			throws DataAccessException {
		try {
			if(null!=loanSchemeRequest && !StringUtils.isEmpty(loanSchemeRequest.getAction())
					&& "add".equalsIgnoreCase(loanSchemeRequest.getAction())) {
				return jdbcTemplate.query(
					APIConstant.QUERY_GET_AVAILABLE_LOAN_SCHEMES_FOR_NEW_ADDITION,
					new Object[]{loanSchemeRequest.getClientId(),loanSchemeRequest.getClientGroupId()},
					new ExistingClientLoanSchemeRowMapper());
			} else if(null!=loanSchemeRequest && !StringUtils.isEmpty(loanSchemeRequest.getClientId())
					&& null!=loanSchemeRequest.getClientTypeId() && loanSchemeRequest.getClientTypeId() ==3){
				return jdbcTemplate.query(
						APIConstant.QUERY_GET_AVAILABLE_LOAN_SCHEMES_FOR_CLIENT_AUDIT_FIRM,
						new Object[]{loanSchemeRequest.getClientId()},
						new ExistingClientLoanSchemeRowMapper());
			} else if(null!=loanSchemeRequest && !StringUtils.isEmpty(loanSchemeRequest.getClientId())){
				return jdbcTemplate.query(
						APIConstant.QUERY_GET_AVAILABLE_LOAN_SCHEMES_FOR_CLIENT,
						new Object[]{loanSchemeRequest.getClientId()},
						new ExistingClientLoanSchemeRowMapper());
			} else {
				return jdbcTemplate.query(
						APIConstant.QUERY_GET_AVAILABLE_LOAN_SCHEMES_FOR_CLIENT_WITHOUT_CRITERIA,new ExistingClientLoanSchemeRowMapper());
			}
		} catch (EmptyResultDataAccessException e) {
			logger.error("No loan schemes returned from db :",e);
			return new ArrayList<ClientLoanSchemeResponse>();
	    } catch (Exception ex) {
	    	logger.error("Unable to get loan schemes :",ex);
			throw new DataAccessException(APIConstant.ERROR_CODE_GET_CLIENT_LOAN_SCHEMES);
		}
	}


	@Override
	public ClientSubscriptionResponse getClientSubscription(String clientId) throws DataAccessException {
		List<ClientSubscriptionResponse> clientSubscriptionResponse = null;
		ClientSubscriptionResponse subscriptionResp =  null;
		try {
			if(null!=clientId && !StringUtils.isEmpty(clientId)) {
				clientSubscriptionResponse = jdbcTemplate.query(
					APIConstant.QUERY_GET_CLIENT_SUBSCRIPTION_FOR_EDIT,
					new Object[]{Integer.parseInt(clientId),Integer.parseInt(clientId)},
					new ClientSubscriptionRowMapper());
				if(null!=clientSubscriptionResponse && clientSubscriptionResponse.size()>0)
					subscriptionResp = clientSubscriptionResponse.get(0);
				else 
					return new ClientSubscriptionResponse();
			}  else {
				return new ClientSubscriptionResponse();
			}
		} catch (EmptyResultDataAccessException e) {
			logger.error("No client subscription found :",e);
			return new ClientSubscriptionResponse();
	    } catch (Exception ex) {
			logger.error("Unable to get client subscription :",ex);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		}
		return subscriptionResp;

	}


	@Override
	public List<ClientCustomizeTemplateResponse> getClientCustomizeTemplate(Integer clientId,Integer clientTypeId)
			throws DataAccessException {
		ClientResponse clientDtl = null;
		int clientType;
		try {
			if(clientId>0) {
				List<ClientResponse> resultSet =  jdbcTemplate.query(APIConstant.QUERY_GET_CLIENT_DETAILS,
						new Object[]{clientId}, new ClientInfoRowMapper());
				if(!CollectionUtils.isEmpty(resultSet)) {
					clientDtl = resultSet.get(0);
					if(null!=clientDtl.getClientType()) {
						clientType = Integer.parseInt(clientDtl.getClientType());
						clientTypeId = clientType;
					}
				} 
				if(null!= clientTypeId && clientTypeId==3) {
					return jdbcTemplate.query(
							APIConstant.QUERY_GET_CLIENT_CUSTOMIZE_TEMPLATE_FOR_BANK,
							new Object[]{clientId},
							new ClientCustomizeTemplateRowMapper());
				} else {
					return jdbcTemplate.query(
						APIConstant.QUERY_GET_CLIENT_CUSTOMIZE_TEMPLATE,
						new Object[]{clientId},
						new ClientCustomizeTemplateRowMapper());
				}
			} else {
				throw new DataAccessException(APIConstant.MSG_NO_CLIENT_ID);
			}
		} catch (Exception ex) {
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		}
	}


	@Override
	public ClientCustomizeTemplateResponse createNewClientTemplate(ClientTemplateRequest clientTemplateRequest)
			throws DataAccessException {
		ClientCustomizeTemplateResponse clientCustomizeTemplateResponse = null;
		Connection connection = null;
		String functionResult = null; 
		CallableStatement cs = null;
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
		try {
			String runFunction = "{ ? = call bmadmin.funccreatenewversion(?,?,?,?) }";
			connection = jdbcTemplate.getDataSource().getConnection();
			cs = connection.prepareCall(runFunction);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setInt(2, clientTemplateRequest.getDdId());
            
            SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
			java.sql.Date sqlPackageDate
			= new java.sql.Date(clientTemplateRequest.getStartDate().getTime());
			cs.setDate(3, sqlPackageDate);
			
			cs.setString(4, clientTemplateRequest.getCloneMethod());
			cs.setString(5, clientTemplateRequest.getUserName());
			cs.executeUpdate();
			functionResult = cs.getString(1);
			clientCustomizeTemplateResponse = new ClientCustomizeTemplateResponse();
			clientCustomizeTemplateResponse.setMessageCode(functionResult);
			return clientCustomizeTemplateResponse;
		} catch (SQLException e) {
			logger.error("unable to execute the function funccreatenewversion",e);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} catch (Exception e) {
			logger.error("unable to execute the function funccreatenewversion",e);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} finally {
			try {
				if(null!= cs)
					cs.close();
				if(null!=connection)
					connection.close();
			} catch (SQLException e) {
				logger.error("unable to close conection after execution of the function funccreatenewversion",e);
				throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
			}
		}
	}


	@Override
	public List<ClientModuleHeaderResponse> getClientModuleHeader(Integer ddId,String moduleName) throws DataAccessException {
		try {
			if(ddId>0 && !StringUtils.isEmpty(moduleName)) {
				if(APIConstant.MODULE_NAME_M1.equalsIgnoreCase(moduleName)) {
					return jdbcTemplate.query(
						APIConstant.QUERY_GET_CLIENT_MODULE_HEADER_FOR_M1,
						new Object[]{ddId},
						new ClientModuleHeaderRowMapper());
				} else if(APIConstant.MODULE_NAME_M2.equalsIgnoreCase(moduleName)) {
					return jdbcTemplate.query(
							APIConstant.QUERY_GET_CLIENT_MODULE_HEADER_FOR_M2,
							new Object[]{ddId},
							new ClientModuleHeaderRowMapper());
				} else if(APIConstant.MODULE_NAME_M3.equalsIgnoreCase(moduleName)) {
					return jdbcTemplate.query(
							APIConstant.QUERY_GET_CLIENT_MODULE_HEADER_FOR_M3,
							new Object[]{ddId},
							new ClientModuleHeaderRowMapper());
				} else if(APIConstant.MODULE_NAME_M4.equalsIgnoreCase(moduleName)) {
					return jdbcTemplate.query(
							APIConstant.QUERY_GET_CLIENT_MODULE_HEADER_FOR_M4,
							new Object[]{ddId},
							new ClientModuleHeaderRowMapper());
				} else if(APIConstant.MODULE_NAME_M5.equalsIgnoreCase(moduleName)) {
					return jdbcTemplate.query(
							APIConstant.QUERY_GET_CLIENT_MODULE_HEADER_FOR_M5,
							new Object[]{ddId},
							new ClientModuleHeaderRowMapper());
				}
			} else {
				logger.error(APIConstant.MSG_NO_DD_ID + " for call of getClientModuleHeader method");
				throw new DataAccessException(APIConstant.MSG_NO_DD_ID);
			}
		} catch (Exception ex) {
			logger.error("Unable to get client module header :",ex);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		}
		return new ArrayList<ClientModuleHeaderResponse>();
	}


	@Override
	public List<ClientDueDeligenceResponse> getClientDueDeligence(ClientDueDeligenceRequest clientDueDeligenceRequest)
			throws DataAccessException {
		String moduleName = clientDueDeligenceRequest.getModuleName();
		String ddId = String.valueOf(clientDueDeligenceRequest.getDdId());
		String header = "";
		String module1Query  = "";
		String orderbyClause = " order by bmddm1.header_seq ";
		try {
			if(null!=clientDueDeligenceRequest && clientDueDeligenceRequest.getDdId() >0
					&& !StringUtils.isEmpty(clientDueDeligenceRequest.getModuleName())) {
				if(APIConstant.MODULE_NAME_M1.equalsIgnoreCase(clientDueDeligenceRequest.getModuleName())) {
					module1Query  =APIConstant.QUERY_GET_CLIENT_DUE_DELIGENCE_M1;
				} else if(APIConstant.MODULE_NAME_M2.equalsIgnoreCase(clientDueDeligenceRequest.getModuleName())) {
					module1Query  = APIConstant.QUERY_GET_CLIENT_DUE_DELIGENCE_M2;
				} else if(APIConstant.MODULE_NAME_M3.equalsIgnoreCase(clientDueDeligenceRequest.getModuleName())) {
					module1Query  =APIConstant.QUERY_GET_CLIENT_DUE_DELIGENCE_M3;
				} else if(APIConstant.MODULE_NAME_M4.equalsIgnoreCase(clientDueDeligenceRequest.getModuleName())) {
					module1Query  =APIConstant.QUERY_GET_CLIENT_DUE_DELIGENCE_M4;
				} else if(APIConstant.MODULE_NAME_M5.equalsIgnoreCase(clientDueDeligenceRequest.getModuleName())) {
					module1Query  =APIConstant.QUERY_GET_CLIENT_DUE_DELIGENCE_M5;
				}
				int cnt = 1;
				if(!StringUtils.isEmpty(clientDueDeligenceRequest.getHeader1())  && !"null".equalsIgnoreCase(clientDueDeligenceRequest.getHeader1())) {
					cnt = cnt +1;
				}
				if(!StringUtils.isEmpty(clientDueDeligenceRequest.getHeader2())  && !"null".equalsIgnoreCase(clientDueDeligenceRequest.getHeader2())) {
					cnt = cnt +1;
				}
				if(!StringUtils.isEmpty(clientDueDeligenceRequest.getHeader3())  && !"null".equalsIgnoreCase(clientDueDeligenceRequest.getHeader3())) {
					cnt = cnt +1;
				}
				if(!StringUtils.isEmpty(clientDueDeligenceRequest.getHeader4())  && !"null".equalsIgnoreCase(clientDueDeligenceRequest.getHeader4())) {
					cnt = cnt +1;
				}
				
				Object[] objInput = new Object[cnt];
				int i = 0;
				module1Query = module1Query + " where bmddm1.dd_Id= ? ";
				objInput[i] = clientDueDeligenceRequest.getDdId();
				if(!StringUtils.isEmpty(clientDueDeligenceRequest.getHeader1()) && !"null".equalsIgnoreCase(clientDueDeligenceRequest.getHeader1())) {
					module1Query = module1Query + " and bmddm1.header1= ? ";
					i = i+1;
					objInput[i] = clientDueDeligenceRequest.getHeader1();
				} else {
					module1Query = module1Query + " and bmddm1.header1 is null";
				}
				if(!StringUtils.isEmpty(clientDueDeligenceRequest.getHeader2()) && !"null".equalsIgnoreCase(clientDueDeligenceRequest.getHeader2())) {
					module1Query = module1Query + " and bmddm1.header2= ? ";
					i = i+1;
					objInput[i] = clientDueDeligenceRequest.getHeader2();
				} else {
					module1Query = module1Query + " and bmddm1.header2 is null";
				}
				if(!StringUtils.isEmpty(clientDueDeligenceRequest.getHeader3()) && !"null".equalsIgnoreCase(clientDueDeligenceRequest.getHeader3())) {
					module1Query = module1Query + " and bmddm1.header3= ? ";
					i = i+1;
					objInput[i] = clientDueDeligenceRequest.getHeader3();
				} else {
					module1Query = module1Query + " and bmddm1.header3 is null";
				}
				if(!StringUtils.isEmpty(clientDueDeligenceRequest.getHeader4()) && !"null".equalsIgnoreCase(clientDueDeligenceRequest.getHeader4())) {
					module1Query = module1Query + " and bmddm1.header4= ? ";
					i = i+1;
					objInput[i] = clientDueDeligenceRequest.getHeader4();
				} else {
					module1Query = module1Query + " and bmddm1.header4 is null";
				}
				module1Query = module1Query + orderbyClause;
				return jdbcTemplate.query(module1Query,
						objInput,
						new ClientDueDeligenceRowMapper());
			} else {
				logger.error("Unable to get client module header as no header was passed");
				throw new DataAccessException(APIConstant.MSG_NO_HEADER_PASSED);
			}

		} catch (Exception ex) {
			logger.error("Unable to get client due deligence for moduleName "+moduleName + " ddId :"+ddId + " header :"+header,ex);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		}
	}


	@Override
	public ClientDueDeligenceResponse saveClientDueDeligence(ClientDueDeligenceRequest clientDueDeligenceRequest)
			throws DataAccessException {
		ClientDueDeligenceResponse clientDueDeligenceResponse = new ClientDueDeligenceResponse();
		Connection connection = null;
		String functionResult = null; 
		CallableStatement cs = null;
		try {
			if(null!=clientDueDeligenceRequest && !StringUtils.isEmpty(clientDueDeligenceRequest.getDdId())) {
				if(APIConstant.ACTION_REVIEW.equalsIgnoreCase(clientDueDeligenceRequest.getAction()) ||
					APIConstant.ACTION_APPROVE.equalsIgnoreCase(clientDueDeligenceRequest.getAction()) ||
					APIConstant.ACTION_FREEZE.equalsIgnoreCase(clientDueDeligenceRequest.getAction())) {
					long millis=System.currentTimeMillis();  
	                 java.sql.Date date=new java.sql.Date(millis); 
	            	 
					int updateStatus = jdbcTemplate.update(APIConstant.QUERY_UPDATE_DUE_DELIGENCE_STATUS, new Object[]{
							clientDueDeligenceRequest.getAction(),date,clientDueDeligenceRequest.getUserName(),clientDueDeligenceRequest.getDdId()});
					if(updateStatus > 0)
						clientDueDeligenceResponse.setMessageCode(APIConstant.SUCCESS_CODE);
					else 
						clientDueDeligenceResponse.setMessageCode(APIConstant.ERROR_CODE_FAILURE_UPDATE_DUEDELIGENCE);
				} else if (APIConstant.ACTION_SAVE.equalsIgnoreCase(clientDueDeligenceRequest.getAction())
						&& !StringUtils.isEmpty(clientDueDeligenceRequest.getModuleName())) {
					int updateStatus = -1;
					long millis=System.currentTimeMillis();  
	                 java.sql.Date date=new java.sql.Date(millis); 
	                 String existingDueDeligenceQuery = "";
	                 boolean isNewAddition = false;
	            	logger.info("Input Request for saving due deligence : DDId :"+clientDueDeligenceRequest.getDdId()+" Header Sequence : "+clientDueDeligenceRequest.getHeaderSequence()+ " DD Sequence :" +clientDueDeligenceRequest.getDdSequence()+ "DD Parent Sequence :" +clientDueDeligenceRequest.getDdParentSequence()+ " DD Data :" +clientDueDeligenceRequest.getDdData()+ "Header 1 :" +clientDueDeligenceRequest.getHeader1()+ "Header 2 :"
	                 +clientDueDeligenceRequest.getHeader2()+ " Header 3 :" +clientDueDeligenceRequest.getHeader3()+ " Header 4 :" +clientDueDeligenceRequest.getHeader4()+ " General Option :" +
									clientDueDeligenceRequest.getGeneralOption()+ "Applicant Option :" +clientDueDeligenceRequest.getApplicantOption()+ "Co Application Option :" +clientDueDeligenceRequest.getCoApplicantOption()+ "Compliance Option :" +clientDueDeligenceRequest.getComplianceOption() + " Guarantor Option :" +
									clientDueDeligenceRequest.getGuarantorOption()+ "Conditions :" +clientDueDeligenceRequest.getConditions()+ "Credit Sector :" +clientDueDeligenceRequest.getCreditSectorId()+ "Loan Scheme Id :" +
									clientDueDeligenceRequest.getLoanSchemeId()+ "Loan Variant Keyword :" +clientDueDeligenceRequest.getLoanVariant_keyword()+ "Borrower Type :" +clientDueDeligenceRequest.getBorrowerTypeId()+ "Criticalty factor :" +
									clientDueDeligenceRequest.getCriticaltyFactor()+ "Profession Id:" +clientDueDeligenceRequest.getProfessionId()+ "LoanAppType :" +clientDueDeligenceRequest.getLoanApplicationTypeId()+ "Security Id :" +
									clientDueDeligenceRequest.getSecurityId()+ "Securitty Typoe id :" +clientDueDeligenceRequest.getSecurityTypeId()+ "Security Sub Type :" +clientDueDeligenceRequest.getSecurity_subtype_id()+ "Application Type Id :" +
									clientDueDeligenceRequest.getApplicationTypeId()+ "Asset Type :" +clientDueDeligenceRequest.getAssetTypeId()+ " User Name :" +clientDueDeligenceRequest.getUserName());

	            	if(APIConstant.MODULE_NAME_M1.equalsIgnoreCase(clientDueDeligenceRequest.getModuleName())){
		                
	            		try {
		            		existingDueDeligenceQuery  =APIConstant.QUERY_GET_CLIENT_DUE_DELIGENCE_M1;
			                existingDueDeligenceQuery = existingDueDeligenceQuery + " where bmddm1.dd_Id= ? and dd_sequence = ?";
			                List<ClientDueDeligenceResponse> resultSet = jdbcTemplate.query(existingDueDeligenceQuery,new Object[]{clientDueDeligenceRequest.getDdId(),clientDueDeligenceRequest.getDdSequence()},new ClientDueDeligenceRowMapper());
			                if(CollectionUtils.isEmpty(resultSet) || resultSet.size() ==0) {
			                	isNewAddition = true;
			                }
		                } catch (EmptyResultDataAccessException e) {
		                	logger.info("No due deligence returned for DD id :"
				                       +clientDueDeligenceRequest.getDdId() +" and ddSesequence "+clientDueDeligenceRequest.getDdSequence());
		        			isNewAddition = true;
		        	    }     
						if(isNewAddition) {
							updateStatus = jdbcTemplate.update(APIConstant.QUERY_INSERT_NEW_DUE_DELIGENCE_ROW_MODULE1,clientDueDeligenceRequest.getDdId(),clientDueDeligenceRequest.getDdSequence(),clientDueDeligenceRequest.getDdParentSequence(),clientDueDeligenceRequest.getDdData(),					clientDueDeligenceRequest.getHeader1(),clientDueDeligenceRequest.getHeader2(),clientDueDeligenceRequest.getHeader3(),clientDueDeligenceRequest.getHeader4(),
									clientDueDeligenceRequest.getGeneralOption(),clientDueDeligenceRequest.getApplicantOption(),clientDueDeligenceRequest.getCoApplicantOption(),
									clientDueDeligenceRequest.getGuarantorOption(),clientDueDeligenceRequest.getConditions(),clientDueDeligenceRequest.getCreditSectorId(),
									clientDueDeligenceRequest.getLoanSchemeId(),clientDueDeligenceRequest.getLoanVariant_keyword(),clientDueDeligenceRequest.getBorrowerTypeId(),
									clientDueDeligenceRequest.getCriticaltyFactor(),clientDueDeligenceRequest.getProfessionId(),clientDueDeligenceRequest.getLoanApplicationTypeId(),
									clientDueDeligenceRequest.getSecurityId(),clientDueDeligenceRequest.getSecurityTypeId(),clientDueDeligenceRequest.getSecurity_subtype_id(),
									clientDueDeligenceRequest.getApplicationTypeId(),clientDueDeligenceRequest.getAssetTypeId(),clientDueDeligenceRequest.getUserName(),date,clientDueDeligenceRequest.getHeaderSequence());
						} else {
							updateStatus = jdbcTemplate.update(APIConstant.QUERY_UPDATE_DUE_DELIGENCE_ROW_MODULE1, new Object[]{
									clientDueDeligenceRequest.getDdParentSequence(),clientDueDeligenceRequest.getDdData(),
									clientDueDeligenceRequest.getHeader1(),clientDueDeligenceRequest.getHeader2(),clientDueDeligenceRequest.getHeader3(),clientDueDeligenceRequest.getHeader4(),
									clientDueDeligenceRequest.getGeneralOption(),clientDueDeligenceRequest.getApplicantOption(),clientDueDeligenceRequest.getCoApplicantOption(),
									clientDueDeligenceRequest.getGuarantorOption(),clientDueDeligenceRequest.getConditions(),clientDueDeligenceRequest.getCreditSectorId(),
									clientDueDeligenceRequest.getLoanSchemeId(),clientDueDeligenceRequest.getLoanVariant_keyword(),clientDueDeligenceRequest.getBorrowerTypeId(),
									clientDueDeligenceRequest.getCriticaltyFactor(),clientDueDeligenceRequest.getProfessionId(),clientDueDeligenceRequest.getLoanApplicationTypeId(),
									clientDueDeligenceRequest.getSecurityId(),clientDueDeligenceRequest.getSecurityTypeId(),clientDueDeligenceRequest.getSecurity_subtype_id(),
									clientDueDeligenceRequest.getApplicationTypeId(),clientDueDeligenceRequest.getAssetTypeId(),clientDueDeligenceRequest.getHeaderSequence(),
									clientDueDeligenceRequest.getRemarks(),clientDueDeligenceRequest.getUserName(),date,clientDueDeligenceRequest.getDdId(),clientDueDeligenceRequest.getDdSequence()});
						}
					} else if(APIConstant.MODULE_NAME_M2.equalsIgnoreCase(clientDueDeligenceRequest.getModuleName())){
						try {
		            		existingDueDeligenceQuery  =APIConstant.QUERY_GET_CLIENT_DUE_DELIGENCE_M2;
			                existingDueDeligenceQuery = existingDueDeligenceQuery + " where bmddm1.dd_Id= ? and dd_sequence = ?";
			                List<ClientDueDeligenceResponse> resultSet = jdbcTemplate.query(existingDueDeligenceQuery,new Object[]{clientDueDeligenceRequest.getDdId(),clientDueDeligenceRequest.getDdSequence()},new ClientDueDeligenceRowMapper());
			                if(CollectionUtils.isEmpty(resultSet) || resultSet.size() ==0) {
			                	isNewAddition = true;
			                }
		                } catch (EmptyResultDataAccessException e) {
		        			logger.info("No user returned from dD id :"
		                       +clientDueDeligenceRequest.getDdId() +" and ddSesequence "+clientDueDeligenceRequest.getDdSequence());
		        			isNewAddition = true;
		        	    }
						if(isNewAddition) {
							updateStatus = jdbcTemplate.update(APIConstant.QUERY_INSERT_NEW_DUE_DELIGENCE_ROW_MODULE2,clientDueDeligenceRequest.getDdId(),clientDueDeligenceRequest.getDdSequence(),
									clientDueDeligenceRequest.getDdParentSequence(),clientDueDeligenceRequest.getDdData(),clientDueDeligenceRequest.getHeader1(),clientDueDeligenceRequest.getHeader2(),
									clientDueDeligenceRequest.getHeader3(),clientDueDeligenceRequest.getHeader4(),clientDueDeligenceRequest.getComplianceOption(),clientDueDeligenceRequest.getConditions(),clientDueDeligenceRequest.getCreditSectorId(),
									clientDueDeligenceRequest.getLoanSchemeId(),clientDueDeligenceRequest.getLoanVariant_keyword(),clientDueDeligenceRequest.getBorrowerTypeId(),
									clientDueDeligenceRequest.getCriticaltyFactor(),clientDueDeligenceRequest.getProfessionId(),clientDueDeligenceRequest.getLoanApplicationTypeId(),
									clientDueDeligenceRequest.getSecurityId(),clientDueDeligenceRequest.getSecurityTypeId(),clientDueDeligenceRequest.getSecurity_subtype_id(),
									clientDueDeligenceRequest.getApplicationTypeId(),clientDueDeligenceRequest.getAssetTypeId(),clientDueDeligenceRequest.getUserName(),date,clientDueDeligenceRequest.getHeaderSequence());
						} else {
							updateStatus = jdbcTemplate.update(APIConstant.QUERY_UPDATE_DUE_DELIGENCE_ROW_MODULE2, new Object[]{
								clientDueDeligenceRequest.getDdParentSequence(),clientDueDeligenceRequest.getDdData(),
								clientDueDeligenceRequest.getHeader1(),clientDueDeligenceRequest.getHeader2(),clientDueDeligenceRequest.getHeader3(),clientDueDeligenceRequest.getHeader4(),
								clientDueDeligenceRequest.getComplianceOption(),clientDueDeligenceRequest.getConditions(),clientDueDeligenceRequest.getCreditSectorId(),
								clientDueDeligenceRequest.getLoanSchemeId(),clientDueDeligenceRequest.getLoanVariant_keyword(),clientDueDeligenceRequest.getBorrowerTypeId(),
								clientDueDeligenceRequest.getCriticaltyFactor(),clientDueDeligenceRequest.getProfessionId(),clientDueDeligenceRequest.getLoanApplicationTypeId(),
								clientDueDeligenceRequest.getSecurityId(),clientDueDeligenceRequest.getSecurityTypeId(),clientDueDeligenceRequest.getSecurity_subtype_id(),
								clientDueDeligenceRequest.getApplicationTypeId(),clientDueDeligenceRequest.getAssetTypeId(),clientDueDeligenceRequest.getHeaderSequence(),
								clientDueDeligenceRequest.getRemarks(),clientDueDeligenceRequest.getUserName(),date,clientDueDeligenceRequest.getDdId(),clientDueDeligenceRequest.getDdSequence()});
						}
					} else if(APIConstant.MODULE_NAME_M3.equalsIgnoreCase(clientDueDeligenceRequest.getModuleName())){
						try {
		            		existingDueDeligenceQuery  =APIConstant.QUERY_GET_CLIENT_DUE_DELIGENCE_M3;
			                existingDueDeligenceQuery = existingDueDeligenceQuery + " where bmddm1.dd_Id= ? and dd_sequence = ?";
			                List<ClientDueDeligenceResponse> resultSet = jdbcTemplate.query(existingDueDeligenceQuery,new Object[]{clientDueDeligenceRequest.getDdId(),clientDueDeligenceRequest.getDdSequence()},new ClientDueDeligenceRowMapper());
			                if(CollectionUtils.isEmpty(resultSet) || resultSet.size() ==0) {
			                	isNewAddition = true;
			                }
		                } catch (EmptyResultDataAccessException e) {
		        			logger.info("No user returned from dD id :"
		                       +clientDueDeligenceRequest.getDdId() +" and ddSesequence "+clientDueDeligenceRequest.getDdSequence());
		        			isNewAddition = true;
		        	    }
						if(isNewAddition) {
							updateStatus = jdbcTemplate.update(APIConstant.QUERY_INSERT_NEW_DUE_DELIGENCE_ROW_MODULE3,clientDueDeligenceRequest.getDdId(),clientDueDeligenceRequest.getDdSequence(),
									clientDueDeligenceRequest.getDdParentSequence(),clientDueDeligenceRequest.getDdData(),clientDueDeligenceRequest.getHeader1(),clientDueDeligenceRequest.getHeader2(),
									clientDueDeligenceRequest.getHeader3(),clientDueDeligenceRequest.getHeader4(),clientDueDeligenceRequest.getComplianceOption(),clientDueDeligenceRequest.getConditions(),clientDueDeligenceRequest.getCreditSectorId(),
									clientDueDeligenceRequest.getLoanSchemeId(),clientDueDeligenceRequest.getLoanVariant_keyword(),clientDueDeligenceRequest.getBorrowerTypeId(),
									clientDueDeligenceRequest.getCriticaltyFactor(),clientDueDeligenceRequest.getProfessionId(),clientDueDeligenceRequest.getLoanApplicationTypeId(),
									clientDueDeligenceRequest.getSecurityId(),clientDueDeligenceRequest.getSecurityTypeId(),clientDueDeligenceRequest.getSecurity_subtype_id(),
									clientDueDeligenceRequest.getApplicationTypeId(),clientDueDeligenceRequest.getAssetTypeId(),clientDueDeligenceRequest.getUserName(),date,clientDueDeligenceRequest.getHeaderSequence());
						} else {
						   updateStatus = jdbcTemplate.update(APIConstant.QUERY_UPDATE_DUE_DELIGENCE_ROW_MODULE3, new Object[]{
								clientDueDeligenceRequest.getDdParentSequence(),clientDueDeligenceRequest.getDdData(),
								clientDueDeligenceRequest.getHeader1(),clientDueDeligenceRequest.getHeader2(),clientDueDeligenceRequest.getHeader3(),clientDueDeligenceRequest.getHeader4(),
								clientDueDeligenceRequest.getComplianceOption(),clientDueDeligenceRequest.getConditions(),clientDueDeligenceRequest.getCreditSectorId(),
								clientDueDeligenceRequest.getLoanSchemeId(),clientDueDeligenceRequest.getLoanVariant_keyword(),clientDueDeligenceRequest.getBorrowerTypeId(),
								clientDueDeligenceRequest.getCriticaltyFactor(),clientDueDeligenceRequest.getProfessionId(),clientDueDeligenceRequest.getLoanApplicationTypeId(),
								clientDueDeligenceRequest.getSecurityId(),clientDueDeligenceRequest.getSecurityTypeId(),clientDueDeligenceRequest.getSecurity_subtype_id(),
								clientDueDeligenceRequest.getApplicationTypeId(),clientDueDeligenceRequest.getAssetTypeId(),clientDueDeligenceRequest.getHeaderSequence(),
								clientDueDeligenceRequest.getRemarks(),clientDueDeligenceRequest.getUserName(),date,clientDueDeligenceRequest.getDdId(),clientDueDeligenceRequest.getDdSequence()});
						}
					} else if(APIConstant.MODULE_NAME_M4.equalsIgnoreCase(clientDueDeligenceRequest.getModuleName())){
						try {
		            		existingDueDeligenceQuery  =APIConstant.QUERY_GET_CLIENT_DUE_DELIGENCE_M4;
			                existingDueDeligenceQuery = existingDueDeligenceQuery + " where bmddm1.dd_Id= ? and dd_sequence = ?";
			                List<ClientDueDeligenceResponse> resultSet = jdbcTemplate.query(existingDueDeligenceQuery,new Object[]{clientDueDeligenceRequest.getDdId(),clientDueDeligenceRequest.getDdSequence()},new ClientDueDeligenceRowMapper());
			                if(CollectionUtils.isEmpty(resultSet) || resultSet.size() ==0) {
			                	isNewAddition = true;
			                }
		                } catch (EmptyResultDataAccessException e) {
		        			logger.info("No user returned from dD id :"
		                       +clientDueDeligenceRequest.getDdId() +" and ddSesequence "+clientDueDeligenceRequest.getDdSequence());
		        			isNewAddition = true;
		        	    }
						if(isNewAddition) {
							updateStatus = jdbcTemplate.update(APIConstant.QUERY_INSERT_NEW_DUE_DELIGENCE_ROW_MODULE4,clientDueDeligenceRequest.getDdId(),clientDueDeligenceRequest.getDdSequence(),
									clientDueDeligenceRequest.getDdParentSequence(),clientDueDeligenceRequest.getDdData(),clientDueDeligenceRequest.getHeader1(),clientDueDeligenceRequest.getHeader2(),
									clientDueDeligenceRequest.getHeader3(),clientDueDeligenceRequest.getHeader4(),clientDueDeligenceRequest.getComplianceOption(),clientDueDeligenceRequest.getConditions(),clientDueDeligenceRequest.getCreditSectorId(),
									clientDueDeligenceRequest.getLoanSchemeId(),clientDueDeligenceRequest.getLoanVariant_keyword(),clientDueDeligenceRequest.getBorrowerTypeId(),
									clientDueDeligenceRequest.getCriticaltyFactor(),clientDueDeligenceRequest.getProfessionId(),clientDueDeligenceRequest.getLoanApplicationTypeId(),
									clientDueDeligenceRequest.getSecurityId(),clientDueDeligenceRequest.getSecurityTypeId(),clientDueDeligenceRequest.getSecurity_subtype_id(),
									clientDueDeligenceRequest.getApplicationTypeId(),clientDueDeligenceRequest.getAssetTypeId(),clientDueDeligenceRequest.getUserName(),date,clientDueDeligenceRequest.getHeaderSequence());
						} else {
							updateStatus = jdbcTemplate.update(APIConstant.QUERY_UPDATE_DUE_DELIGENCE_ROW_MODULE4, new Object[]{
						
								clientDueDeligenceRequest.getDdParentSequence(),clientDueDeligenceRequest.getDdData(),
								clientDueDeligenceRequest.getHeader1(),clientDueDeligenceRequest.getHeader2(),clientDueDeligenceRequest.getHeader3(),clientDueDeligenceRequest.getHeader4(),
								clientDueDeligenceRequest.getComplianceOption(),clientDueDeligenceRequest.getConditions(),clientDueDeligenceRequest.getCreditSectorId(),
								clientDueDeligenceRequest.getLoanSchemeId(),clientDueDeligenceRequest.getLoanVariant_keyword(),clientDueDeligenceRequest.getBorrowerTypeId(),
								clientDueDeligenceRequest.getCriticaltyFactor(),clientDueDeligenceRequest.getProfessionId(),clientDueDeligenceRequest.getLoanApplicationTypeId(),
								clientDueDeligenceRequest.getSecurityId(),clientDueDeligenceRequest.getSecurityTypeId(),clientDueDeligenceRequest.getSecurity_subtype_id(),
								clientDueDeligenceRequest.getApplicationTypeId(),clientDueDeligenceRequest.getAssetTypeId(),clientDueDeligenceRequest.getHeaderSequence(),
								clientDueDeligenceRequest.getRemarks(),clientDueDeligenceRequest.getUserName(),date,clientDueDeligenceRequest.getDdId(),clientDueDeligenceRequest.getDdSequence()});
						}
					} else if(APIConstant.MODULE_NAME_M5.equalsIgnoreCase(clientDueDeligenceRequest.getModuleName())){
						try {
		            		existingDueDeligenceQuery  =APIConstant.QUERY_GET_CLIENT_DUE_DELIGENCE_M5;
			                existingDueDeligenceQuery = existingDueDeligenceQuery + " where bmddm1.dd_Id= ? and dd_sequence = ?";
			                List<ClientDueDeligenceResponse> resultSet = jdbcTemplate.query(existingDueDeligenceQuery,new Object[]{clientDueDeligenceRequest.getDdId(),clientDueDeligenceRequest.getDdSequence()},new ClientDueDeligenceRowMapper());
			                if(CollectionUtils.isEmpty(resultSet) || resultSet.size() ==0) {
			                	isNewAddition = true;
			                }
		                } catch (EmptyResultDataAccessException e) {
		        			logger.info("No user returned from dD id :"
		                       +clientDueDeligenceRequest.getDdId() +" and ddSesequence "+clientDueDeligenceRequest.getDdSequence());
		        			isNewAddition = true;
		        	    }
						if(isNewAddition) {
							updateStatus = jdbcTemplate.update(APIConstant.QUERY_INSERT_NEW_DUE_DELIGENCE_ROW_MODULE5,clientDueDeligenceRequest.getDdId(),clientDueDeligenceRequest.getDdSequence(),
									clientDueDeligenceRequest.getDdParentSequence(),clientDueDeligenceRequest.getDdData(),clientDueDeligenceRequest.getHeader1(),clientDueDeligenceRequest.getHeader2(),
									clientDueDeligenceRequest.getHeader3(),clientDueDeligenceRequest.getHeader4(),clientDueDeligenceRequest.getComplianceOption(),clientDueDeligenceRequest.getConditions(),clientDueDeligenceRequest.getCreditSectorId(),
									clientDueDeligenceRequest.getLoanSchemeId(),clientDueDeligenceRequest.getLoanVariant_keyword(),clientDueDeligenceRequest.getBorrowerTypeId(),
									clientDueDeligenceRequest.getCriticaltyFactor(),clientDueDeligenceRequest.getProfessionId(),clientDueDeligenceRequest.getLoanApplicationTypeId(),
									clientDueDeligenceRequest.getSecurityId(),clientDueDeligenceRequest.getSecurityTypeId(),clientDueDeligenceRequest.getSecurity_subtype_id(),
									clientDueDeligenceRequest.getApplicationTypeId(),clientDueDeligenceRequest.getAssetTypeId(),clientDueDeligenceRequest.getUserName(),date,clientDueDeligenceRequest.getHeaderSequence());
						} else {
						    updateStatus = jdbcTemplate.update(APIConstant.QUERY_UPDATE_DUE_DELIGENCE_ROW_MODULE5, new Object[]{
								clientDueDeligenceRequest.getDdParentSequence(),clientDueDeligenceRequest.getDdData(),
								clientDueDeligenceRequest.getHeader1(),clientDueDeligenceRequest.getHeader2(),clientDueDeligenceRequest.getHeader3(),clientDueDeligenceRequest.getHeader4(),
								clientDueDeligenceRequest.getComplianceOption(),clientDueDeligenceRequest.getConditions(),clientDueDeligenceRequest.getCreditSectorId(),
								clientDueDeligenceRequest.getLoanSchemeId(),clientDueDeligenceRequest.getLoanVariant_keyword(),clientDueDeligenceRequest.getBorrowerTypeId(),
								clientDueDeligenceRequest.getCriticaltyFactor(),clientDueDeligenceRequest.getProfessionId(),clientDueDeligenceRequest.getLoanApplicationTypeId(),
								clientDueDeligenceRequest.getSecurityId(),clientDueDeligenceRequest.getSecurityTypeId(),clientDueDeligenceRequest.getSecurity_subtype_id(),
								clientDueDeligenceRequest.getApplicationTypeId(),clientDueDeligenceRequest.getAssetTypeId(),clientDueDeligenceRequest.getHeaderSequence(),
								clientDueDeligenceRequest.getRemarks(),clientDueDeligenceRequest.getUserName(),date,clientDueDeligenceRequest.getDdId(),clientDueDeligenceRequest.getDdSequence()});
						}
					}
					
					if(updateStatus > 0)
						clientDueDeligenceResponse.setMessageCode(APIConstant.SUCCESS_CODE);
					else {
						logger.error("unable to update the due deligence with update status as 0 for module :"+clientDueDeligenceRequest.getModuleName()+
								" DDid :"+clientDueDeligenceRequest.getDdId()+" and dd sequence :"+clientDueDeligenceRequest.getDdSequence());
						throw new APIException(APIConstant.MSG_UPDATE_CLIENT_DUE_DELIGENCE);
					}
				} else if(APIConstant.ACTION_SUBMIT.equalsIgnoreCase(clientDueDeligenceRequest.getAction())
						&& !StringUtils.isEmpty(clientDueDeligenceRequest.getModuleName())) {
					if(clientDueDeligenceRequest.getModuleName().equalsIgnoreCase(APIConstant.MODULE_NAME_M1)) {
						String runFunction = "{ ? = call bmadmin.funcupdateclientddapsm1(?,?,?) }";
						connection = jdbcTemplate.getDataSource().getConnection();
						cs = connection.prepareCall(runFunction);
						cs.registerOutParameter(1, Types.VARCHAR);
						cs.setString(2, clientDueDeligenceRequest.getUserName());
						cs.setInt(3, clientDueDeligenceRequest.getDdId());
						int i = 0;
						String[] arrDueDeligenceString =  new String[clientDueDeligenceRequest.getDueDeligenceDetails().size()];
						for(ClientDueDeligenceArray arr: clientDueDeligenceRequest.getDueDeligenceDetails()) {
							String inputData = "("+clientDueDeligenceRequest.getModuleName()+","
					        		+clientDueDeligenceRequest.getHeader1()+","
									+clientDueDeligenceRequest.getHeader2()+","
									+clientDueDeligenceRequest.getHeader3()+","
									+clientDueDeligenceRequest.getHeader4()+","
									+arr.getDdSequence()+","
									+arr.getDdParentSequence()+","
									+"\""+arr.getDd_data()+"\","
									+"\""+arr.getGeneralOption()+"\","
									+"\""+arr.getApplicantOption()+"\","
									+"\""+arr.getCoApplicantOption()+"\","
									+"\""+arr.getGuarantorOption()+"\","
									+arr.getRemarks()+")";
							arrDueDeligenceString[i] = inputData;
							i++;
						}
						cs.setArray(4, connection.createArrayOf(  
							      "bmadmin.obj_client_m1_ddaps",arrDueDeligenceString));
						cs.executeUpdate();
					} else {
						String runFunction = "{ ? = call bmadmin.funcupdateclientddapsm25(?,?,?) }";
						connection = jdbcTemplate.getDataSource().getConnection();
						cs = connection.prepareCall(runFunction);
						cs.registerOutParameter(1, Types.VARCHAR);
						cs.setString(2, clientDueDeligenceRequest.getUserName());
						cs.setInt(3, clientDueDeligenceRequest.getDdId());
						int i = 0;
						String[] arrDueDeligenceString =  new String[clientDueDeligenceRequest.getDueDeligenceDetails().size()];
						for(ClientDueDeligenceArray arr: clientDueDeligenceRequest.getDueDeligenceDetails()) {
							String inputData = "("+clientDueDeligenceRequest.getModuleName()+","
					        		+clientDueDeligenceRequest.getHeader1()+","
									+clientDueDeligenceRequest.getHeader2()+","
									+clientDueDeligenceRequest.getHeader3()+","
									+clientDueDeligenceRequest.getHeader4()+","
									+arr.getDdSequence()+","
									+arr.getDdParentSequence()+","
									+"\""+arr.getDd_data()+"\","
									+"\""+arr.getComplianceOption()+"\","
									+arr.getRemarks()+")";
							arrDueDeligenceString[i] = inputData;
							i++;
						}
						cs.setArray(4, connection.createArrayOf(  
							      "bmadmin.obj_client_m25_ddaps",arrDueDeligenceString));
						cs.executeUpdate();
					}
					functionResult = cs.getString(1);
					logger.info("Result of function funcupdateclientddapsm25 :"+functionResult);
					clientDueDeligenceResponse.setMessageCode(functionResult);
				}
			}  else {
				throw new DataAccessException(APIConstant.MSG_MISSING_DD_SEQUENCE);
			}
		} catch (Exception ex) {
			logger.error("unable to update due deligence for "+clientDueDeligenceRequest.getModuleName(),ex);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} finally {
			try {
				if(null!= cs)
					cs.close();
				if(null!=connection)
					connection.close();
			} catch (SQLException e) {
				if(clientDueDeligenceRequest.getModuleName().equalsIgnoreCase(APIConstant.MODULE_NAME_M1) )
					logger.error("unable to close connection after execution for "+clientDueDeligenceRequest.getModuleName(),e);
				else 
					logger.error("unable to close connection after execution for "+clientDueDeligenceRequest.getModuleName(),e);
				throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
			}
		}
		return clientDueDeligenceResponse;
	}


	@Override
	public ClientConfigResponse addBankDetails(ClientAuditFirmBankRequest auditBankDetailRequest) throws DataAccessException {
		ClientConfigResponse clientConfigResponse = null;
		Connection connection = null;
		String functionResult = null; 
		CallableStatement cs = null;
		Integer clientGroupId = -1;
		try {
			String runFunction = "{ ? = call bmadmin.funcaddauditbank(?,?,?) }";
			connection = jdbcTemplate.getDataSource().getConnection();
			cs = connection.prepareCall(runFunction);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setString(2, auditBankDetailRequest.getCreatedBy());
			cs.setInt(3, auditBankDetailRequest.getClientId());
						
			if(!StringUtils.isEmpty(auditBankDetailRequest.getClientTypeId()) &&
					auditBankDetailRequest.getClientTypeId() == APIConstant.CLIENT_TYPE_AUDIT_FIRM) {
				List<ClientBankResponse> resultSet =  jdbcTemplate.query(APIConstant.QUERY_GET_CLIENT_BANK_DETAILS,
						new Object[]{auditBankDetailRequest.getClientId()}, new ClientBankRowMapper());
				if(!CollectionUtils.isEmpty(resultSet)) {
					ClientBankResponse  clientDtl =  resultSet.get(0);
					clientGroupId = clientDtl.getClientGroupId();
				} 
			}
			int i = 0;
			String[] arrBankDtl =  new String[auditBankDetailRequest.getBankInfo().size()];
			for(BankDetails arr: auditBankDetailRequest.getBankInfo()) {
				if(!StringUtils.isEmpty(arr.getPincode())) {
					String inputData = "("+clientGroupId+","
				            +"\""+arr.getBankName()+"\","
			        		+"\""+arr.getAddress()+"\","
			        		+arr.getCity()+","
			        		+arr.getPincode()+","
			        		+arr.getState()+")";
					arrBankDtl[i] = inputData;
				} else {
					String inputData = "("+clientGroupId+","
				            +"\""+arr.getBankName()+"\","
			        		+"\""+arr.getAddress()+"\","
			        		+arr.getCity()+","
			        		+0+","
			        		+arr.getState()+")";
					arrBankDtl[i] = inputData;
				}
				i++;
			}
			cs.setArray(4,connection.createArrayOf(  
				      "bmadmin.obj_audit_banks",arrBankDtl));
			cs.executeUpdate();
			functionResult = cs.getString(1);
			logger.info("Output of function funcaddauditbank :"+functionResult);
			clientConfigResponse = new ClientConfigResponse();
			clientConfigResponse.setMessageCode(functionResult);
			return clientConfigResponse;
		} catch (SQLException e) {
			logger.error("unable to execute the function : funcaddauditbank",e);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} finally {
			try {
				if(null!= cs)
					cs.close();
				if(null!=connection)
					connection.close();
			} catch (SQLException e) {
				logger.error("unable to close the callable statement or connection for function : funcaddauditbank",e);
				throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
			}
		}

	}


	@Override
	public ClientResponse getClientInformation(ClientConfigRequest clientConfigRequest) throws DataAccessException {
		try {
			if(null!=clientConfigRequest && !StringUtils.isEmpty(clientConfigRequest.getClientId())){
				List<ClientResponse> resultSet =  jdbcTemplate.query(APIConstant.QUERY_GET_CLIENT_DETAILS,
						new Object[]{clientConfigRequest.getClientId()}, new ClientInfoRowMapper());
				if(!CollectionUtils.isEmpty(resultSet)) {
					return resultSet.get(0);
				} 
			}
		} catch (Exception ex) {
			logger.error("Unable to get client details: ",ex);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		}
		return null;
	}


	@Override
	public List<ClientBankResponse> getBankDetails(ClientConfigRequest clientConfigRequest) throws DataAccessException {
		List<ClientBankResponse> bankList = null;
		try {
			if(null!=clientConfigRequest && !StringUtils.isEmpty(clientConfigRequest.getClientId())){
				bankList =  jdbcTemplate.query(APIConstant.QUERY_GET_CLIENT_BANK_DETAILS,
						new Object[]{clientConfigRequest.getClientId()}, new ClientBankRowMapper());
			}
		} catch (EmptyResultDataAccessException e) {
			logger.error("No bank details found for client id : ",e);
			return new ArrayList<ClientBankResponse>();
	    } catch (Exception ex) {
			logger.error("Unable to get bank details: ",ex);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		}
		return bankList;
	}


	@Override
	public List<ClientLoanVariantResponse> getClientLoanVariant(ClientConfigRequest clientConfigRequest)
			throws DataAccessException {
		List<ClientLoanVariantResponse> clientLoanVariant = null;
		try {
			if(null!=clientConfigRequest && !StringUtils.isEmpty(clientConfigRequest.getClientId())){
				if(null!=clientConfigRequest.getClientTypeId() && clientConfigRequest.getClientTypeId() ==3) {
				  clientLoanVariant =  jdbcTemplate.query(APIConstant.QUERY_GET_CLIENT_LOANVARIANT_DETAILS_FOR_AUDIT,
							new Object[]{clientConfigRequest.getClientId()}, new ExistingClientLoanVariantRowMapper());
				} else {
				   clientLoanVariant =  jdbcTemplate.query(APIConstant.QUERY_GET_CLIENT_LOANVARIANT_DETAILS,
						new Object[]{clientConfigRequest.getClientId()}, new ExistingClientLoanVariantRowMapper());
				}
			}
		} catch (EmptyResultDataAccessException e) {
			logger.error("No client loan variant found for client id : ",e);
			return new ArrayList<ClientLoanVariantResponse>();
	    } catch (Exception ex) {
			logger.error("Unable to get client loan variants: ",ex);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		}
		return clientLoanVariant;
	}


	@Override
	public List<RegistrationClientResponse> getListOfClientByClientTypeId(ClientConfigRequest clientConfigRequest)
			throws DataAccessException {
		try {
			if(null!=clientConfigRequest && !StringUtils.isEmpty(clientConfigRequest.getClientTypeId())){
				return jdbcTemplate.query(APIConstant.QUERY_GET_CLIENTS_BY_CLIENTTYPE,
						new Object[]{clientConfigRequest.getClientTypeId()}, new ClientListRowMapper());
			}
		} catch (EmptyResultDataAccessException e) {
			logger.error("No client found for client type id : ",e);
			return new ArrayList<RegistrationClientResponse>();
	    } catch (Exception ex) {
			logger.error("Unable to get list of client by client type id: ",ex);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		}
		return new ArrayList<RegistrationClientResponse>();
	}


	@Override
	public int deleteDueDeligence(ClientDeleteDueDeligenceRequest dueDeligenceRequest)
			throws DataAccessException {
		int deleteStatus = -1;
		try {
			if(null!=dueDeligenceRequest && !StringUtils.isEmpty(dueDeligenceRequest.getDdId())
					&& !StringUtils.isEmpty(dueDeligenceRequest.getDdSequence())
					&& !StringUtils.isEmpty(dueDeligenceRequest.getModuleName())) {
				if(APIConstant.MODULE_NAME_M1.equalsIgnoreCase(dueDeligenceRequest.getModuleName()))
					deleteStatus = jdbcTemplate.update(APIConstant.QUERY_DELETE_DUE_DELIGENCE_BY_CLIENT_MODULE1,
							new Object[]{dueDeligenceRequest.getDdId(),
									dueDeligenceRequest.getDdSequence()});
				else if(APIConstant.MODULE_NAME_M2.equalsIgnoreCase(dueDeligenceRequest.getModuleName()))
					deleteStatus = jdbcTemplate.update(APIConstant.QUERY_DELETE_DUE_DELIGENCE_BY_CLIENT_MODULE2,
							new Object[]{dueDeligenceRequest.getDdId(),
									dueDeligenceRequest.getDdSequence()});
				else if(APIConstant.MODULE_NAME_M3.equalsIgnoreCase(dueDeligenceRequest.getModuleName()))
					deleteStatus = jdbcTemplate.update(APIConstant.QUERY_DELETE_DUE_DELIGENCE_BY_CLIENT_MODULE3,
							new Object[]{dueDeligenceRequest.getDdId(),
									dueDeligenceRequest.getDdSequence()});
				else if(APIConstant.MODULE_NAME_M4.equalsIgnoreCase(dueDeligenceRequest.getModuleName()))
					deleteStatus = jdbcTemplate.update(APIConstant.QUERY_DELETE_DUE_DELIGENCE_BY_CLIENT_MODULE4,
							new Object[]{dueDeligenceRequest.getDdId(),
									dueDeligenceRequest.getDdSequence()});
				else if(APIConstant.MODULE_NAME_M5.equalsIgnoreCase(dueDeligenceRequest.getModuleName()))
					deleteStatus = jdbcTemplate.update(APIConstant.QUERY_DELETE_DUE_DELIGENCE_BY_CLIENT_MODULE5,
							new Object[]{dueDeligenceRequest.getDdId(),
									dueDeligenceRequest.getDdSequence()});
			} else {
				logger.error("unable to delete the due deligence as input is not passed properly as input passed : ddId :"
			           +dueDeligenceRequest.getDdId()+" ddSequence :"+
						dueDeligenceRequest.getDdSequence()+ "ddParentSequence :" + dueDeligenceRequest.getDdParentSequence()); 
				throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
			}
		} catch (Exception ex) {
			logger.error("unable to delete the due deligence ",ex);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		}
		return deleteStatus;
	}
	
	@Override
	public Long getNewClientDueDeligence(Integer ddId) throws DataAccessException {
		try {
			if(ddId>0) {
				return jdbcTemplate.queryForObject(APIConstant.QUERY_GET_NEW_DELIGENCE, new Object[]{ddId,ddId,ddId,ddId,ddId}, Long.class);
			    			
			} else {
				logger.error(APIConstant.MSG_NO_DDID + " for call of getNewClientDueDeligence method");
				throw new DataAccessException(APIConstant.MSG_NO_DDID);
			}
		} catch (Exception ex) {
			logger.error("Unable to get client module header :",ex);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		}
	}


	@Override
	public ClientBankResponse deleteClientBank(DeleteBankDetails bankRequest) throws DataAccessException {
		int deleteStatus = -1;
		ClientBankResponse bankResponse = null;
		Connection connection = null;
		String functionResult = null; 
		CallableStatement cs = null;
		Integer clientGroupId = -1;
			
		
		try {
			if(null!=bankRequest.getClientId() && bankRequest.getClientId() >0 &&
					!CollectionUtils.isEmpty(bankRequest.getBankDetails()) && bankRequest.getBankDetails().get(0).getClientGroupId() >0) {
				/*deleteStatus = jdbcTemplate.update(APIConstant.QUERY_DELETE_BANK_DTL_BY_CLIENTID,
						new Object[]{bankRequest.getClientId(),
								bankRequest.getBankDetails().get(0).getClientGroupId()});*/
				String runFunction = "{ ? = call bmadmin.funcdeleteclientbank(?,?) }";
				connection = jdbcTemplate.getDataSource().getConnection();
				cs = connection.prepareCall(runFunction);
				cs.registerOutParameter(1, Types.VARCHAR);
				cs.setInt(2, bankRequest.getClientId());
				cs.setInt(3, bankRequest.getBankDetails().get(0).getClientGroupId());
				cs.executeUpdate();
				functionResult = cs.getString(1);
				logger.info("Output of function funcdeleteclientbank :"+functionResult);
				
			}
			bankResponse = new ClientBankResponse();
			bankResponse.setMessageCode(functionResult);
			if(null==functionResult ) {
				logger.error("unable to deleteClientBank for clientId :"+bankRequest.getClientId()+" and clientId :"+
			       bankRequest.getClientId());
				throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
			} 
			return bankResponse;
		} catch (Exception e) {
			logger.error("unable to deleteClientBank",e);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		}
	}


	@Override
	public List<ActiveClient> getListOfActiveClients() throws DataAccessException {
		return jdbcTemplate.query(APIConstant.GET_ACTIVE_CLIENT_LIST,new ActiveClientRowMapper());
	}

}