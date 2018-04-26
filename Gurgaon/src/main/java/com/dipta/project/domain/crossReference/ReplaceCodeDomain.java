package com.dipta.project.domain.crossReference;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ashish.Patel
 *
 */
@Entity
@Table(name = "CDI_REPLACE_CODE")
public class ReplaceCodeDomain {

	@Getter                   
	@Setter                   
	@Id
	@Column(name = "ID")
	private long id;
	
	@Getter                   
	@Setter                   
	@Column(name = "RULE_ID")
	private long ruleId;
	
	@Getter                   
	@Setter                   
	@Column(name = "REPLACE_SUBCODE_ID")
	private long replaceSubcodeId;
	
	@Getter
	@Setter
	@Column(name = "MASTER_TBL_NAME")
	private String masterTblName;
	
	@Getter
	@Setter
	@Column(name = "MASTER_JOIN_COL_NAME")
	private String masterJoinColName;
	
	@Getter
	@Setter
	@Column(name = "MASTER_CODE_COL_NAME")
	private String masterCodeColName;
	
	@Getter
	@Setter
	@Column(name = "REMARKS")
	private String remarks;
	
	@Getter
	@Setter
	@Column(name = "USERCREATED")
	private String userIdCreated;
	
	@Getter                   
	@Setter                   
	@Column(name = "DATECREATED")
	private Timestamp dateCreated;  
	
	@Getter                   
	@Setter                   
	@Column(name = "USERMODIFIED")
	private String userIdModified;  
	
	@Getter                   
	@Setter                   
	@Column(name = "DATEMODIFIED")
	private Timestamp dateModified;
	
	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "REPLACE_CATEGORY_ID", nullable=false)
	private ReplaceCategoryDomain replaceCategory = new ReplaceCategoryDomain();
}
