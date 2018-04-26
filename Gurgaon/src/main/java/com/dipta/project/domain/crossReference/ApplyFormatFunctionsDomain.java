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
@Table(name = "CDI_APPLY_FORMAT_FUNCTIONS")
public class ApplyFormatFunctionsDomain {

	@Getter                   
	@Setter                   
	@Id
	@Column(name = "ID")
	private long id;
	
	@Getter                   
	@Setter                   
	@Column(name = "FUNC_ORDER")
	private long funcOrder;
	
	@Getter                   
	@Setter                   
	@Column(name = "RULE_SUB_ID")
	private long ruleSubId;
	
	@Getter                   
	@Setter                   
	@Column(name = "RULE_ID")
	private long ruleId;
	
	@Getter                   
	@Setter                   
	@Column(name = "PARAMETER_ID")
	private long parameterId;
	
	@Getter
	@Setter
	@Column(name = "PARAMETER_VALUE")
	private String parameterValue;
	
	@Getter
	@Setter
	@Column(name = "CONDITION_OPERATOR")
	private String conditionOperator;
	
	@Getter
	@Setter
	@Column(name = "FILTER_CONDITION")
	private String filterCondition;
	
	@Getter
	@Setter
	@Column(name = "FUNCTION_NAME")
	private String functionName;
	
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