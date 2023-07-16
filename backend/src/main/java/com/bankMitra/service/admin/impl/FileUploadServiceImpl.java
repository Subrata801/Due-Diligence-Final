/**
 * 
 */
package com.bankMitra.service.admin.impl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
import com.bankMitra.model.admin.ClientUploadDueDeligenceRequest;
import com.bankMitra.model.admin.ImportTemplateRequest;
import com.bankMitra.model.admin.TemplateRequest;
import com.bankMitra.model.admin.response.ClientDueDeligenceDownloadResponse;
import com.bankMitra.model.admin.response.TemplateResponse;
import com.bankMitra.model.admin.response.TemplateUploadResponse;
import com.bankMitra.model.reference.MessageCode;
import com.bankMitra.repository.admin.TemplateRepository;
import com.bankMitra.security.services.UserDetailsImpl;
import com.bankMitra.service.admin.FileService;
import com.bankMitra.service.reference.ReferenceService;
import com.bankMitra.util.APIConstant;
import com.bankMitra.util.ExcelHelper;

/**
 * @author BankMitra
 *
 */
@Service
public class FileUploadServiceImpl implements FileService {
	private static final Logger logger = LoggerFactory.getLogger(FileUploadServiceImpl.class);
	@Autowired
	TemplateRepository templateRepo;
	
	@Autowired
	ReferenceService refService;
	
	/* (non-Javadoc)
	 * @see com.bankMitra.service.admin.FileUploadService#uploadTemplate(com.bankMitra.model.admin.FileUploadRequest)
	 */
	@Override
	@Transactional
	public List<TemplateUploadResponse> uploadTemplate(String templateName,int clientTypeId, int creditScoreTypeId,MultipartFile file) throws APIException {
		List<ClientUploadDueDeligenceRequest> clientDueDeligenceRequestList = null;
		List<TemplateUploadResponse> templateUploadResponse = null;
		TemplateRequest templateRequest = new TemplateRequest();
		templateRequest.setClientTypeId(clientTypeId);
		templateRequest.setCreditSectorId(creditScoreTypeId);
		templateRequest.setImportTemplateName(templateName);
		List<TemplateResponse> templateList;
		try {
			templateList = templateRepo.getLanguageTemplate(templateRequest, true);
			if (ExcelHelper.hasExcelFormat(file) && null!=templateList && templateList.size()>0) {
				try {
					clientDueDeligenceRequestList = ExcelHelper.readExcelFile(file.getInputStream(),file.getOriginalFilename(),templateList.get(0).getTemplateId());
					UserDetailsImpl user = (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
				    String userName = user.getUserName();
					templateUploadResponse  =  templateRepo.uploadTemplate(templateList.get(0).getTemplateId(),clientDueDeligenceRequestList,userName);
					
				} catch (IOException e1) {
					throw new APIException(APIConstant.MSG_IMPORT_TEMPLATE_FAILURE,e1.getMessage());
				} catch (DataAccessException e) {
					throw new APIException(APIConstant.MSG_IMPORT_TEMPLATE_FAILURE,e.getMessage());
				}
			} else {
				throw new APIException(APIConstant.MSG_INVALID_XLS_FAILURE);
			}
		} catch (DataAccessException e2) {
			logger.error(e2.getMessage());
			throw new APIException(e2.getMessage());
		}
		
		return templateUploadResponse;
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
	@Transactional(readOnly=true)
	public ByteArrayInputStream download(String outputType,Integer ddId) throws APIException {
		try {    
			List<ClientDueDeligenceDownloadResponse> importSummaryResult = templateRepo.getImportSummary(outputType,ddId);

		    ByteArrayInputStream in = ExcelHelper.writeImportSummaryToExcel(importSummaryResult,outputType);
		    return in;
		} catch (DataAccessException de) {
			throw new APIException("Unable to download");
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<TemplateUploadResponse> getListOfExistingTemplates(ImportTemplateRequest importTemplateRequest)
			throws APIException {
		List<TemplateUploadResponse> importSummaryResult = null;
		try {		
			importSummaryResult = templateRepo.getListOfExistingTemplates(importTemplateRequest);
		} catch (DataAccessException de) {
			throw new APIException(de.getMessage());
		} catch (Exception ex) {
			throw new APIException("Unable to get existing template summary");
		}
		return importSummaryResult;
	}

}
