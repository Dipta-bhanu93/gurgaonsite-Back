package com.dipta.project.domain.project;

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
 * @author Saurabh Agarwal
 *
 */
@Entity
@Table(name = "project_preexecution_files")
public class ProjectPreExecutionFilesDomain {
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_PROJECT_PREEXECUTIONID")
	@SequenceGenerator(name="SEQ_PROJECT_PREEXECUTIONID", sequenceName="SEQ_PROJECT_PREEXECUTIONID")
	@Column(name = "ID")
	private long id;
	
	@Getter
	@Setter
	@Column(name = "projectid")
	private long projectId;
	
	
	@Getter
	@Setter
	@Column(name = "executionid")
	private long executionId;
	
	
	@Getter
	@Setter
	@Column(name = "fileid")
	private long fileId;
	
	
	@Getter
	@Setter
	@Column(name = "catelogid")
	private long catelogId;
	
	
	@Getter
	@Setter
	@Column(name = "datecreated")
	private Timestamp dateCreated;
	
	
}
