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
@Table(name = "CDI_TRANS_RULES")
public class TransRulesDomain {

	@Getter
	@Setter
	@Id
	@Column(name = "RULE_ID")
	private String ruleId;
	
	@Getter
	@Setter
	@Column(name = "RULE_DESC")
	private String ruleDesc;
	
	@Getter
	@Setter
	@Column(name = "RULE_TABLE_NAME")
	private String ruleTableName;
	
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
