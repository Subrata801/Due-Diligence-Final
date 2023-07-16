/**
 * 
 */
package com.bankMitra.util;

import java.io.File;

/**
 * @author BankMitra
 *
 */
public class APIConstant {

	public static final String SWAGGER_UI_ENDPOINT = "/ui/**";
	public static final String HEALTH_URL = "/health";
	public static final String SWAGGER_ENDPOINT = "/swagger**";
	public static final String CSS_ENDPOINT = "/css/**";
	public static final String JS_ENDPOINT = "/js/**";
	public static final String ERROR = "/error";
	public static final String LOGOUT_ENDPOINT = "/logout";
	public static final String UNAUTHORIZED_ENDPOINT = "/unauthorized";
	public static final String USER_STATUS_ACTIVE = "A";
	public static final String USER_BANK_MITRA = "BankMitraAdmin";
	public static final String DB_SCHEME_NAME = "bmadmin";	
	public static final String HEADER_REQUEST_CREATE = "createHeaderRequest";
	public static final String ACTION_REVIEW = "Pending Approval";
	public static final String ACTION_FREEZE = "Freezed";
	public static final String ACTION_APPROVE = "Approved";
	public static final String ACTION_SUBMIT = "submit";
	public static final String ACTION_SAVE = "save";
	public static final String MODULE_NAME_M1 = "M1";
	public static final String MODULE_NAME_M2 = "M2";
	public static final String MODULE_NAME_M3 = "M3";
	public static final String MODULE_NAME_M4 = "M4";
	public static final String MODULE_NAME_M5 = "M5";
	public static final String IMPORT_SUCCESS = "success";
	public static final String IMPORT_failure = "failure";
	public static final String USER_SEARCH_TYPE_BY_USERNAME = "usernamesearch";
	public static final String USER_SEARCH_TYPE_BY_USERID = "useridsearch";
	public static final String USER_SEARCH_TYPE_BY_FULLNAME = "fullnamesearch";
	public static final String USER_SEARCH_TYPE_BY_EMAIL = "emailsearch";
	public static final String USER_SEARCH_TYPE_BY_MOBILE = "mobilesearch";
	public static final String USER_SEARCH_TYPE_BY_USERTYPE = "usertypesearch";
	public static final String USER_SEARCH_TYPE_BY_USERROLE = "userrolesearch";
	public static final String USER_SEARCH_TYPE_BY_UNITTYPE = "unittypesearch";
	
	public static final String SUBSCRIPTION_SEARCH_TYPE_BY_PRODUCTTYPE = "searchproducttype";
	public static final String SUBSCRIPTION_SEARCH_TYPE_BY_SUBSCRIPTIONTYPE = "searchsubscriptiontype";
	public static final String SUBSCRIPTION_SEARCH_TYPE_BY_SUBSCRIPTION_SUBTYPE = "searchsubscriptionsubtype";
	
	// Error Codes for Reference data 
	public static final String ERROR_CODE_SECURITYTYPE = "REFERROR001";
	public static final String ERROR_CODE_SUBSCRIPTIONSUBTYPE = "REFERROR002";
	public static final String ERROR_CODE_SUBSCRIPTIONTYPE = "REFERROR003";
	public static final String ERROR_CODE_USERROLES = "REFERROR004";
	public static final String ERROR_CODE_PROFESSIONS = "REFERROR005";
	public static final String ERROR_CODE_CREDITSCORETYPES = "REFERROR006";
	public static final String ERROR_CODE_BORROWERTYPES = "REFERROR007";
	public static final String ERROR_CODE_APPLICANTTYPES = "REFERROR008";
	public static final String ERROR_CODE_USERTYPES = "REFERROR009";
	public static final String ERROR_CODE_SECURITYQUEST = "REFERROR0010";
	public static final String ERROR_CODE_LANGUAGES = "REFERROR0011";
	public static final String ERROR_CODE_LOANSCHEMES = "REFERROR0012";
	public static final String ERROR_CODE_LOANVARIANT = "REFERROR0013";
	public static final String ERROR_CODE_RISKTYPES = "REFERROR0014";
	public static final String ERROR_CODE_MESSSAGECODE = "REFERROR015";
	public static final String ERROR_CODE_FAILURE_UPDATE_DUEDELIGENCE = "E11";
	
	//DAO layer error code
	public static final String ERROR_CODE_INVALIDLOGIN = "AUERROR01";
	public static final String ERROR_CODE_REGISTER = "AUERROR02";
	public static final String ERROR_CODE_CREATE_TEMPLATE_NAME = "DERROR01";
	public static final String ERROR_CODE_CREATE_TEMPLATE = "DERROR02";
	public static final String ERROR_CODE_CREATE_LOANSCHEME_WS_NAME = "DERROR03";
	public static final String ERROR_CODE_CREATE_LOANSCHEME = "DERROR04";
	public static final String ERROR_CODE_CREATE_LOANVARIANT = "DERROR05";
	public static final String ERROR_CODE_CREATE_RISKRATING = "DERROR06";
	public static final String ERROR_CODE_CREATE_SUBSCRIPTION = "DERROR07";
	public static final String ERROR_CODE_RESETPASSWORD = "DEERROR08";
	public static final String ERROR_CODE_ADMINMESAGE = "Unable to process request.Please contact administrator";
	public static final String ERROR_CODE_USER_NOT_FOUND = "Incorrect user name or password";
	public static final String ERROR_CODE_UPDATEPASSWORD = "DEERROR10";
	public static final String ERROR_CODE_UPDATEUSER = "DEERROR11";
	public static final String ERROR_CODE_UPDATE_HEADER = "DERROR12";
	public static final String ERROR_CODE_GET_LOAN_SCHEMES = "DERROR13";
	public static final String ERROR_CODE_GET_LOAN_VARIANTS = "DERROR14";
	public static final String ERROR_CODE_GET_HEADER = "DERROR15";
	public static final String ERROR_CODE_CREATE_CLIENT = "DERROR016";
	public static final String ERROR_CODE_CREATE_CLIENT_LOANSCHEME = "DERROR017";
	public static final String ERROR_CODE_DELETE_CLIENT_LOANSCHEME = "DERROR018";
	public static final String ERROR_CODE_CREATE_CLIENT_LOANVARIANT = "DERROR019";
	public static final String ERROR_CODE_DELETE_CLIENT_LOANVARIANT = "DERROR020";
	public static final String ERROR_CODE_UPDATE_CLIENT_SUBSCRIPTION = "DERROR021";
	public static final String ERROR_CODE_GET_CLIENT_SUBSCRIPTION_HISTORY = "DERROR022";
	public static final String ERROR_CODE_GET_CLIENT_LOAN_SCHEMES = "DERROR23";
	public static final String ERROR_CODE_GET_CLIENT_SUBSCRIPTION = "DERROR024";
	public static final String ERROR_CODE_GET_RISK_SCORE = "DERROR025";
	public static final String ERROR_CODE_GET_CLIENT_TEMPLATE = "DERROR026";
	public static final String ERROR_CODE_CREATE_CLIENT_TEMPLATE = "DERROR027";
	public static final String ERROR_CODE_GET_CLIENT_MODULE_HEADER = "DERROR028";
	public static final String ERROR_CODE_DOWNLOAD_IMPORT_SUMMARY = "DERROR029";
	public static final String ERROR_CODE_CREATE_CLIENT_SUBSCRIPTION = "DERROR030";
	public static final String ERROR_CODE_ADD_BANK_DETAIL = "DERROR031";
	public static final String ERROR_CODE_GET_SUBSCRIPTION_MODEL = "DERROR32";
	
	public static final String MSG_GET_EMPLOYEE_ERROR_RECORDS_FAILURE = "Unable to get employee error records";
	public static final String MSG_UPDATE_EMPLOYEE_FAILURE = "Unable to update employee";
	public static final String MSG_USERROLE_SEARCH_FAILURE = "Unable to get list of user roles";
	public static final String MSG_UNITNAME_SEARCH_FAILURE = "Unable to get list of unit Name";
	public static final String MSG_USER_SEARCH_FAILURE = "Unable to get list of user";
	public static final String MSG_REGISTER_FAILURE = "Unable to register user";
	public static final String MSG_GENERATE_TEMPLATENAME_FAILURE = "Unable to generate template name";
	public static final String MSG_CREATETEMPLATE_FAILURE = "Unable to create template";
	public static final String MSG_CREATE_LOANSCHEME_WORKSHEET_FAILURE = "Unable to create loansheet worksheet name";
	public static final String MSG_CREATE_LOAN_SCHEME_FAILURE = "Unable to create loan scheme";
	public static final String MSG_CREATE_LOAN_VARIANT_FAILURE = "Unable to create loan variant";
	public static final String MSG_DELETE_LOAN_SCHEME_FAILURE = "Unable to delete loan scheme";
	public static final String MSG_DELETE_BANK_FAILURE = "Unable to delete bank details";
	public static final String MSG_DELETE_DUE_DELIGENCE_FAILURE = "Unable to delete due deligence";
	public static final String MSG_GET_NEW_DUE_DELIGENCE_FAILURE = "Unable to get new DD sequence";
	public static final String MSG_DELETE_LOAN_VARIANT_FAILURE = "Unable to delete loan variant";
	public static final String MSG_CREATE_RISKRATING_FAILURE = "Unable to create Risk Rating";
	public static final String MSG_GET_RISKRATING_FAILURE = "Unable to get Risk Rating";
	public static final String MSG_CREATE_SUBSCRIPTION_FAILURE="Unable to create subscription";
	public static final String MSG_ADD_BANK_FAILURE="Unable to add bank";
	public static final String MSG_RESET_PASSWORD_FAILURE = "Unable to reset password";
	public static final String MSG_UPDATE_PASSWORD_FAILURE = "Unable to update password";
	public static final String MSG_UPDATE_USER_FAILURE = "Unable to update user details";
	public static final String MSG_UPDATE_HEADER_FAILURE = "Unable to update header";
	public static final String MSG_GET_HEADER_FAILURE = "Unable to get header";
	public static final String MSG_GET_GET_LANGUAGE_TEMPLATE_FAILURE = "Unable to get template name";
	public static final String MSG_GET_GET_SUBSCRIPTION_MODEL_FAILURE = "Unable to get subscription model";
	public static final String MSG_GET_GET_SUBSCRIPTION_LIST_FAILURE = "Unable to get subscriptions";
	public static final String MSG_GET_GET_LOAN_SCHEMES_FAILURE = "Unable to get loan schemes";
	public static final String MSG_UPDATE_CLIENT_SUBSCRIPTION_FAILURE = "Unable to update client subscription";
	public static final String MSG_GET_CLIENT_SUBSCRIPTION_FAILURE = "Unable to get subscription of client";
	public static final String MSG_GET_CLIENT_SUBSCRIPTION_HISTORY_FAILURE = "Unable to get subscription history of client";
	public static final String MSG_GET_CLIENT_LIST_FAILURE = "Unable to get list of client";
	public static final String MSG_GET_GET_CLIENT_TEMPLATE_FAILURE = "Unable to get client templates";
	public static final String MSG_CREATE_CLIENT_NEWVERSION_TEMPLATE_FAILURE = "Unable to create new version of template";
	public static final String MSG_GET_GET_CLIENT_MODULE_HEADER_FAILURE = "Unable to get client module header";
	public static final String MSG_GET_GET_CLIENT_DUEDELIGENCE_FAILURE = "Unable to get client due deligence";
	public static final String MSG_NO_HEADER_PASSED = "No Header passed for retrieving due deligence";
	public static final String MSG_NO_SEQUENCE_PASSED = "No Sequence passed for retrieving due deligence";
	public static final String MSG_UPDATE_CLIENT_DUE_DELIGENCE = "Unable to update client due deligence";
	public static final String MSG_MISSING_DD_SEQUENCE = "DD Sequence is missing in the request";
	public static final String MSG_NO_MODULE_CONFIGURED = "No such module configured";
	public static final String MSG_IMPORT_TEMPLATE_FAILURE="Unable to upload template";
	public static final String MSG_UPLOAD_EMPLOYEE_FAILURE="Unable to upload employee file";
	public static final String MSG_EXPORT_TEMPLATE_FAILURE="Please pass the trype of export expected";
	public static final String MSG_INVALID_XLS_FAILURE="Please upload a valid excel file";
	public static final String MSG_GET_GET_CLIENT_DETAIL_FAILURE = "Unable to get client details";
	public static final String MSG_GET_GET_CLIENT_BANK_DETAIL_FAILURE = "Unable to get client bank details";
	public static final String MSG_GET_GET_CLIENT_LOAN_VARIANT_FAILURE = "Unable to get client loan variant details";
	public static final String MSG_NO_CLIENT_ID = "No client id was found";
	public static final String MSG_NO_DD_ID = "No dd id or module name was found";
	public static final String MSG_NO_DDID = "No dd id was found";
	public static final String MSG_GET_USER_FAILURE = "Unable to get user details";
	public static final String MSG_CREATE_BRANCH_USER_FAILURE="Unable to create branch user";
	public static final String MSG_GET_BRANCH_LIST_FAILURE = "Unable to get list of branch users";
	public static final String MSG_GET_BRANCH_USER_FAILURE = "Unable to get branch user";
	public static final String MSG_GET_EMPLOYEES_LIST_FAILURE = "Unable to get list of employees";
	public static final String MSG_CREATE_UNIT_FAILURE="Unable to create unit";
	public static final String MSG_GET_UNITS_FAILURE="Unable to get units";
	public static final String MSG_GET_UNIT_FAILURE="Unable to get unit";
	public static final String MSG_GET_BANKDETAILS_FAILURE="Unable to get bank details";
	public static final String MSG_GET_E2E_TASK_FAILURE="Unable to e2e task details";
	public static final String MSG_GET_AUDIT_FIRM_USERS_FAILURE="Unable to get audit firm users";
	public static final String MSG_GET_AUDIT_FIRM_USER_FAILURE="Unable to get audit firm user";
	public static final String MSG_GET_DASHBOARD_TASKS_FAILURE="Unable to get tasks";
	public static final String MSG_GET_DASHBOARD_TASK_DETAILS_FAILURE="Unable to get task details";
	public static final String MSG_UPDATE_TASK_FAILURE="Unable to update task";
	public static final String MSG_REGISTER_CIF_FAILURE="Unable to register cif";
	public static final String MSG_GET_DASHBOARDTASKS_FAILURE = "Unable to get dashboard tasks";
	public static final String MSG_GET_CNC_DASHBOARDTASKS_FAILURE = "Unable to get CNC dashboard tasks";
	public static final String MSG_CREATE_AUDIT_FIRM_USER_FAILURE="Unable to create audit firm user";
	public static final String MSG_UPDATE_E2EDETAILS_FAILURE="Unable to update e2e details";
	public static final String MSG_GET_E2E_TAKS_FAILURE="Unable to get e2e tasks";
	public static final String MSG_DELETE_E2E_COMMERCIAL_FACILITY_FAILURE = "Unable to delete commercial facility";
	public static final String MSG_PROCESS_DUE_DELIGENCE_FAILURE="Unable to process due diligence";
	public static final String MSG_PROCESS_ADMINISTRATIVE_DETAILS_FAILURE="Unable to update administrative details";
	public static final String MSG_PROCESS_DUEDILIGENCE_GENERAL_INFO_FAILURE="Unable to update general info details";
	public static final String MSG_PROCESS_DUEDILIGENCE_CO_APPLICANT_FAILURE="Unable to update coapplicant details";
	public static final String MSG_GET_DUEDILIGENCE_GENERAL_INFO_FAILURE="Unable to get general info details";
	public static final String MSG_GET_DUEDILIGENCE_CO_APPLICANT_FAILURE="Unable to get coapplicant details";
	public static final String MSG_AUTO_GENERATED_DETAILS_FAILURE="Unable to get auto generated details";
	public static final String MSG_REASSIGN_USER_FAILURE="Unable to reassign user";
	public static final String MSG_SUBSTITUTE_USER_FAILURE="Unable to substitute user";
	public static final String MSG_GET_USERS_FAILURE = "Unable to get list of users";
	public static final String MSG_GET_REALTIME_CNC_DASHBOARDTASKS_FAILURE = "Unable to get real time c n c dashboard tasks";
	public static final String MSG_GET_DUE_DELIGENCE_FAILURE = "Unable to get due diligence";
	public static final String MSG_MANAGE_EMPLOYEE_FAILURE="Unable to save employee details";
	public static final String MSG_GET_REASSIGNUSERS_TASKS_FAILURE = "Unable to get list of tasks";
	public static final String MSG_GET_MAKERS_FAILURE = "Unable to get list of makers";
	public static final String MSG_GET_CHECKERS_FAILURE = "Unable to get list of checkers";
	public static final String MSG_GET_SA_FAILURE = "Unable to get list of sanction authority";
	public static final String MSG_GET_E2E_DASHBOARD_HEADER_FAILURE="Unable to get header details";
	public static final String MSG_GET_EMPLOYEE_FAILURE = "Unable to get list of employees";
	public static final String MSG_GET_USERROLE_FAILURE = "Unable to get list of userRoles";
	public static final String MSG_GET_UNITNAME_FAILURE = "Unable to get list of unitNames";
	public static final String MSG_GET_COMMERCIAL_CREDIT_FACILITIES_FAILURE = "Unable to get list of commercial credit facilities";
	public static final String MSG_GET_BRANCHNAME_FAILURE = "Unable to get list of branchNames";
	public static final String MSG_GET_AUDITFIRMCHECKER_FAILURE = "Unable to get list of audit firm checker";
	public static final String MSG_GET_AUDITFIRMMAKER_FAILURE = "Unable to get list of audit firm maker";
	public static final String MSG_GET_LOANCHEME_FAILURE = "Unable to get list of loan scheme";
	public static final String MSG_GET_LOANVARIANT_FAILURE = "Unable to get list of loan variant";
	public static final String MSG_GET_ACCOUNTTYPE_FAILURE = "Unable to get list of account type";
	public static final String MSG_GET_BORROWERTYPE_FAILURE = "Unable to get list of borrower type";
	public static final String MSG_GET_COAPPLICANT_FAILURE = "Unable to get list of coapplicant";
	public static final String MSG_GET_CIF_FAILURE = "Unable to get list of cif numbers";
	public static final String MSG_GET_BRANCH_MAKER_FAILURE = "Unable to get list of branch makers";
	public static final String MSG_GET_BRANCH_CHECKER_FAILURE = "Unable to get list of branch checkers";
	public static final String MSG_GET_BRANCH_SA_FAILURE = "Unable to get list of branch SA";
	public static final String MSG_GET_LOAN_SA_FAILURE = "Unable to get list of loan SA";
	public static final String MSG_GET_BORROWER_CATEGORY_FAILURE = "Unable to get list of borrower category";
	public static final String MSG_GET_MOVABLE_PROPERTY_FAILURE = "Unable to get list of movable property";
	public static final String MSG_GET_AUTO_GENERATED_DATA_FAILURE = "Unable to get auto generated data";
	public static final String MSG_GET_UNITCHECKER_FAILURE = "Unable to get list of unit checker";
	public static final String MSG_GET_DEFAULT_UNITCHECKER_FAILURE = "Unable to get default unit checker and maker";
	public static final String MSG_GET_DUE_DILIGENCE_GENERAL_INFO_FAILURE = "Unable to get general info of due diligence";
	public static final String MSG_GET_DUE_DILIGENCE_CO_APPLICANT_FAILURE = "Unable to get co applicant of due diligence";
	public static final String MSG_GET_DUE_DILIGENCE_GURANTOR_FAILURE = "Unable to get gurantor of due diligence";
	public static final String MSG_GET_DUE_DILIGENCE_COLLATERAL_SECURITY_FAILURE = "Unable to get collateral Security of due diligence";
	public static final String MSG_GET_DUE_DILIGENCE_MOVEABLEPROPERTY_FAILURE = "Unable to get moveable property of due diligence";
	public static final String MSG_NO_HEADER_FOR_DUE_DILIGENCE = "No Header found for due deligence";
	public static final String MSG_NO_DETAILS_FOR_DUE_DILIGENCE = "No details found for due deligence";
	public static final String MSG_NO_HEADER_FOR_DUE_DILIGENCE_LOAN_APP_ID = "No Header found for loan App Id";
	public static final String MSG_GET_MODULENAME_FAILURE = "Unable to get module name";
	
	//Functions OutputCode
	public static final String SUCCESS_CODE = "SUCCESS";
	public static final String LOGIN_FAILURE_CODE = "E01";
	public static final String MSG_REGISTER_SUCCESSCODE = "S";
	public static final String MSG_RESET_PASSWORD_SUCCESSCODE = "S";
	public static final String MSG_GENERATE_TEMPLATE_SUCCESSCODE = "";
	public static final String MSG_ADD_HEADER_SUCCESSCODE = "S";
	public static final String MSG_CREATE_TEMPLATE_SUCCESSCODE = "";
	public static final String MSG_GENERATE_LOANSCHEME_WORKSHEET_SUCCESSCODE = "";
	public static final String MSG_CREATE_LOANSCHEME_SUCCESSCODE = "S";
	public static final String MSG_CREATE_LOANVARIANT_SUCCESSCODE = "S";
	public static final String MSG_CREATE_RISKRATING_SUCCESSCODE = "";
	public static final String MSG_CREATE_SUBSCRIPTION_SUCCESSCODE = "S";
	public static final String MSG_CREATE_CLIENT_SUCCESSCODE = "";
	public static final String MSG_ADD_BANK_SUCCESSCODE = "";
	public static final String MSG_CREATE_CLIENT_LOANSCHEME_SUCCESSCODE = "";
	public static final String MSG_UPLOAD_FILE_SUCCESSCODE = "";
	public static final String MSG_UPDATE_USER_SUCCESSCODE = "S";
	public static final String MSG_UPDATE_PASSWORD_SUCCESSCODE = "";
	
	//REST Services
	public static final String SERVICE_LOANSCHEME = "/create-loanschemes";
	public static final String SERVICE_LOANVARIANT = "/create-loanvariants";
	public static final String SERVICE_GET_EXISTING_LOANVARIANTS = "/available-loanvariants";
	public static final String SERVICE_GET_EXISTING_LOANSCHEMES = "/available-loanschemes";
	public static final String SERVICE_LOANSCHEME_WORKSHEET_NAME = "/loanscheme-worksheetname";
	public static final String SERVICE_CREATE_TEMPLATE = "/create-template";
	public static final String SERVICE_GET_LANGUAGE_TEMPLATE = "/language-template";
	public static final String SERVICE_GENERATE_TEMPLATE_NAME = "/excel-templatename";
	public static final String SERVICE_ADD_HEADER = "/header";
	public static final String SERVICE_GET_HEADER = "/header";
	public static final String SERVICE_CREATE_RISKRATING_COLOR = "/risk-rating";
	public static final String SERVICE_GET_RISKRATING_COLOR = "/get-risk-rating";
	public static final String SERVICE_CREATE_SUBSCRIPTION = "/create-subscription/{subscriptionId}";
	public static final String SERVICE_CREATE_CLIENT = "/client";
	public static final String SERVICE_ADD_BANK_DETAILS = "/bank-details/{clientTypeId}";
	public static final String SERVICE_UPLOAD_TEMPLATE_FILE = "/template-upload/{templateId}/{clientTypeId}/{creditScoreTypeId}";
	public static final String SERVICE_EMPLOYEE_UPLOAD_TEMPLATE_FILE = "/employee-upload";
	public static final String SERVICE_DOWNLOAD_TEMPLATE_FILE = "/template-download";
	public static final String SERVICE_GET_EXISTING_TEMPLATES = "/view-imported-template/{clientTypeId}/{creditScoreTypeId}/{riskTypeId}";
	public static final String SERVICE_CREATE_CLIENT_LOANSCHEME = "/create-clientloanscheme";
	public static final String SERVICE_DELETE_CLIENT_LOANSCHEME = "/delete-clientloanscheme";
	public static final String SERVICE_DELETE_CLIENT_BANK = "/delete-clientbank";
	public static final String SERVICE_CREATE_CLIENT_LOANSVARIANT = "/create-clientloanvariant";
	public static final String SERVICE_DELETE_CLIENT_LOANSVARIANT = "/delete-clientloanvariant";
	public static final String SERVICE_LOAD_CLIENT_SUBSCRIPTION = "/load-clientsubscription";
	public static final String SERVICE_CREATE_CLIENT_SUBSCRIPTION = "/create-clientsubscription";
	public static final String SERVICE_UPDATE_CLIENT_SUBSCRIPTION = "/update-clientsubscription/{typeofrequest}";
	public static final String SERVICE_GET_CLIENT_SUBSCRIPTION_HISTORY = "/clientsubscription-history";
	public static final String SERVICE_GET_CLIENT_EXISTING_LOANSCHEMES = "/client-loanschemes";
	public static final String SERVICE_GET_CLIENTS = "/clients";
	public static final String SERVICE_GET_ACTIVE_CLIENTS = "/active-clients";
	public static final String SERVICE_GET_CLIENT_BYCLIENTTYPEID = "/registration-clients";
	public static final String SERVICE_GET_SUBSCRIPTION_MODEL = "/subscription-model";
	public static final String SERVICE_RESET_PASSWORD = "/reset-password";
	public static final String SERVICE_REGISTER_USER = "/signup/{userId}";
	public static final String SERVICE_LOGIN_USER = "/signin";
	public static final String SERVICE_UPDATE_PASSWORD_OF_USER = "/update-password";
	public static final String SERVICE_UPDATE_USER = "/update-user";
	public static final String SERVICE_GET_LANGUAGES = "/reference-languages";
	public static final String SERVICE_GET_CLIENT_CUSTOMIZE_TEMPLATE = "/client-customize-template";
	public static final String SERVICE_CREATE_CLIENT_TEMPLATE_NEW_VERSION = "/client-customize-template-newversion";
	public static final String SERVICE_GET_CLIENT_MODULE_HEADER = "/client-module-headers/{ddId}/{moduleName}";
	public static final String SERVICE_CLIENT_DUE_DELIGENCE = "/due-deligence";
	public static final String SERVICE_DELETE_CLIENT_DUE_DELIGIENCE = "/delete-duedeligence/{module}/{ddId}";
	public static final String SERVICE_SAVE_CLIENT_DUE_DELIGENCE = "/save-due-deligence/{action}/{headerKey}";
	public static final String SERVICE_GET_CLIENT_INFO = "/client-info";
	public static final String SERVICE_GET_BANK_DETAILS = "/get-bank-details";
	public static final String SERVICE_GET_CLIENT_LOANVARIANT = "/client-loanvariants";
	public static final String SERVICE_USER_DETAILS = "/user-details";
	public static final String SERVICE_GET_USERS = "/users";
	public static final String SERVICE_GET_SUBSCRIPTION = "/subscriptions";
	public static final String SERVICE_GET_NEW_DUE_DELIEGENCE = "/new-due-deligence/{ddId}";
	
	public static final String SERVICE_CLIENT_MANAGEMENT_DASHBOARD_TASK = "/client-mgmt-dashboard-task";
	public static final String SERVICE_GET_CLIENT_MANAGEMENT_DASHBOARD_TASKS = "/get-client-mgmt-dashboard-tasks";
	public static final String SERVICE_GET_CLIENT_MANAGEMENT_TASK = "/get-client-mgmt-dashboard-task";
	public static final String SERVICE_CLIENT_MANAGEMENT_CREATE_UNIT = "/client-mgmt-create-unit";
	public static final String SERVICE_CLIENT_MANAGEMENT_GET_UNIT = "/get-client-mgmt-unit";
	public static final String SERVICE_CLIENT_MANAGEMENT_GET_UNITS = "/get-client-mgmt-all-unit";
	
	public static final String SERVICE_CLIENT_MANAGEMENT_CREATE_AUDITFIRM_USER = "/client-mgmt-create-auditfirm-user";
	public static final String SERVICE_CLIENT_MANAGEMENT_GET_AUDITFIRM_USER = "/get-client-mgmt-auditfirm-user";
	public static final String SERVICE_CLIENT_MANAGEMENT_GET_AUDITFIRM_USERS = "/get-client-mgmt-all-auditfirm-user";
	
	public static final String SERVICE_CLIENT_MANAGEMENT_VIEW_EMPLOYEES = "/client-mgmt-view-employees";
	public static final String SERVICE_CLIENT_MANAGEMENT_UPDATE_EMPLOYEE = "/client-mgmt-update-employee";
	public static final String SERVICE_CLIENT_MANAGEMENT_DOWNLOAD_ERROR_EMPLOYEE = "/client-mgmt-download-error";
	
	public static final String SERVICE_CLIENT_MANAGEMENT_CREATE_BRANCH_USER = "/client-mgmt-create-branch-user";
	public static final String SERVICE_CLIENT_MANAGEMENT_GET_BRANCH_USER = "/get-client-mgmt-branch-user";
	public static final String SERVICE_CLIENT_MANAGEMENT_GET_BRANCH_USERS = "/get-client-mgmt-all-branch-users";
	
	public static final String SERVICE_REGISTER_CIF = "/cif-register";
	public static final String SERVICE_GET_E2E_DASHBOARD_TASKS = "/e2e-dashboard-tasks";
	public static final String SERVICE_GET_DASHBOARD_BANK_DETAILS = "/dashboard-bank-details";
	public static final String SERVICE_GET_DASHBOARD_REALTIME_BANK_DETAILS = "/realtime-dashboard-bank-details";
	public static final String SERVICE_UPDATE_E2E_DETAILS = "/e2e-details";
	public static final String SERVICE_GET_E2E_DETAILS = "/get-e2e-details";
	public static final String SERVICE_DELETE_E2E_COMERCIAL_CREDIT_FACILITY = "/delete-e2e-commercial-credit-facility";
	public static final String SERVICE_DUE_DELIGENCE_PROCESS = "/initiate-due-deligence-process";
	public static final String SERVICE_DUE_DELIGENCE_AUDIT_PROCESS = "/initiate-due-deligence-audit-process";
	public static final String SERVICE_REASSIGN_USER_APP = "/reassign-userapp";
	public static final String SERVICE_GET_REASSIGN_USER_APP = "/get-reassign-userapp";
	public static final String SERVICE_GET_CNC_DASHBOARD_TASKS = "/cnc-dashboard-tasks";
	public static final String SERVICE_GET_E2E_REALTIME_DASHBOARD_TASKS = "/e2e-realtime-dashboard-tasks";
	public static final String SERVICE_GET_E2E_REALTIME_HEADER_DASHBOARD = "/get-e2e-dashboard-header";
	public static final String SERVICE_GET_CNC_REALTIME_DASHBOARD_TASKS = "/cnc-realtime-dashboard-tasks";
	public static final String SERVICE_SUBSTITUTE_USER_APP = "/substitute-userapp";
	public static final String SERVICE_GET_SUBSTITUTE_USER_APP = "/get-substitute-userapp";
	public static final String SERVICE_NEW_DUE_DELIGENCE_PROCESS = "/initiate-new-due-deligence-process";
	public static final String SERVICE_MANAGE_EMPLOYEE = "/manage-employee";
	public static final String SERVICE_GET_MAKERS = "/makers";
	public static final String SERVICE_GET_CHECKERS = "/checkers";
	public static final String SERVICE_GET_SANCTIONING_AUTH = "/sanctioning-authority";
	public static final String SERVICE_GET_UNIT_NAMES = "/unit-names";
	public static final String SERVICE_GET_USER_ROLES = "/userrole-names";
	public static final String SERVICE_GET_EMPLOYEE_NAMES = "/employee-names";
	public static final String SERVICE_E2E_FULL_REPORT = "e2e-full-report";
	public static final String SERVICE_SAVE_VIEW_DD = "/save-viewDD";
	public static final String SERVICE_SAVE_VIEW_DD_M2_M5 = "/save-viewDD_M2_M5";
	public static final String SERVICE_SAVE_REASSIGN_USER = "/save-reassign-user";
	
	//Query
	public static final String QUERY_GET_EXISTING_SUMMARY_TEMPLATES = "select dd_id,template_name,imported_date,"
			+ "loan_scheme_name,total_ddaps,success,failure from bmadmin.bmduediligenceimportsummary bmddis"
			+ " where bmddis.dd_id in (select bmddm.dd_id  from bmadmin.bmduediligencemaster bmddm"
			+ "  where bmddm.template_id in (select template_id from bmadmin.bmtemplatemaster bmtm"
			+ " where bmtm.client_type_id = ?  and bmtm.credit_sector_type_id = ?  and bmtm.risk_type_id = ?))";
	public static final String QUERY_GET_TEMPLATE_NAME = "select client_type_id,credit_sector_type_id,risk_type_id,bml.language_id, bml.language_name, template_id,import_template_name "
			+ "from   bmadmin.bmtemplatemaster bmtm, bmadmin.bmlanguage bml where bml.language_id = bmtm.language_id "
			+ "and    client_type_id = ? and    risk_type_id = ? and    credit_sector_type_id = ?";
	public static final String QUERY_GET_ACTUAL_TEMPLATE_NAME = "select client_type_id,credit_sector_type_id,risk_type_id,bml.language_id, bml.language_name, template_id,import_template_name "
			+ "from   bmadmin.bmtemplatemaster bmtm, bmadmin.bmlanguage bml where bml.language_id = bmtm.language_id "
			+ "and    client_type_id = ?  and    credit_sector_type_id = ? and import_template_name = ?";
	public static final String QUERY_GET_AVAILABLE_LOAN_SCHEMES = "select template_id,tls.loan_scheme_id,loan_scheme_name,tls.loan_scheme_keyword,import_temp_loan_scheme_name from   "
			+ "bmadmin.bmtemplateloanschememaster tls,bmadmin.bmloanschemesmaster lsm where  tls.loan_scheme_id = lsm.loan_scheme_id and template_id = ?";
	public static final String QUERY_GET_AVAILABLE_LOAN_VARIANTS = "SELECT lvm.loan_scheme_id,loan_scheme_name,loan_variant_id,loan_variant,loan_variant_keyword "
			+ "FROM bmadmin.bmloanvariantsmaster lvm,bmadmin.bmloanschemesmaster lsm where lvm.loan_scheme_id = lsm.loan_scheme_id and lvm.loan_scheme_id = ?";
	public static final String QUERY_GET_HEADER_KEY_WITH_ALL_FILTER = "select header_key,english_desc,other_desc from bmadmin.bmheaders where header_key like %?% or english_desc like %?%";
	public static final String QUERY_GET_HEADER_KEY_WITH_HEADERKEY_FILTER = "select header_key,english_desc,other_desc from bmadmin.bmheaders where header_key like %?% ";
	public static final String QUERY_GET_HEADER_KEY_WITH_ENGDESC_FILTER = "select header_key,english_desc,other_desc from bmadmin.bmheaders where english_desc like %?%";
	public static final String QUERY_GET_HEADER_KEY_WITHOUT_FILTER = "select header_key,english_desc,other_desc from bmadmin.bmheaders";
	public static final String QUERY_GET_AVAILABLE_LOAN_SCHEMES_WITHOUT_CRITERIA = "select loan_scheme_id,loan_scheme_name,loan_scheme_keyword from bmadmin.bmloanschemesmaster";
	public static final String QUERY_GET_CLIENT_SUBSCRIPTION_HISTORY = "Select subscription_name,price_package,gst_percentage,"
			+ "tax_percentage,total_amount,subscription_start_date,subscription_end_date from bmadmin.bmclientsubscription bmcs, "
			+ "bmadmin.bmsubscription bms where bms.subscription_id = bmcs.subscription_id and bmcs.client_id = ? order by subscription_start_date";
	public static final String QUERY_GET_CLIENT_BY_ALL_CRITERIA = "select cg.client_group_id,client_group_type_id,bc.status,bc.client_id,client_type_id,client_name,bc.created_date,bc.updated_date,subscription_status,clinet_prefix,'' client_loan_scheme_name "
			+ "from  bmadmin.bmclient bc,bmadmin.bmclientsubscription bcs,bmadmin.bmclientgroup cg "
			+ "where bc.client_id = bcs.client_id and cg.client_id = bc.client_id and bc.client_type_id =? and client_name like CONCAT( '%',?,'%') "
			+ "and subscription_id = ? and city = ? and state = ?";
	
	public static final String QUERY_GET_CLIENT_BY_V1_TEMPLATE_AND_CLIENTID = "select dd_id,ls.loan_scheme_id,"
			+ "dg.client_group_id,client_loan_scheme_name,dg.start_date,dg.end_date,bc.status,dg.status as templatestatus,"
			+ " dg.client_id,client_type_id,bc.client_name,bc.created_date,bc.updated_date,clinet_prefix,client_loan_scheme_name,bc.updated_by "
			+ "from bmadmin.bmclientloanschemename  ls,bmadmin.bmduediligencemaster dg,bmadmin.bmclient bc "
			+ " where ls.client_id = dg.client_id and bc.client_id = dg.client_id "
			+ "and ls.loan_scheme_id = dg.loan_scheme_id and ls.client_id = ? and UPPER(dg.status) = UPPER(?) order by bc.client_name";
	
	public static final String QUERY_GET_CLIENT_BY_V1_TEMPLATE = "select dd_id,ls.loan_scheme_id,"
			+ "dg.client_group_id,client_loan_scheme_name,dg.start_date,dg.end_date,bc.status,dg.status as templatestatus,"
			+ " dg.client_id,client_type_id,bc.client_name,bc.created_date,bc.updated_date,clinet_prefix,client_loan_scheme_name,bc.updated_by "
			+ "from bmadmin.bmclientloanschemename  ls,bmadmin.bmduediligencemaster dg,bmadmin.bmclient bc "
			+ " where ls.client_id = dg.client_id  and bc.client_id = dg.client_id "
			+ "and ls.loan_scheme_id = dg.loan_scheme_id and UPPER(dg.status) = UPPER(?) order by bc.client_name";
	
	public static final String QUERY_GET_CLIENT_BY_CLIENTID = "select dd_id,ls.loan_scheme_id,"
			+ "dg.client_group_id,client_loan_scheme_name,dg.start_date,dg.end_date,bc.status,dg.status as templatestatus,"
			+ " dg.client_id,client_type_id,bc.client_name,bc.created_date,bc.updated_date,clinet_prefix,client_loan_scheme_name,bc.updated_by "
			+ "from bmadmin.bmclientloanschemename  ls,bmadmin.bmduediligencemaster dg,bmadmin.bmclient bc "
			+ " where ls.client_id = dg.client_id  and bc.client_id = dg.client_id "
			+ "and ls.loan_scheme_id = dg.loan_scheme_id and ls.client_id = ?";
	
	public static final String QUERY_GET_CLIENT_BY_CLIENTTYPE_CLIENTNM_SUBSCRIPTION = "select cg.client_group_id,"
			+ "client_group_type_id,bc.status,bc.client_id,client_type_id,client_name,bc.created_date,"
			+ "bc.updated_date,subscription_status,clinet_prefix,'' client_loan_scheme_name "
			+ "from  bmadmin.bmclient bc,bmadmin.bmclientsubscription bcs,bmadmin.bmclientgroup cg "
			+ "where bc.client_id = bcs.client_id and cg.client_id = bc.client_id and bc.client_type_id =? and client_name like CONCAT( '%',?,'%') "
			+ "and subscription_id = ?";
	public static final String QUERY_GET_CLIENT_BY_CLIENTNM_CLIENTTYPE = "SELECT bc.status,bc.client_id,"
			+ "client_type_id,client_name,bc.created_date,bc.updated_date,clinet_prefix,'' templatestatus,'' client_loan_scheme_name,bc.updated_by "
			+ "FROM bmadmin.bmclient bc where  bc.client_type_id =? and UPPER(client_name) like CONCAT( '%',UPPER(?),'%') order by client_name";
	public static final String QUERY_GET_CLIENT_BY_CLIENTTYPE_SUBSCRIPTION = "select cg.client_group_id,"
			+ "client_group_type_id,bc.status,bc.client_id,client_type_id,client_name,bc.created_date,bc.updated_date,"
			+ "subscription_status,clinet_prefix,'' templatestatus,'' client_loan_scheme_name "
			+ "from  bmadmin.bmclient bc,bmadmin.bmclientsubscription bcs,bmadmin.bmclientgroup cg "
			+ "where bc.client_id = bcs.client_id and cg.client_id = bc.client_id and bc.client_type_id =? and subscription_id = ?";
	public static final String QUERY_GET_CLIENT_BY_CLIENTTYPE = "SELECT bc.status,bc.client_id,"
			+ "client_type_id,client_name,bc.created_date,bc.updated_date,clinet_prefix,'' templatestatus,'' client_loan_scheme_name,bc.updated_by "
			+ "FROM bmadmin.bmclient bc where  bc.client_type_id =? order by client_name";
	
	public static final String QUERY_DELETE_DUE_DELIGENCE_BY_CLIENT_MODULE1 = "delete from bmadmin.bmduediligencedetails_m1 where dd_id = ? and dd_sequence = ?";
	
	public static final String QUERY_DELETE_DUE_DELIGENCE_BY_CLIENT_MODULE2 = "delete from bmadmin.bmduediligencedetails_m2 where dd_id = ? and dd_sequence = ?";
	
	public static final String QUERY_DELETE_DUE_DELIGENCE_BY_CLIENT_MODULE3 = "delete from bmadmin.bmduediligencedetails_m3 where dd_id = ? and dd_sequence = ?";
	
	public static final String QUERY_DELETE_DUE_DELIGENCE_BY_CLIENT_MODULE4 = "delete from bmadmin.bmduediligencedetails_m4 where dd_id = ? and dd_sequence = ?";
	
	public static final String QUERY_DELETE_DUE_DELIGENCE_BY_CLIENT_MODULE5 = "delete from bmadmin.bmduediligencedetails_m5 where dd_id = ? and dd_sequence = ?";
	public static final String QUERY_GET_CLIENTS_BY_CLIENTTYPE = "select bc.client_id,bc.client_name "
			+ "from  bmadmin.bmclient bc "
			+ "where bc.client_type_id =? order by bc.client_name";
	public static final String QUERY_GET_CLIENT_BY_CLIENTNM = "SELECT bc.status,bc.client_id,client_type_id,client_name,"
			+ "bc.created_date,bc.updated_date,clinet_prefix,'' templatestatus,'' client_loan_scheme_name,bc.updated_by "
			+ "FROM bmadmin.bmclient bc where  UPPER(client_name) like CONCAT( '%',UPPER(?),'%') order by client_name";
	public static final String QUERY_GET_CLIENT_BY_SUBSCRIPTION = "select cg.client_group_id,client_group_type_id,"
			+ "bc.status,bc.client_id,client_type_id,client_name,bc.created_date,bc.updated_date,subscription_status,"
			+ "clinet_prefix,'' templatestatus,'' client_loan_scheme_name "
			+ "from  bmadmin.bmclient bc,bmadmin.bmclientsubscription bcs,bmadmin.bmclientgroup cg "
			+ "where bc.client_id = bcs.client_id and cg.client_id = bc.client_id  "
			+ "and subscription_id = ?";
	public static final String QUERY_GET_AVAILABLE_LOAN_SCHEMES_FOR_CLIENT_WITHOUT_CRITERIA = "select loan_scheme_id,"
			+ "client_loan_scheme_name,null loan_scheme_keyword from bmadmin.bmclientloanschemename";
	
	public static final String QUERY_GET_AVAILABLE_LOAN_SCHEMES_FOR_NEW_ADDITION = "select loan_scheme_id,"
			+ "loan_scheme_name client_loan_scheme_name,loan_scheme_keyword,-1 client_group_id	from bmadmin.bmloanschemesmaster a"
			+ "	where not exists (select 'X' from  bmadmin.bmclientloanschemename b where  "
			+ "b.client_id = ? and  b.client_group_id = ? and b.loan_scheme_id = a.loan_scheme_id)";
	public static final String QUERY_GET_CLIENT_SUBSCRIPTION = "select subscription_name,subscription_period,"
			+ "max_clinet_group_allowed,max_loan_scheme_allowed,reminder_before,data_validity_period,price_per_month,"
			+ "price_package,tax_percentage,gst_percentage,total_amount,subscription_start_date,subscription_end_date,ct.client_type_id "
			+ "from   bmadmin.bmsubscription bs,bmadmin.bmclientsubscription bcs,bmadmin.bmclient bc,bmadmin.bmclienttype ct "
			+ "where  bcs.subscription_id = bs.subscription_id and bc.client_type_id = ct.client_type_id and bcs.client_id = bc.client_id and"
			+ " bcs.client_id = ?";
	public static final String QUERY_CHECK_NEW_CLIENT_SUBSCRIPTION  ="SELECT client_id  FROM bmadmin.bmclientsubscription WHERE client_id = ?"; 
	/*public static final String QUERY_GET_CLIENT_SUBSCRIPTION_FOR_EDIT = "SELECT   bmp.product_id,bmp.product_name,bmst.subscription_type_id,"
			+ "bmst.subscription_type,bmsst.subscription_sub_type_id,bmsst.subscription_sub_type_name,bms.subscription_id,"
			+ "bms.subscription_name,bmcs.client_id,bmcs.subscription_start_date,subscription_period,max_clinet_group_allowed,max_loan_scheme_allowed,"
			+ "reminder_before,data_validity_period,price_per_month,price_package,tax_percentage,gst_percentage,subscription_status,total_amount,subscription_end_date,renewal_reminder_date "
			+ "FROM bmadmin.bmclientsubscription bmcs,"
			+ "bmadmin.bmsubscription bms,bmadmin.bmsubscriptiontype bmst,bmadmin.bmsubscriptionsubtype bmsst,bmadmin.bmproduct bmp"
			+ "   where bmcs.client_id = ? and  bmcs.subscription_id = bms.subscription_id "
			+ "and bms.subscription_type_id = bmst.subscription_type_id and bms.subscription_sub_type_id = bmsst.subscription_sub_type_id "
			+ "and bms.product_id = bmp.product_id and bmcs.subscription_start_date <= now() and bmcs.subscription_end_date >= now()";
	// and bcs.subscription_status = 'A' and bcs.subscription_start_date <= now() and bcs.subscription_end_date >= now()*/
	public static final String QUERY_GET_CLIENT_SUBSCRIPTION_FOR_EDIT = "SELECT   bmp.product_id,bmp.product_name,"
			+ "bmst.subscription_type_id,bmst.subscription_type,bmsst.subscription_sub_type_id,bmsst.subscription_sub_type_name,"
			+ "bms.subscription_id,bms.subscription_name,bmcs.client_id,bmcs.subscription_start_date,"
			+ "subscription_period,max_clinet_group_allowed,max_loan_scheme_allowed,reminder_before,data_validity_period,"
			+ "price_per_month,price_package,tax_percentage,gst_percentage,subscription_status,total_amount,"
			+ "subscription_end_date,renewal_reminder_date FROM bmadmin.bmclientsubscription bmcs,"
			+ "bmadmin.bmsubscription bms,bmadmin.bmsubscriptiontype bmst,bmadmin.bmsubscriptionsubtype bmsst,bmadmin.bmproduct bmp "
			+ "where bmcs.client_id = ? and  bmcs.subscription_id = bms.subscription_id "
			+ "and bms.subscription_type_id = bmst.subscription_type_id and bms.subscription_sub_type_id = bmsst.subscription_sub_type_id "
			+ "and bms.product_id = bmp.product_id "
			+ "and bmcs.subscription_start_date in (select max(subscription_start_date) from bmadmin.bmclientsubscription "
			+ "where client_id=?)";
	
	
	public static final String QUERY_GET_RISK_RATING_SCORE = "select bmdr.response_id,bmdr.response_key,bmdr.response_description,"
			+ "bmdr.response_color,bmrd.general_score scheme_norms,bmrd.applicant_score,bmrd.co_applicant_score,bmrd.guarantor_score"
			+ "  from bmadmin.bmriskscoredetails bmrd,bmadmin.bmclient bmc,bmadmin.bmddresponse bmdr"
			+ " where bmrd.risk_type_id = bmc.risk_type_id and bmrd.client_id = bmc.client_id"
			+ " and bmrd.client_id = ? and bmrd.response_id = bmdr.response_id and bmdr.risk_type_id = bmc.risk_type_id ";
	
	public static final String QUERY_GET_RISK_RATING_SCORE_AUDIT_FIRM = "select bmdr.response_id,bmdr.response_key,bmdr.response_description,"
			+ "bmdr.response_color,bmrd.general_score scheme_norms,bmrd.applicant_score,bmrd.co_applicant_score,bmrd.guarantor_score"
			+ "  from bmadmin.bmriskscoredetails bmrd,bmadmin.bmclient bmc,bmadmin.bmddresponse bmdr"
			+ " where bmrd.risk_type_id = bmc.risk_type_id and bmrd.client_id = bmc.client_id"
			+ " and bmrd.client_id = ? and bmrd.client_group_id = ? and bmrd.response_id = bmdr.response_id  and bmdr.risk_type_id = bmc.risk_type_id";
	
	public static final String QUERY_GET_CLIENT_CUSTOMIZE_TEMPLATE = "select dd_id,ls.loan_scheme_id,dg.client_group_id,"
			+ "client_loan_scheme_name,dg.start_date,dg.end_date,dg.status from bmadmin.bmclientloanschemename  ls,"
			+ "bmadmin.bmduediligencemaster dg where ls.client_id = dg.client_id and ls.loan_scheme_id = dg.loan_scheme_id and ls.client_id = ?";
	
	public static final String QUERY_GET_CLIENT_CUSTOMIZE_TEMPLATE_FOR_BANK = "select distinct  dd_id,"
			+ " ls.loan_scheme_id,dg.client_group_id,"
			+ " concat(bmcg.client_group_name,concat('-',ls.client_loan_scheme_name)) client_loan_scheme_name,"
			+ " dg.start_date,dg.end_date,dg.status"
			+ "  from bmadmin.bmclientloanschemename  ls,bmadmin.bmduediligencemaster dg,"
			+ "bmadmin.bmclientgroup bmcg  where ls.client_id = dg.client_id and ls.client_id = bmcg.client_id"
			+ " and ls.loan_scheme_id = dg.loan_scheme_id and ls.client_id = ? and ls.client_group_id = bmcg.client_group_id"
			+ " and dg.client_group_id = bmcg.client_group_id";
	
	public static final String QUERY_GET_CLIENT_MODULE_HEADER_FOR_M1 = "SELECT dd_id,header1,header1_desc,header2,"
			+ "header2_desc,header3,header3_desc,header4,header4_desc,MIN(dd_sequence) dd_seq "
			+ "FROM   (SELECT DISTINCT dd_id,"
			+ "    dd_sequence,"
             + "           bmddm1.header1,"
              + "          (SELECT concat(english_desc, ',', other_desc)"
              + "           FROM   bmadmin.bmheaders"
             + "            WHERE  header_key = bmddm1.header1) header1_desc,"
            + "            bmddm1.header2,"
           + "             (SELECT concat(english_desc, ',', other_desc)"
           + "              FROM   bmadmin.bmheaders"
            + "             WHERE  header_key = bmddm1.header2) header2_desc,"
           + "             bmddm1.header3,"
           + "             (SELECT concat(english_desc, ',', other_desc)"
            + "             FROM   bmadmin.bmheaders"
           + "              WHERE  header_key = bmddm1.header3) header3_desc,"
           + "             bmddm1.header4,"
           + "             (SELECT concat(english_desc, ',', other_desc)"
           + "              FROM   bmadmin.bmheaders"
           + "              WHERE  header_key = bmddm1.header4) header4_desc"
           + " FROM   bmadmin.bmduediligencedetails_m1 bmddm1"
           + " WHERE  bmddm1.dd_id = ?) hdr"
			+ "			GROUP  BY dd_id,"
			+ "			          header1,"
			+ "			          header1_desc,"
			+ "			          header2,"
			+ "			          header2_desc,"
			+ "			          header3,"
			+ "			          header3_desc,"
			+ "			          header4,"
			+ "			          header4_desc"
			+ "			ORDER  BY dd_seq";
	
	public static final String QUERY_GET_CLIENT_MODULE_HEADER_FOR_M2 = "SELECT dd_id,header1,header1_desc,header2,"
			+ "header2_desc,header3,header3_desc,header4,header4_desc,MIN(dd_sequence) dd_seq "
			+ "FROM   (SELECT DISTINCT dd_id,"
			+ "    dd_sequence,"
             + "           bmddm1.header1,"
              + "          (SELECT concat(english_desc, ',', other_desc)"
              + "           FROM   bmadmin.bmheaders"
             + "            WHERE  header_key = bmddm1.header1) header1_desc,"
            + "            bmddm1.header2,"
           + "             (SELECT concat(english_desc, ',', other_desc)"
           + "              FROM   bmadmin.bmheaders"
            + "             WHERE  header_key = bmddm1.header2) header2_desc,"
           + "             bmddm1.header3,"
           + "             (SELECT concat(english_desc, ',', other_desc)"
            + "             FROM   bmadmin.bmheaders"
           + "              WHERE  header_key = bmddm1.header3) header3_desc,"
           + "             bmddm1.header4,"
           + "             (SELECT concat(english_desc, ',', other_desc)"
           + "              FROM   bmadmin.bmheaders"
           + "              WHERE  header_key = bmddm1.header4) header4_desc"
           + " FROM   bmadmin.bmduediligencedetails_m2 bmddm1"
           + " WHERE  bmddm1.dd_id = ?) hdr"
			+ "			GROUP  BY dd_id,"
			+ "			          header1,"
			+ "			          header1_desc,"
			+ "			          header2,"
			+ "			          header2_desc,"
			+ "			          header3,"
			+ "			          header3_desc,"
			+ "			          header4,"
			+ "			          header4_desc"
			+ "			ORDER  BY dd_seq";
	
	public static final String QUERY_GET_CLIENT_MODULE_HEADER_FOR_M3 = "SELECT dd_id,header1,header1_desc,header2,"
			+ "header2_desc,header3,header3_desc,header4,header4_desc,MIN(dd_sequence) dd_seq "
			+ "FROM   (SELECT DISTINCT dd_id,"
			+ "    dd_sequence,"
             + "           bmddm1.header1,"
              + "          (SELECT concat(english_desc, ',', other_desc)"
              + "           FROM   bmadmin.bmheaders"
             + "            WHERE  header_key = bmddm1.header1) header1_desc,"
            + "            bmddm1.header2,"
           + "             (SELECT concat(english_desc, ',', other_desc)"
           + "              FROM   bmadmin.bmheaders"
            + "             WHERE  header_key = bmddm1.header2) header2_desc,"
           + "             bmddm1.header3,"
           + "             (SELECT concat(english_desc, ',', other_desc)"
            + "             FROM   bmadmin.bmheaders"
           + "              WHERE  header_key = bmddm1.header3) header3_desc,"
           + "             bmddm1.header4,"
           + "             (SELECT concat(english_desc, ',', other_desc)"
           + "              FROM   bmadmin.bmheaders"
           + "              WHERE  header_key = bmddm1.header4) header4_desc"
           + " FROM   bmadmin.bmduediligencedetails_m3 bmddm1"
           + " WHERE  bmddm1.dd_id = ?) hdr"
			+ "			GROUP  BY dd_id,"
			+ "			          header1,"
			+ "			          header1_desc,"
			+ "			          header2,"
			+ "			          header2_desc,"
			+ "			          header3,"
			+ "			          header3_desc,"
			+ "			          header4,"
			+ "			          header4_desc"
			+ "			ORDER  BY dd_seq";
	
	public static final String QUERY_GET_CLIENT_MODULE_HEADER_FOR_M4 = "SELECT dd_id,header1,header1_desc,header2,"
			+ "header2_desc,header3,header3_desc,header4,header4_desc,MIN(dd_sequence) dd_seq "
			+ "FROM   (SELECT DISTINCT dd_id,"
			+ "    dd_sequence,"
             + "           bmddm1.header1,"
              + "          (SELECT concat(english_desc, ',', other_desc)"
              + "           FROM   bmadmin.bmheaders"
             + "            WHERE  header_key = bmddm1.header1) header1_desc,"
            + "            bmddm1.header2,"
           + "             (SELECT concat(english_desc, ',', other_desc)"
           + "              FROM   bmadmin.bmheaders"
            + "             WHERE  header_key = bmddm1.header2) header2_desc,"
           + "             bmddm1.header3,"
           + "             (SELECT concat(english_desc, ',', other_desc)"
            + "             FROM   bmadmin.bmheaders"
           + "              WHERE  header_key = bmddm1.header3) header3_desc,"
           + "             bmddm1.header4,"
           + "             (SELECT concat(english_desc, ',', other_desc)"
           + "              FROM   bmadmin.bmheaders"
           + "              WHERE  header_key = bmddm1.header4) header4_desc"
           + " FROM   bmadmin.bmduediligencedetails_m4 bmddm1"
           + " WHERE  bmddm1.dd_id = ?) hdr"
			+ "			GROUP  BY dd_id,"
			+ "			          header1,"
			+ "			          header1_desc,"
			+ "			          header2,"
			+ "			          header2_desc,"
			+ "			          header3,"
			+ "			          header3_desc,"
			+ "			          header4,"
			+ "			          header4_desc"
			+ "			ORDER  BY dd_seq";
	
	public static final String QUERY_GET_CLIENT_MODULE_HEADER_FOR_M5 = "SELECT dd_id,header1,header1_desc,header2,"
			+ "header2_desc,header3,header3_desc,header4,header4_desc,MIN(dd_sequence) dd_seq "
			+ "FROM   (SELECT DISTINCT dd_id,"
			+ "    dd_sequence,"
            + "           bmddm1.header1,"
            + "          (SELECT concat(english_desc, ',', other_desc)"
            + "           FROM   bmadmin.bmheaders"
            + "            WHERE  header_key = bmddm1.header1) header1_desc,"
            + "            bmddm1.header2,"
            + "             (SELECT concat(english_desc, ',', other_desc)"
            + "              FROM   bmadmin.bmheaders"
            + "             WHERE  header_key = bmddm1.header2) header2_desc,"
            + "             bmddm1.header3,"
            + "             (SELECT concat(english_desc, ',', other_desc)"
            + "             FROM   bmadmin.bmheaders"
           + "              WHERE  header_key = bmddm1.header3) header3_desc,"
           + "             bmddm1.header4,"
           + "             (SELECT concat(english_desc, ',', other_desc)"
           + "              FROM   bmadmin.bmheaders"
           + "              WHERE  header_key = bmddm1.header4) header4_desc"
           + " FROM   bmadmin.bmduediligencedetails_m5 bmddm1"
           + " WHERE  bmddm1.dd_id = ?) hdr"
			+ "			GROUP  BY dd_id,"
			+ "			          header1,"
			+ "			          header1_desc,"
			+ "			          header2,"
			+ "			          header2_desc,"
			+ "			          header3,"
			+ "			          header3_desc,"
			+ "			          header4,"
			+ "			          header4_desc"
			+ "			ORDER  BY dd_seq";
	
	public static final String QUERY_GET_CLIENT_DUE_DELIGENCE_M1 = "select bmddm1.header_seq,dd_sequence,dd_parent_sequence,dd_data,"
			+ "general_options,applicant_options,coapplicant_options,guarantor_options,'' as compliance_options,remarks, bmddm1.conditions,"
			+ "bmddm1.credit_sector_id,bmddm1.loan_scheme_id,bmddm1.loan_variant_keyword,bmddm1.borrower_type_id,"
			+ "bmddm1.criticalty_factor,bmddm1.profession_id,bmddm1.loan_application_type_id,bmddm1.security_id,"
			+ "bmddm1.security_type_id,bmddm1.applicant_type_id,bmddm1.asset_type_id "
			+ " from bmadmin.bmduediligencedetails_m1 bmddm1 ";
	
	public static final String QUERY_GET_CLIENT_DUE_DELIGENCE_M2 = "select bmddm1.header_seq,dd_sequence,dd_parent_sequence,dd_data,"
			+ "'' as general_options,'' as applicant_options,'' as coapplicant_options,'' as guarantor_options,compliance_options,remarks, bmddm1.conditions,"
			+ "bmddm1.credit_sector_id,bmddm1.loan_scheme_id,bmddm1.loan_variant_keyword,bmddm1.borrower_type_id,"
			+ "bmddm1.criticalty_factor,bmddm1.profession_id,bmddm1.loan_application_type_id,bmddm1.security_id,"
			+ "bmddm1.security_type_id,bmddm1.applicant_type_id,bmddm1.asset_type_id "
			+ " from bmadmin.bmduediligencedetails_m2 bmddm1 ";
	
	public static final String QUERY_GET_CLIENT_DUE_DELIGENCE_M3 = "select bmddm1.header_seq,dd_sequence,dd_parent_sequence,dd_data,"
			+ "'' as general_options,'' as applicant_options,'' as coapplicant_options,'' as guarantor_options,compliance_options,remarks, bmddm1.conditions,"
			+ "bmddm1.credit_sector_id,bmddm1.loan_scheme_id,bmddm1.loan_variant_keyword,bmddm1.borrower_type_id,"
			+ "bmddm1.criticalty_factor,bmddm1.profession_id,bmddm1.loan_application_type_id,bmddm1.security_id,"
			+ "bmddm1.security_type_id,bmddm1.applicant_type_id,bmddm1.asset_type_id "
			+ " from bmadmin.bmduediligencedetails_m3 bmddm1 ";
	
	public static final String QUERY_GET_CLIENT_DUE_DELIGENCE_M4 = "select bmddm1.header_seq,dd_sequence,dd_parent_sequence,dd_data,"
			+ "'' as general_options,'' as applicant_options,'' as coapplicant_options,'' as guarantor_options,compliance_options,remarks, bmddm1.conditions,"
			+ "bmddm1.credit_sector_id,bmddm1.loan_scheme_id,bmddm1.loan_variant_keyword,bmddm1.borrower_type_id,"
			+ "bmddm1.criticalty_factor,bmddm1.profession_id,bmddm1.loan_application_type_id,bmddm1.security_id,"
			+ "bmddm1.security_type_id,bmddm1.applicant_type_id,bmddm1.asset_type_id "
			+ " from bmadmin.bmduediligencedetails_m4 bmddm1 ";
	
	
	public static final String QUERY_GET_CLIENT_DUE_DELIGENCE_M5 = "select bmddm1.header_seq,dd_sequence,dd_parent_sequence,dd_data,"
			+ "'' as general_options,'' as applicant_options,'' as coapplicant_options,'' as guarantor_options,compliance_options,remarks, bmddm1.conditions,"
			+ "bmddm1.credit_sector_id,bmddm1.loan_scheme_id,bmddm1.loan_variant_keyword,bmddm1.borrower_type_id,"
			+ "bmddm1.criticalty_factor,bmddm1.profession_id,bmddm1.loan_application_type_id,bmddm1.security_id,"
			+ "bmddm1.security_type_id,bmddm1.applicant_type_id,bmddm1.asset_type_id "
			+ " from bmadmin.bmduediligencedetails_m5 bmddm1 ";

	
	public static final String QUERY_UPDATE_DUE_DELIGENCE_STATUS = "update bmadmin.bmduediligencemaster set status = ?,updated_date = ?,"
			+ " updated_by = ? "
			+ " where dd_id = ?";
	
	public static final String QUERY_UPDATE_EMPLOYEE_STATUS = "update bmadmin.bmemployeemaster set status = ? where employee_id = ?";
	
	public static final String QUERY_INSERT_NEW_DUE_DELIGENCE_ROW_MODULE1 = "INSERT INTO bmadmin.bmduediligencedetails_m1("
			+ "dd_id,dd_sequence,dd_parent_sequence,dd_data,header1,header2,header3,header4,general_options,"
			+ "applicant_options,coapplicant_options,guarantor_options,conditions,credit_sector_id,loan_scheme_id,"
			+ "loan_variant_keyword,borrower_type_id,criticalty_factor,profession_id,loan_application_type_id,security_id,"
			+ "security_type_id,security_subtype_id,applicant_type_id,asset_type_id,created_by,created_date,header_seq) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public static final String QUERY_UPDATE_DUE_DELIGENCE_ROW_MODULE1 = "update bmadmin.bmduediligencedetails_m1 "
			+ "   set  dd_parent_sequence = ?,dd_data=?,header1=?,header2=?,header3=?,"
			+ "header4=?,general_options=?,applicant_options=?,coapplicant_options=?,"
			+ "guarantor_options=?,conditions = ?,credit_sector_id = ?,loan_scheme_id = ? ,"
			+ "loan_variant_keyword = ?,borrower_type_id =?,criticalty_factor = ?,"
			+ "profession_id =?,loan_application_type_id = ?,security_id =?,security_type_id =?,"
			+ "security_subtype_id = ?,applicant_type_id = ?,asset_type_id = ?,header_seq = ?,"
			+ "remarks = ?,updated_by=?,updated_date= ? where  dd_id = ?  and  dd_sequence = ?";
	
	public static final String QUERY_INSERT_NEW_DUE_DELIGENCE_ROW_MODULE2 = "INSERT INTO bmadmin.bmduediligencedetails_m2("
			+ "dd_id,dd_sequence,dd_parent_sequence,dd_data,header1,header2,header3,header4,compliance_options,conditions,credit_sector_id,loan_scheme_id,"
			+ "loan_variant_keyword,borrower_type_id,criticalty_factor,profession_id,loan_application_type_id,security_id,"
			+ "security_type_id,security_subtype_id,applicant_type_id,asset_type_id,created_by,created_date,header_seq) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public static final String QUERY_UPDATE_DUE_DELIGENCE_ROW_MODULE2 = "update bmadmin.bmduediligencedetails_m2 "
			+ "   set  dd_parent_sequence = ?,dd_data=?,header1=?,header2=?,header3=?,"
			+ "header4=?,compliance_options=?,conditions = ?,credit_sector_id = ?,loan_scheme_id = ? ,"
			+ "loan_variant_keyword = ?,borrower_type_id =?,criticalty_factor = ?,"
			+ "profession_id =?,loan_application_type_id = ?,security_id =?,security_type_id =?,"
			+ "security_subtype_id = ?,applicant_type_id = ?,asset_type_id = ?,header_seq = ?,"
			+ "remarks = ?,updated_by=?,updated_date= ? where  dd_id = ?  and  dd_sequence = ?";
	
	public static final String QUERY_INSERT_NEW_DUE_DELIGENCE_ROW_MODULE3 = "INSERT INTO bmadmin.bmduediligencedetails_m3("
			+ "dd_id,dd_sequence,dd_parent_sequence,dd_data,header1,header2,header3,header4,compliance_options,conditions,credit_sector_id,loan_scheme_id,"
			+ "loan_variant_keyword,borrower_type_id,criticalty_factor,profession_id,loan_application_type_id,security_id,"
			+ "security_type_id,security_subtype_id,applicant_type_id,asset_type_id,created_by,created_date,header_seq) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public static final String QUERY_UPDATE_DUE_DELIGENCE_ROW_MODULE3 = "update bmadmin.bmduediligencedetails_m3 "
			+ "   set  dd_parent_sequence = ?,dd_data=?,header1=?,header2=?,header3=?,"
			+ "header4=?,compliance_options=?,conditions = ?,credit_sector_id = ?,loan_scheme_id = ? ,"
			+ "loan_variant_keyword = ?,borrower_type_id =?,criticalty_factor = ?,"
			+ "profession_id =?,loan_application_type_id = ?,security_id =?,security_type_id =?,"
			+ "security_subtype_id = ?,applicant_type_id = ?,asset_type_id = ?,header_seq = ?,"
			+ "remarks = ?,updated_by=?,updated_date= ? where  dd_id = ?  and  dd_sequence = ?";
	
	public static final String QUERY_INSERT_NEW_DUE_DELIGENCE_ROW_MODULE4 = "INSERT INTO bmadmin.bmduediligencedetails_m4("
			+ "dd_id,dd_sequence,dd_parent_sequence,dd_data,header1,header2,header3,header4,compliance_options,conditions,credit_sector_id,loan_scheme_id,"
			+ "loan_variant_keyword,borrower_type_id,criticalty_factor,profession_id,loan_application_type_id,security_id,"
			+ "security_type_id,security_subtype_id,applicant_type_id,asset_type_id,created_by,created_date,header_seq) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public static final String QUERY_UPDATE_DUE_DELIGENCE_ROW_MODULE4 = "update bmadmin.bmduediligencedetails_m4 "
			+ "   set  dd_parent_sequence = ?,dd_data=?,header1=?,header2=?,header3=?,"
			+ "header4=?,compliance_options=?,conditions = ?,credit_sector_id = ?,loan_scheme_id = ? ,"
			+ "loan_variant_keyword = ?,borrower_type_id =?,criticalty_factor = ?,"
			+ "profession_id =?,loan_application_type_id = ?,security_id =?,security_type_id =?,"
			+ "security_subtype_id = ?,applicant_type_id = ?,asset_type_id = ?,header_seq = ?,"
			+ "remarks = ?,updated_by=?,updated_date=?  where  dd_id = ?  and  dd_sequence = ?";
	
	public static final String QUERY_INSERT_NEW_DUE_DELIGENCE_ROW_MODULE5 = "INSERT INTO bmadmin.bmduediligencedetails_m5("
			+ "dd_id,dd_sequence,dd_parent_sequence,dd_data,header1,header2,header3,header4,compliance_options,conditions,credit_sector_id,loan_scheme_id,"
			+ "loan_variant_keyword,borrower_type_id,criticalty_factor,profession_id,loan_application_type_id,security_id,"
			+ "security_type_id,security_subtype_id,applicant_type_id,asset_type_id,created_by,created_date,header_seq) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	
	public static final String QUERY_UPDATE_DUE_DELIGENCE_ROW_MODULE5 = "update bmadmin.bmduediligencedetails_m5 "
			+ "   set  dd_parent_sequence = ?,dd_data=?,header1=?,header2=?,header3=?,"
			+ "header4=?,compliance_options=?,conditions = ?,credit_sector_id = ?,loan_scheme_id = ? ,"
			+ "loan_variant_keyword = ?,borrower_type_id =?,criticalty_factor = ?,"
			+ "profession_id =?,loan_application_type_id = ?,security_id =?,security_type_id =?,"
			+ "security_subtype_id = ?,applicant_type_id = ?,asset_type_id = ?,header_seq = ?,"
			+ "remarks = ?,updated_by=?,updated_date = ? where  dd_id = ?  and  dd_sequence = ?";
	
	public static final String QUERY_GET_DOWNLOAD_IMPORT_SUMMARY = "SELECT dd_seq,dd_parent_seq,header1,header2,header3 FROM bmadmin.bmduediligenceaudit";
	
	public static final String QUERY_GET_DOWNLOAD_SUCCESS_RECORDS = "SELECT 'M1' module,header1, header2, header3, header4,dd_id, header_seq,dd_sequence, dd_parent_sequence, dd_data, general_options, applicant_options, coapplicant_options, guarantor_options, conditions, credit_sector_id, loan_scheme_id, loan_variant_keyword, borrower_type_id, criticalty_factor, profession_id, loan_application_type_id, security_id, security_type_id, security_subtype_id, applicant_type_id, asset_type_id, remarks, created_by, created_date, updated_by, updated_date "
	+ "FROM bmadmin.bmduediligencedetails_m1 where dd_id = ? union all SELECT 'M2'module,header1, header2, header3, header4,dd_id, header_seq,dd_sequence, dd_parent_sequence, dd_data, compliance_options general_options, null applicant_options,null coapplicant_options,null guarantor_options, conditions, credit_sector_id, loan_scheme_id, loan_variant_keyword, borrower_type_id, criticalty_factor, profession_id, loan_application_type_id, security_id, security_type_id, security_subtype_id, applicant_type_id, asset_type_id, remarks, created_by, created_date, updated_by, updated_date "
	+ "FROM bmadmin.bmduediligencedetails_m2 where dd_id = ? union all SELECT 'M3'module,header1, header2, header3, header4,dd_id, header_seq,dd_sequence, dd_parent_sequence, dd_data, compliance_options general_options, null applicant_options,null coapplicant_options,null guarantor_options, conditions, credit_sector_id, loan_scheme_id, loan_variant_keyword, borrower_type_id, criticalty_factor, profession_id, loan_application_type_id, security_id, security_type_id, security_subtype_id, applicant_type_id, asset_type_id, remarks, created_by, created_date, updated_by, updated_date "
	+ "FROM bmadmin.bmduediligencedetails_m3 where dd_id = ? union all SELECT 'M4'module,header1, header2, header3, header4,dd_id, header_seq,dd_sequence, dd_parent_sequence, dd_data, compliance_options general_options, null applicant_options,null coapplicant_options,null guarantor_options, conditions, credit_sector_id, loan_scheme_id, loan_variant_keyword, borrower_type_id, criticalty_factor, profession_id, loan_application_type_id, security_id, security_type_id, security_subtype_id, applicant_type_id, asset_type_id, remarks, created_by, created_date, updated_by, updated_date "
	+ "FROM bmadmin.bmduediligencedetails_m4 where dd_id = ? union all SELECT 'M5'module,header1, header2, header3, header4,dd_id, header_seq,dd_sequence, dd_parent_sequence, dd_data, compliance_options general_options, null applicant_options,null coapplicant_options,null guarantor_options, conditions, credit_sector_id, loan_scheme_id, loan_variant_keyword, borrower_type_id, criticalty_factor, profession_id, loan_application_type_id, security_id, security_type_id, security_subtype_id, applicant_type_id, asset_type_id, remarks, created_by, created_date, updated_by, updated_date "
	+ "FROM bmadmin.bmduediligencedetails_m5 where dd_id = ?";
	
	public static final String QUERY_GET_DOWNLOAD_FAILURE_RECORDS = "select dd_id,template_name,worksheet_name,module,header1,header2,"
			+ "header3,header4,dd_seq,dd_parent_seq,remarks from bmadmin.bmduediligenceaudit where dd_id = ?";
	
	public static final String QUERY_GET_SUBSCRIPTION_MODEL = "SELECT subscription_id,subscription_name FROM bmadmin.bmsubscription "
			+ "where subscription_type_id = ? and subscription_sub_type_id = ? and product_id = ? ORDER BY subscription_name ASC ";
	
	public static final String QUERY_GET_SUBSCRIPTION_LIST = "select subscription_type,subscription_sub_type_name,product_name,"
			+ "bs.product_id,subscription_id,bs.subscription_type_id,bs.subscription_sub_type_id,subscription_name,subscription_period,"
			+ "max_clinet_group_allowed,max_loan_scheme_allowed,data_validity_period,price_per_month,reminder_before FROM "
			+ "bmadmin.bmsubscription bs, bmadmin.bmsubscriptiontype bstype,bmadmin.bmsubscriptionsubtype bsubtype,bmadmin.bmproduct bp "
			+ "where bs.subscription_type_id = bstype.subscription_type_id and bp.product_id = bs.product_id and "
			+ "bs.subscription_sub_type_id = bsubtype.subscription_sub_type_id "
			+ "and bs.product_id = ? and  bs.subscription_type_id = ? and bs.subscription_sub_type_id = ?";
	
	public static final String QUERY_GET_SUBSCRIPTION_BY_ID = "select subscription_type,subscription_sub_type_name,product_name,"
			+ "bs.product_id,subscription_id,bs.subscription_type_id,bs.subscription_sub_type_id,subscription_name,subscription_period,"
			+ "max_clinet_group_allowed,max_loan_scheme_allowed,data_validity_period,price_per_month,reminder_before FROM "
			+ "bmadmin.bmsubscription bs, bmadmin.bmsubscriptiontype bstype,bmadmin.bmsubscriptionsubtype bsubtype,bmadmin.bmproduct bp "
			+ "where bs.subscription_type_id = bstype.subscription_type_id and bp.product_id = bs.product_id and "
			+ "bs.subscription_sub_type_id = bsubtype.subscription_sub_type_id "
			+ "and bs.subscription_id = ?";

	public static final String QUERY_GET_LATEST_CLIENT_ID = "SELECT client_id FROM bmadmin.bmclient ORDER BY client_id DESC";
	
	public static final String QUERY_GET_CLIENT_DETAILS = "SELECT client_id,client_type_id,clinet_prefix,client_name,client_start_date,"
			+ "address,city,pincode,state,gstn_no,primary_poc,primary_poc_number,primary_poc_designation,primary_poc_email,secondary_poc,"
			+ "secondary_poc_number,secondary_poc_designation,secondary_poc_email,client_logo,created_date,created_by,updated_date,updated_by,"
			+ "language_id,status,risk_type_id FROM bmadmin.bmclient WHERE client_id = ?";
	public static final String QUERY_GET_CLIENT_BANK_DETAILS = "SELECT client_group_id,client_id,client_group_name Bank_Name,"
			+ "address,city,state,pincode,created_date,created_by,updated_date,updated_by FROM bmadmin.bmclientgroup where client_id = ?";
	public static final String QUERY_GET_AVAILABLE_LOAN_SCHEMES_FOR_CLIENT = "SELECT distinct bmlsm.loan_scheme_id,bmlsm.loan_scheme_name,"
			+ "client_loan_scheme_name,-1 client_group_id,loan_scheme_keyword FROM bmadmin.bmclientloanschemename bmclsn,bmadmin.bmloanschemesmaster bmlsm"
			+ " WHERE bmclsn.loan_scheme_id = bmlsm.loan_scheme_id  AND bmclsn.client_id = ?";
	
	public static final String QUERY_GET_AVAILABLE_LOAN_SCHEMES_FOR_CLIENT_AUDIT_FIRM = "select distinct a.loan_scheme_id,"
			+ "a.client_group_name loan_scheme_name,"
			+ "client_loan_scheme_name,client_group_id,loan_scheme_keyword "
			+ "from (SELECT  bmlsm.loan_scheme_id,"
			+ "(select client_group_name from bmadmin.bmclientgroup where client_group_id=bmclsn.client_group_id) client_group_name,"
			+ "bmlsm.loan_scheme_name,client_loan_scheme_name,client_group_id,loan_scheme_keyword"
			+ " FROM bmadmin.bmclientloanschemename bmclsn,bmadmin.bmloanschemesmaster bmlsm"
			+ "  WHERE bmclsn.loan_scheme_id = bmlsm.loan_scheme_id AND  bmclsn.client_id = ?) A";
	
	public static final String QUERY_GET_CLIENT_LOANVARIANT_DETAILS = "SELECT distinct bmclsn.loan_scheme_id,-1 client_group_id,bmlsm.loan_scheme_name,"
			+ "bmclsv.loan_variant_id,bmclsv.client_loan_variant_name,bmclsv.client_loan_variant_keyword"
			+ "  FROM bmadmin.bmclientloanschemevariant bmclsv,bmadmin.bmclientloanschemename bmclsn,bmadmin.bmloanschemesmaster bmlsm"
			+ " WHERE bmclsv.loan_scheme_id = bmclsn.loan_scheme_id and bmlsm.loan_scheme_id = bmclsv.loan_scheme_id  "
			+ " and bmclsn.client_id = bmclsv.client_id AND bmclsv.client_id = ?";
	
	public static final String QUERY_GET_CLIENT_LOANVARIANT_DETAILS_FOR_AUDIT = "SELECT  a.loan_scheme_id,client_group_id,"
			+ "a.client_group_name loan_scheme_name,a.loan_variant_id,"
			+ "a.client_loan_variant_name,a.client_loan_variant_keyword from ( SELECT bmclsn.loan_scheme_id,"
			+ "(select client_group_name from bmadmin.bmclientgroup where client_group_id=bmclsv.client_group_id) client_group_name,"
			+ "bmlsm.loan_scheme_name,bmclsv.loan_variant_id,bmclsv.client_loan_variant_name,bmclsv.client_loan_variant_keyword,bmclsv.client_group_id "
			+ " FROM bmadmin.bmclientloanschemevariant bmclsv,bmadmin.bmclientloanschemename bmclsn,bmadmin.bmloanschemesmaster bmlsm"
			+ " WHERE bmclsv.loan_scheme_id = bmclsn.loan_scheme_id"
			+ " and bmlsm.loan_scheme_id = bmclsv.loan_scheme_id"
			+ "  and bmclsn.client_id = bmclsv.client_id"
			+ " and bmclsn.client_group_id=bmclsv.client_group_id AND bmclsv.client_id = ? ) A";
	
	public static final String QUERY_GET_USER_BY_ALL_CRITERIA = "select bmct.client_type_id,bmct.client_name,bmu.client_id,bmu.client_name,bmur.user_role_id,user_id,"
			+ "bmur.user_role_name, bmu.employee_id,bmu.username,bmu.fullname,bmu.mobile_number,bmu.email,bmu.userstatus from   bmadmin.bmusers bmu,"
			+ "bmadmin.bmuserroles bmur,bmadmin.bmclienttype bmct where bmu.user_role_id = bmur.user_role_id and  bmur.client_type_id = bmct.client_type_id ";
	public static String QUERY_UPDATE_SUBSCRIPTION = "update bmadmin.bmsubscription set "
			+ "product_id = ?,subscription_type_id=?,subscription_sub_type_id =?,subscription_name =?,subscription_period=?, "
			+ "max_clinet_group_allowed=?,max_loan_scheme_allowed=?,data_validity_period=?,price_per_month=?,reminder_before = ? where subscription_id = ?";
	
	public static String QUERY_GET_NEW_DELIGENCE ="select max(dd_seq)+1 from ("
	        + " select max(dd_sequence) dd_seq from bmadmin.bmduediligencedetails_m1 where dd_id = ?"
		    + "	union all"
			+ " select max(dd_sequence) dd_seq from bmadmin.bmduediligencedetails_m2 where dd_id = ?"
			+ " union all"
			+ " select max(dd_sequence) dd_seq from bmadmin.bmduediligencedetails_m3 where dd_id = ?"
			+ " union all"
			+ " select max(dd_sequence) dd_seq from bmadmin.bmduediligencedetails_m4 where dd_id = ?"
			+ " union all"
			+ " select max(dd_sequence) dd_seq from bmadmin.bmduediligencedetails_m5 where dd_id = ?"
			+ ") A";
	
	public static String QUERY_GET_BRANCH_USER_BY_ALL_CRITERIA = "select bmcg.client_group_name,bmcg.client_group_id,"
			+ "bmu.fullname,bmu.employee_id,bmu.username,bmu.userstatus,"
			+ "coalesce(bmu.updated_date,bmu.created_date) updated_date from bmadmin.bmusers bmu,bmadmin.bmuserclientgroup bmucg,"
			+ "bmadmin.bmclientgroup bmcg where bmu.user_id = bmucg.user_id and bmucg.client_group_id = bmcg.client_group_id and bmu.client_id= ?";
	
	public static String QUERY_GET_BRANCH_USER_BY_EACHUSER = "select userstatus,"
			+" (select client_group_id from bmadmin.bmuserclientgroup bmcg where bmcg.user_id =bmu.user_id )client_group_id,"
			+" user_id,user_role_id,employee_id,fullname,email,mobile_number,username,password from bmadmin.bmusers bmu "
			+" where username = ?";
	public static final String QUERY_DELETE_BANK_DTL_BY_CLIENTID = "delete from bmadmin.bmclientgroup  where client_id =? and client_group_id = ?";
	public static final String QUERY_GET_AUDITUSER_BY_ALL_CRITERIA = "select bmct.client_type_id,bmct.client_name,bmu.client_id,"
			+ "bmu.client_name,bmur.user_role_id,bmu.user_id,bmur.user_role_name, bmu.employee_id,bmu.username,"
			+ "bmu.fullname,bmu.mobile_number,bmu.email,bmu.userstatus from bmadmin.bmuserclientgroup bmcg ,"
			+ " bmadmin.bmusers bmu,bmadmin.bmuserroles bmur,bmadmin.bmclienttype bmct "
			+ "where bmu.user_id = bmcg.user_id and bmu.user_role_id = bmur.user_role_id and  bmur.client_type_id = bmct.client_type_id ";
	public static final String GET_ACTIVE_CLIENT_LIST = "select client_id,client_name from bmadmin.bmclient where status = 'COMPLETED' order by client_name";
	
	public static final String GET_CLIENT_TYPE = "select client_type_id from bmadmin.bmclient where client_id=?";
	public static final Integer CLIENT_TYPE_AUDIT_FIRM = 3;
	
	public static final String QUERY_GET_UNITS_BY_ALL_CRITERIA = "Select client_group_id,bcgt.client_group_type_id,bcgt.client_group_type,\r\n"
			+ "			 bcg.client_group_name,bcg.ifsc_code, bcg.city,bcg.status,COALESCE(bcg.updated_by,bcg.created_by) updated_by,\r\n"
			+ "			 COALESCE(bcg.updated_date,bcg.created_date) updated_date \r\n"
			+ "			 from bmadmin.bmclientgroup bcg , bmadmin.bmclientgrouptype bcgt \r\n"
			+ "			 where bcg.client_group_type_id = bcgt.client_group_type_id and   bcg.client_id = ?";
	
	public static final String QUERY_GET_UNIT_TYPES = "Select client_group_type_id,client_group_type_desc from bmadmin.bmclientgrouptype where client_group_type in ('HO','ZO','CPC','Branch')";
	
	public static final String QUERY_GET_EMPLOYEES_BY_ALL_CRITERIA = "select bmcgt.client_group_type,bmcg.client_group_name,bem.ifsc_code,bem.employee_name,"
			+ "bem.employee_id,bem.status,COALESCE(bem.updated_date, bem.created_date) updated_date,COALESCE(bem.updated_by, bem.created_by) updated_by from bmadmin.bmemployeemaster bem,bmadmin.bmclientgroup bmcg,bmadmin.bmclientgrouptype bmcgt"
			+ " where bmcgt.client_group_type_id=bem.client_group_type_id and bmcg.client_group_id=bem.client_group_id ";
	
	public static final String QUERY_GET_E2E_DASHBOARD_TASKS_M1 = "select e2e_no,loan_application_date,loan_application_no,"
			+ "loan_applicant_name,cif_no,e2e_m4_review_date,loan_status,assigned_to,final_status "
			+ " from bmadmin.bmloanapplication where client_id= ? "
			+ "and client_group_id=? and loan_status like '%M1%' and "
			+ "(assigned_to=? or unit_maker = ? or unit_checker = ? or unit_sanction_authority = ?)";
	public static final String QUERY_GET_E2E_DASHBOARD_TASKS_M2 = "select e2e_no,loan_application_date,loan_application_no,"
			+ "loan_applicant_name,cif_no,e2e_m4_review_date,loan_status,assigned_to,final_status "
			+ " from bmadmin.bmloanapplication where client_id= ? "
			+ "and client_group_id=? and loan_status like '%M2%' and "
			+ "(assigned_to=? or unit_maker = ? or unit_checker = ? or unit_sanction_authority = ?)";
	public static final String QUERY_GET_E2E_DASHBOARD_TASKS_M3 = "select e2e_no,loan_application_date,loan_application_no,"
			+ "loan_applicant_name,cif_no,e2e_m4_review_date,loan_status,assigned_to,final_status "
			+ " from bmadmin.bmloanapplication where client_id= ? "
			+ "and client_group_id= ? and loan_status like '%M3%' and "
			+ "(assigned_to=? or unit_maker = ? or unit_checker = ? or unit_sanction_authority = ?)";
	public static final String QUERY_GET_E2E_DASHBOARD_TASKS_M4 = "select e2e_no,loan_application_date,loan_application_no,"
			+ "loan_applicant_name,cif_no,e2e_m4_review_date,loan_status,assigned_to,final_status "
			+ " from bmadmin.bmloanapplication where client_id= ? "
			+ "and client_group_id=? and loan_status like '%M4%' and "
			+ "(assigned_to= ? or unit_maker = ? or unit_checker = ? or unit_sanction_authority = ?)";
	
	public static final String QUERY_GET_E2E_DASHBOARD_TASKS_M5 = "select e2e_no,loan_application_date,loan_application_no,"
			+ "loan_applicant_name,cif_no,e2e_m4_review_date,loan_status,assigned_to,final_status "
			+ " from bmadmin.bmloanapplication where client_id=? "
			+ "and client_group_id=? and loan_status like '%M5%' and "
			+ "(assigned_to=? or unit_maker = ? or unit_checker = ? or unit_sanction_authority = ?)";
	
	public static final String QUERY_GET_BANK_BRANCH_IFSC = "select client_name bank_name, "
			+ "client_group_name branch_name, ifsc_code "
			+ "from bmadmin.bmclient bmc, bmadmin.bmclientgroup bmcg "
			+ "where bmc.client_id = bmcg.client_id	and bmcg.client_group_id = ?";
	
	public static final String QUERY_GET_E2E_REALTIME_BANK_BRANCH_IFSC = "select (select bmcg1.client_group_name branch_name "
			+ "from bmadmin.bmclientgroup bmcg1 where bmcg1.client_group_id = bmcg.zo_client_group_id) Zo_name,"
			+ "(select bmcg1.client_group_name branch_name from bmadmin.bmclientgroup bmcg1 where "
			+ "bmcg1.client_group_id = bmcg.cpc_client_group_id) cpc_name,bmcg.client_group_name branch_name, bmcg.ifsc_code "
			+ "from bmadmin.bmclientgroup bmcg,bmadmin.bmuserclientgroup bmucg,bmadmin.bmusers bmu where bmu.user_id = bmucg.user_id "
			+ " and bmucg.client_group_id = bmcg.client_group_id and bmu.username = ?";
	
	public static final String QUERY_GET_REASSIGN_TASKS_M1 = "select loan_application_date, e2e_no,"
			+ "loan_applicant_name,loan_status,final_status,unit_maker,unit_checker,loan_sanction_authority,"
			+ "initiate_ddp_comments from bmadmin.bmloanapplication where client_id=?  and client_group_id=? "
			+ "and loan_status like '%M1%' and "
			+ "(assigned_to=? or unit_maker =? or unit_checker=? or unit_sanction_authority=?)";

	public static final String QUERY_GET_REASSIGN_TASKS_M2 = "select loan_application_date, e2e_no,"
			+ "loan_applicant_name,loan_status,final_status,unit_maker,unit_checker,loan_sanction_authority,"
			+ "initiate_ddp_comments from bmadmin.bmloanapplication where client_id=?  and client_group_id=? "
			+ "and loan_status like '%M2%' and "
			+ "(assigned_to=? or unit_maker =? or unit_checker=? or unit_sanction_authority=?)";

	public static final String QUERY_GET_REASSIGN_TASKS_M3 = "select loan_application_date, e2e_no,"
			+ "loan_applicant_name,loan_status,final_status,unit_maker,unit_checker,loan_sanction_authority,"
			+ "initiate_ddp_comments from bmadmin.bmloanapplication where client_id=?  and client_group_id=? "
			+ "and loan_status like '%M3%' and "
			+ "(assigned_to=? or unit_maker =? or unit_checker=? or unit_sanction_authority=?)";

	public static final String QUERY_GET_REASSIGN_TASKS_M4 = "select loan_application_date, e2e_no,"
			+ "loan_applicant_name,loan_status,final_status,unit_maker,unit_checker,loan_sanction_authority,"
			+ "initiate_ddp_comments from bmadmin.bmloanapplication where client_id=?  and client_group_id=? "
			+ "and loan_status like '%M4%' and "
			+ "(assigned_to=? or unit_maker =? or unit_checker=? or unit_sanction_authority=?)";

	public static final String QUERY_GET_REASSIGN_TASKS_M5 = "select loan_application_date, e2e_no,"
			+ "loan_applicant_name,loan_status,final_status,unit_maker,unit_checker,loan_sanction_authority,"
			+ "initiate_ddp_comments from bmadmin.bmloanapplication where client_id=?  and client_group_id=? "
			+ "and loan_status like '%M5%' and "
			+ "(assigned_to=? or unit_maker =? or unit_checker=? or unit_sanction_authority=?)";
	public static final String GET_MAKERS_LIST = "select * from bmadmin.bmusers where user_role_id in (1,2,27,28,29) "
			+ "and user_id in (select user_id from bmadmin.bmuserclientgroup "
			+ "where client_group_id = ?) ";
	
	public static final String GET_CHECKERS_LIST = "select * from bmadmin.bmusers where user_role_id in (3,4) and user_id in "
			+ "(select user_id from bmadmin.bmuserclientgroup where client_group_id = ?)";
	
	public static final String GET_SA_LIST = "select * from bmadmin.bmusers where user_role_id in (3,4) and "
			+ "user_id in (select user_id from bmadmin.bmuserclientgroup where client_group_id  in "
			+ "(?,?,?,?))";
	
	public static final String GET_UNITNAME_LIST = "Select  client_group_id, client_group_name from bmadmin.bmclientgroup where client_id = ? ";
	
	public static final String GET_CO_APPLICANT_LIST = "select profession_id,profession_name from bmadmin.bmprofession";
	
	public static final String GET_DUE_DILIGENCE_FOR_E2E = "select  loan_application_id,client_id,client_group_id,module_id start_module,loan_application_no, "
			+ "loan_application_date,cif_flag,cif_no,loan_status,"
			+ "loan_applicant_name,credit_sector_type_id,loan_scheme_id,loan_variant_id,unit_maker,initiate_ddp_comments from bmadmin.bmloanapplication where e2e_no = ?";
	
	public static final String GET_CO_LOANSCHEME_FACILITY_LIST = "select loan_scheme_id,loan_variant_id,client_loan_variant_name from bmadmin.bmclientloanschemevariant "
			+ "where loan_scheme_id = 13 and client_id = ? order by loan_variant_id";
	
	public static final String GET_CO_LOANSCHEME_LIST = "select loan_scheme_id,client_loan_scheme_name from bmadmin.bmclientloanschemename "
			+ "where client_group_id = ? and status='A' "
			+ "and loan_scheme_id in (select loan_scheme_id from bmadmin.bmloanschemesmaster"
			+ " where credit_sector_type_id=?)";
	
	public static final String GET_LOANSCHEME_LIST_FOR_NEW_DUE_DILIGENCE = "select loan_scheme_id,client_loan_scheme_name from bmadmin.bmclientloanschemename where client_id = ? "
			+ " and loan_scheme_id in (select loan_scheme_id from bmadmin.bmloanschemesmaster where credit_sector_type_id = ?)";
	
	
	public static final String GET_CO_LOANVARIANT_LIST = "select loan_variant_id,client_loan_variant_name,loan_scheme_id from bmadmin.bmclientloanschemevariant where loan_scheme_id = ?";
	
	public static final String GET_LOANVARIANT_LIST_FOR_NEW_DUE_DILIGENCE = "select loan_variant_id,"
			+ "client_loan_variant_name,loan_scheme_id from bmadmin.bmclientloanschemevariant where client_id = ?";
	
	public static final String GET_BORROWER_TYPE_LIST = "select borrower_type_id,borrower_type_name from bmadmin.bmborrowertype ";
	
	public static final String GET_ACCOUNT_TYPE_LIST = "select account_type_id,account_type_name from bmadmin.bmaccounttype";
	
	public static final String GET_BORROWER_CATEGORY_LIST = "select profession_id,profession_name from bmadmin.bmprofession";
	
	public static final String GET_MOVABLE_PROPERTY_LIST = "select security_subtype_id,security_sub_type from bmadmin.bmsecuritysubtype order by security_subtype_id";
	
	public static final String GET_AUTO_GENERATED_DATA = "SELECT e2e_no,e2e_date,e2e_m3_expected_start_date,"
			+ "e2e_m4_expected_start_date,e2e_m4_review_date,e2e_m4_review_no,e2e_m5_security_release_number,"
			+ "e2e_m5_date,ifsc_code FROM bmadmin.bmloanapplication bmla where loan_application_no = ?";
	
	public static final String GET_AUDIt_FIRM_MAKER_LIST = "select user_id,username from bmadmin.bmusers where client_id = ? and user_role_id = 16";
	
	public static final String GET_AUDIt_FIRM_CHECKER_LIST = "select user_id,username from bmadmin.bmusers where client_id = ? and user_role_id = 16";
	
	public static final String GET_UNIT_CHECKER_LIST = "select bmu.username, bmu.fullname "
			+ "from bmadmin.bmusers bmu, bmadmin.bmuserclientgroup bmucg , bmadmin.bmclientgroup bmcg "
			+ "where bmu.user_id = bmucg.user_id "
			+ "and bmucg.client_group_id = bmcg.client_group_id "
			+ "and bmcg.client_group_id = ? and bmu.user_role_id in (3,4,6,7,9,10,12,13)";
	
	public static final String GET_COLLATERAL_SECURITY = "select security_id,security_type_id "
			+ "from bmadmin.bmloanapplication where e2e_no = ?";
	
	public static final String GET_MODULE_NAME = "select substr(loan_status,1,2) moduleName from bmadmin.bmloanapplication where loan_application_no = ?";
	
	public static final String GET_DUE_DILIGENCE_HEADER_M1 = "SELECT loan_application_id,header1,header1_desc,header2,"
			+ "header2_desc,header3,header3_desc,header4,header4_desc,min(dd_sequence) dd_sequence,"
			+ "count(applicant_response_matrix_id) Total_response_expected, count(applicant_response) total_response_filled "
			+ "FROM   (SELECT DISTINCT loan_application_id,dd_sequence,applicant_response_matrix_id,"
			+ "applicant_response,bmddm1.header1,"
			+ "(SELECT concat(english_desc, ',', other_desc) FROM   bmadmin.bmheaders"
			+ "  WHERE  header_key = bmddm1.header1) header1_desc,"
			+ "bmddm1.header2,(SELECT concat(english_desc, ',', other_desc)"
			+ "  FROM   bmadmin.bmheaders WHERE  header_key = bmddm1.header2) header2_desc,"
			+ "bmddm1.header3,"
			+ "(SELECT concat(english_desc, ',', other_desc) FROM   bmadmin.bmheaders"
			+ "  WHERE  header_key = bmddm1.header3) header3_desc,bmddm1.header4,"
			+ "(SELECT concat(english_desc, ',', other_desc) FROM   bmadmin.bmheaders"
			+ " WHERE  header_key = bmddm1.header4) header4_desc"
			+ " FROM   bmadmin.bmloanapplicationdd_m1 bmddm1"
			+ "  Where   bmddm1.loan_application_id = (select loan_application_id from "
			+ " bmadmin.bmloanapplication where loan_application_no = ? ) and bmddm1.header1 not in ('NA')) hdr"
			+ "   GROUP  BY loan_application_id,header1,header1_desc,header2,header2_desc,header3,"
			+ "header3_desc,header4,header4_desc  ORDER  BY dd_sequence";
	
	public static final String GET_DUE_DILIGENCE_HEADER_M2 = " SELECT loan_application_id,header1,header1_desc,header2,"
			+ "header2_desc,header3,header3_desc,header4,header4_desc,min(dd_sequence) dd_sequence,"
			+ "count(compliance_response_matrix_id) Total_response_expected, count(compliance_response) total_response_filled "
			+ "FROM   (SELECT DISTINCT loan_application_id,dd_sequence,compliance_response_matrix_id,"
			+ "compliance_response,bmddm1.header1,(SELECT concat(english_desc, ',', other_desc)"
			+ "  FROM   bmadmin.bmheaders WHERE  header_key = bmddm1.header1) header1_desc,"
			+ "bmddm1.header2,(SELECT concat(english_desc, ',', other_desc) FROM   bmadmin.bmheaders"
			+ "  WHERE  header_key = bmddm1.header2) header2_desc,"
			+ "bmddm1.header3,(SELECT concat(english_desc, ',', other_desc)"
			+ "  FROM   bmadmin.bmheaders"
			+ " WHERE  header_key = bmddm1.header3) header3_desc,bmddm1.header4,"
			+ "(SELECT concat(english_desc, ',', other_desc)"
			+ " FROM   bmadmin.bmheaders"
			+ "  WHERE  header_key = bmddm1.header4) header4_desc"
			+ "  FROM   bmadmin.bmloanapplicationdd_m2 bmddm1"
			+ " Where   bmddm1.loan_application_id = (select loan_application_id from "
			+ " bmadmin.bmloanapplication where loan_application_no = ? ) and bmddm1.header1 not in ('NA')) hdr"
			+ "  GROUP  BY loan_application_id,header1,header1_desc,"
			+ "header2,header2_desc,header3,header3_desc,header4,header4_desc ORDER  BY dd_sequence";
	
	public static final String GET_DUE_DILIGENCE_HEADER_M3 = " SELECT loan_application_id,header1,header1_desc,header2,"
			+ "header2_desc,header3,header3_desc,header4,header4_desc,min(dd_sequence) dd_sequence,"
			+ "count(compliance_response_matrix_id) Total_response_expected, count(compliance_response) total_response_filled "
			+ "FROM   (SELECT DISTINCT loan_application_id,dd_sequence,compliance_response_matrix_id,"
			+ "compliance_response,bmddm1.header1,(SELECT concat(english_desc, ',', other_desc)"
			+ "  FROM   bmadmin.bmheaders WHERE  header_key = bmddm1.header1) header1_desc,"
			+ "bmddm1.header2,(SELECT concat(english_desc, ',', other_desc) FROM   bmadmin.bmheaders"
			+ "  WHERE  header_key = bmddm1.header2) header2_desc,"
			+ "bmddm1.header3,(SELECT concat(english_desc, ',', other_desc)"
			+ "  FROM   bmadmin.bmheaders"
			+ " WHERE  header_key = bmddm1.header3) header3_desc,bmddm1.header4,"
			+ "(SELECT concat(english_desc, ',', other_desc)"
			+ " FROM   bmadmin.bmheaders"
			+ "  WHERE  header_key = bmddm1.header4) header4_desc"
			+ "  FROM   bmadmin.bmloanapplicationdd_m3 bmddm1"
			+ " Where   bmddm1.loan_application_id = (select loan_application_id from "
			+ " bmadmin.bmloanapplication where loan_application_no = ? ) and bmddm1.header1 not in ('NA')) hdr "
			+ "  GROUP  BY loan_application_id,header1,header1_desc,"
			+ "header2,header2_desc,header3,header3_desc,header4,header4_desc ORDER  BY dd_sequence";
	
	public static final String GET_DUE_DILIGENCE_HEADER_M4 = " SELECT loan_application_id,header1,header1_desc,header2,"
			+ "header2_desc,header3,header3_desc,header4,header4_desc,min(dd_sequence) dd_sequence,"
			+ "count(compliance_response_matrix_id) Total_response_expected, count(compliance_response) total_response_filled "
			+ "FROM   (SELECT DISTINCT loan_application_id,dd_sequence,compliance_response_matrix_id,"
			+ "compliance_response,bmddm1.header1,(SELECT concat(english_desc, ',', other_desc)"
			+ "  FROM   bmadmin.bmheaders WHERE  header_key = bmddm1.header1) header1_desc,"
			+ "bmddm1.header2,(SELECT concat(english_desc, ',', other_desc) FROM   bmadmin.bmheaders"
			+ "  WHERE  header_key = bmddm1.header2) header2_desc,"
			+ "bmddm1.header3,(SELECT concat(english_desc, ',', other_desc)"
			+ "  FROM   bmadmin.bmheaders"
			+ " WHERE  header_key = bmddm1.header3) header3_desc,bmddm1.header4,"
			+ "(SELECT concat(english_desc, ',', other_desc)"
			+ " FROM   bmadmin.bmheaders"
			+ "  WHERE  header_key = bmddm1.header4) header4_desc"
			+ "  FROM   bmadmin.bmloanapplicationdd_m4 bmddm1"
			+ " Where   bmddm1.loan_application_id = (select loan_application_id from "
			+ " bmadmin.bmloanapplication where loan_application_no = ? ) and bmddm1.header1 not in ('NA')) hdr "
			+ "  GROUP  BY loan_application_id,header1,header1_desc,"
			+ "header2,header2_desc,header3,header3_desc,header4,header4_desc ORDER  BY dd_sequence";
	
	public static final String GET_DUE_DILIGENCE_HEADER_M5 = " SELECT loan_application_id,header1,header1_desc,header2,"
			+ "header2_desc,header3,header3_desc,header4,header4_desc,min(dd_sequence) dd_sequence,"
			+ "count(compliance_response_matrix_id) Total_response_expected, count(compliance_response) total_response_filled "
			+ "FROM   (SELECT DISTINCT loan_application_id,dd_sequence,compliance_response_matrix_id,"
			+ "compliance_response,bmddm1.header1,(SELECT concat(english_desc, ',', other_desc)"
			+ "  FROM   bmadmin.bmheaders WHERE  header_key = bmddm1.header1) header1_desc,"
			+ "bmddm1.header2,(SELECT concat(english_desc, ',', other_desc) FROM   bmadmin.bmheaders"
			+ "  WHERE  header_key = bmddm1.header2) header2_desc,"
			+ "bmddm1.header3,(SELECT concat(english_desc, ',', other_desc)"
			+ "  FROM   bmadmin.bmheaders"
			+ " WHERE  header_key = bmddm1.header3) header3_desc,bmddm1.header4,"
			+ "(SELECT concat(english_desc, ',', other_desc)"
			+ " FROM   bmadmin.bmheaders"
			+ "  WHERE  header_key = bmddm1.header4) header4_desc"
			+ "  FROM   bmadmin.bmloanapplicationdd_m5 bmddm1"
			+ " Where   bmddm1.loan_application_id = (select loan_application_id from "
			+ " bmadmin.bmloanapplication where loan_application_no = ? ) and bmddm1.header1 not in ('NA')) hdr "
			+ "  GROUP  BY loan_application_id,header1,header1_desc,"
			+ "header2,header2_desc,header3,header3_desc,header4,header4_desc ORDER  BY dd_sequence";
	
	public static final String GET_DUE_DILIGENCE_DETAILS_M1 = "SELECT dd_sequence,\r\n"
			+ "       dd_parent_sequence,\r\n"
			+ "       dd_data,\r\n"
			+ "       (select place_holder_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.general_response_matrix_id and ui_valid_value ='Y') schmema_norm_place_holder_values,\r\n"
			+ "    (select ui_valid_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.general_response_matrix_id and db_valid_value = bmladdm1.schema_response ) schmema_norm_ui_valid_value,\r\n"
			+ "    (select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.general_response_matrix_id and db_valid_value = bmladdm1.schema_response ) schmema_norm_color,\r\n"
			+ "    (select place_holder_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.applicant_response_matrix_id and ui_valid_value ='Y') applicant_place_holder_values,\r\n"
			+ "    (select ui_valid_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.applicant_response_matrix_id and db_valid_value = bmladdm1.applicant_response ) applicant_ui_valid_value,\r\n"
			+ "    (select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.applicant_response_matrix_id and db_valid_value = bmladdm1.applicant_response ) applicant_color,\r\n"
			+ "       (select place_holder_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.coapplicant_response_matrix_id and ui_valid_value ='Y' and exists (select 1 from bmadmin.bmloanapplication where loan_application_id=bmladdm1.loan_application_id and co_applicant is not null)) coapplicant_place_holder_values,\r\n"
			+ "    (select ui_valid_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.coapplicant_response_matrix_id and db_valid_value = bmladdm1.coapplicant_response ) coapplicant_ui_valid_value,\r\n"
			+ "    (select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.coapplicant_response_matrix_id and db_valid_value = bmladdm1.coapplicant_response ) coapplicant_color,\r\n"
			+ "       (select place_holder_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.coapplicant_response_matrix_id and ui_valid_value ='Y' and exists (select 1 from bmadmin.bmloanapplication where loan_application_id=bmladdm1.loan_application_id and co_applicant_1 is not null)) coapplicant1_place_holder_values,\r\n"
			+ "    (select ui_valid_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.coapplicant_response_matrix_id and db_valid_value = bmladdm1.coapplicant_response1 ) coapplicant1_ui_valid_value,\r\n"
			+ "    (select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.coapplicant_response_matrix_id and db_valid_value = bmladdm1.coapplicant_response1 ) coapplicant1_color,\r\n"
			+ "       (select place_holder_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.coapplicant_response_matrix_id and ui_valid_value ='Y' and exists (select 1 from bmadmin.bmloanapplication where loan_application_id=bmladdm1.loan_application_id and co_applicant_2 is not null)) coapplicant2_place_holder_values,\r\n"
			+ "    (select ui_valid_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.coapplicant_response_matrix_id and db_valid_value = bmladdm1.coapplicant_response2 ) coapplicant2_ui_valid_value,\r\n"
			+ "    (select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.coapplicant_response_matrix_id and db_valid_value = bmladdm1.coapplicant_response2 ) coapplicant2_color,\r\n"
			+ "       (select place_holder_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.coapplicant_response_matrix_id and ui_valid_value ='Y' and exists (select 1 from bmadmin.bmloanapplication where loan_application_id=bmladdm1.loan_application_id and co_applicant_3 is not null)) coapplicant3_place_holder_values,\r\n"
			+ "    (select ui_valid_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.coapplicant_response_matrix_id and db_valid_value = bmladdm1.coapplicant_response3 ) coapplicant3_ui_valid_value,\r\n"
			+ "    (select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.coapplicant_response_matrix_id and db_valid_value = bmladdm1.coapplicant_response3 ) coapplicant3_color,\r\n"
			+ "       (select place_holder_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.coapplicant_response_matrix_id and ui_valid_value ='Y' and exists (select 1 from bmadmin.bmloanapplication where loan_application_id=bmladdm1.loan_application_id and co_applicant_4 is not null)) coapplicant4_place_holder_values,\r\n"
			+ "    (select ui_valid_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.coapplicant_response_matrix_id and db_valid_value = bmladdm1.coapplicant_response4 ) coapplicant4_ui_valid_value,\r\n"
			+ "    (select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.coapplicant_response_matrix_id and db_valid_value = bmladdm1.coapplicant_response4 ) coapplicant4_color,\r\n"
			+ "       (select place_holder_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.guarantor_response_matrix_id and ui_valid_value ='Y' and exists (select 1 from bmadmin.bmloanapplication where loan_application_id=bmladdm1.loan_application_id and guarantor is not null)) guarantor_place_holder_values,\r\n"
			+ "    (select ui_valid_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.guarantor_response_matrix_id and db_valid_value = bmladdm1.guarantor_response ) guarantor_ui_valid_value,\r\n"
			+ "    (select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.guarantor_response_matrix_id and db_valid_value = bmladdm1.guarantor_response ) guarantor_color,\r\n"
			+ "       (select place_holder_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.guarantor_response_matrix_id and ui_valid_value ='Y' and exists (select 1 from bmadmin.bmloanapplication where loan_application_id=bmladdm1.loan_application_id and guarantor_1 is not null)) guarantor1_place_holder_values,\r\n"
			+ "    (select ui_valid_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.guarantor_response_matrix_id and db_valid_value = bmladdm1.guarantor_response1 ) guarantor1_ui_valid_value,\r\n"
			+ "    (select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.guarantor_response_matrix_id and db_valid_value = bmladdm1.guarantor_response1 ) guarantor1_color,\r\n"
			+ "       (select place_holder_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.guarantor_response_matrix_id and ui_valid_value ='Y' and exists (select 1 from bmadmin.bmloanapplication where loan_application_id=bmladdm1.loan_application_id and guarantor_2 is not null)) guarantor2_place_holder_values,\r\n"
			+ "    (select ui_valid_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.guarantor_response_matrix_id and db_valid_value = bmladdm1.guarantor_response2 ) guarantor2_ui_valid_value,\r\n"
			+ "    (select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.guarantor_response_matrix_id and db_valid_value = bmladdm1.guarantor_response2 ) guarantor2_color,    \r\n"
			+ "       (select place_holder_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.guarantor_response_matrix_id and ui_valid_value ='Y' and exists (select 1 from bmadmin.bmloanapplication where loan_application_id=bmladdm1.loan_application_id and guarantor_3 is not null)) guarantor3_place_holder_values,\r\n"
			+ "    (select ui_valid_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.guarantor_response_matrix_id and db_valid_value = bmladdm1.guarantor_response3 ) guarantor3_ui_valid_value,\r\n"
			+ "    (select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.guarantor_response_matrix_id and db_valid_value = bmladdm1.guarantor_response3 ) guarantor3_color,\r\n"
			+ "       (select place_holder_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.guarantor_response_matrix_id and ui_valid_value ='Y' and exists (select 1 from bmadmin.bmloanapplication where loan_application_id=bmladdm1.loan_application_id and guarantor_4 is not null)) guarantor4_place_holder_values,\r\n"
			+ "    (select ui_valid_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.guarantor_response_matrix_id and db_valid_value = bmladdm1.guarantor_response4 ) guarantor4_ui_valid_value,\r\n"
			+ "    (select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.guarantor_response_matrix_id and db_valid_value = bmladdm1.guarantor_response4 ) guarantor4_color    \r\n"
			+ " FROM bmadmin.bmloanapplicationdd_m1 bmladdm1";
	
	public static final String GET_DUE_DILIGENCE_DETAILS_M2 = "SELECT dd_sequence,dd_parent_sequence,dd_data,"
			+ "(select place_holder_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm2.compliance_response_matrix_id and ui_valid_value ='Y') compliance_place_holder_values,"
			+ "(select ui_valid_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm2.compliance_response_matrix_id and db_valid_value = bmladdm2.compliance_response ) compliance_ui_valid_value,"
			+ "(select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm2.compliance_response_matrix_id and db_valid_value = bmladdm2.compliance_response ) compliance_color"
			+ " FROM bmadmin.bmloanapplicationdd_m2 bmladdm2 ";
	
	public static final String GET_DUE_DILIGENCE_DETAILS_M3 = "SELECT dd_sequence,dd_parent_sequence,dd_data,"
			+ "(select place_holder_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm2.compliance_response_matrix_id and ui_valid_value ='Y') compliance_place_holder_values,"
			+ "(select ui_valid_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm2.compliance_response_matrix_id and db_valid_value = bmladdm2.compliance_response ) compliance_ui_valid_value,"
			+ "(select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm2.compliance_response_matrix_id and db_valid_value = bmladdm2.compliance_response ) compliance_color"
			+ " FROM bmadmin.bmloanapplicationdd_m3 bmladdm2 ";
	
	public static final String GET_DUE_DILIGENCE_DETAILS_M4 = "SELECT dd_sequence,dd_parent_sequence,dd_data,"
			+ "(select place_holder_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm2.compliance_response_matrix_id and ui_valid_value ='Y') compliance_place_holder_values,"
			+ "(select ui_valid_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm2.compliance_response_matrix_id and db_valid_value = bmladdm2.compliance_response ) compliance_ui_valid_value,"
			+ "(select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm2.compliance_response_matrix_id and db_valid_value = bmladdm2.compliance_response ) compliance_color"
			+ " FROM bmadmin.bmloanapplicationdd_m4 bmladdm2 ";
	
	public static final String GET_DUE_DILIGENCE_DETAILS_M5 = "SELECT dd_sequence,dd_parent_sequence,dd_data,"
			+ "(select place_holder_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm2.compliance_response_matrix_id and ui_valid_value ='Y') compliance_place_holder_values,"
			+ "(select ui_valid_value from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm2.compliance_response_matrix_id and db_valid_value = bmladdm2.compliance_response ) compliance_ui_valid_value,"
			+ "(select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm2.compliance_response_matrix_id and db_valid_value = bmladdm2.compliance_response ) compliance_color"
			+ " FROM bmadmin.bmloanapplicationdd_m5 bmladdm2 ";
	
	public static final String GET_MOVEABLE_PROPERTY = "SELECT security_subtype_id, security_sub_type"
			+ " FROM bmadmin.bmsecuritysubtype bmss,bmadmin.bmloanapplicationsstype bmlasst"
			+ " where bmss.security_subtype_id = movable_property_id"
			+ " and bmlasst.loan_application_id = (select loan_application_id from bmadmin.bmloanapplication where e2e_no = ?)";
	
	public static final String GET_DEFAULT_UNIT_CHECKER_LIST = "select unit_maker, unit_checker,unit_sanction_authority,"
			+ " loan_sanction_authority,number_of_reviews_completed from bmadmin.bmloanapplication where e2e_no = ?";
	
	public static final String GET_DUE_DILIGENCE_GENERAL_INFO = "select loan_application_no,cif_flag,cif_no,loan_applicant_name,"
			+ "(select client_loan_scheme_name from bmadmin.bmclientloanschemename bmclsn "
			+ "where bmclsn.loan_scheme_id=bmla.loan_scheme_id and bmclsn.client_id=bmla.client_id) loan_scheme_name,"
			+ "(select client_loan_variant_name from bmadmin.bmclientloanschemevariant bmclsv "
			+ "where bmclsv.loan_variant_id=bmla.loan_variant_id and bmclsv.client_id=bmla.client_id) loan_variant_name,"
			+ "credit_sector_type_id,loan_account_no,loan_sanctioned_date,loan_amount,loan_amount_in_words,"
			+ "loan_tenor,revised_loan_tenor,disbursement_date,m4_current_review_sanction_date,"
			+ "asset_type_id,release_of_security_on_account_closure,date_of_closure_of_loan,account_type_id,"
			+ "borrower_type_id,profession_id from bmadmin.bmloanapplication bmla where e2e_no = ?";
	
	public static final String GET_BRANCHUSER_LIST = "select client_group_id, client_group_name from bmadmin.bmclientgroup where client_id = ?";
	
	public static final String GET_CIF_LIST = "Select cif_number,customer_name from bmadmin.bmcifmaster "
			+ " where client_id = ? order by cif_number";
	
	public static final String GET_BRANCH_MAKER_LIST = "select bmu.username, bmu.fullname from bmadmin.bmusers bmu,"
			+ " bmadmin.bmuserclientgroup bmucg , bmadmin.bmclientgroup bmcg where bmu.user_id = bmucg.user_id "
			+ "and bmucg.client_group_id = bmcg.client_group_id "
			+ "and bmcg.client_group_id = ? and bmu.user_role_id in (1,2,27,28,29)";
	
	public static final String GET_BRANCH_CHECKER_LIST = "select bmu.username, bmu.fullname from bmadmin.bmusers bmu,"
			+ " bmadmin.bmuserclientgroup bmucg , bmadmin.bmclientgroup bmcg "
			+ "where bmu.user_id = bmucg.user_id "
			+ "and bmucg.client_group_id = bmcg.client_group_id "
			+ "and bmcg.client_group_id = ? and bmu.user_role_id in (3,4)";
	
	public static final String GET_BRANCH_SA_LIST = "select bmu.username, bmu.fullname from "
			+ "bmadmin.bmusers bmu, bmadmin.bmuserclientgroup bmucg , bmadmin.bmclientgroup bmcg "
			+ "where bmu.user_id = bmucg.user_id and bmucg.client_group_id = bmcg.client_group_id "
			+ "and bmcg.client_group_id = ? and bmu.user_role_id = 5";
	
	public static final String GET_LOAN_SA_LIST = "select bmu.username, bmu.fullname from bmadmin.bmusers bmu, "
			+ "bmadmin.bmuserclientgroup bmucg , bmadmin.bmclientgroup bmcg "
			+ "where bmu.user_id = bmucg.user_id and bmucg.client_group_id = bmcg.client_group_id "
			+ "and bmcg.client_group_id = ? and bmu.user_role_id = 5 "
			+ "union all "
			+ "select bmu.username, bmu.fullname from bmadmin.bmusers bmu, bmadmin.bmuserclientgroup bmucg , bmadmin.bmclientgroup bmcg "
			+ "where bmu.user_id = bmucg.user_id "
			+ "and bmucg.client_group_id = bmcg.cpc_client_group_id "
			+ "and bmcg.client_group_id = ? and bmu.user_role_id = 8 "
			+ "union all "
			+ "select bmu.username, bmu.fullname from bmadmin.bmusers bmu, bmadmin.bmuserclientgroup bmucg , bmadmin.bmclientgroup bmcg "
			+ "where bmu.user_id = bmucg.user_id  and bmucg.client_group_id = bmcg.zo_client_group_id "
			+ "and bmcg.client_group_id = ? and bmu.user_role_id = 11 "
			+ "union all "
			+ "select bmu.username, bmu.fullname from bmadmin.bmusers bmu, bmadmin.bmuserclientgroup bmucg , bmadmin.bmclientgroup bmcg "
			+ "where bmu.user_id = bmucg.user_id "
			+ "and bmucg.client_group_id = bmcg.ho_client_group_id "
			+ "and bmcg.client_group_id = ? and bmu.user_role_id = 14";
	
	public static final String GET_COMMERCIAL_CREDIT_FACILITIES_LIST = "SELECT loan_application_id, facility_id, loan_account_number, "
			+ "date_of_sanction, sanctioned_limit, sanctioned_limit_in_words, loan_tenor"
			+ " FROM bmadmin.bmloanapplicationccfacility  where loan_application_id = (select loan_application_id from bmadmin.bmloanapplication where e2e_no = ?)"
			+ " order by facility_id";
	
	public static final String GET_CO_APP_LIST = "select co_applicant,co_applicant_1,co_applicant_2,"
			+ "co_applicant_3,co_applicant_4,co_applicant_designation,co_applicant1_designation,"
			+ "co_applicant2_designation,co_applicant3_designation,"
			+ "co_applicant4_designation,guarantor,guarantor_1,guarantor_2,guarantor_3,guarantor_4,"
			+ "security_id,security_type_id from bmadmin.bmloanapplication where e2e_no = ?";
	
	public static final String GET_CO_APP_GURANTOR_LIST = "select guarantor,guarantor_1,guarantor_2,guarantor_3,"
			+ "guarantor_4 from bmadmin.bmloanapplication where e2e_no = ?";
	
	public static final String GET_USERROLE_LIST = "select user_role_id, user_role_name from bmadmin.bmuserroles "
			+ "where client_group_type_id in (select client_group_type_id from bmadmin.bmclientgroup where client_group_id = ?) ";
	
	
	public static final String GET_EMPLOYEE_LIST = "select employee_id,employee_name from bmadmin.bmemployeemaster where employee_id = ?";
	
	public static final String QUERY_GET_E2E_TASKS_M1 = "select loan_application_date,e2e_no,\r\n"
			+ "       (select client_group_name from bmadmin.bmclientgroup where client_group_id =bmla.client_group_id) assigned_to,\r\n"
			+ "	   loan_application_no,\r\n"
			+ "	   loan_applicant_name,(select fullname from bmadmin.bmusers where username=bmla.unit_maker) cif_no,\r\n"
			+ "			 e2e_m4_review_date,loan_status, e2e_m4_review_no, e2e_m5_security_release_number \r\n"
			+ "			  from bmadmin.bmloanapplication bmla \r\n"
			+ "			  where client_id= ? \r\n"
			+ "			 and ( client_group_id in (select client_group_id from bmadmin.bmclientgroup where client_group_id=?)\r\n"
			+ "				  or client_group_id in (select client_group_id from bmadmin.bmclientgroup where cpc_client_group_id=?)\r\n"
			+ "				  or client_group_id in (select client_group_id from bmadmin.bmclientgroup where zo_client_group_id=?)\r\n"
			+ "				  or client_group_id in (select client_group_id from bmadmin.bmclientgroup where ho_client_group_id=?)\r\n"
			+ "				 ) and loan_status like '%M1%'";

	public static final String QUERY_GET_E2E_TASKS_M2 = "select loan_application_date,e2e_no,\r\n"
			+ "       (select client_group_name from bmadmin.bmclientgroup where client_group_id =bmla.client_group_id) assigned_to,\r\n"
			+ "	   loan_application_no,\r\n"
			+ "	   loan_applicant_name,(select fullname from bmadmin.bmusers where username=bmla.unit_maker) cif_no,\r\n"
			+ "			 e2e_m4_review_date,loan_status, e2e_m4_review_no, e2e_m5_security_release_number \r\n"
			+ "			  from bmadmin.bmloanapplication bmla \r\n"
			+ "			  where client_id= ? \r\n"
			+ "			 and ( client_group_id in (select client_group_id from bmadmin.bmclientgroup where client_group_id=?)\r\n"
			+ "				  or client_group_id in (select client_group_id from bmadmin.bmclientgroup where cpc_client_group_id=?)\r\n"
			+ "				  or client_group_id in (select client_group_id from bmadmin.bmclientgroup where zo_client_group_id=?)\r\n"
			+ "				  or client_group_id in (select client_group_id from bmadmin.bmclientgroup where ho_client_group_id=?)\r\n"
			+ "				 ) and loan_status like '%M2%'";

	public static final String QUERY_GET_E2E_TASKS_M3 = "select loan_application_date,e2e_no,\r\n"
			+ "       (select client_group_name from bmadmin.bmclientgroup where client_group_id =bmla.client_group_id) assigned_to,\r\n"
			+ "	   loan_application_no,\r\n"
			+ "	   loan_applicant_name,(select fullname from bmadmin.bmusers where username=bmla.unit_maker) cif_no,\r\n"
			+ "			 e2e_m4_review_date,loan_status, e2e_m4_review_no, e2e_m5_security_release_number \r\n"
			+ "			  from bmadmin.bmloanapplication bmla \r\n"
			+ "			  where client_id= ? \r\n"
			+ "			 and ( client_group_id in (select client_group_id from bmadmin.bmclientgroup where client_group_id=?)\r\n"
			+ "				  or client_group_id in (select client_group_id from bmadmin.bmclientgroup where cpc_client_group_id=?)\r\n"
			+ "				  or client_group_id in (select client_group_id from bmadmin.bmclientgroup where zo_client_group_id=?)\r\n"
			+ "				  or client_group_id in (select client_group_id from bmadmin.bmclientgroup where ho_client_group_id=?)\r\n"
			+ "				 ) and loan_status like '%M3%'";

	public static final String QUERY_GET_E2E_TASKS_M4 = "select loan_application_date,e2e_no,\r\n"
			+ "       (select client_group_name from bmadmin.bmclientgroup where client_group_id =bmla.client_group_id) assigned_to,\r\n"
			+ "	   loan_application_no,\r\n"
			+ "	   loan_applicant_name,(select fullname from bmadmin.bmusers where username=bmla.unit_maker) cif_no,\r\n"
			+ "			 e2e_m4_review_date,loan_status, e2e_m4_review_no, e2e_m5_security_release_number \r\n"
			+ "			  from bmadmin.bmloanapplication bmla \r\n"
			+ "			  where client_id= ? \r\n"
			+ "			 and ( client_group_id in (select client_group_id from bmadmin.bmclientgroup where client_group_id=?)\r\n"
			+ "				  or client_group_id in (select client_group_id from bmadmin.bmclientgroup where cpc_client_group_id=?)\r\n"
			+ "				  or client_group_id in (select client_group_id from bmadmin.bmclientgroup where zo_client_group_id=?)\r\n"
			+ "				  or client_group_id in (select client_group_id from bmadmin.bmclientgroup where ho_client_group_id=?)\r\n"
			+ "				 ) and loan_status like '%M4%'";

	public static final String QUERY_GET_E2E_TASKS_M5 = "select loan_application_date,e2e_no,\r\n"
			+ "       (select client_group_name from bmadmin.bmclientgroup where client_group_id =bmla.client_group_id) assigned_to,\r\n"
			+ "	   loan_application_no,\r\n"
			+ "	   loan_applicant_name,(select fullname from bmadmin.bmusers where username=bmla.unit_maker) cif_no,\r\n"
			+ "			 e2e_m4_review_date,loan_status, e2e_m4_review_no, e2e_m5_security_release_number \r\n"
			+ "			  from bmadmin.bmloanapplication bmla \r\n"
			+ "			  where client_id= ? \r\n"
			+ "			 and ( client_group_id in (select client_group_id from bmadmin.bmclientgroup where client_group_id=?)\r\n"
			+ "				  or client_group_id in (select client_group_id from bmadmin.bmclientgroup where cpc_client_group_id=?)\r\n"
			+ "				  or client_group_id in (select client_group_id from bmadmin.bmclientgroup where zo_client_group_id=?)\r\n"
			+ "				  or client_group_id in (select client_group_id from bmadmin.bmclientgroup where ho_client_group_id=?)\r\n"
			+ "				 ) and loan_status like '%M5%'";

	public static final String QUERY_GET_E2E_DASHBOARD_HEADER_DTLS = "select (select bmcg1.client_group_name branch_name "
			+ "from bmadmin.bmclientgroup bmcg1 where bmcg1.client_group_id = bmcg.zo_client_group_id) Zo_name,"
			+ "(select bmcg1.client_group_name branch_name from bmadmin.bmclientgroup bmcg1 where "
			+ "bmcg1.client_group_id = bmcg.cpc_client_group_id) cpc_name,bmcg.client_group_name branch_name,"
			+ " bmcg.ifsc_code from bmadmin.bmclientgroup bmcg where bmcg.client_group_id = ?";
	public static final String SEARCH_UNITTYPE = "unittypesearch";
	public static final String SEARCH_UNITNAME = "unitnamesearch";
	public static final String SEARCH_IFSCCODE = "ifsccodesearch";
	
	public static final String SEARCH_USERNAME = "userNamesearch";
	public static final String SEARCH_EMPID = "empIdsearch";
	public static final String SEARCH_EMPNAME = "empNamesearch";
	
	public static final String QUERY_GET_CNC_DASHBOARD_TASKS_M1 = "select bmla.loan_application_date,"
			+ "bmcg.client_group_name bank_branch_name,bmcg.ifsc_code,"
			+ " bmla.loan_application_no cnc_no, bmla.loan_applicant_name name_of_the_borrower,"
			+ "bmla.cif_no,bmla.assigned_to,bmla.loan_status,bmla.loan_status "
			+ "from bmadmin.bmloanapplication bmla,"
			+ "bmadmin.bmclientgroup bmcg where bmcg.client_id= ? "
			+ " and bmcg.client_group_id = bmla.client_group_id"
			+ "  and loan_status like '%A1%' and (assigned_to=? or unit_maker = ? or unit_checker = ?)";
	public static final String QUERY_GET_CNC_DASHBOARD_TASKS_M2 = "select bmla.loan_application_date,"
			+ "bmcg.client_group_name bank_branch_name,bmcg.ifsc_code,"
			+ " bmla.loan_application_no cnc_no, bmla.loan_applicant_name name_of_the_borrower,"
			+ "bmla.cif_no,bmla.assigned_to,bmla.loan_status,bmla.loan_status "
			+ "from bmadmin.bmloanapplication bmla,"
			+ "bmadmin.bmclientgroup bmcg where bmcg.client_id= ? "
			+ " and bmcg.client_group_id = bmla.client_group_id"
			+ "  and loan_status like '%A2%' and (assigned_to=? or unit_maker = ? or unit_checker = ?)";
	public static final String QUERY_GET_CNC_DASHBOARD_TASKS_M3 = "select bmla.loan_application_date,"
			+ "bmcg.client_group_name bank_branch_name,bmcg.ifsc_code,"
			+ " bmla.loan_application_no cnc_no, bmla.loan_applicant_name name_of_the_borrower,"
			+ "bmla.cif_no,bmla.assigned_to,bmla.loan_status,bmla.loan_status "
			+ "from bmadmin.bmloanapplication bmla,"
			+ "bmadmin.bmclientgroup bmcg where bmcg.client_id= ? "
			+ " and bmcg.client_group_id = bmla.client_group_id"
			+ "  and loan_status like '%A3%' and (assigned_to=? or unit_maker = ? or unit_checker = ?)";
	public static final String QUERY_GET_CNC_DASHBOARD_TASKS_M4 = "select bmla.loan_application_date,"
			+ "bmcg.client_group_name bank_branch_name,bmcg.ifsc_code,"
			+ " bmla.loan_application_no cnc_no, bmla.loan_applicant_name name_of_the_borrower,"
			+ "bmla.cif_no,bmla.assigned_to,bmla.loan_status,bmla.loan_status "
			+ "from bmadmin.bmloanapplication bmla,"
			+ "bmadmin.bmclientgroup bmcg where bmcg.client_id= ? "
			+ " and bmcg.client_group_id = bmla.client_group_id"
			+ "  and loan_status like '%A4%' and (assigned_to=? or unit_maker = ? or unit_checker = ?)";
	
	public static final String QUERY_GET_CNC_DASHBOARD_TASKS_M5 = "select bmla.loan_application_date,"
			+ "bmcg.client_group_name bank_branch_name,bmcg.ifsc_code,"
			+ " bmla.loan_application_no cnc_no, bmla.loan_applicant_name name_of_the_borrower,"
			+ "bmla.cif_no,bmla.assigned_to,bmla.loan_status,bmla.loan_status "
			+ "from bmadmin.bmloanapplication bmla,"
			+ "bmadmin.bmclientgroup bmcg where bmcg.client_id= ? "
			+ " and bmcg.client_group_id = bmla.client_group_id"
			+ "  and loan_status like '%A5%' and (assigned_to=? or unit_maker = ? or unit_checker = ?)";
	public static final String SERVICE_GET_AUTO_GENERATED_DETAILS = "/auto-generated-details";
	public static final String SERVICE_SAVE_ADMINISTRATIVE_DETAILS = "/administrative-details";
	public static final String SERVICE_GET_UNIT_CHECKER = "/unit-checker";
	public static final String SERVICE_GET_DEFAULT_UNIT_CHECKER = "/default-unit-maker-checker";
	public static final String SERVICE_SAVE_DUE_DILIGENCE_GENERAL_INFO = "/due-diligence-general-info";
	public static final String SERVICE_DUE_DILIGENCE_GENERAL_INFO = "/retieve-due-diligence-general-info";
	public static final String SERVICE_DUE_DILIGENCE_COAPP_GURANTAR_INFO = "/due-diligence-coapp-gurantor";
	public static final String SERVICE_DUE_DILIGENCE_COAPP_COLLATERAN_SECURITY = "/due-diligence-coapp-collateral-security";
	public static final String SERVICE_DUE_DILIGENCE_MOVEABLE_PROP = "/due-diligence-coapp-moveable-prop";
	public static final String SERVICE_DUE_DILIGENCE_CO_APPLICANT = "/due-diligence-co-applicant";
	public static final String SERVICE_VIEW_DUE_DILIGENCE_HEADER = "/view-due-diligence-header";
	public static final String SERVICE_VIEW_DETAILS_FOR_DUE_DILIGENCE_HEADER = "/view-due-diligence-details";
	
	public static final String SERVICE_GET_BRANCH_NAMES = "/branch-names";
	public static final String SERVICE_GET_AUDIT_FIRM_CHECKER = "/audit-firm-checkers";
	public static final String SERVICE_GET_AUDIT_FIRM_MAKER = "/audit-firm-makers";
	public static final String SERVICE_GET_LOAN_SCHEMES = "/loan-schemes";
	public static final String SERVICE_GET_LOAN_VARIANTS = "/loan-variants";
	public static final String SERVICE_GET_ACCOUNT_TYPES = "/account-types";
	public static final String SERVICE_GET_BORROWER_TYPES = "/borrower-types";
	public static final String SERVICE_GET_LOAN_SCHEME_DROP_DOWN_FOR_FACILITIES = "/loan-scheme-facilities";
	public static final String SERVICE_GET_COMMERCIAL_CREDIT_FACILITIES = "/commercial-credit-facilities";
	public static final String SERVICE_GET_CIF = "/cif-details";
	public static final String SERVICE_GET_BRANCH_MAKER = "/branch-maker";
	public static final String SERVICE_GET_BRANCH_CHECKER = "/branch-checker";
	public static final String SERVICE_GET_COAPPLICANT_DESIGNATION = "/co-applicant-designation";
	public static final String SERVICE_GET_BRANCH_SA = "/branch-sa";
	public static final String SERVICE_GET_LOAN_SA = "/loan-sa";
	public static final String SERVICE_GET_BORROWER_CATEGORY = "/borrower-category";
	public static final String SERVICE_GET_MOVABLE_PROPERTIES = "/movable-properties";
	public static final String SERVICE_GET_REPORTING_HEADERS = "/report-headers";
	public static final String SERVICE_GET_REPORTING_ACTIONS = "/report-actions";
	public static final String SERVICE_GET_REPORTING_TABLE_DATA = "/report-table-data";
	public static final String SERVICE_UPDATE_REPORTING_STATUS = "/update-report-status";
	public static final String SERVICE_GET_RISK_TYPE = "/risk-type";
	public static final String SERVICE_GENERATE_REPORT = "/generate-report";
	public static final String SERVICE_DOWNLOAD_REPORT = "/download-report";
	public static final String DIRECTORY_LOCATION= "src"+File.separator+"main"+File.separator+"resources"+File.separator;
	public static final String QUERY_GET_UNIT = "select client_group_id, client_id, client_group_type_id, cpc_client_group_id, client_group_name, "
			+ " address, city, state, pincode, created_date, created_by, status, ifsc_code, zo_client_group_id,"
			+ " ho_client_group_id from bmadmin.bmclientgroup where client_group_id=?";
	
	public static final String QUERY_GET_DOWNLOAD_EMP_ERROR_FAILURE_RECORDS = "select employee_id,employee_name,"
			+ "ifsc_code,mobile_number,client_id,error_desc from bmadmin.bmemployeemasteraudit where client_id=  ?";
	
	public static final String QUERY_GET_REPORT_HEADER = "select loan_applicant_name applicant_name,e2e_no,cif_no,e2e_date,"
			+ "(select client_group_name from bmadmin.bmclientgroup where client_group_id = bmla.client_group_id) "
			+ "unit,created_by username,(select client_loan_scheme_name from bmadmin.bmclientloanschemename "
			+ "where loan_scheme_id=bmla.loan_scheme_id and client_id=bmla.client_id) loan_scheme,"
			+ "(select client_loan_variant_name from bmadmin.bmclientloanschemevariant where loan_variant_id "
			+ "= bmla.loan_variant_id and client_id=bmla.client_id) loan_variant from bmadmin.bmloanapplication bmla where e2e_no = ?";
	
	public static final String QUERY_GET_REPORT_ACTION = "select action_id,action_name from bmadmin.bmloanactions \n"
			+ "where user_role_id in (select user_role_id from bmadmin.bmusers where upper(username)=upper(?))";
	
	public static final String QUERY_GET_REPORT_TABLE_DATA = "SELECT particular_of_response, positive_y_and_n,"
			+ " neutral_risk_positive_response, \n"
			+ "low_risk_lr, medium_risk_mr, high_risk_hr, na, open,\n"
			+ "total_ddaps, total_responded, non_compliance_risk, risk_score\n"
			+ " FROM bmadmin.bmddcompliancereport\n"
			+ " where loan_application_no = (select loan_application_no from bmadmin.bmloanapplication\n"
			+ "	where e2e_no = ?)";
	
	public static final String QUERY_GET_RISK_TYPE_ID = "select risk_type_id from bmadmin.bmclient where client_id=?";
	
	public static final String QUERY_FULL_REPORT_HEADER = "select bmcgt.client_group_type unit_type,\r\n"
			+ "       bmcg.client_group_name unit_name,\r\n"
			+ "    bmla.e2e_no,\r\n"
			+ "    bmla.e2e_date,\r\n"
			+ "    bmla.loan_applicant_name applicant_name,\r\n"
			+ "    bmla.loan_application_date date_of_receipt_of_application,\r\n"
			+ "	bmla.loan_sanctioned_date date_of_sanction, \r\n"
			+ "	bmla.loan_sanction_authority sanctioning_authority,\r\n"
			+ "    bmcst.credit_sector_desc loan_type,\r\n"
			+ "    bmclsn.client_loan_scheme_name loan_scheme\r\n"
			+ "from bmadmin.bmloanapplication bmla, \r\n"
			+ "     bmadmin.bmclientgroup bmcg, \r\n"
			+ "  bmadmin.bmclientgrouptype bmcgt,\r\n"
			+ "  bmadmin.bmcreditsectortype bmcst, \r\n"
			+ "  bmadmin.bmclientloanschemename bmclsn\r\n"
			+ "where bmla.client_group_id = bmcg.client_group_id \r\n"
			+ "  and bmcg.client_group_type_id = bmcgt.client_group_type_id \r\n"
			+ "  and bmla.credit_sector_type_id = bmcst.credit_sector_type_id\r\n"
			+ "  and bmla.loan_scheme_id = bmclsn.loan_scheme_id\r\n"
			+ "  and bmla.client_id = bmclsn.client_id\r\n"
			+ "  and bmla.e2e_no = ?";
	
	public static final String QUERY_FULL_REPORT_LOAN_VARIANT_RETAIL = "select client_loan_variant_name loan_variant_name\r\n"
			+ "from bmadmin.bmloanapplication bmla, \r\n"
			+ "  bmadmin.bmclientloanschemename bmclsn,\r\n"
			+ "  bmadmin.bmclientloanschemevariant bmclsv\r\n"
			+ "where bmla.loan_scheme_id = bmclsn.loan_scheme_id\r\n"
			+ "  and bmla.client_id = bmclsn.client_id\r\n"
			+ "  and bmla.client_id = bmclsv.client_id\r\n"
			+ "  and bmla.loan_variant_id = bmclsv.loan_variant_id\r\n"
			+ "  and bmla.e2e_no = ?";
	
	public static final String QUERY_FULL_REPORT_LOAN_VARIANT_COMMERCIAL = "select bmlvm.loan_variant loan_variant_name\r\n"
			+ "from bmadmin.bmloanapplication bmla,\r\n"
			+ "     bmadmin.bmloanapplicationccfacility bmlaccf,\r\n"
			+ "  bmadmin.bmloanvariantsmaster bmlvm\r\n"
			+ "where bmla.loan_application_id = bmlaccf.loan_application_id\r\n"
			+ "  and bmlaccf.facility_id = bmlvm.loan_variant_id\r\n"
			+ "  and bmla.e2e_no = ?";
	public static final String QUERY_FULL_REPORT_FOOTER = "select (select fullname from bmadmin.bmusers where username = unit_maker ) maker,\r\n"
			+ "       (select fullname from bmadmin.bmusers where username = unit_checker) checker,\r\n"
			+ "    (select fullname from bmadmin.bmusers where username = unit_sanction_authority) branch_manager \r\n"
			+ "  from bmadmin.bmloanapplication \r\n"
			+ "  where e2e_no = ?";
	public static final String QUERY_FULL_REPORT_TABLE_DATA = "SELECT dd_sequence,dd_data,\r\n"
			+ "    (select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.general_response_matrix_id and db_valid_value = bmladdm1.schema_response ) schmema_norm_color,\r\n"
			+ "    (select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.applicant_response_matrix_id and db_valid_value = bmladdm1.applicant_response ) applicant_color,\r\n"
			+ "    (select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.coapplicant_response_matrix_id and db_valid_value = bmladdm1.coapplicant_response ) coapplicant_color,\r\n"
			+ "    (select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.coapplicant_response_matrix_id and db_valid_value = bmladdm1.coapplicant_response1 ) coapplicant1_color,\r\n"
			+ "    (select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.coapplicant_response_matrix_id and db_valid_value = bmladdm1.coapplicant_response2 ) coapplicant2_color,\r\n"
			+ "    (select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.coapplicant_response_matrix_id and db_valid_value = bmladdm1.coapplicant_response3 ) coapplicant3_color,\r\n"
			+ "    (select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.coapplicant_response_matrix_id and db_valid_value = bmladdm1.coapplicant_response4 ) coapplicant4_color,\r\n"
			+ "    (select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.guarantor_response_matrix_id and db_valid_value = bmladdm1.guarantor_response ) guarantor_color,\r\n"
			+ "    (select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.guarantor_response_matrix_id and db_valid_value = bmladdm1.guarantor_response1 ) guarantor1_color,\r\n"
			+ "    (select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.guarantor_response_matrix_id and db_valid_value = bmladdm1.guarantor_response2 ) guarantor2_color,    \r\n"
			+ "    (select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.guarantor_response_matrix_id and db_valid_value = bmladdm1.guarantor_response3 ) guarantor3_color,\r\n"
			+ "    (select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.guarantor_response_matrix_id and db_valid_value = bmladdm1.guarantor_response4 ) guarantor4_color    \r\n"
			+ " FROM bmadmin.bmloanapplicationdd_m1 bmladdm1\r\n"
			+ " where loan_application_id in (select loan_application_id from bmadmin.bmloanapplication where e2e_no= ?) order by dd_sequence";
	public static final String QUERY_FULL_REPORT_TABLE_DATA_M2 = "SELECT dd_sequence,dd_data,\r\n"
			+ "			     (select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.compliance_response_matrix_id and db_valid_value = bmladdm1.compliance_response ) schmema_norm_color,\r\n"
			+ "			     NULL applicant_color,\r\n"
			+ "			     NULL coapplicant_color,\r\n"
			+ "			     NULL coapplicant1_color,\r\n"
			+ "			     NULL coapplicant2_color,\r\n"
			+ "			     NULL coapplicant3_color,\r\n"
			+ "			     NULL coapplicant4_color,\r\n"
			+ "			     NULL guarantor_color,\r\n"
			+ "			     NULL guarantor1_color,\r\n"
			+ "			     NULL guarantor2_color,    \r\n"
			+ "			     NULL guarantor3_color,\r\n"
			+ "			     NULL guarantor4_color    \r\n"
			+ "			  FROM bmadmin.bmloanapplicationdd_m2 bmladdm1\r\n"
			+ "			  where loan_application_id in (select loan_application_id from bmadmin.bmloanapplication where e2e_no= ?) order by dd_sequence";

	public static final String QUERY_FULL_REPORT_TABLE_DATA_M3 = "SELECT dd_sequence,dd_data,\r\n"
			+ "			     (select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.compliance_response_matrix_id and db_valid_value = bmladdm1.compliance_response ) schmema_norm_color,\r\n"
			+ "			     NULL applicant_color,\r\n"
			+ "			     NULL coapplicant_color,\r\n"
			+ "			     NULL coapplicant1_color,\r\n"
			+ "			     NULL coapplicant2_color,\r\n"
			+ "			     NULL coapplicant3_color,\r\n"
			+ "			     NULL coapplicant4_color,\r\n"
			+ "			     NULL guarantor_color,\r\n"
			+ "			     NULL guarantor1_color,\r\n"
			+ "			     NULL guarantor2_color,    \r\n"
			+ "			     NULL guarantor3_color,\r\n"
			+ "			     NULL guarantor4_color    \r\n"
			+ "			  FROM bmadmin.bmloanapplicationdd_m3 bmladdm1\r\n"
			+ "			  where loan_application_id in (select loan_application_id from bmadmin.bmloanapplication where e2e_no= ?) order by dd_sequence";

	public static final String QUERY_FULL_REPORT_TABLE_DATA_M4 = "SELECT dd_sequence,dd_data,\r\n"
			+ "			     (select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.compliance_response_matrix_id and db_valid_value = bmladdm1.compliance_response ) schmema_norm_color,\r\n"
			+ "			     NULL applicant_color,\r\n"
			+ "			     NULL coapplicant_color,\r\n"
			+ "			     NULL coapplicant1_color,\r\n"
			+ "			     NULL coapplicant2_color,\r\n"
			+ "			     NULL coapplicant3_color,\r\n"
			+ "			     NULL coapplicant4_color,\r\n"
			+ "			     NULL guarantor_color,\r\n"
			+ "			     NULL guarantor1_color,\r\n"
			+ "			     NULL guarantor2_color,    \r\n"
			+ "			     NULL guarantor3_color,\r\n"
			+ "			     NULL guarantor4_color    \r\n"
			+ "			  FROM bmadmin.bmloanapplicationdd_m4 bmladdm1\r\n"
			+ "			  where loan_application_id in (select loan_application_id from bmadmin.bmloanapplication where e2e_no= ?) order by dd_sequence";

	public static final String QUERY_FULL_REPORT_TABLE_DATA_M5 = "SELECT dd_sequence,dd_data,\r\n"
			+ "			     (select color from bmadmin.bmddresponsematrix where dd_response_matrix_id = bmladdm1.compliance_response_matrix_id and db_valid_value = bmladdm1.compliance_response ) schmema_norm_color,\r\n"
			+ "			     NULL applicant_color,\r\n"
			+ "			     NULL coapplicant_color,\r\n"
			+ "			     NULL coapplicant1_color,\r\n"
			+ "			     NULL coapplicant2_color,\r\n"
			+ "			     NULL coapplicant3_color,\r\n"
			+ "			     NULL coapplicant4_color,\r\n"
			+ "			     NULL guarantor_color,\r\n"
			+ "			     NULL guarantor1_color,\r\n"
			+ "			     NULL guarantor2_color,    \r\n"
			+ "			     NULL guarantor3_color,\r\n"
			+ "			     NULL guarantor4_color    \r\n"
			+ "			  FROM bmadmin.bmloanapplicationdd_m5 bmladdm1\r\n"
			+ "			  where loan_application_id in (select loan_application_id from bmadmin.bmloanapplication where e2e_no= ?) order by dd_sequence";


}
