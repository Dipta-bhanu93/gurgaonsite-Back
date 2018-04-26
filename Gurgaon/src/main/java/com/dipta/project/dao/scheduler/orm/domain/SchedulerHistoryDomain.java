package com.dipta.project.dao.scheduler.orm.domain;

import java.sql.Timestamp;

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
@Table(name = "SCHEDULER_HISTORY")
public class SchedulerHistoryDomain {
	
	@Getter
	@Setter
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_SCHEDULER_HISTORYID")
	@SequenceGenerator(name="SEQ_SCHEDULER_HISTORYID", sequenceName="SEQ_SCHEDULER_HISTORYID")
	private Long seqId;
	
	@Getter
	@Setter
	@Column(name = "JOBID")
	private String jobId;
	
	@Getter
	@Setter
	@Column(name = "JOBDATA")
	private String jobData;
	
	@Getter
	@Setter
	@Column(name = "JOBDATACATEGORY")
	private String category;
	
	@Getter
	@Setter
	@Column(name = "EXECUTION")
	private Timestamp executionDate;
	
	@Getter
	@Setter
	@Column(name = "STATUS")
	private Integer statusId;
	
	@Getter
	@Setter
	@Column(name = "LASTUPDATED")
	private Timestamp lastUpdated;
	
	@Getter
	@Setter
	@Column(name = "JOBCATEGORY")
	private String jobCategory;
	
	
	
	@Getter
	@Setter
	@Column(name = "USEREMAIL")
	private String userEmail;
	
	
	@Getter
	@Setter
	@Column(name = "REPEATFREQUENCY")
	private Integer repeatFrequency;
	
	@Getter
	@Setter
	@Column(name = "REINITIATEONSERVERSTARTUP")
	private String reInitiateOnServerStartup;
}