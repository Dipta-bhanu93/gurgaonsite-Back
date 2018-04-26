package com.dipta.project.dto.project.template;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * 
 * @author Ashish.Patel
 * 
 */

@XmlRootElement(name = "TemplateServiceMasterInformation")
@JsonRootName(value = "TemplateServiceMasterInformation")
@XmlAccessorType(XmlAccessType.NONE)
@JsonInclude(Include.NON_NULL)
public class TemplateServiceMasterDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@JsonProperty(value = "ServiceId")
	@XmlElement(name = "ServiceId")
	private Long serviceId;
	
	@Getter
	@Setter
	@JsonProperty(value = "Description")
	@XmlElement(name = "Description")
	private String description;
	
	@Getter
	@Setter
	@JsonProperty(value = "UserID")
	@XmlElement(name = "UserID")
	private String userID;
	
	@Getter
	@Setter
	@JsonProperty(value = "DateCreated")
	@XmlElement(name = "DateCreated")
	private Date dateCreated;

	@Override
	public String toString() {
		return "TemplateServiceMasterDto [serviceId=" + serviceId
				+ ", description=" + description + ", userID=" + userID
				+ ", dateCreated=" + dateCreated + "]";
	}
	

}
