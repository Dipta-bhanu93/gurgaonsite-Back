package com.dipta.project.dto.file;

import javax.persistence.Column;
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
 * @author saurabh.agarwal
 *
 */
@XmlRootElement(name = "FileData")
@JsonRootName(value = "FileData")
@XmlAccessorType(XmlAccessType.NONE)
public class FileDataDTO {
	@Getter
	@Setter
	@XmlElement(name = "Id")
	@JsonProperty(value = "Id")
	private String f0;
	
	@Getter
	@Setter
	@XmlElement(name = "LegalName")
	@JsonProperty(value = "LegalName")
	private String f1;
	
	@Getter
	@Setter
	@XmlElement(name = "Country")
	@JsonProperty(value = "Country")
	private String f2;
	
	@Getter
	@Setter
	@XmlElement(name = "CUSIP")
	@JsonProperty(value = "CUSIP")
	private String f3;
	
	@Getter
	@Setter
	@XmlElement(name = "ISIN")
	@JsonProperty(value = "ISIN")
	private String f4;
	
	@Getter
	@Setter
	@XmlElement(name = "SEDOL")
	@JsonProperty(value = "SEDOL")
	private String f5;

	@Getter
	@Setter
	@XmlElement(name = "Status")
	@JsonProperty(value = "Status")
	private String status;
	
	@Getter
	@Setter
	@XmlElement(name = "ProjectId")
	@JsonProperty(value = "ProjectId")
	private Long projectId;
	
	
	@Getter
	@Setter
	@XmlElement(name = "Comments")
	@JsonProperty(value = "Comments")
	private String comments;
	
}
