package com.dipta.project.dto.project.config;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Getter;
import lombok.Setter;


/**
 * 
 * @author Vinay.Kumar1
 *
 */
@XmlRootElement(name = "PremiumServices")
@JsonRootName(value = "PremiumServices")
@XmlAccessorType(XmlAccessType.NONE)
public class PremuimServicesPropsDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7765745396993887211L;

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
	
	
/*	@Getter
	@Setter
	@XmlElement(name = "NameAndTrackFlag")
	@JsonProperty(value = "NameAndTrackFlag")
	private Boolean nameAndTrackFlag;
	
	@Getter
	@Setter
	@XmlElement(name = "NotifyOnChangeFlag")
	@JsonProperty(value = "NotifyOnChangeFlag")
	private Boolean notifyOnChangeFlag;
	
	@Getter
	@Setter
	@XmlElement(name = "SendCnsldtReportFlag")
	@JsonProperty(value = "SendCnsldtReportFlag")
	private Boolean sendCnsldtReportFlag;*/
	
	
}
