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
 * @author Ashish.Patel
 * 
 */

@Entity
@Table(name = "PRJ_TEMPLATE_MASTER")
public class ProjectTemplateMasterDomain {
	
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_PRJ_TEMPLATE_ID")
	@SequenceGenerator(name="SEQ_PRJ_TEMPLATE_ID", sequenceName="SEQ_PRJ_TEMPLATE_ID")
	@Column(name = "TEMPLATE_ID")
	private long templateId;
	
	@Getter
	@Setter
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Getter
	@Setter
	@Column(name = "USER_ID_CREATED")
	private String userID;
	
	@Getter
	@Setter
	@Column(name="DATE_CREATED")
	private Timestamp dateCreated;
	
	@Getter
	@Setter
	@Column(name = "PARENT_TEMPLATE_ID")
	private long parentTemplateId;

	@Override
	public String toString() {
		return "ProjectTemplateMasterDomain [templateId=" + templateId
				+ ", description=" + description + ", userID=" + userID
				+ ", dateCreated=" + dateCreated + "]";
	}
	
	

}