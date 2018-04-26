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

/**
 * 
 * @author Saurabh Agarwal
 *
 */
@XmlRootElement(name = "ProjectStatusCollection")
@JsonRootName(value = "ProjectStatusCollection")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({ProjectStatusTemplateDto.class})
public class ProjectStatusCollectionDto {
	public ProjectStatusCollectionDto() {
		templates = new ArrayList<>();
	}
	@Getter
	@Setter
	@XmlElement(name = "ProjectTemplates")
	@JsonProperty(value = "ProjectTemplates")
	private List<ProjectStatusTemplateDto> templates;
}