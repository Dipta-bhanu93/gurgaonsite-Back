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
@Table(name = "CDI_REPLACE_RULE")
public class ReplaceRuleDomain {
	
	@Getter
	@Setter
	@Id
	@Column(name = "RULE_ID")
	private String ruleId;
	
	@Getter
	@Setter
	@Column(name = "REPLACE_TEXT")
	private String replaceText;
	
	@Getter
	@Setter
	@Column(name = "REPLACE_TEXT_WITH")
	private String replaceTextWith;
	
	@Getter
	@Setter
	@Column(name = "REPLACE_POSITION")
	private String replacePosition;
	
	@Getter
	@Setter
	@Column(name = "REMARKS")
	private String remarks;
	
	@Getter
	@Setter
	@Column(name = "REPLACE_TEXT_ASCI_FLAG")
	private String replaceTextAsciFlag;
	
	@Getter
	@Setter
	@Column(name = "REPLACE_TEXT_WITH_ASCI_FLAG")
	private String replaceTextWithAsciFlag;
	
	@Getter
	@Setter
	@Column(name = "RULE_STATUS")
	private String ruleStatus;
	
	@Getter
	@Setter
	@Column(name = "RULE_TYPE")
	private String ruleType;
	
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