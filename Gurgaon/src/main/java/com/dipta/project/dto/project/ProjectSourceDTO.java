package com.dipta.project.dto.project;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@XmlRootElement(name = "ProjectSource")
@JsonRootName(value = "ProjectSource")
@XmlAccessorType(XmlAccessType.NONE)
public class ProjectSourceDTO {
	@Getter
	@Setter
	@XmlElement(name = "Id")
	@JsonProperty(value = "Id")
	private Long id;
	
	@Getter
	@Setter
	@XmlElement(name = "Name")
	@JsonProperty(value = "Name")
	private String name;
}
