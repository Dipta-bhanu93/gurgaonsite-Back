package com.dipta.project.dto.hierarchy;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name="HierarchyViewMasters")
@JsonRootName(value = "HierarchyViewMasters")
@XmlAccessorType(XmlAccessType.NONE)
public class HierarchyViewMasterDTO {

	
	@Getter
	@Setter
	@JsonProperty(value = "Id")
	@XmlElement(name = "Id")
	private long id;
	
	@Getter
	@Setter
	@JsonProperty(value = "ProjectID")
	@XmlElement(name = "ProjectID")
	private long projectID;
	
	
	@Getter
	@Setter
	@JsonProperty(value = "ViewName")
	@XmlElement(name = "ViewName")
	private String viewName;
	
	
	@Getter
	@Setter
	@JsonProperty(value = "SerialNO")
	@XmlElement(name = "SerialNO")
	private String serialNO;
	
	
	@Getter
	@Setter
	@JsonProperty(value = "Cdid")
	@XmlElement(name = "Cdid")
	private long cdid;
	
	@Getter
	@Setter
	@JsonProperty(value = "UserId")
	@XmlElement(name = "UserId")
	private long userId;
	
	
	@Getter
	@Setter
	@JsonProperty(value = "Filters")
	@XmlElement(name = "Filters")
	private String filters;
}


