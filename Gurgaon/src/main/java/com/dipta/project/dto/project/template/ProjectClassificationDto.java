package com.dipta.project.dto.project.template;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * 
 * @author Ashish.Patel
 * 
 */

@XmlRootElement(name = "ProjectClassificationInformation")
@JsonRootName(value = "ProjectClassificationInformation")
@XmlAccessorType(XmlAccessType.NONE)
@JsonInclude(Include.NON_NULL)
public class ProjectClassificationDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@JsonProperty(value = "ProjectClassID")
	@XmlElement(name = "ProjectClassID")
	private long projectClassID;

	@Getter
	@Setter
	@JsonProperty(value = "ProjectID")
	@XmlElement(name = "ProjectID")
	private long projectID;
	
	@Getter
	@Setter
	@JsonProperty(value = "ClassType")
	@XmlElement(name = "ClassType")
	private String classType;
	
	@Getter
	@Setter
	@JsonProperty(value = "ClassDetails")
	@XmlElement(name = "ClassDetails")
	private String classDetails;
	
	@Getter
	@Setter
	@JsonProperty(value = "ClassCount")
	@XmlElement(name = "ClassCount")
	private long classCount;
	
	@Getter
	@Setter
	@JsonProperty(value = "ProjectClassificationLst")
	@XmlElement(name = "ProjectClassificationLst")
	private List<ProjectClassificationDto> projectClassificationLst;
	
	@Getter
	@Setter
	@XmlElement(name = "DonutChartKeyMap")
	@JsonProperty(value = "DonutChartKeyMap")
	private HashMap<String,ProjectClassificationDto> donutChartKeyMap;

}
