package com.dipta.project.domain.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;


/**
 * 
 * @author Pranav.Aggarwal
 * 
 */
@Entity
@Table(name = "CDID_PROJECT_MAPPING")
public class CdidProjectMappingDomain {

	@Getter
	@Setter
	@Id
	@Column(name = "ID")
	private Long id;
	
	@Getter
	@Setter
	@Column(name = "CDID")
	private Long cdid;
		
	@Getter
	@Setter
	@Column(name = "PROJECTID")
	private Long projectId;
	
	@Getter
	@Setter
	@Column(name = "TEMPLATE_ID")
	private Long templateId;
	

}
