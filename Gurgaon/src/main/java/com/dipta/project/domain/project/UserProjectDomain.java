package com.dipta.project.domain.project;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import com.dipta.project.domain.crossReference.ProjectFeedDomain;

/**
 * 
 * @author Vinay.Kumar1
 * 
 */
@Entity
@Table(name = "user_projects")

public class UserProjectDomain {
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_PROJECT_ID")
	@SequenceGenerator(name="SEQ_PROJECT_ID", sequenceName="SEQ_PROJECT_ID")
	@Column(name = "PROJECT_ID")
	private long id;

	@Getter
	@Setter
	@Column(name = "PROJECT_NAME")
	private String projectName;

	@Getter
	@Setter
	@Column(name = "SOURCE_ID")
	private long sourceId;

	@Getter
	@Setter
	@Column(name = "CATEGORY_ID")
	private long categoryId;

	@Getter
	@Setter
	@Column(name = "PERSIST_DATA")
	private String perssistData;

	@Getter
	@Setter
	@Column(name = "STATUS_ID")
	private long statusId;
	
	@Getter
	@Setter
	@Column(name = "USER_ID_CREATED")
	private long userCreated;
	

	@Getter
	@Setter
	@Column(name = "date_created")
	private Timestamp dateCreated;
	
	@Getter
	@Setter
	@Column(name = "FILE_ID")
	private Long fileId;
	
	@Getter
	@Setter
	@Column(name = "MINMATCHINGSCORE")
	private int  MinimumMatchScore;
	
	@Getter
	@Setter
	@Column(name = "TEMPLATE_ID")
	private Long templateID;
	
	@Getter
	@Setter
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userProject")
	private List<ProjectFeedDomain> projectFeedDetailsSet = new ArrayList<ProjectFeedDomain>();
	 
	
	
	/*@Getter
	@Setter
	@OneToMany( mappedBy="userProject", cascade = CascadeType.ALL, orphanRemoval=true )
	@org.hibernate.annotations.Cascade( {org.hibernate.annotations.CascadeType.SAVE_UPDATE,org.hibernate.annotations.CascadeType.DELETE})
	private List<ProjectConfigDomain> projectConfigs;
	*/
	
	

	
	
	
	}
