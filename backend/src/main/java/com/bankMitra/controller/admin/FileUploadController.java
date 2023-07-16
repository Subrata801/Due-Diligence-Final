/**
 * 
 */
package com.bankMitra.controller.admin;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bankMitra.exception.APIException;
import com.bankMitra.model.admin.ImportTemplateRequest;
import com.bankMitra.model.admin.response.TemplateUploadResponse;
import com.bankMitra.model.response.MetaData;
import com.bankMitra.model.response.ResponseWrapperNoPagination;
import com.bankMitra.model.response.ResponseWrapperWithError;
import com.bankMitra.service.admin.FileService;
import com.bankMitra.util.APIConstant;
import com.google.common.io.ByteStreams;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author BankMitra
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/fileUpload")
public class FileUploadController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
	
	@Autowired
	FileService fileService;
	
	@ApiOperation(value = "Upload the file", produces = "application/json")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Internal Server Error", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 401, message = "UnAuthorized resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 403, message = "Forbidden resource", response = ResponseWrapperWithError.class),
			@ApiResponse(code = 404, message = "Not Found", response = ResponseWrapperWithError.class) })
	@RequestMapping(value = APIConstant.SERVICE_UPLOAD_TEMPLATE_FILE, method = RequestMethod.POST, produces = "application/json")
	// @PreAuthorize("hasRole('VIEW_ACCOUNT')")
	public ResponseWrapperNoPagination<List<TemplateUploadResponse>> uploadTemplate(
			@RequestParam("file") MultipartFile file,@PathVariable("templateId") String templateName,
			@PathVariable("clientTypeId") int clientTypeId,
			@PathVariable("creditScoreTypeId") int creditScoreTypeId
			) throws APIException {
		List<TemplateUploadResponse> fileUploadResponse = null;
        String errMsg = "";
        String extensionOfFile = file.getOriginalFilename().indexOf(".") >0 ? file.getOriginalFilename().substring(file.getOriginalFilename().indexOf(".")+1) : "";
        String fileName = file.getOriginalFilename().indexOf(".") >0 ? file.getOriginalFilename().substring(0, file.getOriginalFilename().indexOf(".")) : file.getOriginalFilename();
        if(StringUtils.isEmpty(extensionOfFile) || (!file.getContentType().equalsIgnoreCase("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet") 
        		&& !file.getContentType().equalsIgnoreCase("application/vnd.ms-excel")))
        	errMsg = "Only excel files are allowed for upload";
        else if(!templateName.equalsIgnoreCase(fileName))
        	errMsg = "File Name and Template name should be same.";
        if(!StringUtils.isEmpty(errMsg)) {
        	TemplateUploadResponse temResponse = new TemplateUploadResponse();
        	temResponse.setMessageDescription(errMsg); 
        	fileUploadResponse = new ArrayList<TemplateUploadResponse>();
        	fileUploadResponse.add(temResponse);
        	//return new ResponseWrapperNoPagination<>(new MetaData(false,"Validation is failed"),fileUploadResponse);
        	throw new APIException(errMsg);
        } 
		fileUploadResponse = fileService.uploadTemplate(templateName,clientTypeId,creditScoreTypeId,file);
		if(!CollectionUtils.isEmpty(fileUploadResponse)) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,"Uploaded template successfully"),fileUploadResponse);
		} else {
			throw new APIException("Failed to upload file");
			//return new ResponseWrapperNoPagination<>(new MetaData(false,"Upload template failed"),fileUploadResponse);
		}

	}
	
	@ApiOperation(value = "Download the file")
	@RequestMapping(value = APIConstant.SERVICE_DOWNLOAD_TEMPLATE_FILE, method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody ResponseEntity<byte[]> getFile(String outputType,Integer ddId) {
        ByteArrayInputStream fileInputStream;
		try {
	        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
	        String currentDateTime = dateFormatter.format(new Date());
	        String fileName = ddId+"_"+outputType+"_"+ currentDateTime + ".xlsx";
			fileInputStream = fileService.download(outputType,ddId);
			byte[] content = ByteStreams.toByteArray(fileInputStream);
			HttpHeaders httpHeader = new HttpHeaders();
			httpHeader.setContentType(MediaType.parseMediaType("application/octet-stream"));
			httpHeader.setContentDispositionFormData("filename",fileName);
			return new ResponseEntity<>(content,httpHeader,HttpStatus.OK);
	        /*return ResponseEntity.ok()
	                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+ddId+"_"+outputType+"_"+ currentDateTime + ".xlsx")
	                .contentType(MediaType.parseMediaType("application/vnd.ms-excel"))
	                .body(file);*/

		} catch (APIException | IOException e) {
			logger.error("Unable to download report for ddId : ",ddId,e);
		}
		return null;

	}
	
    @ApiOperation(value = "Get list of existing import templates",produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 401, message = "UnAuthorized resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 403, message = "Forbidden resource",response=ResponseWrapperWithError.class),
            @ApiResponse(code = 404, message = "Not Found",response=ResponseWrapperWithError.class)
    	}
    )
    @RequestMapping(value = APIConstant.SERVICE_GET_EXISTING_TEMPLATES, method= RequestMethod.GET, produces = "application/json")
    //@PreAuthorize("hasRole('VIEW_ACCOUNT')")
    public ResponseWrapperNoPagination<List<TemplateUploadResponse>> getListOfExistingTemplates(@PathVariable("clientTypeId") int clientTypeId,
    		@PathVariable("creditScoreTypeId") int creditScoreTypeId,@PathVariable("riskTypeId") int riskTypeId) throws APIException{
        List<TemplateUploadResponse> existingUploadedtemplates = null;
        ImportTemplateRequest importTemplateRequest = new ImportTemplateRequest();
        importTemplateRequest.setClientTypeId(clientTypeId);
        importTemplateRequest.setCreditScoreTypeId(creditScoreTypeId);
        importTemplateRequest.setRiskTypeId(riskTypeId);
		existingUploadedtemplates = fileService.getListOfExistingTemplates(importTemplateRequest);
		if(CollectionUtils.isNotEmpty(existingUploadedtemplates)) {
			return new ResponseWrapperNoPagination<>(new MetaData(true,"Retrieved list of existing uploaded templates successfully"),existingUploadedtemplates);
		} else {
			return new ResponseWrapperNoPagination<>(new MetaData(true,"existing uploaded templates configured"),existingUploadedtemplates);
		}
        
    }

}
