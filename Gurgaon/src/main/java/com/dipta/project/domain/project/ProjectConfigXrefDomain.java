package com.dipta.project.domain.project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import org.hibernate.annotations.Type;

/**
 * @author Ashish.Patel
 *
 */
@Entity
@Table(name = "PROJECT_CONFIGURATION_XREF")
public class ProjectConfigXrefDomain {
	
	@Getter
	@Setter
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_Project_Config_Xref")
	@SequenceGenerator(name="SEQ_Project_Config_Xref", sequenceName="SEQ_Project_Config_Xref")
	private long id;
	
	@Getter                   
	@Setter                   
	@Column(name = "PROJECT_ID")
	private long projectId;
	
	@Getter                   
	@Setter                   
	@Column(name = "FEED_ID")
	private long feedId;
	
	@Getter                   
	@Setter                   
	@Column(name = "ATTRIBUTE_NAME")
	private String attributeName; 
	
	@Getter                   
	@Setter                   
	@Column(name = "TYPE")
	private String type;
	
	@Getter
	@Setter
	@Column(name = "VALUE")
	@Type(type="yes_no")
	private Boolean value;
	

}