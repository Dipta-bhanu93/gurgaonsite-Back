package com.dipta.project.dto.dashboard;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


@XmlRootElement(name = "GoldDataTypeDto")
@JsonRootName(value = "GoldDataTypeDto")
@XmlAccessorType(XmlAccessType.NONE)
public class GoldDataTypeDto {
	
	@Getter
	@Setter
	@XmlElement(name = "displayLabel")
	@JsonProperty(value = "displayLabel")
	private String displayLabel;
	
	
	@Getter
	@Setter
	@XmlElement(name = "value")
	@JsonProperty(value = "value")
	private String value;
	
	

}