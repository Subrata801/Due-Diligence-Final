/**
 * 
 */
package com.bankMitra.service.clientManagement;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

import com.bankMitra.exception.APIException;
import com.bankMitra.model.clientManagement.request.ManageEmployeeRequest;
import com.bankMitra.model.clientManagement.response.EmployeeUploadResponse;
import com.bankMitra.model.clientManagement.response.ManageEmployeeResponse;

/**
 * @author BankMitra
 *
 */
public interface ManageEmployeeService {

	List<ManageEmployeeResponse> getAllEmployees(@Valid ManageEmployeeRequest manageEmployeeRequest) throws APIException;

	ManageEmployeeResponse manageEmployee(@Valid ManageEmployeeRequest manageEmployeeRequest) throws APIException;

	EmployeeUploadResponse uploadTemplate(MultipartFile file, String userName) throws APIException;

	ManageEmployeeResponse updateEmployee(@Valid ManageEmployeeRequest manageEmployeeRequest) throws APIException;

	ByteArrayInputStream downloadErrorFile(String clientId) throws APIException;
	
}