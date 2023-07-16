/**
 * 
 */
package com.bankMitra.controller.clientManagement;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bankMitra.exception.APIException;
import com.bankMitra.model.clientManagement.request.ManageEmployeeRequest;
import com.bankMitra.model.clientManagement.response.EmployeeUploadResponse;
import com.bankMitra.model.clientManagement.response.ManageEmployeeResponse;
import com.bankMitra.model.response.MetaData;
import com.bankMitra.model.response.ResponseWrapperNoPagination;
import com.bankMitra.model.response.ResponseWrapperWithError;
import com.bankMitra.security.services.UserDetailsImpl;
import com.bankMitra.service.clientManagement.ManageEmployeeService;
import com.bankMitra.util.APIConstant;
import com.bankMitra.validator.ManageEmployeeValidator;
import com.google.common.io.ByteStreams;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Bank Maitra
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/clientManagementManageEmployee")
public class ManageEmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(ManageEmployeeController.class);
	
	@Autowired
	ManageEmployeeService manageEmployeeService;
	
	@Autowired
	private ManageEmployeeValidator manageEmployeeValidator;
	
	@ApiOperation(value = "View employees", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 401, message = "UnAuthorized resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 403, message = "Forbidden resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 404, message = "Not Found", response = ResponseWrapperWithError.class) })
	@RequestMapping(value = APIConstant.SERVICE_CLIENT_MANAGEMENT_VIEW_EMPLOYEES, method = RequestMethod.POST, produces = "application/json")
	public ResponseWrapperNoPagination<List<ManageEmployeeResponse>> viewEmployees
	(@Valid @RequestBody ManageEmployeeRequest manageEmployeeRequest,BindingResult result) throws APIException {
		manageEmployeeRequest.setSearchOption(true);
		manageEmployeeValidator.validate(manageEmployeeRequest, result);

		if (result.hasErrors()) {
			String errMsg = "";
			for(Object err :result.getAllErrors()) {
        		if(err instanceof ObjectError ) {
        			if(null!=((ObjectError)err).getDefaultMessage())
        				errMsg= errMsg + ((ObjectError)err).getDefaultMessage() + " , ";
        		} else
        			errMsg= errMsg + ((FieldError)err).getDefaultMessage() + " , ";
        	}
			throw new APIException(errMsg.substring(0,errMsg.lastIndexOf(",")));
		}
		
		UserDetailsImpl user = (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String userName = user.getUserName();
	    manageEmployeeRequest.setCreatedBy(userName);
		
		List<ManageEmployeeResponse> manageEmployeeResponseList = null;
    	try {
    		manageEmployeeResponseList = manageEmployeeService.getAllEmployees(manageEmployeeRequest);
			if(CollectionUtils.isNotEmpty(manageEmployeeResponseList)) {
				return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved all employees successfully"),manageEmployeeResponseList);
			} else {
				throw new APIException("No employees found for the criteria");
			}
		} catch (APIException e) {
			throw new APIException(e.getMessage());
		}
	}
	
	@ApiOperation(value = "Manage employee", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 401, message = "UnAuthorized resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 403, message = "Forbidden resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 404, message = "Not Found", response = ResponseWrapperWithError.class) })
	@RequestMapping(value = APIConstant.SERVICE_MANAGE_EMPLOYEE, method = RequestMethod.POST, produces = "application/json")
	// @PreAuthorize("hasRole('VIEW_ACCOUNT')")
	public ResponseWrapperNoPagination<ManageEmployeeResponse> manageEmployee(@Valid @RequestBody ManageEmployeeRequest manageEmployeeRequest,BindingResult result) throws APIException {
		manageEmployeeRequest.setSearchOption(false);
		manageEmployeeValidator.validate(manageEmployeeRequest, result);

		if (result.hasErrors()) {
			String errMsg = "";
			for(Object err :result.getAllErrors()) {
        		if(err instanceof ObjectError ) {
        			if(null!=((ObjectError)err).getDefaultMessage())
        				errMsg= errMsg + ((ObjectError)err).getDefaultMessage() + " , ";
        		} else
        			errMsg= errMsg + ((FieldError)err).getDefaultMessage() + " , ";
        	}
			throw new APIException(errMsg.substring(0,errMsg.lastIndexOf(",")));
		}
		UserDetailsImpl user = (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String userName = user.getUserName();
	    manageEmployeeRequest.setCreatedBy(userName);
	    ManageEmployeeResponse manageEmployeeResponse = manageEmployeeService.manageEmployee(manageEmployeeRequest);
		if(null!=manageEmployeeResponse && APIConstant.SUCCESS_CODE.equalsIgnoreCase(manageEmployeeResponse.getMessageCode())) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,manageEmployeeResponse.getMessageDescription()),manageEmployeeResponse);
		} else {
			throw new APIException(manageEmployeeResponse.getMessageDescription());
		}
	}
	
	
	@ApiOperation(value = "Upload the employee file", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 401, message = "UnAuthorized resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 403, message = "Forbidden resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 404, message = "Not Found", response = ResponseWrapperWithError.class) })
	@RequestMapping(value = APIConstant.SERVICE_EMPLOYEE_UPLOAD_TEMPLATE_FILE, method = RequestMethod.POST, produces = "application/json")
	// @PreAuthorize("hasRole('VIEW_ACCOUNT')")
	public ResponseWrapperNoPagination<EmployeeUploadResponse> uploadEmployeeFile(
			@RequestParam("file") MultipartFile file) throws APIException {
		EmployeeUploadResponse fileUploadResponse = null;
        String errMsg = "";
        String extensionOfFile = file.getOriginalFilename().indexOf(".") >0 ? file.getOriginalFilename().substring(file.getOriginalFilename().indexOf(".")+1) : "";
        String fileName = file.getOriginalFilename().indexOf(".") >0 ? file.getOriginalFilename().substring(0, file.getOriginalFilename().indexOf(".")) : file.getOriginalFilename();
        if(StringUtils.isEmpty(extensionOfFile) || (!file.getContentType().equalsIgnoreCase("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet") 
        		&& !file.getContentType().equalsIgnoreCase("application/vnd.ms-excel")))
        	errMsg = "Only excel files are allowed for upload";
        if(!StringUtils.isEmpty(errMsg)) {
        	EmployeeUploadResponse temResponse = new EmployeeUploadResponse();
        	temResponse.setMessageDescription(errMsg); 
        	throw new APIException(errMsg);
        } 
        UserDetailsImpl user = (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String userName = user.getUserName();
		fileUploadResponse = manageEmployeeService.uploadTemplate(file,userName);
		if(null!=fileUploadResponse && APIConstant.SUCCESS_CODE.equalsIgnoreCase(fileUploadResponse.getMessageCode())) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,"Uploaded file successfully"),fileUploadResponse);
		} else {
			throw new APIException("Failed to upload file");
		}
	}
	
	@ApiOperation(value = "Update employee", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 401, message = "UnAuthorized resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 403, message = "Forbidden resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 404, message = "Not Found", response = ResponseWrapperWithError.class) })
	@RequestMapping(value = APIConstant.SERVICE_CLIENT_MANAGEMENT_UPDATE_EMPLOYEE, method = RequestMethod.POST, produces = "application/json")
	// @PreAuthorize("hasRole('VIEW_ACCOUNT')")
	public ResponseWrapperNoPagination<ManageEmployeeResponse> updateEmployee(@Valid @RequestBody ManageEmployeeRequest manageEmployeeRequest,BindingResult result) throws APIException {
		UserDetailsImpl user = (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String userName = user.getUserName();
	    manageEmployeeRequest.setCreatedBy(userName);
	    ManageEmployeeResponse manageEmployeeResponse = manageEmployeeService.updateEmployee(manageEmployeeRequest);
		if(null!=manageEmployeeResponse && APIConstant.SUCCESS_CODE.equalsIgnoreCase(manageEmployeeResponse.getMessageCode())) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,manageEmployeeResponse.getMessageDescription()),manageEmployeeResponse);
		} else {
			throw new APIException(manageEmployeeResponse.getMessageDescription());
		}
	}

	@ApiOperation(value = "Download Error employee records")
	@RequestMapping(value = APIConstant.SERVICE_CLIENT_MANAGEMENT_DOWNLOAD_ERROR_EMPLOYEE, method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody ResponseEntity<byte[]> getFile(String clientId) {
        ByteArrayInputStream fileInputStream;
		try {
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	        String fileName = clientId+"employee_error_"+ currentDateTime + ".xlsx";
			fileInputStream = manageEmployeeService.downloadErrorFile(clientId);
			byte[] content = ByteStreams.toByteArray(fileInputStream);
			HttpHeaders httpHeader = new HttpHeaders();
			httpHeader.setContentType(MediaType.parseMediaType("application/octet-stream"));
			httpHeader.setContentDispositionFormData("filename",fileName);
			return new ResponseEntity<>(content,httpHeader,HttpStatus.OK);
	        
		} catch (APIException | IOException e) {
			logger.error("Unable to download report for clientId : ",clientId,e);
		}
		return null;

	}
	
}