package com.dipta.project.domain.project;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Vinay.Kumar1
 *
 */
@Entity
@Table(name = "ALL_EXECUTIONS_STATUS")
public class AllExecutionsStatusDomain {

	
	
	@Getter
	@Setter
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_PRJ_EXEC_STATUS")
	@SequenceGenerator(name="SEQ_PRJ_EXEC_STATUS", sequenceName="SEQ_PRJ_EXEC_STATUS")
	private Long executionId;
	
	

	@Getter
	@Setter
	@Column(name = "PROJECTID")
	private Long projectId;
	
	/*@Getter
	@Setter
	@OneToOne(fetch = FetchType.EAGER)
    @Cascade(value=org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name = "STATUS_ID")
	private StatusDomain statusMaster;*/
	
	@Getter
	@Setter
	@Column(name = "STATUS_ID")
	private Long statusId;
	
	@Getter
	@Setter
	@Column(name = "EXECUTION_DATE")
	private Date lastExecution;
	
	
	
	@Getter
	@Setter
	@Column(name = "COMMENTS")
	private String comments;
	
	
	@Getter
	@Setter
	@Column(name = "DATE_CREATED")
	private Date dateCreated;
	
	
	
	@Getter
	@Setter
	@OneToMany(cascade=javax.persistence.CascadeType.ALL, fetch=FetchType.LAZY,  orphanRemoval = true)
	@JoinColumn(name="EXECUTION_ID")
	private List<GeneratedReportsDomain> generatedReports;
	
	
	@Getter
	@Setter
	@Column(name = "EXECUTION_ID")
	private String executionType;
	
	
	
}
