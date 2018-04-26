package com.dipta.project.dto.project.config;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Getter;
import lombok.Setter;


/**
 * 
 * @author Vinay.Kumar1
 *
 */
@XmlRootElement(name = "IncludeInResult")
@JsonRootName(value = "IncludeInResult")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({ConfigAttributesDto.class})
public class IncludeInResultPropsDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6663419918881565287L;

	@Getter
	@Setter
	@XmlElement(name = "SaveFlag")
	@JsonProperty(value = "SaveFlag")
	private boolean saveFlag;
	
	@Getter
	@Setter
	@XmlElement(name = "Category")
	@JsonProperty(value = "Category")
	private String category;
	
	@Getter
	@Setter
	@XmlElement(name = "CategoryText")
	@JsonProperty(value = "CategoryText")
	private String categoryText;
	
	
	@Getter
	@Setter
	@XmlElement(name = "Attributes")
	@JsonProperty(value = "Attributes")
	List<ConfigAttributesDto> attributes;
	
	
	
	
	
	
	
	
	
	@Getter
	@Setter
	@XmlElement(name = "PerfectMatchOnlyFlag")
	@JsonProperty(value = "PerfectMatchOnlyFlag")
	private Boolean perfectMatchOnlyFlag;
	

	@Getter
	@Setter
	@XmlElement(name = "NoMatchFlag")
	@JsonProperty(value = "NoMatchFlag")
	private Boolean noMatchFlag;
	

	@Getter
	@Setter
	@XmlElement(name = "PotentailMatchFlag")
	@JsonProperty(value = "PotentailMatchFlag")
	private Boolean potentailMatchFlag;
	
	

	@Getter
	@Setter
	@XmlElement(name = "ExceptionReportFlag")
	@JsonProperty(value = "ExceptionReportFlag")
	private Boolean exceptionReportFlag;
	
	
}