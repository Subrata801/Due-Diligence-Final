/**
 * 
 */
package com.bankMitra.validator;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bankMitra.model.admin.BankDetails;
import com.bankMitra.model.admin.ClientAuditFirmBankRequest;
import com.bankMitra.model.admin.ClientLoanVariantRequest;
import com.bankMitra.model.admin.UserRequest;
import com.bankMitra.util.APIConstant;

/**
 * @author BankMitra
 *
 */
@Component
public class SearchUserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return UserRequest.class == clazz;
	}

	@Override
	public void validate(Object target, Errors errors) {
				
		UserRequest userReq = (UserRequest) target;
		if(StringUtils.isEmpty(userReq.getKeywordType())) {
	    	errors.reject("searchCriteria.missing","One of the search criteria is required");
	    } else if(!StringUtils.isEmpty(userReq.getSearchCriteria()) && 
	    		!"usertypesearch".equalsIgnoreCase(userReq.getSearchCriteria()) 
	    		&& StringUtils.isEmpty(userReq.getKeyword())) {
	    	errors.reject("searchText.missing","Search Text is required");
	    } /*else if(!StringUtils.isEmpty(userReq.getSearchText()) && !StringUtils.isEmpty(userReq.getSearchCriteria())
	    		&& userReq.getSearchCriteria().equalsIgnoreCase(APIConstant.USER_SEARCH_TYPE_BY_MOBILE) &&
	    		!validatePhoneNumber(String.valueOf(userReq.getSearchText()))) {
	    	errors.reject("searchTextMobile.invalid","Please provide a valid mobile number");
	    }*/
		
	}
	
	private static boolean validatePhoneNumber(String phoneNumber) {
		  // validate phone numbers of format "1234567890"
		  if (phoneNumber.matches("\\d{10}"))
		   return true;
		  // validating phone number with -, . or spaces
		  else if (phoneNumber.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}"))
		   return true;
		  // validating phone number with extension length from 3 to 5
		  else if (phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}"))
		   return true;
		  // validating phone number where area code is in braces ()
		  else if (phoneNumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}"))
		   return true;
		  // Validation for India numbers
		  else if (phoneNumber.matches("\\d{4}[-\\.\\s]\\d{3}[-\\.\\s]\\d{3}"))
		   return true;
		  else if (phoneNumber.matches("\\(\\d{5}\\)-\\d{3}-\\d{3}"))
		   return true;

		  else if (phoneNumber.matches("\\(\\d{4}\\)-\\d{3}-\\d{3}"))
		   return true;
		  // return false if nothing matches the input
		  else
		   return false;

       }


}
