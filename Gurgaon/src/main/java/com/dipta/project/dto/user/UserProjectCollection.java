package com.dipta.project.dto.user;

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
import com.dipta.project.dto.dashboard.DashboardDto;
import com.dipta.project.dto.workflow.ProjectDTO;

@XmlRootElement(name = "UserProjects")
@JsonRootName(value = "UserProjects")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso(ProjectDTO.class)
public class UserProjectCollection implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Getter
	@Setter
	@XmlElement(name = "Projects")
	@JsonProperty(value = "Projects")
	private List<ProjectDTO> userProjects;

	
}