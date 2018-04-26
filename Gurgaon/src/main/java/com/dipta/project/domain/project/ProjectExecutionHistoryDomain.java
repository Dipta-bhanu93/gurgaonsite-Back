package com.dipta.project.domain.project;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author saurabh.agarwal
 *
 */
@Entity
@Table(name = "USER_PROJECT_EXECUTION_HISTORY")
public class ProjectExecutionHistoryDomain {
	
	@Getter
	@Setter
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="PR_EXECUTION_HSTRY_SEQ")
	@SequenceGenerator(name="PR_EXECUTION_HSTRY_SEQ", sequenceName="PR_EXECUTION_HSTRY_SEQ")
	private Long seqId;
	
	@Getter
	@Setter
	@Column(name = "PROJECTID")
	private Long projectId;
	
	@Getter
	@Setter
	@Column(name = "ONETIME")
	private String oneTime;
	
	@Getter
	@Setter
	@Column(name = "PERIODICALLY")
	private String periodically;

	
	@Getter
	@Setter
	@Column(name = "ONDAY")
	private Integer onDay;
	
	@Getter
	@Setter
	@Column(name = "STATUS")
	private Integer statusId;
	
	@Getter
	@Setter
	@Column(name = "COMMENTS")
	private String comments;
	
	@Getter
	@Setter
	@Column(name = "DATECREATED")
	private Timestamp dateCreated;
	
	@Getter
	@Setter
	@Column(name = "LASTEXECUTION")
	private Timestamp lastExecution;
	
	@Getter
	@Setter
	@Column(name = "LASTEXECUTIONSTATUS")
	private Integer lastStatus;
	
	@Getter
	@Setter
	@Column(name = "NEXTEXECUTION")
	private Date nextExecution;
	
	@Getter
	@Setter
	@Column(name = "RESULT_PUBLISHED")
	private String resultPublished;

	@Getter
	@Setter
	@Column(name = "FEED_ID")
	private String feedId;
	
	
	@Getter
	@Setter
	@Column(name = "FEED_COUNTER")
	private String feedCounter;
	
	/*@Getter
	@Setter
	@Column(name = "USEREXECUTED")
	private String userExecuted;*/
}