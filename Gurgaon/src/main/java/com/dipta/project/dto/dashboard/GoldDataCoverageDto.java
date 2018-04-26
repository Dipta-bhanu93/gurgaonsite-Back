package com.dipta.project.dto.dashboard;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


@XmlRootElement(name = "GoldCoverageData")
@JsonRootName(value = "GoldCoverageData")
@XmlAccessorType(XmlAccessType.NONE)
public class GoldDataCoverageDto {
	
	@Getter
	@Setter
	@XmlElement(name = "Type")
	@JsonProperty(value = "Type")
	private String type;
	
	@Getter
	@Setter
	@XmlElement(name = "label")
	@JsonProperty(value = "label")
	private String label;
	
	

	@Getter
	@Setter
	@XmlElement(name = "value")
	@JsonProperty(value = "value")
	private Long value;
	
	

	@Getter
	@Setter
	@XmlElement(name = "displayLabel")
	@JsonProperty(value = "displayLabel")
	private String displayLabel;
	
}
