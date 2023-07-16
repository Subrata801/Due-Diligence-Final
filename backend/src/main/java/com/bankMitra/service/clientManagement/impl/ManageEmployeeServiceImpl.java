/**
 * 
 */
package com.bankMitra.service.clientManagement.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.bankMitra.exception.APIException;
import com.bankMitra.exception.DataAccessException;
import com.bankMitra.exception.ResourceNotFoundException;
import com.bankMitra.model.admin.response.ClientDueDeligenceDownloadResponse;
import com.bankMitra.model.clientManagement.request.EmployeeUploadArray;
import com.bankMitra.model.clientManagement.request.ManageEmployeeRequest;
import com.bankMitra.model.clientManagement.response.EmpErrorDownloadResponse;
import com.bankMitra.model.clientManagement.response.EmployeeUploadResponse;
import com.bankMitra.model.clientManagement.response.ManageEmployeeResponse;
import com.bankMitra.model.reference.MessageCode;
import com.bankMitra.repository.clientManagement.ViewEmployeeRepository;
import com.bankMitra.security.services.UserDetailsImpl;
import com.bankMitra.service.clientManagement.ManageEmployeeService;
import com.bankMitra.service.reference.ReferenceService;
import com.bankMitra.util.APIConstant;
import com.bankMitra.util.ExcelHelper;

/**
 * @author Bank Maitra
 *
 */
@Service
public class ManageEmployeeServiceImpl implements ManageEmployeeService {

	private static final Logger logger = LoggerFactory.getLogger(ManageEmployeeServiceImpl.class);
	@Autowired
	ViewEmployeeRepository manageEmployeeRepository;
	
	@Autowired
	ReferenceService refService;
	
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
	
	/* (non-Javadoc)
	 * @see com.bankMitra.service.clientManagement.ManageEmployeeService#getAllEmployees(com.bankMitra.model.clientManagement.request.ManageEmployeeRequest)
	 */
	@Override
	@Transactional(readOnly=true)
	public List<ManageEmployeeResponse> getAllEmployees(@Valid ManageEmployeeRequest manageEmployeeRequest)
			throws APIException {
		List<ManageEmployeeResponse> listOfEmployees = null;
		try {
			listOfEmployees = manageEmployeeRepository.getAllEmployees(manageEmployeeRequest);
		} catch (DataAccessException e) {
			throw new APIException(APIConstant.MSG_GET_EMPLOYEES_LIST_FAILURE,e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_EMPLOYEES_LIST_FAILURE,e.getMessage());
		}
		return listOfEmployees;
	}

	@Override
	@Transactional
	public ManageEmployeeResponse manageEmployee(ManageEmployeeRequest manageEmployeeRequest) throws APIException {
		ManageEmployeeResponse manageEmployeeResponse = null;
		try {
			manageEmployeeResponse  =  manageEmployeeRepository.manageEmployee(manageEmployeeRequest);
			final String dbResponseCode = manageEmployeeResponse.getMessageCode();
			MessageCode filteredMsgData = getMessageDescription(dbResponseCode);
			if(null!=filteredMsgData){
				manageEmployeeResponse.setMessageCode(filteredMsgData.getMessageCode());
				manageEmployeeResponse.setMessageDescription(filteredMsgData.getMessageDescription());
			}
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_MANAGE_EMPLOYEE_FAILURE);
		}
		return manageEmployeeResponse;
	}

	@Override
	@Transactional
	public EmployeeUploadResponse uploadTemplate(MultipartFile file,String clientId) throws APIException {
		List<EmployeeUploadArray> employeeList;
		EmployeeUploadResponse uploadResponse = null;
		try {
			if (ExcelHelper.hasExcelFormat(file)) {
				try {
					employeeList = ExcelHelper.readEmployeeExcelFile(file.getInputStream(),file.getOriginalFilename());
					UserDetailsImpl user = (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				    String userName = user.getUserName();
				    uploadResponse  =  manageEmployeeRepository.uploadTemplate(clientId,employeeList,userName);
					
				} catch (IOException e1) {
					throw new APIException(APIConstant.MSG_UPLOAD_EMPLOYEE_FAILURE,e1.getMessage());
				} catch (DataAccessException e) {
					throw new APIException(APIConstant.MSG_UPLOAD_EMPLOYEE_FAILURE,e.getMessage());
				}
			} else {
				throw new APIException(APIConstant.MSG_INVALID_XLS_FAILURE);
			}
		} catch (Exception e2) {
			logger.error(e2.getMessage());
			throw new APIException(e2.getMessage());
		}
		
		return uploadResponse;
	}

	@Override
	@Transactional
	public ManageEmployeeResponse updateEmployee(ManageEmployeeRequest manageEmployeeRequest) throws APIException {
		ManageEmployeeResponse manageEmployeeResponse = null;
		try {
			manageEmployeeResponse  =  manageEmployeeRepository.updateEmployee(manageEmployeeRequest);
			final String dbResponseCode = manageEmployeeResponse.getMessageCode();
			MessageCode filteredMsgData = getMessageDescription(dbResponseCode);
			if(null!=filteredMsgData){
				manageEmployeeResponse.setMessageCode(filteredMsgData.getMessageCode());
				manageEmployeeResponse.setMessageDescription(filteredMsgData.getMessageDescription());
			}
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_MANAGE_EMPLOYEE_FAILURE);
		}
		return manageEmployeeResponse;
	}

	@Override
	@Transactional(readOnly=true)
	public ByteArrayInputStream downloadErrorFile(String clientId) throws APIException {
		try {    
			List<EmpErrorDownloadResponse> errorResult = manageEmployeeRepository.getErrorRecords(clientId);

		    ByteArrayInputStream in = ExcelHelper.writeEmployeeErrorToExcel(errorResult);
		    return in;
		} catch (DataAccessException de) {
			throw new APIException("Unable to download employee error records");
		}
	}

}
