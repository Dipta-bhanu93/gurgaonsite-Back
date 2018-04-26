package com.dipta.project.domain.project;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Ashish.Patel
 * 
 */

@Entity
@Table(name = "STATS_GOLD_TEMPLATE")
public class StatsGoldTemplateDomain {
	
	@Getter
	@Setter
	@Id
	@Column(name = "ID")
	private long id;
	
	@Getter
	@Setter
	@OneToOne
	@JoinColumn(name="TEMPLATE_ID") 
	private ProjectTemplateMasterDomain projectTemplateMasterDomain;

	@Getter
	@Setter
	@Column(name="LATEST_EXECUTION_DATE")
	private Timestamp latestExecutionDate;
	
	@Getter
	@Setter
	@Column(name = "EXECUTED_PROJECTS")
	private Long executedProjectsCount;
	
	
	@Getter
	@Setter
	@Column(name = "TOTAL_PROJECTS")
	private Long totalProjectsCount;
	
	
	@Getter
	@Setter
	@Column(name = "TOTAL_RECORDS")
	private Long totalCount;
	
	@Getter
	@Setter
	@Column(name = "MATCH")
	private Long matchCount;
	
	@Getter
	@Setter
	@Column(name = "POTENTIAL_MATCH")
	private Long potentialMatchCount;
	
	@Getter
	@Setter
	@Column(name = "NO_MATCH")
	private Long noMatchCount;
	
	@Getter
	@Setter
	@Column(name = "EXCEPTIONS")
	private Long exceptionsCount;
	
	
	@Getter
	@Setter
	@Column(name = "ACTIVE_RECORDS")
	private Long activeCount;
	
	@Getter
	@Setter
	@Column(name = "NEW_RECORDS")
	private Long newCount;
	
	

}
