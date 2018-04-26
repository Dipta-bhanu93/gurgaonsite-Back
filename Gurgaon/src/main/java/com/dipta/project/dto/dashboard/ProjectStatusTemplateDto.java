package com.dipta.project.dto.dashboard;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.dipta.project.dto.project.template.ProjectTemplateMasterDto;

/**
 * 
 * @author Saurabh Agarwal
 *
 */
@XmlRootElement(name = "ProjectTemplate")
@JsonRootName(value = "ProjectTemplate")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({ProjectTemplateProjectsDTO.class,ProjectTemplateMasterDto.class})
public class ProjectStatusTemplateDto {
	
	public ProjectStatusTemplateDto() {
		projects = new ArrayList<>();
		projectsTruncated = false;
	}
	@Getter
	@Setter
	@XmlElement(name = "SrNo")
	@JsonProperty(value = "SrNo")
	private Integer srNo;
	
	@Getter
	@Setter
	@XmlElement(name = "Projects")
	@JsonProperty(value = "Projects")
	private List<ProjectTemplateProjectsDTO> projects;
	
	@Getter
	@Setter
	@XmlElement(name = "TemplateInfo")
	@JsonProperty(value = "TemplateInfo")
	private ProjectTemplateMasterDto template;
	
	@Getter
	@Setter
	@XmlElement(name = "ProjectsTruncated")
	@JsonProperty(value = "ProjectsTruncated")
	private Boolean projectsTruncated;
}