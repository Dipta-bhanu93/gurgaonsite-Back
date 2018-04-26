package com.dipta.project.dto.project.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * 
 * @author Vinay.Kumar1
 *
 */
@XmlRootElement(name = "ProjectConfig")
@JsonRootName(value = "ProjectConfig")
@XmlAccessorType(XmlAccessType.NONE)
public class ProjectConfigDto {

	
	@Getter
	@Setter
	private long id;
	
	
	@Getter
	@Setter
	private String type;
	
	
	@Getter
	@Setter
	private String attribute;
	
	
	@Getter
	@Setter
	private String value;
}
