/**
 * 
 */
package com.bankMitra.service.bankenduserpanel.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xwpf.usermodel.VerticalAlign;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankMitra.exception.APIException;
import com.bankMitra.exception.DataAccessException;
import com.bankMitra.exception.ResourceNotFoundException;
import com.bankMitra.model.bankenduserpanel.request.E2EDashboardRequest;
import com.bankMitra.model.bankenduserpanel.request.E2EDetailRequest;
import com.bankMitra.model.bankenduserpanel.request.E2EFullReportDTO;
import com.bankMitra.model.bankenduserpanel.request.E2EFullReportFooter;
import com.bankMitra.model.bankenduserpanel.request.E2EFullReportHeader;
import com.bankMitra.model.bankenduserpanel.request.E2EFullReportTable;
import com.bankMitra.model.bankenduserpanel.response.DashboardBankDetailResponse;
import com.bankMitra.model.bankenduserpanel.response.E2EDashboardResponse;
import com.bankMitra.model.bankenduserpanel.response.E2EDetailResponse;
import com.bankMitra.model.reference.MessageCode;
import com.bankMitra.repository.bankenduserpanel.E2EDashboardRepository;
import com.bankMitra.service.bankenduserpanel.E2EDashboardService;
import com.bankMitra.service.reference.ReferenceService;
import com.bankMitra.util.APIConstant;

import io.micrometer.core.instrument.util.StringUtils;

/**
 * @author Bank Maitra
 *
 */
@Service
public class E2EDashboardServiceImpl implements E2EDashboardService {

	private static final Logger logger = LoggerFactory.getLogger(E2EDashboardServiceImpl.class);
	
	@Autowired
	E2EDashboardRepository e2eDashboardRepo;
	
	@Autowired
	ReferenceService refService;
	
	/* (non-Javadoc)
	 * @see com.bankMitra.service.bankenduserpanel.E2EDashboardService#getAllDashboardData(com.bankMitra.model.bankenduserpanel.request.E2EDashboardRequest)
	 */
	@Override
	@Transactional(readOnly=true)
	public List<E2EDashboardResponse> getAllDashboardData(@Valid E2EDashboardRequest e2eDashboardRequest)
			throws APIException {
		List<E2EDashboardResponse> listOfDashBoardResponse = null;
		try {
			listOfDashBoardResponse = e2eDashboardRepo.getAllDashboardData(e2eDashboardRequest);
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_DASHBOARDTASKS_FAILURE);
		}
		return listOfDashBoardResponse;
	}

	@Override
	@Transactional
	public E2EDetailResponse updatee2eDetails(E2EDetailRequest e2eDetailRequest) throws APIException {
		E2EDetailResponse e2eDetailResponse = null;
		try {
			e2eDetailResponse  =  e2eDashboardRepo.updatee2eDetails(e2eDetailRequest);
			final String dbResponseCode = e2eDetailResponse.getMessageCode();
			MessageCode filteredMsgData = getMessageDescription(dbResponseCode);
			if(null!=filteredMsgData){
				e2eDetailResponse.setMessageCode(filteredMsgData.getMessageCode());
				e2eDetailResponse.setMessageDescription(filteredMsgData.getMessageDescription());
			}
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_UPDATE_E2EDETAILS_FAILURE);
		}
		return e2eDetailResponse;
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
	@Transactional
	public E2EDetailResponse deleteCommercialCreditFacility(E2EDetailRequest e2eDetailRequest) throws APIException {
		E2EDetailResponse e2eDetailResponse = null;
		try {
			e2eDetailResponse  =  e2eDashboardRepo.deleteCommercialCreditFacility(e2eDetailRequest);
			final String dbResponseCode = e2eDetailResponse.getMessageCode();
			MessageCode filteredMsgData = getMessageDescription(dbResponseCode);
			if(null!=filteredMsgData){
				e2eDetailResponse.setMessageCode(filteredMsgData.getMessageCode());
				e2eDetailResponse.setMessageDescription(filteredMsgData.getMessageDescription());
			}
		} catch (DataAccessException e) {
			throw new APIException(e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_DELETE_E2E_COMMERCIAL_FACILITY_FAILURE);
		}
		return e2eDetailResponse;
	}

	@Override
	@Transactional(readOnly=true)
	public E2EDetailResponse getE2EDetails(E2EDetailRequest e2eDetailRequest) throws APIException {
		E2EDetailResponse e2eDetailResponse = null;
		try {
			e2eDetailResponse = e2eDashboardRepo.getE2EDetails(e2eDetailRequest);
		} catch (DataAccessException e) {
			throw new APIException(APIConstant.MSG_GET_E2E_TASK_FAILURE,e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_E2E_TASK_FAILURE,e.getMessage());
		}
		return e2eDetailResponse;
	}

	@Override
	@Transactional(readOnly=true)
	public DashboardBankDetailResponse getDashboardBankDetails(E2EDashboardRequest e2eDashboardRequest)
			throws APIException {
		DashboardBankDetailResponse bankDetailResponse = null;
		try {
			bankDetailResponse = e2eDashboardRepo.getDashboardBankDetails(e2eDashboardRequest);
		} catch (DataAccessException e) {
			throw new APIException(APIConstant.MSG_GET_BANKDETAILS_FAILURE,e.getMessage());
		} catch (Exception e) {
			throw new APIException(APIConstant.MSG_GET_BANKDETAILS_FAILURE,e.getMessage());
		}
		return bankDetailResponse;
	}

	
	public byte[] getE2EFullReportService(String fileName, String e2eNum, String moduleName, String clientName) throws  APIException{
		logger.info("getE2EFullReportService started with e2eNum:{} moduleNum:{} clientName:{}", e2eNum, moduleName,
				clientName);
		byte[] excelArr;
		try {
			E2EFullReportDTO e2eFullReportDTO = new E2EFullReportDTO();
			E2EFullReportHeader header = e2eDashboardRepo.getFullReportHeader(e2eNum);
			E2EFullReportFooter footer = e2eDashboardRepo.getFullReportFooter(e2eNum);
			List<E2EFullReportTable> tableData=e2eDashboardRepo.getE2EFullReportTableData(e2eNum,moduleName);
			
			
			if (header == null || footer == null || tableData == null) {
				logger.error("E2EDashboardServiceImpl:getE2EFullReportService: error occurred, header is null");
				throw new APIException("E2EDashboardServiceImpl:getE2EFullReportService::report cannot be generated"); 
			} else {
				String loanVariant = getLoanVariant(header.getLoanScheme(), e2eNum);
				header.setLoanVariant(loanVariant);
				excelArr = getExcelData(fileName, e2eFullReportDTO, moduleName, header, footer, tableData, clientName);
			}
		} catch (Exception e) {
			logger.error("E2EDashboardServiceImpl::getE2EFullReportService::error occurred:e2eNum:" + e2eNum
					+ "::exception:" + e);
			throw new APIException(e.getMessage());
		}
		logger.info("E2EDashboardServiceImpl:getE2EFullReportService::completed with byte arr size:"+excelArr.length);
		return excelArr;
	}
	
	private String getLoanVariant(String loanScheme, String e2eNum) throws DataAccessException {
		// TODO Auto-generated method stub
		if(loanScheme!=null && loanScheme.equalsIgnoreCase("Retail")) {
			return e2eDashboardRepo.getLoanVariant(APIConstant.QUERY_FULL_REPORT_LOAN_VARIANT_RETAIL, e2eNum);
		}
		if(loanScheme!=null && loanScheme.equalsIgnoreCase("Commercial")) {
			return e2eDashboardRepo.getLoanVariant(APIConstant.QUERY_FULL_REPORT_LOAN_VARIANT_COMMERCIAL, e2eNum);
		}
		return null;
	}

	private byte[] getExcelData(String fileName, E2EFullReportDTO fullReport, String moduleName, E2EFullReportHeader header, E2EFullReportFooter footer,
			List<E2EFullReportTable> tableData, String clientName) throws IOException {
		logger.info("Starts generating report in excel");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet("full_report");
		XSSFRow row;
		
		CellStyle centerStyle = workbook.createCellStyle();
		centerStyle.setAlignment(HorizontalAlignment.CENTER);
		
		CellStyle centerBoldStyle = workbook.createCellStyle();
		centerBoldStyle.setAlignment(HorizontalAlignment.CENTER);
		XSSFFont boldFont = workbook.createFont();
		boldFont.setBold(true);
		centerBoldStyle.setFont(boldFont);
		
		CellStyle centerBoldStyleWithMargin = workbook.createCellStyle();
		centerBoldStyleWithMargin.setAlignment(HorizontalAlignment.CENTER);
		centerBoldStyleWithMargin.setFont(boldFont);
		centerBoldStyleWithMargin.setBorderTop(BorderStyle.THIN);centerBoldStyle.setBorderLeft(BorderStyle.THIN);
		centerBoldStyleWithMargin.setBorderRight(BorderStyle.THIN);centerBoldStyle.setBorderBottom(BorderStyle.THIN);
		
		CellStyle leftWithMargin = workbook.createCellStyle();
		leftWithMargin.setAlignment(HorizontalAlignment.LEFT);
		leftWithMargin.setBorderTop(BorderStyle.THIN);leftWithMargin.setBorderLeft(BorderStyle.THIN);
		leftWithMargin.setBorderRight(BorderStyle.THIN);leftWithMargin.setBorderBottom(BorderStyle.THIN);
		
		CellStyle leftStyle = workbook.createCellStyle();
		leftStyle.setAlignment(HorizontalAlignment.LEFT);
		
		CellStyle leftBoldStyle = workbook.createCellStyle();
		leftBoldStyle.setAlignment(HorizontalAlignment.LEFT);
		leftBoldStyle.setFont(boldFont);
		
		CellStyle leftUpperStyle = workbook.createCellStyle();
		leftUpperStyle.setAlignment(HorizontalAlignment.LEFT);
		leftUpperStyle.setVerticalAlignment(VerticalAlignment.TOP);
		
		/*header starts*/
		
		Cell cell1 = spreadsheet.createRow(0).createCell(0);
		cell1.setCellValue(clientName);
		CellRangeAddress range1=new CellRangeAddress(0, 0, 0, 15); 
		spreadsheet.addMergedRegion(range1);
		cell1.setCellStyle(centerStyle);
		setDefaultBorderForRangeOfCells(range1, spreadsheet);
		
		Cell cell2 = spreadsheet.createRow(1).createCell(0);
		cell2.setCellValue("Module ("+moduleName+") - "+getModuleDescription(moduleName));
		CellRangeAddress range2=new CellRangeAddress(1, 1, 0, 15); 
		spreadsheet.addMergedRegion(range2);
		cell2.setCellStyle(centerStyle);
		setDefaultBorderForRangeOfCells(range2, spreadsheet);
		
		XSSFRow row2= spreadsheet.createRow(2);
		Cell cell3 = row2.createCell(0);
		cell3.setCellValue("Unit Type: "+header.getUnitType());
		CellRangeAddress range3=new CellRangeAddress(2, 2, 0, 7); 
		spreadsheet.addMergedRegion(range3);
		cell3.setCellStyle(leftStyle);
		setDefaultBorderForRangeOfCells(range3, spreadsheet);
		
		Cell cell4 = row2.createCell(8);
		cell4.setCellValue("Name of Branch: "+header.getNameOfBranch());
		CellRangeAddress range4=new CellRangeAddress(2, 2, 8, 15); 
		spreadsheet.addMergedRegion(range4);
		cell4.setCellStyle(leftStyle);
		setDefaultBorderForRangeOfCells(range4, spreadsheet);
		
		XSSFRow row3= spreadsheet.createRow(3);
		Cell cell5 = row3.createCell(0);
		cell5.setCellValue("E2E No: "+header.getE2eNum());
		CellRangeAddress range5=new CellRangeAddress(3, 3, 0, 7); 
		spreadsheet.addMergedRegion(range5);
		cell5.setCellStyle(leftStyle);
		setDefaultBorderForRangeOfCells(range5, spreadsheet);
		
		Cell cell6 = row3.createCell(8);
		cell6.setCellValue("E2E Date: "+header.getE2eDate());
		CellRangeAddress range6=new CellRangeAddress(3, 3, 8, 15); 
		spreadsheet.addMergedRegion(range6);
		cell6.setCellStyle(leftStyle);
		setDefaultBorderForRangeOfCells(range6, spreadsheet);
		
		Cell cell7 = spreadsheet.createRow(4).createCell(0);
		cell7.setCellValue("Name of Applicant/ Borrower: "+header.getApplicantName());
		CellRangeAddress range7=new CellRangeAddress(4, 4, 0, 15); 
		spreadsheet.addMergedRegion(range7);
		cell7.setCellStyle(leftStyle);
		setDefaultBorderForRangeOfCells(range7, spreadsheet);
		
		XSSFRow row5= spreadsheet.createRow(5);
		Cell cell8 = row5.createCell(0);
		cell8.setCellValue("Date of Receipt of Application: "+header.getDateOfReceiptOfApplication());
		CellRangeAddress range8=new CellRangeAddress(5, 5, 0, 7); 
		spreadsheet.addMergedRegion(range8);
		cell8.setCellStyle(leftStyle);
		setDefaultBorderForRangeOfCells(range8, spreadsheet);
		
		Cell cell9 = row5.createCell(8);
		cell9.setCellValue("Date of Sanction: "+header.getDateOfSanction());
		CellRangeAddress range9=new CellRangeAddress(5, 5, 8, 15); 
		spreadsheet.addMergedRegion(range9);
		cell9.setCellStyle(leftStyle);
		setDefaultBorderForRangeOfCells(range9, spreadsheet);
		
		XSSFRow row6= spreadsheet.createRow(6);
		Cell cell10 = row6.createCell(0);
		cell10.setCellValue("Loan Type: "+header.getLoanType());
		CellRangeAddress range10=new CellRangeAddress(6, 6, 0, 7); 
		spreadsheet.addMergedRegion(range10);
		cell10.setCellStyle(leftStyle);
		setDefaultBorderForRangeOfCells(range10, spreadsheet);
		
		Cell cell11 = row6.createCell(8);
		cell11.setCellValue("Loan Scheme: "+header.getLoanScheme());
		CellRangeAddress range11=new CellRangeAddress(6, 6, 8, 15); 
		spreadsheet.addMergedRegion(range11);
		cell11.setCellStyle(leftStyle);
		setDefaultBorderForRangeOfCells(range11, spreadsheet);
		
		XSSFRow row7= spreadsheet.createRow(7);
		Cell cell12 = row7.createCell(0);
		cell12.setCellValue("Loan Variant/Facility/ies: "+header.getLoanVariant());
		CellRangeAddress range12=new CellRangeAddress(7, 7, 0, 7); 
		spreadsheet.addMergedRegion(range12);
		cell12.setCellStyle(leftStyle);
		setDefaultBorderForRangeOfCells(range12, spreadsheet);
		
		Cell cell13 = row7.createCell(8);
		cell13.setCellValue("Sanctioning Authority: "+header.getSanctionedAuthority());
		CellRangeAddress range13=new CellRangeAddress(7, 7, 8, 15); 
		spreadsheet.addMergedRegion(range13);
		cell13.setCellStyle(leftStyle);
		setDefaultBorderForRangeOfCells(range13, spreadsheet);
		
		/*header completed*/
		
		/*footer starts*/
		
		XSSFRow row9= spreadsheet.createRow(9);
		Cell cell14 = row9.createCell(0);
		cell14.setCellValue("Maker");
		CellRangeAddress range14=new CellRangeAddress(9, 9, 0, 4); 
		spreadsheet.addMergedRegion(range14);
		cell14.setCellStyle(centerBoldStyle);
		setDefaultBorderForRangeOfCells(range14, spreadsheet);
		
		Cell cell15 = row9.createCell(5);
		cell15.setCellValue("Checker");
		CellRangeAddress range15=new CellRangeAddress(9, 9, 5, 9); 
		spreadsheet.addMergedRegion(range15);
		cell15.setCellStyle(centerBoldStyle);
		setDefaultBorderForRangeOfCells(range15, spreadsheet);
		
		Cell cell16 = row9.createCell(10);
		cell16.setCellValue("Branch manager");
		CellRangeAddress range16=new CellRangeAddress(9, 9, 10, 15); 
		spreadsheet.addMergedRegion(range16);
		cell16.setCellStyle(centerBoldStyle);
		setDefaultBorderForRangeOfCells(range16, spreadsheet);
		
		XSSFRow row10= spreadsheet.createRow(10);
		Cell cell17 = row10.createCell(0);
		cell17.setCellValue(footer.getMaker());
		CellRangeAddress range17=new CellRangeAddress(10, 11, 0, 4); 
		spreadsheet.addMergedRegion(range17);
		cell17.setCellStyle(leftUpperStyle);
		setDefaultBorderForRangeOfCells(range17, spreadsheet);
		
		Cell cell18 = row10.createCell(5);
		cell18.setCellValue(footer.getChecker());
		CellRangeAddress range18=new CellRangeAddress(10, 11, 5, 9); 
		spreadsheet.addMergedRegion(range18);
		cell18.setCellStyle(leftUpperStyle);
		setDefaultBorderForRangeOfCells(range18, spreadsheet);
		
		Cell cell19 = row10.createCell(10);
		cell19.setCellValue(footer.getBranchManager());
		CellRangeAddress range19=new CellRangeAddress(10, 11, 10, 15); 
		spreadsheet.addMergedRegion(range19);
		cell19.setCellStyle(leftUpperStyle);
		setDefaultBorderForRangeOfCells(range19, spreadsheet);
		
		XSSFRow row12= spreadsheet.createRow(12);
		Cell cellRow12 = row12.createCell(0);
		cellRow12.setCellValue("Report Generated Date & Time");
		CellRangeAddress rangeRow12=new CellRangeAddress(12, 12, 0, 4); 
		spreadsheet.addMergedRegion(rangeRow12);
		cellRow12.setCellStyle(leftStyle);
		setDefaultBorderForRangeOfCells(rangeRow12, spreadsheet);
		
		Cell cellRow12_2 = row12.createCell(5);
		cellRow12_2.setCellValue(getCurrentDateTime());
		CellRangeAddress rangeRow12_2=new CellRangeAddress(12, 12, 5, 15); 
		spreadsheet.addMergedRegion(rangeRow12_2);
		cellRow12_2.setCellStyle(centerStyle);
		setDefaultBorderForRangeOfCells(rangeRow12_2, spreadsheet);
		
		/*footer completed*/
		
		/*table data starts*/
		
		XSSFRow row13= spreadsheet.createRow(14);
		Cell cellH0 = row13.createCell(0);cellH0.setCellValue("Sl No");cellH0.setCellStyle(centerBoldStyleWithMargin);
		
		Cell cellH1 = row13.createCell(1);cellH1.setCellValue("Due Diligence Action Points");
		CellRangeAddress range20=new CellRangeAddress(14, 14, 1, 3);
		spreadsheet.addMergedRegion(range20);
		setDefaultBorderForRangeOfCells(range20, spreadsheet);
		cellH1.setCellStyle(leftBoldStyle);
		
		Cell cellH2 = row13.createCell(4);cellH2.setCellValue("Scheme Norms");cellH2.setCellStyle(centerBoldStyleWithMargin);
		Cell cellH3 = row13.createCell(5);cellH3.setCellValue("Applicant");cellH3.setCellStyle(centerBoldStyleWithMargin);
		Cell cellH4 = row13.createCell(6);cellH4.setCellValue("Co-Applicant");cellH4.setCellStyle(centerBoldStyleWithMargin);
		Cell cellH5 = row13.createCell(7);cellH5.setCellValue("Co-Applicant1");cellH5.setCellStyle(centerBoldStyleWithMargin);
		Cell cellH6 = row13.createCell(8);cellH6.setCellValue("Co-Applicant2");cellH6.setCellStyle(centerBoldStyleWithMargin);
		Cell cellH7 = row13.createCell(9);cellH7.setCellValue("Co-Applicant3");cellH7.setCellStyle(centerBoldStyleWithMargin);
		Cell cellH8 = row13.createCell(10);cellH8.setCellValue("Co-Applicant4");cellH8.setCellStyle(centerBoldStyleWithMargin);
		Cell cellH9 = row13.createCell(11);cellH9.setCellValue("Gurantor");cellH9.setCellStyle(centerBoldStyleWithMargin);
		Cell cellH20 = row13.createCell(12);cellH20.setCellValue("Gurantor1");cellH20.setCellStyle(centerBoldStyleWithMargin);
		Cell cellH21 = row13.createCell(13);cellH21.setCellValue("Gurantor2");cellH21.setCellStyle(centerBoldStyleWithMargin);
		Cell cellH22 = row13.createCell(14);cellH22.setCellValue("Gurantor3");cellH22.setCellStyle(centerBoldStyleWithMargin);
		Cell cellH23 = row13.createCell(15);cellH23.setCellValue("Gurantor4");cellH23.setCellStyle(centerBoldStyleWithMargin);
		
		int rowNum = 15;
//		XSSFCellStyle cellStyle = workbook.createCellStyle();
//		cellStyle = getBasicBorderStyle(cellStyle);
		
		//XSSFColor color = new XSSFColor(workbook.getStylesSource().getIndexedColors());
		int counter=1;
		for(E2EFullReportTable data : tableData) {
						
			row = spreadsheet.createRow(rowNum);
			XSSFCellStyle cellStyleCol1 = workbook.createCellStyle();
			cellStyleCol1 = getBasicBorderStyle(cellStyleCol1);
			Cell cell20 = row.createCell(0);
			//cell20.setCellValue(counter++);
			cell20.setCellValue(data.getDdSequence());
			cell20.setCellStyle(cellStyleCol1);
			
			Cell cell21 = row.createCell(1);
			CellRangeAddress range21=new CellRangeAddress(rowNum, rowNum, 1, 3);
			cell21.setCellValue(data.getDdData());
			setDefaultBorderForRangeOfCells(range21, spreadsheet);
			spreadsheet.addMergedRegion(range21);
			//cell21.setCellStyle(cellStyle);
			
			Cell cell22 = row.createCell(4);
			XSSFCellStyle cellStyleCol2 = workbook.createCellStyle();
			cellStyleCol2 = getBasicBorderStyle(cellStyleCol2);
			cellStyleCol2.setFillForegroundColor(getColorStyle(data.getSchemeNormColor()));
			cellStyleCol2.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell22.setCellStyle(cellStyleCol2);
			
			Cell cell23 = row.createCell(5);
			XSSFCellStyle cellStyleCol3 = workbook.createCellStyle();
			cellStyleCol3 = getBasicBorderStyle(cellStyleCol3);
			cellStyleCol3.setFillForegroundColor(getColorStyle(data.getApplicantColor()));
			cellStyleCol3.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell23.setCellStyle(cellStyleCol3);
			
			Cell cell24 = row.createCell(6);
			XSSFCellStyle cellStyleCol4 = workbook.createCellStyle();
			cellStyleCol4 = getBasicBorderStyle(cellStyleCol4);
			cellStyleCol4.setFillForegroundColor(getColorStyle(data.getCoapplicantColor()));
			cellStyleCol4.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell24.setCellStyle(cellStyleCol4);
			
			Cell cell25 = row.createCell(7);
			XSSFCellStyle cellStyleCol5 = workbook.createCellStyle();
			cellStyleCol5 = getBasicBorderStyle(cellStyleCol5);
			cellStyleCol5.setFillForegroundColor(getColorStyle(data.getCoapplicant1Color()));
			cellStyleCol5.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell25.setCellStyle(cellStyleCol5);
			
			Cell cell26 = row.createCell(8);
			XSSFCellStyle cellStyleCol6 = workbook.createCellStyle();
			cellStyleCol6 = getBasicBorderStyle(cellStyleCol6);
			cellStyleCol6.setFillForegroundColor(getColorStyle(data.getCoapplicant2Color()));
			cellStyleCol6.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell26.setCellStyle(cellStyleCol6);
			
			Cell cell27 = row.createCell(9);
			XSSFCellStyle cellStyleCol7 = workbook.createCellStyle();
			cellStyleCol7 = getBasicBorderStyle(cellStyleCol7);
			cellStyleCol7.setFillForegroundColor(getColorStyle(data.getCoapplicant3Color()));
			cellStyleCol7.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell27.setCellStyle(cellStyleCol7);
			
			Cell cell28 = row.createCell(10);
			XSSFCellStyle cellStyleCol8 = workbook.createCellStyle();
			cellStyleCol8 = getBasicBorderStyle(cellStyleCol8);
			cellStyleCol8.setFillForegroundColor(getColorStyle(data.getCoapplicant4Color()));
			cellStyleCol8.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell28.setCellStyle(cellStyleCol8);
			
			Cell cell29 = row.createCell(11);
			XSSFCellStyle cellStyleCol9 = workbook.createCellStyle();
			cellStyleCol9 = getBasicBorderStyle(cellStyleCol9);
			cellStyleCol9.setFillForegroundColor(getColorStyle(data.getGurantorColor()));
			cellStyleCol9.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell29.setCellStyle(cellStyleCol9);
			
			Cell cell30 = row.createCell(12);
			XSSFCellStyle cellStyleCol10 = workbook.createCellStyle();
			cellStyleCol10 = getBasicBorderStyle(cellStyleCol10);
			cellStyleCol10.setFillForegroundColor(getColorStyle(data.getGurantor1Color()));
			cellStyleCol10.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell30.setCellStyle(cellStyleCol10);
			
			Cell cell31 = row.createCell(13);
			XSSFCellStyle cellStyleCol11 = workbook.createCellStyle();
			cellStyleCol11 = getBasicBorderStyle(cellStyleCol11);
			cellStyleCol11.setFillForegroundColor(getColorStyle(data.getGurantor2Color()));
			cellStyleCol11.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell31.setCellStyle(cellStyleCol11);
			
			Cell cell32 = row.createCell(14);
			XSSFCellStyle cellStyleCol12 = workbook.createCellStyle();
			cellStyleCol12 = getBasicBorderStyle(cellStyleCol12);
			cellStyleCol12.setFillForegroundColor(getColorStyle(data.getGurantor3Color()));
			cellStyleCol12.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell32.setCellStyle(cellStyleCol12);
			
			Cell cell33 = row.createCell(15);
			XSSFCellStyle cellStyleCol13 = workbook.createCellStyle();
			cellStyleCol13 = getBasicBorderStyle(cellStyleCol13);
			cellStyleCol13.setFillForegroundColor(getColorStyle(data.getGurantor4Color()));
			cellStyleCol13.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			cell33.setCellStyle(cellStyleCol13);
			
			rowNum++;
		}
		
		/*table data ends*/
		
//		int end1RowNum=++rowNum;
//		XSSFRow end1Row= spreadsheet.createRow(end1RowNum);
//		Cell endCell1 = end1Row.createCell(0);
//		endCell1.setCellValue("Report Generated Date & Time");
//		CellRangeAddress range22=new CellRangeAddress(end1RowNum, end1RowNum+1, 0, 15); 
//		spreadsheet.addMergedRegion(range22);
//		endCell1.setCellStyle(leftStyle);
//		setDefaultBorderForRangeOfCells(range22, spreadsheet);
		
		
		FileOutputStream out = new FileOutputStream(new File(fileName));
		workbook.write(out);
		out.close();
		workbook.close();
		
		Path path = Paths.get(fileName);
	    byte[] arr = Files.readAllBytes(path);
	    
	    return arr;
	}
	
	private String getCurrentDateTime() {
		// TODO Auto-generated method stub
		long timeInMillis = System.currentTimeMillis();
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(timeInMillis);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy hh:mm a");
		String currentTime = formatter.format(cal.getTime());
		logger.info("getCurrentDateTime:"+currentTime);
		return currentTime;
	}

	private XSSFCellStyle getBasicBorderStyle(XSSFCellStyle cellStyle) {
		cellStyle.setBorderTop(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		cellStyle.setBorderRight(BorderStyle.THIN);
		cellStyle.setBorderBottom(BorderStyle.THIN);
		return cellStyle;
	}
	
	private void setDefaultBorderForRangeOfCells(CellRangeAddress range, XSSFSheet sheet) {
		// TODO Auto-generated method stub
		RegionUtil.setBorderTop(BorderStyle.THIN, range, sheet);
		RegionUtil.setBorderBottom(BorderStyle.THIN, range, sheet);
		RegionUtil.setBorderLeft(BorderStyle.THIN, range, sheet);
		RegionUtil.setBorderRight(BorderStyle.THIN, range, sheet);
	}
	
	private String getModuleDescription(String moduleName) {
		switch(moduleName) {
		case "M1":
			return "Scrutiny of Application";
		case "M2":
			return "Documentation,Creation of Securities,Insurance And Loan Disbursement";
		case "M3":
			return "Confirmation of Securities Obtained,to be done within 1Month of Loan Disbursement";
		case "M4":
			return "Periodic Monitoring & Follow up";
		case "M5":
			return "Release of Securities on Closure of Account";
		default:
			return "Invalid Module";
		}
	}
	
//	private short getColorStyle(String colorInHex) {
//		//logger.info("getColor:colorInHex:"+colorInHex);
//		XSSFColor color = new XSSFColor();
//		if(StringUtils.isNotBlank(colorInHex)) {
//			colorInHex = colorInHex.substring(1);
//			colorInHex = "FF"+colorInHex;
//			logger.info("colorInHex:"+colorInHex);
//			color.setARGBHex(colorInHex);
//			
//		} else {
//			color.setIndexed(1);;
//		}
//		//logger.info("color value:"+color.getARGBHex());
//		return color.getIndex();
//	}
	
	private short getColorStyle(String colorInRGBValue) {
		//logger.info("getColorStyle:colorInRGBValue:"+colorInRGBValue);
		if(StringUtils.isNotBlank(colorInRGBValue)) {
			switch(colorInRGBValue) {
			case "#FF0000":
				return IndexedColors.RED.getIndex();
			case "#FFC000":
				return IndexedColors.ORANGE.getIndex();//yellow shade
			case "#FBE5D5":
				return IndexedColors.LIGHT_ORANGE.getIndex();//to be updated to pink or pink1 and do the testing
			case "#0070C0":
				return IndexedColors.BLUE.getIndex();
			case "#00B050":
				return IndexedColors.BRIGHT_GREEN.getIndex();
			case "#E7E6E6":
				return IndexedColors.GREY_25_PERCENT.getIndex();
			case "#000000":
				return IndexedColors.BLACK.getIndex();
			case "#ffffff":
				return IndexedColors.WHITE.getIndex();
			default :
				return IndexedColors.WHITE.getIndex();
			}
		}else {
			return IndexedColors.WHITE.getIndex();
		}
		
	}
}
