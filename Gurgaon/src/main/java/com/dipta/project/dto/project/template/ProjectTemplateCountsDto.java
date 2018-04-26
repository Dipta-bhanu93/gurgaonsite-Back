package com.dipta.project.dto.project.template;

import java.io.Serializable;
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
 * @author Ashish.Patel
 *
 */

@XmlRootElement(name = "ProjectTemplateCountsInformation")
@JsonRootName(value = "ProjectTemplateCountsInformation")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({ProjectTemplateMasterDto.class})
public class ProjectTemplateCountsDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@JsonProperty(value = "ProjectTemplatemasterDtoList")
	@XmlElement(name = "ProjectTemplatemasterDtoList")
	private List<ProjectTemplateMasterDto> projectTemplatemasterDtoList;

}