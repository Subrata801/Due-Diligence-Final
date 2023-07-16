/**
 * 
 */
package com.bankMitra.repository.admin.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.admin.SubscriptionModel;
import com.bankMitra.model.admin.SubscriptionSearchRequest;
import com.bankMitra.model.admin.response.SubscriptionModelResponse;
import com.bankMitra.model.subscription.SubscriptionRequest;
import com.bankMitra.model.subscription.response.SubscriptionResponse;
import com.bankMitra.repository.admin.SubscriptionRepository;
import com.bankMitra.repository.admin.rowmapper.SubscriptionRowMapper;
import com.bankMitra.repository.admin.rowmapper.SubscriptionSearchRowMapper;
import com.bankMitra.util.APIConstant;

/**
 * @author BankMitra
 *
 */
@Repository
public class SubscriptionRepositoryImpl implements SubscriptionRepository {

	private static final Logger logger = LoggerFactory.getLogger(SubscriptionRepositoryImpl.class);
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	/* (non-Javadoc)
	 * @see com.bankMitra.repository.admin.SubscriptionRepository#createSubscription(com.bankMitra.model.subscription.SubscriptionRequest)
	 */
	@Override
	public SubscriptionResponse createSubscription(SubscriptionRequest subscriptionRequest) throws DataAccessException {
		SubscriptionResponse subscriptionResponse = null;
		Connection connection = null;
		String functionResult = null; 
		CallableStatement cs = null;
		try {
			if(subscriptionRequest.getSubscriptionId() == null || subscriptionRequest.getSubscriptionId() <=0) {
				String runFunction = "{ ? = call bmadmin.funcdefinesubscription(?,?,?,?,?,?,?,?,?,?,?,?) }";
				connection = jdbcTemplate.getDataSource().getConnection();
				cs = connection.prepareCall(runFunction);
				cs.registerOutParameter(1, Types.VARCHAR);
				cs.setString(2, subscriptionRequest.getCreatedBy());
				cs.setInt(3, subscriptionRequest.getProductTypeId());
				cs.setInt(4, subscriptionRequest.getSubscriptionTypeId());
				cs.setInt(5, subscriptionRequest.getSubscriptionSubTypeId());
				cs.setString(6, subscriptionRequest.getSubscriptionName());
				cs.setInt(7, subscriptionRequest.getSubscriptionPeriod());
				if(!StringUtils.isEmpty(subscriptionRequest.getMaxBranches()))
					cs.setInt(8, subscriptionRequest.getMaxBranches());
				else 
					cs.setInt(8, 0);
				
				if(!StringUtils.isEmpty(subscriptionRequest.getMaxNumOfLoanSchemes()))
					cs.setInt(9, subscriptionRequest.getMaxNumOfLoanSchemes());
				else 
					cs.setInt(9, 0);
				if(null!=subscriptionRequest.getMaxBanks())
					cs.setInt(10, subscriptionRequest.getMaxBanks());
				else 
					cs.setInt(10, 0);
				cs.setInt(11, subscriptionRequest.getRenewalReminderDate());
				cs.setInt(12, subscriptionRequest.getDataValidityPeriod());
				cs.setInt(13, subscriptionRequest.getPricePerMonth());
				cs.executeUpdate();
				functionResult = cs.getString(1);
				//System.out.println(functionResult);
				subscriptionResponse = new SubscriptionResponse();
				subscriptionResponse.setMessageCode(functionResult);
				return subscriptionResponse;
			} else {
				int isUpdated = jdbcTemplate.update(APIConstant.QUERY_UPDATE_SUBSCRIPTION,
								subscriptionRequest.getProductTypeId(),subscriptionRequest.getSubscriptionTypeId(),
								subscriptionRequest.getSubscriptionSubTypeId(),subscriptionRequest.getSubscriptionName(),
								subscriptionRequest.getSubscriptionPeriod(),subscriptionRequest.getMaxBranches(),
								subscriptionRequest.getMaxNumOfLoanSchemes(),subscriptionRequest.getDataValidityPeriod(),
								subscriptionRequest.getPricePerMonth(),subscriptionRequest.getRenewalReminderDate(),
								subscriptionRequest.getSubscriptionId());
				subscriptionResponse = new SubscriptionResponse();
				if(isUpdated>0)
					subscriptionResponse.setMessageCode(APIConstant.SUCCESS_CODE);
				else
					subscriptionResponse.setMessageCode("E02");
				return subscriptionResponse;
			}
		} catch (Exception e) {
			logger.error("unable to execute the function :funcdefinesubscription ",e);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		} finally {
			try {
				if(null!= cs)
					cs.close();
				if(null!=connection)
					connection.close();
			} catch (SQLException e) {
				logger.error("unable to close the connection :funcdefinesubscription ",e);
			}
		}
	}

	@Override
	public List<SubscriptionModelResponse> getListOfSubscriptionModel(SubscriptionModel subscriptionModel) throws DataAccessException {
		try {
			if(null!=subscriptionModel && !StringUtils.isEmpty(subscriptionModel.getSubscriptionTypeId())
					&& !StringUtils.isEmpty(subscriptionModel.getSubscriptionSubTypeId()))
				return jdbcTemplate.query(APIConstant.QUERY_GET_SUBSCRIPTION_MODEL,
					new Object[]{subscriptionModel.getSubscriptionTypeId(),
							subscriptionModel.getSubscriptionSubTypeId(),subscriptionModel.getProductTypeId()}, 
					new SubscriptionRowMapper());
			else 
				return new ArrayList<SubscriptionModelResponse>();
		} catch (Exception ex) {
			logger.error("unable to execute the query for getListOfSubscriptionModel ",ex);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		}
	}

	@Override
	public List<SubscriptionResponse> getListOfSubscriptions(SubscriptionSearchRequest searchSubscriptionRequest)
			throws DataAccessException {
		try {
			if(null!=searchSubscriptionRequest && !StringUtils.isEmpty(searchSubscriptionRequest.getProductTypeId())
					&& !StringUtils.isEmpty(searchSubscriptionRequest.getSubscriptionTypeId())
					&& !StringUtils.isEmpty(searchSubscriptionRequest.getSubscriptionSubTypeId())) {
				return jdbcTemplate.query(APIConstant.QUERY_GET_SUBSCRIPTION_LIST,
						new Object[]{searchSubscriptionRequest.getProductTypeId(),searchSubscriptionRequest.getSubscriptionTypeId(),
								searchSubscriptionRequest.getSubscriptionSubTypeId()}, 
						new SubscriptionSearchRowMapper());
			} else if(null!=searchSubscriptionRequest && !StringUtils.isEmpty(searchSubscriptionRequest.getSubscriptionId())) {
				return jdbcTemplate.query(APIConstant.QUERY_GET_SUBSCRIPTION_BY_ID,
						new Object[]{searchSubscriptionRequest.getSubscriptionId()}, 
						new SubscriptionSearchRowMapper());
			} else {
				return new ArrayList<SubscriptionResponse>();
			}
		} catch (Exception ex) {
			logger.error("unable to execute the query for getListOfSubscriptions ",ex);
			throw new DataAccessException(APIConstant.ERROR_CODE_ADMINMESAGE);
		}
	}

}
