package com.dipta.project.utility.constants;

/**
 * 
 * @author Saurabh.Agarwal
 *
 */
public enum StatusConstants {
	ACTIVE(1,"ACTIVE"),
	PENDING(2,"PENDING"),
	ACTIVATIONPENDING(3,"ACTIVATIONPENDING"),
	CHANGEPASSWORDPENDING(55,"CHANGEPASSWORDPENDING"),
	SUSPENDED(4,"SUSPENDED"),
	DELETED(5,"DELETED"),
	INACTIVE(6,"INACTIVE"),
	NEW(7,"NEW"),
	FORGETPASSWORD(8,"FORGERPASSWORD"), 
	
	FAILED(9,"FAILED"), 
	PROCESSING(10,"PROCESSING"), 
	SCHEDULED(11,"SCHEDULED"),
	COMPLETED(12,"COMPLETED"),
	
	IDCOMPLETE(13,"IDCOMPLETE"),
	NORMALIZATIONCOMPLETED(14,"NORMALIZATIONCOMPLETED"),
	MATCHINGCOMPLETE(15,"MATCHINGCOMPLETE"),
	
	FEEDSKIPPED(53,"FEEDSKIPPED"),
	REPORTINGSTARTED(54,"REPORTINGSTARTED"),
	
	REPORTINGCOMPLETED(16,"REPORTINGCOMPLETED"),
	
	
	
	
	
	EXECUTIONREPORTCOMPLETE(17, "EXECUTIONREPORTCOMPLETE"),
	
	OPEN(21,"OPEN", "Open"),
	INPROGRESS(22,"INPROGRESS"),
	ON_HOLD(23,"ON_HOLD", "On Hold"),
	RESOLVED(24,"RESOLVED"),
	ESCALATE(25,"ESCALATE", "Escalate"),
	ALL(100,"ALL", "All"),
	REC_ALLOCATED(18,"REC_ALLOCATED"),
	REC_LOCKED(19,"REC_LOCKED"),
	REC_APPROVED(27,"REC_APPROVED"),
	REC_REJECTED(28,"REC_REJECTED"),
	TICKET_NEW(26,"NEW"),
	UNASSIGNED(29,"UNASSIGNED"),
	
	
	//* Cross Ref ********
	IDLE(30,"IDLE","Re-usable in any project"),
	LOCKED(31,"LOCKED","Locked and in use by project"),
	
	XREF_NO_FEED_ADDED(32 , "NO_FEED_ADDED" , "No feed added in the project"),
	XREF_FILE_UPLOADED(33 , "FILE_UPLOADED" , "Mapping file uploaded"),
	XREF_MAPPINGS_COMPLETED(34 , "MAPPINGS_COMPLETED" , "All feeds mappings saved"),
	XREF_TRANSF_SAVED(35 , "TRANSF_SAVED" , "Transformation saved"),
	XREF_INITDIAG_SAVED(36 , "INITDIAG_SAVED" , "Initial-Diagnostic saved"),
	XREF_MATCHING_SAVED(37 , "MATCHING_SAVED" , "Matching Saved"),
	XREF_FEED_SETUP_COMPLETE(38 , "FEED_SETUP_COMPLETE" , "Project matching configuration saved"),
	XREF_MATCH_CONFIG_SAVED(39 , "MATCH_CONFIG_SAVED" , "Project matching configuration saved"),
	XREF_ATTRIB_CONFIG_SAVED(40 , "ATTRIB_CONFIG_SAVED" , "Project attributes configuration saved"),
	
		
	//**********************
		
	UPLS(41,"UPLS","Upload successful"),
	UPLF(42,"UPLF","Upload failed"),
	PSLS(43,"PSLS","Prestage load successful"),
	PSLF(44,"PSLF","Prestage load failed"),
	PSTS(45,"PSTS","Prestage transformation successful"),
	PSTF(46,"PSTF","Prestage transformation failed"),
	STLS(47,"STLS","Stage load successful"),
	STLF(48,"STLF","Stage load failed"),
	AUTMS(51 , "AUTMS" , "Gold load successful"),
	AUTME(52 , "AUTME" , "Gold load failed"),
	;
	
	private Integer id;
	private String status;
	private String statusDesc;
	
	private StatusConstants(Integer statusId,String status) {
		this.status=status;
		this.id = statusId;
	}
	
	private StatusConstants(Integer statusId,String status,String statusDesc) {
		this.status=status;
		this.id = statusId;
		this.statusDesc = statusDesc;
	}
	public String getStatus() {
		return status;
	}
	public Integer getID(){
		return id;
	}
	public String getStatusDesc() {
		return statusDesc;
	}
	
}
