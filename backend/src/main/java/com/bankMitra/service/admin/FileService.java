/**
 * 
 */
package com.bankMitra.service.admin;

import java.io.ByteArrayInputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

import com.bankMitra.exception.APIException;
import com.bankMitra.model.admin.ImportTemplateRequest;
import com.bankMitra.model.admin.response.TemplateUploadResponse;

/**
 * @author BankMitra
 *
 */
public interface FileService {

	List<TemplateUploadResponse> uploadTemplate(@Valid String templateId, int clientTypeId, int creditScoreTypeId, MultipartFile file) throws APIException;

	ByteArrayInputStream download(String outputType, Integer ddId) throws APIException;

	List<TemplateUploadResponse> getListOfExistingTemplates(@Valid ImportTemplateRequest importTemplateRequest) throws APIException;

}
