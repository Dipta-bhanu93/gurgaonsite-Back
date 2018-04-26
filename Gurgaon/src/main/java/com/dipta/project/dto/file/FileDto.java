package com.dipta.project.dto.file;

import java.io.Serializable;
import java.util.Date;

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
@XmlRootElement(name = "UserFile")
@JsonRootName(value = "UserFile")
@XmlAccessorType(XmlAccessType.NONE)
public class FileDto implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7622962660408018648L;

	@Getter
	@Setter
	@XmlElement(name = "Id")
	@JsonProperty(value = "Id")
	private long id;

	@Getter
	@Setter
	@XmlElement(name = "FileName")
	@JsonProperty(value = "FileName")
	private String fileName;
	
	@Getter
	@Setter
	@XmlElement(name = "FileLocation")
	@JsonProperty(value = "FileLocation")
	private String fileLocation;
	
	@Getter
	@Setter
	@XmlElement(name = "Extension")
	@JsonProperty(value = "Extension")
	private String extension;

	@Getter
	@Setter
	@XmlElement(name = "StatusId")
	@JsonProperty(value = "StatusId")
	private long statusId;

	@Getter
	@Setter
	@XmlElement(name = "DateModified")
	@JsonProperty(value = "DateModified")
	private Date dateModified;

	@Getter
	@Setter
	@XmlElement(name = "DateCreated")
	@JsonProperty(value = "DateCreated")
	private Date dateCreated;
	
	@Getter
	@Setter
	@XmlElement(name = "FileData")
	@JsonProperty(value = "FileData")
	private byte[] data;
	
	@Getter
	@Setter
	@XmlElement(name = "Source")
	@JsonProperty(value = "Source")
	private String source;
	
	
	@Getter
	@Setter
	@XmlElement(name = "ProcessPercentage")
	@JsonProperty(value = "ProcessPercentage")
	private Integer processPercentage;
	
	@Getter
	@Setter
	@XmlElement(name = "UploadState")
	@JsonProperty(value = "UploadState")
	private String UploadState;
	
	
	
	@Getter
	@Setter
	@XmlElement(name = "FeedName")
	@JsonProperty(value = "FeedName")
	private String feedName;	

	@Getter
	@Setter
	@XmlElement(name = "userCreated")
	@JsonProperty(value = "userCreated")
	private Long userCreated;
	
	
	@Getter
	@Setter
	//@XmlElement(name = "userCreated")
	//@JsonProperty(value = "userCreated")
	private String sourceType;
}
