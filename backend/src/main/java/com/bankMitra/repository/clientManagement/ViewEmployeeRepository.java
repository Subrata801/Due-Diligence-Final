/**
 * 
 */
package com.bankMitra.repository.clientManagement;

import java.util.List;

import javax.validation.Valid;

import com.bankMitra.exception.DataAccessException;
import com.bankMitra.model.clientManagement.request.EmployeeUploadArray;
import com.bankMitra.model.clientManagement.request.ManageEmployeeRequest;
import com.bankMitra.model.clientManagement.response.EmpErrorDownloadResponse;
import com.bankMitra.model.clientManagement.response.EmployeeUploadResponse;
import com.bankMitra.model.clientManagement.response.ManageEmployeeResponse;

/**
 * @author Bank Maitra
 *
 */
public interface ViewEmployeeRepository {

	List<ManageEmployeeResponse> getAllEmployees(@Valid ManageEmployeeRequest manageEmployeeRequest) throws DataAccessException;

	ManageEmployeeResponse manageEmployee(ManageEmployeeRequest manageEmployeeRequest) throws DataAccessException;

	EmployeeUploadResponse uploadTemplate(String clientId, List<EmployeeUploadArray> employeeList,
			String userName)  throws DataAccessException;

	ManageEmployeeResponse updateEmployee(ManageEmployeeRequest manageEmployeeRequest)   throws DataAccessException;

	List<EmpErrorDownloadResponse> getErrorRecords(String clientId) throws DataAccessException;
}
