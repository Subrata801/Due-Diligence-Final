/**
 * 
 */
package com.bankMitra.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.bankMitra.model.admin.ClientDueDeligenceArray;
import com.bankMitra.model.admin.ClientDueDeligenceRequest;
import com.bankMitra.model.admin.ClientUploadDueDeligenceRequest;
import com.bankMitra.model.admin.response.ClientDueDeligenceDownloadResponse;
import com.bankMitra.model.clientManagement.request.EmployeeUploadArray;
import com.bankMitra.model.clientManagement.response.EmpErrorDownloadResponse;
import com.bankMitra.model.clientManagement.response.ManageEmployeeResponse;
import com.bankMitra.repository.admin.impl.TemplateRepositoryImpl;

/**
 * @author BankMitra
 *
 */

public class ExcelHelper {
	private static final Logger logger = LoggerFactory.getLogger(ExcelHelper.class);
	
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "Id", "Title", "Description", "Published" };
	static String SHEET = "SuccessExport";
	

	public static boolean hasExcelFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	private static Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
		Workbook workbook = null;
		if (excelFilePath.endsWith("xlsx")) {
			workbook = new XSSFWorkbook(inputStream);
		} else if (excelFilePath.endsWith("xls")) {
			workbook = new HSSFWorkbook(inputStream);
		} else {
			throw new IllegalArgumentException("The specified file is not Excel file");
		}

		return workbook;
	}

	public static List<ClientUploadDueDeligenceRequest> readExcelFile(InputStream inputStream, String fileName, Integer templateId) throws IOException {
		List<ClientUploadDueDeligenceRequest> clientDueDeligenceRequestList = null;
		ClientUploadDueDeligenceRequest clientDueDeligenceRequest = null;
		List<ClientDueDeligenceArray> dueDelegencyList = null;
		Workbook workbook = null;
		try {
			workbook = getWorkbook(inputStream, fileName);
			int numberOfSheets = workbook.getNumberOfSheets();
			clientDueDeligenceRequestList = new ArrayList<ClientUploadDueDeligenceRequest>();
			for (int i = 0; i < numberOfSheets; i++) {
				Sheet aSheet = workbook.getSheetAt(i);
				//log.info(aSheet.getSheetName());
				Iterator<Row> iterator = aSheet.iterator();
				
				clientDueDeligenceRequest = new ClientUploadDueDeligenceRequest();
				dueDelegencyList = new ArrayList<ClientDueDeligenceArray>();
				while (iterator.hasNext()) {
					Row nextRow = iterator.next();
					if(nextRow.getRowNum()>=7) {
						Iterator<Cell> cellIterator = nextRow.cellIterator();
						
						ClientDueDeligenceArray clientDueDeligenceArray = new ClientDueDeligenceArray();
						boolean isDataPresent = true;
						while (cellIterator.hasNext()) {
							Cell nextCell = cellIterator.next();
							int columnIndex = nextCell.getColumnIndex();
	      
							switch (columnIndex) {
							case 3:
								if(StringUtils.isEmpty(String.valueOf(nextCell)) ||
									(!"M1".equalsIgnoreCase(String.valueOf(nextCell)) && !"M2".equalsIgnoreCase(String.valueOf(nextCell)) && 
											!"M3".equalsIgnoreCase(String.valueOf(nextCell)) && !"M4".equalsIgnoreCase(String.valueOf(nextCell))
										&& !"M5".equalsIgnoreCase(String.valueOf(nextCell))))
									isDataPresent = false;
								else 
									clientDueDeligenceArray.setModuleName(nextCell.getStringCellValue().trim());
								break;
							case 4:
								if(null!=String.valueOf(nextCell))
									clientDueDeligenceArray.setHeader1(String.valueOf(nextCell).trim());
								break;
							case 5:
								if(null!=String.valueOf(nextCell))
									clientDueDeligenceArray.setHeader2(String.valueOf(nextCell).trim());
								break;
							case 6:
								if(null!=String.valueOf(nextCell))
									clientDueDeligenceArray.setHeader3(String.valueOf(nextCell).trim());
								break;
							case 7:
								if(null!=String.valueOf(nextCell))
									clientDueDeligenceArray.setHeader4(String.valueOf(nextCell).trim());
								break;
							case 8:
								if(!StringUtils.isEmpty(String.valueOf(nextCell)))
									clientDueDeligenceArray.setDdSequence(Math.round(Float.parseFloat(String.valueOf(nextCell))));
								break;
							case 9:
								if(!StringUtils.isEmpty(String.valueOf(nextCell)))
									clientDueDeligenceArray.setDdParentSequence(Math.round(Float.parseFloat(String.valueOf(nextCell))));
								break;
							case 10:
								/*if(!StringUtils.isEmpty(String.valueOf(nextCell)) && (String.valueOf(nextCell)).indexOf("'")>0) {
									String replaceString=(String.valueOf(nextCell)).replace("'","''");  
									System.out.println("Case 10 :"+replaceString);  
									clientDueDeligenceArray.setDd_data(replaceString);
								} else {
									clientDueDeligenceArray.setDd_data(String.valueOf(nextCell));
								}*/
								if(null!=String.valueOf(nextCell))
									clientDueDeligenceArray.setDd_data(String.valueOf(nextCell));
								break;
							case 11:
								if(null!=String.valueOf(nextCell))
									clientDueDeligenceArray.setGeneralOption(String.valueOf(nextCell).trim());
								break;
							case 12:
								if(null!=String.valueOf(nextCell))
									clientDueDeligenceArray.setApplicantOption(String.valueOf(nextCell).trim());
								break;
							case 13:
								if(null!=String.valueOf(nextCell))
									clientDueDeligenceArray.setCoApplicantOption(String.valueOf(nextCell).trim());
								break;
							case 14:
								if(null!=String.valueOf(nextCell))
									clientDueDeligenceArray.setGuarantorOption(String.valueOf(nextCell).trim());
								break;
							case 15:
								if(null!=String.valueOf(nextCell))
									clientDueDeligenceArray.setConditions(String.valueOf(nextCell).trim());
								break;
							case 16:
								if(null!=String.valueOf(nextCell))
									clientDueDeligenceArray.setLoanVariant_keyword(String.valueOf(nextCell).trim());
								break;
							case 17:
								if(!StringUtils.isEmpty(String.valueOf(nextCell)))
									clientDueDeligenceArray.setBorrowerTypeId(Math.round(Float.parseFloat(String.valueOf(nextCell))));
								break;
							case 18:
								/*if(!StringUtils.isEmpty(String.valueOf(nextCell)) && (String.valueOf(nextCell)).indexOf("'")>0) {
									String replaceString=(String.valueOf(nextCell)).replace("'","''");  
									System.out.println(replaceString);  
									clientDueDeligenceArray.setCriticalty_factor(replaceString);
								} else {
									clientDueDeligenceArray.setCriticalty_factor(String.valueOf(nextCell));
								}*/
								if(null!=String.valueOf(nextCell))
									clientDueDeligenceArray.setCriticaltyFactor(String.valueOf(nextCell).trim());
								break;
							case 19:
								if(!StringUtils.isEmpty(String.valueOf(nextCell)))
									clientDueDeligenceArray.setProfessionId(Math.round(Float.parseFloat(String.valueOf(nextCell))));
								break;
							case 20:
								if(!StringUtils.isEmpty(String.valueOf(nextCell)))
									clientDueDeligenceArray.setLoanSchemeId(Math.round(Float.parseFloat(String.valueOf(nextCell))));
								break;
							case 21:
								if(!StringUtils.isEmpty(String.valueOf(nextCell)))
									clientDueDeligenceArray.setSecurityId(Math.round(Float.parseFloat(String.valueOf(nextCell))));
								break;
							case 22:
								if(!StringUtils.isEmpty(String.valueOf(nextCell)))
									clientDueDeligenceArray.setSecurityTypeId(Math.round(Float.parseFloat(String.valueOf(nextCell))));
								break;
							case 23:
								if(!StringUtils.isEmpty(String.valueOf(nextCell)))
									clientDueDeligenceArray.setSecurity_subtype_id(Math.round(Float.parseFloat(String.valueOf(nextCell))));
								break;
							case 24:
								if(!StringUtils.isEmpty(String.valueOf(nextCell)))
									clientDueDeligenceArray.setApplicationTypeId(Math.round(Float.parseFloat(String.valueOf(nextCell))));
								break;
							case 25:
								if(!StringUtils.isEmpty(String.valueOf(nextCell)))
									clientDueDeligenceArray.setAssetTypeId(Math.round(Float.parseFloat(String.valueOf(nextCell))));
								break;
							}
							if(!isDataPresent)
								break;
						}
						if(isDataPresent && !StringUtils.isEmpty(clientDueDeligenceArray.getModuleName())) {
							dueDelegencyList.add(clientDueDeligenceArray);
							
					    }
					}
				}
				clientDueDeligenceRequest.setDueDelegencyList(dueDelegencyList);
				clientDueDeligenceRequest.setLoanSchemeKeyword(aSheet.getSheetName().substring(6));
				clientDueDeligenceRequest.setTemplateId(templateId);
				clientDueDeligenceRequestList.add(clientDueDeligenceRequest);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			workbook.close();
			inputStream.close();
		}
		return clientDueDeligenceRequestList;

	}

	public static ByteArrayInputStream writeImportSummaryToExcel(
          List<ClientDueDeligenceDownloadResponse> importSummaryResult, String outputType) {
		try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
		      Sheet sheet = workbook.createSheet(SHEET);

		      // Header
		      writeHeaderLine(workbook,outputType,sheet);

		      //Data Writing
		      writeDataLines(workbook,outputType,importSummaryResult,sheet);
		      
		      workbook.write(out);
		      return new ByteArrayInputStream(out.toByteArray());
		    } catch (IOException e) {
		      throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
		    }
	}
	
    private static void writeHeaderLine(XSSFWorkbook workbook, String outputType, Sheet sheet) {

        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        if(!StringUtils.isEmpty(outputType) && APIConstant.IMPORT_SUCCESS.equalsIgnoreCase(outputType)) {
	        createCell(row, 0, "Module Name", style,sheet);      
	        createCell(row, 1, "Header 1", style,sheet);       
	        createCell(row, 2, "Header 2", style,sheet);    
	        createCell(row, 3, "Header 3", style,sheet);
	        createCell(row, 4, "Header 4", style,sheet);
	        createCell(row, 5, "DD Id", style,sheet);  
	        createCell(row, 6, "Header Sequence", style,sheet);
	        createCell(row, 7, "DD Sequence", style,sheet);       
	        createCell(row, 8, "DD Parent Sequence", style,sheet);    
	        createCell(row, 9, "General Options", style,sheet);
	        createCell(row, 10, "Applicant Options", style,sheet);      
	        createCell(row, 11, "Co-Applicantt Options", style,sheet);       
	        createCell(row, 12, "Guarantor Options", style,sheet);    
	        createCell(row, 13, "Conditions", style,sheet);
	        createCell(row, 14, "Credit Sector ID", style,sheet);
	        createCell(row, 15, "Loan Scheme Id", style,sheet);      
	        createCell(row, 16, "Loan Variant KeyWord", style,sheet);       
	        createCell(row, 17, "Borower Type Id", style,sheet);    
	        createCell(row, 18, "Criticality Factor", style,sheet);
	        createCell(row, 19, "Profession Id", style,sheet);
	        createCell(row, 20, "Loan Application Type Id", style,sheet);
	        createCell(row, 21, "Security Id", style,sheet);
	        createCell(row, 22, "Security Type Id", style,sheet);
	        createCell(row, 23, "Security Sub Type Id", style,sheet);
	        createCell(row, 24, "Applicant Type Id", style,sheet);
	        createCell(row, 25, "Asset Type Id", style,sheet);
	        createCell(row, 26, "Remarks", style,sheet);
	        createCell(row, 27, "Created By", style,sheet);
	        createCell(row, 28, "Created Date", style,sheet);
	        createCell(row, 29, "Updated By", style,sheet);
	        createCell(row, 30, "Updated Date", style,sheet);
	        createCell(row, 31, "DD Data", style,sheet);
        } else {
	        createCell(row, 0, "Module Name", style,sheet); 
	        createCell(row, 1, "Header 1", style,sheet);       
	        createCell(row, 2, "Header 2", style,sheet);    
	        createCell(row, 3, "Header 3", style,sheet);
	        createCell(row, 4, "Header 4", style,sheet);
	        createCell(row, 5, "DD ID", style,sheet); 
	        createCell(row, 6, "DD Sequence", style,sheet);       
	        createCell(row, 7, "DD Parent Sequence", style,sheet);  
	        createCell(row, 8, "Template Name", style,sheet);    
	        createCell(row, 9, "WorkSheet Name", style,sheet);
	        createCell(row, 10, "Remarks", style,sheet);
        }
    }
     
    private static void createCell(Row row, int columnCount, Object value, CellStyle style,Sheet sheet) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
     
    private static void writeDataLines(XSSFWorkbook workbook, String outputType, List<ClientDueDeligenceDownloadResponse> importSummaryResult, Sheet sheet) {
    	
    	int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
         
        if(!StringUtils.isEmpty(outputType)) {
        	if(APIConstant.IMPORT_SUCCESS.equalsIgnoreCase(outputType)) {
        		for (ClientDueDeligenceDownloadResponse successResponse : importSummaryResult) {
                    Row row = sheet.createRow(rowCount++);
                    int columnCount = 0;
                     
                    createCell(row, columnCount++, successResponse.getModule(), style,sheet);
                    createCell(row, columnCount++, successResponse.getHeader1(), style,sheet);
                    createCell(row, columnCount++, successResponse.getHeader2(), style,sheet);
                    createCell(row, columnCount++, successResponse.getHeader3(), style,sheet);
                    createCell(row, columnCount++, successResponse.getHeader4(), style,sheet);
                    createCell(row, columnCount++, successResponse.getDdId(), style,sheet);
                    createCell(row, columnCount++, successResponse.getHeaderSequence(), style,sheet);
                    createCell(row, columnCount++, successResponse.getDdSequence(), style,sheet);
                    createCell(row, columnCount++, successResponse.getDdParentSequence(), style,sheet);
                    createCell(row, columnCount++, successResponse.getGeneralOption(), style,sheet);
                    createCell(row, columnCount++, successResponse.getApplicantOption(), style,sheet);
                    createCell(row, columnCount++, successResponse.getCoApplicantOption(), style,sheet);
                    createCell(row, columnCount++, successResponse.getGuarantorOption(), style,sheet);
                    createCell(row, columnCount++, successResponse.getConditions(), style,sheet);
                    createCell(row, columnCount++, successResponse.getCreditSectorId(), style,sheet);
                    createCell(row, columnCount++, successResponse.getLoanSchemeId(), style,sheet);
                    createCell(row, columnCount++, successResponse.getLoanVariant_keyword(), style,sheet);
                    createCell(row, columnCount++, successResponse.getBorrowerTypeId(), style,sheet);
                    createCell(row, columnCount++, successResponse.getCriticaltyFactor(), style,sheet);
                    createCell(row, columnCount++, successResponse.getProfessionId(), style,sheet);
                    createCell(row, columnCount++, successResponse.getLoanApplicationTypeId(), style,sheet);
                    createCell(row, columnCount++, successResponse.getSecurityId(), style,sheet);
                    createCell(row, columnCount++, successResponse.getSecurityTypeId(), style,sheet);
                    createCell(row, columnCount++, successResponse.getSecuritySubtypeId(), style,sheet);
                    createCell(row, columnCount++, successResponse.getApplicationTypeId(), style,sheet);
                    createCell(row, columnCount++, successResponse.getAssetTypeId(), style,sheet);
                    createCell(row, columnCount++, successResponse.getRemarks(), style,sheet);
                    createCell(row, columnCount++, successResponse.getCreatedBy(),style,sheet);
                    createCell(row, columnCount++, successResponse.getCreatedDate(), style,sheet);
                    createCell(row, columnCount++, successResponse.getUpdatedBy(), style,sheet);
                    createCell(row, columnCount++, successResponse.getUpdatedDate(), style,sheet);
                    createCell(row, columnCount++, successResponse.getDdData(), style,sheet);
                }		
        	} else {
        		for (ClientDueDeligenceDownloadResponse failureResponse : importSummaryResult) {
                    Row row = sheet.createRow(rowCount++);
                    int columnCount = 0;
                     
                    createCell(row, columnCount++, failureResponse.getModule(), style,sheet);
                    createCell(row, columnCount++, failureResponse.getHeader1(), style,sheet);
                    createCell(row, columnCount++, failureResponse.getHeader2(), style,sheet);
                    createCell(row, columnCount++, failureResponse.getHeader3(), style,sheet);
                    createCell(row, columnCount++, failureResponse.getHeader4(), style,sheet);
                    createCell(row, columnCount++, failureResponse.getDdId(), style,sheet);
                    createCell(row, columnCount++, failureResponse.getDdSequence(), style,sheet);
                    createCell(row, columnCount++, failureResponse.getDdParentSequence(), style,sheet);
                    createCell(row, columnCount++, failureResponse.getTemplateName(), style,sheet);
                    createCell(row, columnCount++, failureResponse.getWorksheetName(), style,sheet);
                    createCell(row, columnCount++, failureResponse.getRemarks(), style,sheet);
        		}
        	}
        }
        
    }
    
    public static List<EmployeeUploadArray> readEmployeeExcelFile(InputStream inputStream, String fileName) throws IOException {
		List<EmployeeUploadArray> employeeList = null;
		Workbook workbook = null;
		try {
			workbook = getWorkbook(inputStream, fileName);
			int numberOfSheets = workbook.getNumberOfSheets();
			for (int i = 0; i < numberOfSheets; i++) {
				Sheet aSheet = workbook.getSheetAt(i);
				//log.info(aSheet.getSheetName());
				Iterator<Row> iterator = aSheet.iterator();
				
				employeeList = new ArrayList<EmployeeUploadArray>();
				while (iterator.hasNext()) {
					Row nextRow = iterator.next();
					Iterator<Cell> cellIterator = nextRow.cellIterator();
					
					EmployeeUploadArray employeeUploadArray = new EmployeeUploadArray();
					boolean isDataPresent = true;
					if(nextRow.getRowNum()>0) {
						while (cellIterator.hasNext()) {
							Cell nextCell = cellIterator.next();
							int columnIndex = nextCell.getColumnIndex();
	      
							switch (columnIndex) {
							
								case 0:
									if(null!=String.valueOf(nextCell))
										employeeUploadArray.setIfscCode(String.valueOf(nextCell).trim());
									break;
								case 1:
									if(null!=String.valueOf(nextCell))
										employeeUploadArray.setEmployeeName(String.valueOf(nextCell).trim());
									break;
								case 2:
									if(null!=String.valueOf(nextCell))
										employeeUploadArray.setEmployeeID(String.valueOf(nextCell).trim());
									break;
								case 3:
									if(!StringUtils.isEmpty(String.valueOf(nextCell))) {
										employeeUploadArray.setMobileNum(Long.parseLong(String.valueOf(NumberToTextConverter.toText(nextCell.getNumericCellValue())).trim()));
									} else {
										employeeUploadArray.setMobileNum(Long.parseLong(String.valueOf(-1)));
									}
									break;
							}
							if(!isDataPresent)
							break;
						}
						if(isDataPresent) {
							employeeList.add(employeeUploadArray);
					    }
					}
					
				}
			}
		} catch (FileNotFoundException e) {
			logger.error("UNable to read employee file "+e);
		} catch (IOException e) {
			logger.error("UNable to read employee file "+e);
		} catch (Exception e) {
			logger.error("UNable to read employee file "+e);
		} finally {
			workbook.close();
			inputStream.close();
		}
		return employeeList;

	}

	public static ByteArrayInputStream writeEmployeeErrorToExcel(List<EmpErrorDownloadResponse> errorResult) {
		try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream();) {
		      Sheet sheet = workbook.createSheet(SHEET);
		      // Header
		      writeHeaderLineForEmployeeError(workbook,sheet);
		      //Data Writing
		      writeDataLinesForEmployeeError(workbook,errorResult,sheet);
		      workbook.write(out);
		      return new ByteArrayInputStream(out.toByteArray());
	    } catch (IOException e) {
	      throw new RuntimeException("fail to import employee error data to Excel file: " + e.getMessage());
	    }
	}
	
    private static void writeHeaderLineForEmployeeError(XSSFWorkbook workbook,Sheet sheet) {

        Row row = sheet.createRow(0);
         
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);
        createCell(row, 0, "Employee ID", style,sheet);      
        createCell(row, 1, "Employee Name", style,sheet);       
        createCell(row, 2, "Ifsc Code", style,sheet);    
        createCell(row, 3, "Mobile Number", style,sheet);
        createCell(row, 4, "Error Description", style,sheet);
    }
    
    private static void writeDataLinesForEmployeeError(XSSFWorkbook workbook,
    		List<EmpErrorDownloadResponse> importSummaryResult, Sheet sheet) {
    	
    	int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        	
		for (EmpErrorDownloadResponse failureResponse : importSummaryResult) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
            createCell(row, columnCount++, failureResponse.getEmployeeID(), style,sheet);
            createCell(row, columnCount++, failureResponse.getEmployeeName(), style,sheet);
            createCell(row, columnCount++, failureResponse.getIfscCode(), style,sheet);
            createCell(row, columnCount++, failureResponse.getMobileNumber(), style,sheet);
            createCell(row, columnCount++, failureResponse.getErrorDescription(), style,sheet);
        }
    }
}