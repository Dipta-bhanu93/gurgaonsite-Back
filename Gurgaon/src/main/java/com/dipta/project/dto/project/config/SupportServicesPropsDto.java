package com.dipta.project.dto.project.config;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


/**
 * 
 * @author Vinay.Kumar1
 *
 */
@XmlRootElement(name = "SupportServices")
@JsonRootName(value = "SupportServices")
@XmlAccessorType(XmlAccessType.NONE)
public class SupportServicesPropsDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4509228264869923145L;

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
	
	/*
	@Getter
	@Setter
	@XmlElement(name = "AddToWorkFlowFlag")
	@JsonProperty(value = "AddToWorkFlowFlag")
	private Boolean addToWorkFlowFlag;
	
	
	@Getter
	@Setter
	@XmlElement(name = "ResolveAndMailFlag")
	@JsonProperty(value = "ResolveAndMailFlag")
	private Boolean resolveAndMailFlag;
	*/
	
	
}
