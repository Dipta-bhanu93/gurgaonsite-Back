package com.dipta.project.domain.crossReference;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Ashish.Patel
 *
 */
@Entity
@Table(name = "CDI_REPLACE_CATEGORY")
public class ReplaceCategoryDomain {
	
	@Getter
	@Setter
	@Id
	@Column(name = "REPLACE_CATEGORY_ID")
	private long replaceCategoryId;
	
	@Getter
	@Setter
	@Column(name = "ORDER_OF_EXECUTION")
	private long orderOfExecution;
	
	@Getter
	@Setter
	@Column(name = "REPLACE_CATEGORY_DESC")
	private String replaceCategoryDesc;
	
	@Getter
	@Setter
	@Column(name = "REMARKS")
	private String remarks;
	
	@Getter
	@Setter
	@Column(name = "CATEGORY_RULE_STATUS")
	private String categoryRuleStatus;
	
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
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "replaceCategory")
	private Set<TransRulesDomain> TransRulesDomainSet = new HashSet<TransRulesDomain>();
	
	@Getter
	@Setter
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "replaceCategory")
	private Set<ReplaceCodeDomain> replaceCodeDomainSet = new HashSet<ReplaceCodeDomain>();
	
	@Getter
	@Setter
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "replaceCategory")
	private Set<ApplyFormatFunctionsDomain> applyFormatFunctionDomainSet = new HashSet<ApplyFormatFunctionsDomain>();
	
	@Getter
	@Setter
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "replaceCategory")
	private Set<ReplaceRuleDomain> replaceRuleDomainSet = new HashSet<ReplaceRuleDomain>();

}
