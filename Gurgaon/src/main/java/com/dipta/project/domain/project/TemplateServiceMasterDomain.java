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
@Table(name = "TEMPLATE_SERVICE_MASTER")
public class TemplateServiceMasterDomain {
	@Getter
	@Setter
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SEQ_TEMPLATE_SERVICE_MASTER")
	@SequenceGenerator(name="SEQ_TEMPLATE_SERVICE_MASTER", sequenceName="SEQ_TEMPLATE_SERVICE_MASTER")
	@Column(name = "SERVICE_ID")
	private long serviceId;
	
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
	@Column(name="STATUS")
	private char status;
	
	@Override
	public String toString() {
		return "TemplateServiceMasterDomain [serviceId=" + serviceId
				+ ", description=" + description + ", userID=" + userID
				+ ", dateCreated=" + dateCreated + "]";
	}
	
	

}