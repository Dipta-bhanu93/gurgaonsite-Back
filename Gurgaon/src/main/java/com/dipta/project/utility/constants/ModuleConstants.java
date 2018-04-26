package com.dipta.project.utility.constants;


/**
 * 
 * @author Saurabh.Agarwal
 *
 */
public enum ModuleConstants {
	USER_MAN(1,"MOD_USERMNT","User Maintenance"),
	USER_MGT(2,"MOD_USERMGT","User Management"),
	PROJ_MANT(3,"MOD_PROJMNT","Project Maintenance"),
	FILE_MGT(4,"MOD_FILEMOD","File Module"),
	WORKFLOW_MGT(5,"MOD_WRKFMGT","WorkFlow Management"),
	REPORT_MGT(6,"MOD_RPRTMOD","Reporting"),
	SUBS_MGT(7,"MOD_SUBSMGT","Subscription Management"),
	TICKET_MGT(8,"MOD_TKTMGT","Ticket Management"),
	ACL_MGT(9,"MOD_ACLMGT","ACL & Role Management"),
	MDV_MGT(10,"MOD_MDVMGT","Data Verification");
	
	private Integer id;
	private String moduleText;
	private String description;
	private ModuleConstants(Integer statusId,String moduleText,String description) {
		this.moduleText=moduleText;
		this.id = statusId;
		this.description=description;
	}
	public String getModuleText() {
		return moduleText;
	}
	public Integer getID(){
		return id;
	}
	public String getDescription(){
		return description;
	}
}