/**
 * 
 */
package com.bankMitra.repository.admin;

import java.util.List;

import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.admin.HeaderRequest;
import com.bankMitra.model.admin.response.HeaderResponse;

/**
 * @author BankMitra
 *
 */
public interface HeaderRepository {

	HeaderResponse updateHeader(HeaderRequest headerRequest) throws DataAccessException;

	List<HeaderResponse> getListOfHeaders(String headerKey, String englishDescription, String nonEnglishDescription)  throws DataAccessException;

}
