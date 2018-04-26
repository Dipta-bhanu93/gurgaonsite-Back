package com.dipta.project.utility.constants;


public class 
CommonConstants {
	
	public static final String Y = "Y";
	public static final String N = "N";
	public static final String E = "E";
	public static final String YES = "Yes";
	public static final String NO = "Yo";
	public static final String BLANK_STRING = "";
	public static final String ALL = "All";
	public static final String COMMA = ",";
	//WorkFlow related constant
	public static final String SERIAL_NO = "SerialNo";
	public static final String ADDED_TIME= "AddedTime";
	public static final String ID = "ID";
	public static final String CLIENT_SERIAL_NO = "ClientSerialNo";
	public static final String NAME = "Name";
	public static final String COUNTRY = "Country";
	public static final String LEGALNAME = "LegalName";
	public static final String DOMICILECOUNTRY = "DomicileCountry";
	public static final String STATUS = "Status";
	public static final String ASSIGNUSER = "AssignUser";
	public static final String ACTION = "Action";
	public static final String TICKET_ID = "TicketID";
	public static final String PROJECT_NAME = "ProjectName";
	
	public static final String WF_NEW_FREE = "New";
	public static final String WF_ASSIGNED = "Assigned";
	public static final String WF_COMPLETED = "Completed";
	public static final String WF_IN_PROGRESS = "In Progress";
	public static final String NULL_STR = "null";
	public static final String[] DASHBOARD_SECTORSUMMARYSTATS_NAME_ARRAY={"Gold","CDi"};
	public static final String[] GOLD_DATACOMLETNESSSTATS_NAME_ARRAY={"Perfect Match Records","Attribute Coverage"};
	
	public static final String WF_GRID_HASH = "workFlow.gridCol.hash";
	public static final String WF_GRID_LAST_UPDATED = "workFlow.gridCol.LastUpdated";
	public static final String WF_GRID_ID = "workFlow.gridCol.Id";
	public static final String WF_GRID_SERIAL_NO = "workFlow.gridCol.Serialno";
	public static final String WF_GRID_NAME = "workFlow.gridCol.Name";
	public static final String WF_GRID_COUNTRY = "workFlow.gridCol.Country";
	public static final String WF_GRID_LEGALNAME = "workFlow.gridCol.Legalname";
	public static final String WF_GRID_DOMICILE_COUNTRY = "workFlow.gridCol.Domicilecountry";
	public static final String WF_GRID_STATUS = "workFlow.gridCol.Status";
	public static final String WF_GRID_ALLOCATED_LASTWORKED = "workFlow.gridCol.Allocated/LastWorked";
	public static final String WF_GRID_EDIT_APPROVE = "workFlow.gridCol.Edit/Approve";
	public static final String WF_TKT_BATCH_ID = "workFlow.gridCol.TicketOrBatchId";
	public static final String WF_GRID_PROJECT_NAME = "workFlow.gridCol.ProjectName";
	public static final String WF_GRID_WF_NAME = "workFlow.gridCol.WFName"; 
	public static final String WF_GRID_WF_LEVEl = "workFlow.gridCol.WFLevel";
	public static final String WF_GRID_WF_STATUS = "workFlow.gridCol.WFStatus";
	public static final String WF_GRID_WF_DATECREATED = "workFlow.gridCol.DateCreated";
	public static final String WF_ID = "WorkFlowId";
	public static final String WF_NAME = "WorkFlowName";
	public static final String WF_LEVEL = "WorkFlowLevel";
	public static final String WF_STATUS = "WorkFlowStatus";
	public static final String WF_DATE_CREATED = "DateCreated";
	
	public static final String WF_TICKET_SUCCESS = "SUCCESS";
	public static final String WF_TICKET_FAIL = "FAIL";
	public static final String WF_TICKET_NO_DATA_AVAILABLE = "NO_DATA_AVAILABLE";
	public static final String WF_BYPASS_SUCCESS = "SUCCESS";
	public static final String WF_BYPASS_FAIL = "FAIL";
	public static final String ADD_USER_WORKFLOW_SUCCESS = "SUCCESS";
	public static final String ADD_USER_WORKFLOW_FAIL = "FAIL";
	
			
	
	//ProjectDetailsRelated Constant
	public static final String PARTYTYPE = "Partytype";
	public static final String DONUTCHARTKEY = "DONUTCHARTKEY";
	public static final String TEMPLATENAME = "TemplateName";
	public static final String USERPROJECTCOUNT = "UserProjectCount";
	public static final String LATESTEXECUTIONDATE = "LatestExecutionDate";
	public static final String EXECUTEDPROJECTSCOUNT = "ExecutedProjectsCount";
	public static final String TOTALPROJECTSCOUNT = "TotalProjectsCount";
	public static final String TOTALCOUNT = "TotalCount";
	public static final String MATCHCOUNT = "MatchCount";
	public static final String POTENTIALMATCHCOUNT = "PotentialMatchCount";
	public static final String NOMATCHCOUNT = "NoMatchCount";
	public static final String EXCEPTIONSCOUNT = "ExceptionsCount";
	
	public static final String PRJ_DTL_TEMPLATE = "projectDetail.gridCol.Template";
	public static final String PRJ_DTL_USER_PROJECT_COUNT = "projectDetail.gridCol.UserProjectCount";
	public static final String PRJ_DTL_LATESTE_XECUTION_DATE = "projectDetail.gridCol.LatestExecutionDate";
	public static final String PRJ_DTL_EXE_PROJECT = "projectDetail.gridCol.ExecutedProject";
	public static final String PRJ_DTL_TOTAL_PROJECT = "projectDetail.gridCol.TotalProjects";
	public static final String PRJ_DTL_TOTAL_RECORD = "projectDetail.gridCol.TotalRecords";
	public static final String PRJ_DTL_PERFECT_MATCH = "projectDetail.gridCol.PerfectMatches";
	public static final String PRJ_DTL_POTENTIAL_MATCH = "projectDetail.gridCol.PotentialMatches";
	public static final String PRJ_DTL_NO_MATCH = "projectDetail.gridCol.NoMatches";
	public static final String PRJ_DTL_EXCEPTION = "projectDetail.gridCol.Exception";
	
	
	//ACL Related
	public   final static String MOD_TKTMGT_8 = "MOD_TKTMGT_8";

	public static final String FILE_PREFIX_XREF="Output_Data_CrossRef_";
	public static final String FILE_PREFIX_REFDATA="Output_RefData_Enrich_";
	public static final String FILE_PREFIX_INSTISS="Output_InstIss_Mapping_";
	public static final String FILE_PREFIX_HIRDATA="Output_Hierarchy_Enrich__";
	
	public static final String FILE_PREFIX_CHY_ENRICH="Output_Hierarchy_Enrich_";
	public static final String FILE_PREFIX_CHY_BUILD="Output_Hierarchy_Build_";
	
	//Template related
	
	public static final long REFERENCE_DATA_ENRICHMENT_ID = 1;
	public static final long INSTRUMENTS_ISSUER_MAPPING = 2;
	public static final long DATA_CROSS_REFERENCING = 3;
	public static final long CLIENT_HIERARCHY = 4;
	public static final long CREDIT_RATINGS = 5;
	public static final long ENRICH = 6;
	public static final long BUILD = 7;
	
	//ReplaceCategory Related
	
	public static final long SPECIAL_CHARACTERS = 1;
	public static final long SPELLING_CORRECTION = 2;
	public static final long REPLACE_WORD_PHRASE = 3;
	public static final long IGNORE_WORD_PHRASE = 4;
	public static final long LEGAL_STRUCTURE = 5;
	public static final long RESERVED_KEYWORDS = 6; 
	public static final long BUILT_IN_FUNCTIONS = 7;
	public static final long COUNTRY_CODE = 8;
	public static final long GENERAL_RULE = 9;
	
	//PROJECT_CONFIGURATION_XREF Related Type Constant
	
	public static final String MATCH_STAT = "MATCH_STAT";
	public static final String FILE_FORMAT = "FILE_FORMAT";
	public static final String EMAIL_ME = "EMAIL_ME";
	public static final String MAPPED_COL = "MAPPED_COL";
	
	public static final String FILE_FORMAT_AND_EMAIL = "FILE_FORMAT_AND_EMAIL";
	public static final String MAPPINGS_COMPLETED = "MAPPINGS_COMPLETED";
	public static final String MAPPINGS_IN_COMPLETED = "MAPPINGS_IN_COMPLETED";
	
	public static final String MATCH_CONFIG_NOT_SAVED = "Project matching configuration is not saved";
	public static final String ATTRIB_CONFIG_NOT_SAVED = "Project attributes configuration is not saved";
	
	public static final String STAGECOL_IDENTIFIER = "IDENTIFIER";
	public static final String STAGECOL_ATTRIBUTE_VALUE = "ATTRIBUTE VALUE";
	
	public static final String FEEDTYPE_CUSTOMER = "customer";
	public static final String NORMALIZED_LEGALNAME = "NORMALIZED_LEGALNAME";
	
	public static final String No_XREF_DATA = "No data to Cross Reference!";
	
	public static final long DEFAULT_PROJECT_ID = 100;
	
	public static final String CUSTOMER_ENRICHMENT_FEED = "1ENR";
	public static final String SECURITY_MAP_FEED = "2SEC";
	public static final String[] HIE_PRO_FEED = {"4HIE","6HIE","7HIE"};
	
	
	
	
	public static final int  CLIENT_HRCY_TEMPLATE = 4;
	public static final Long[]  CLIENT_HRCY_SUBTEMPLATES = new Long[]{(long)6,(long) 7};
	
	public static final String LEGAL_REFTYPE = "Enriched Entities Legal";
	public static final String POTEN_REFTYPE = "Manual Review Required";
	public static final String NOMATCH_REFTYPE = "Not Enriched";
	public static final String BUSINESS_REFTYPE = "Enriched Entities Business";
	
	
	public static final int ADD_TO_GOLD_EXECN = 2;
	public static final String API_REQUEST_STATUS = "START";
	
	public static final String SOURCE_COUNTERPARTY = "COUNTERPARTY";
	public static final String SOURCE_SECURITY = "SECURITY";
	public static final String SOURCE_XREF = "XREF";

	
	public static final String CD_ID = "ID";
	public static final String CD_DATECREATED = "DATECREATED";
	public static final String CD_ID_SEQ = "SEQ_ENTITYID.NEXTVAL";
	public static final String CD_SYS_DATE = "SYSDATE";
	
	public static final Integer UPLOAD_PERCENT_VALIDATION = 25;
	public static final Integer UPLOAD_PERCENT_CTL = 50;
	public static final Integer UPLOAD_PERCENT_LOAD = 75;
	public static final Integer UPLOAD_PERCENT_STAGE_IDS = 90;
	
	public static final int BUFFER_SIZE_1024 = 1024;
	public static final int ROW_CACHE_SIZE_100 = 100;
	
	public static final String X_REFERENCETYPE = "x.REFERENCETYPE,";
	
	public static final String LEGAL_REFTYPE_ = "legal";
	public static final String BUSINESS_REFTYPE_ = "business";
	
	public static String BUILD_HIERARCHY_COLUMN = "select SERIAL_NO,ID,ID_LEGALNAME,ID_COUNTRY,level1 from ( ";
	public static String BUILD_HIERARCHY_COLUMN_CONDITION = " ) where user_flag='Y' or IDREFERENCE=-1 ";
	public static String BUILD_HIERARCHY_COLUMN_WITHOUT_SERIAL_NO = "select ID,ID_LEGALNAME,ID_COUNTRY,level1 from ( ";
	
	

}
