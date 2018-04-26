package com.dipta.project.domain.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PROJECT_STATS")
public class ProjectMatchStatsDomain {

	
	@Getter
	@Setter
	@Id
	@Column(name = "ID")
//	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_PROJECT_FEEDS")
//	@SequenceGenerator(name="SEQ_PROJECT_FEEDS", sequenceName="SEQ_PROJECT_FEEDS")
	private long id;
	
	
	@Getter
	@Setter
	@Column(name = "PROJECT_ID")
	private long projectId;
	
	
	@Getter
	@Setter
	@Column(name = "FEEDID")
	private long feedId;
	
	
	@Getter
	@Setter
	@Column(name = "ACTIVE_RECORDS")
	private Long activeCount;
	
	@Getter
	@Setter
	@Column(name = "NEW_RECORDS")
	private Long newCount;
	
	@Getter
	@Setter
	@Column(name = "MATG")
	private long perfectMatch;
	
	@Getter
	@Setter
	@Column(name = "MATP")
	private long partialMatch;
	
	
	@Getter
	@Setter
	@Column(name = "MATE")
	private long noMatch;
	
	@Getter
	@Setter
	@Column(name = "CRITICAL_RECORDS")
	private Long criticalBad;
	
	@Getter
	@Setter
	@Column(name = "EXECUTION_TYPE")
	private String executionType;
	
	
	
}