/**
 * 
 */
package com.bankMitra.service.admin;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

import com.bankMitra.exception.APIException;
import com.bankMitra.model.admin.response.TemplateUploadResponse;

/**
 * @author BankMitra
 *
 */
public interface FileUploadService {

	List<TemplateUploadResponse> uploadTemplate(@Valid int templateId, MultipartFile file) throws APIException;

}
