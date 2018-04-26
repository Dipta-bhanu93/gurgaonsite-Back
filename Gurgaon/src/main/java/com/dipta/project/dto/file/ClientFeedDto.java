package com.dipta.project.dto.file;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@XmlRootElement(name = "ClientFeed")
@JsonRootName(value = "ClientFeed")
@XmlAccessorType(XmlAccessType.NONE)
public class ClientFeedDto {
	
	@Getter
	@Setter
	@XmlElement(name = "Id")
	@JsonProperty(value = "Id")
	private long id;
	
	@Getter
	@Setter
	@XmlElement(name = "clientId")
	@JsonProperty(value = "clientId")
	private long clientId;
	
	@Getter
	@Setter
	@XmlElement(name = "dateModified")
	@JsonProperty(value = "dateModified")
	private Date dateModified;
	
	@Getter
	@Setter
	@XmlElement(name = "userIdModified")
	@JsonProperty(value = "userIdModified")
	private String userIdModified;
	
	@Getter
	@Setter
	@XmlElement(name = "dateCreated")
	@JsonProperty(value = "dateCreated")
	private Date dateCreated;
	
	@Getter
	@Setter
	@XmlElement(name = "userIdCreated")
	@JsonProperty(value = "userIdCreated")
	private String userIdCreated;
	
	@Getter
	@Setter
	@XmlElement(name = "comments")
	@JsonProperty(value = "comments")
	private String comments;
	
	@Getter
	@Setter
	@XmlElement(name = "statusUser")
	@JsonProperty(value = "statusUser")
	private String statusUser;
	
	@Getter
	@Setter
	@XmlElement(name = "statusDate")
	@JsonProperty(value = "statusDate")
	private Date statusDate;
	
	@Getter
	@Setter
	@XmlElement(name = "status")
	@JsonProperty(value = "status")
	private String status;

	@Getter
	@Setter
	@XmlElement(name = "fileId")
	@JsonProperty(value = "fileId")
	private Long fileId;
	
	@Getter
	@Setter
	@XmlElement(name = "fileName")
	@JsonProperty(value = "fileName")
	private String fileName;

	@Getter
	@Setter
	@XmlElement(name = "directoryName")
	@JsonProperty(value = "directoryName")
	private String directoryName;
	

	@Getter
	@Setter
	@XmlElement(name = "feedType")
	@JsonProperty(value = "feedType")
	private String feedType;
	
	@Getter
	@Setter
	@XmlElement(name = "originalFileName")
	@JsonProperty(value = "originalFileName")
	private String originalFileName;
	
	@Getter
	@Setter
	@XmlElement(name = "dataFeedId")
	@JsonProperty(value = "dataFeedId")
	private Long dataFeedId;

	@Getter
	@Setter
	@XmlElement(name = "fileType")
	@JsonProperty(value = "fileType")
	private String fileType;
	
	@Getter
	@Setter
	@XmlElement(name = "projectId")
	@JsonProperty(value = "projectId")
	private Long projectId;

}
