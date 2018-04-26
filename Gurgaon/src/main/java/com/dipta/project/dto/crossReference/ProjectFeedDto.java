package com.dipta.project.dto.crossReference;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


@XmlRootElement(name = "ProjectFeedInformation")
@JsonRootName(value = "ProjectFeedDtoInformation")
@XmlAccessorType(XmlAccessType.NONE)
public class ProjectFeedDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@XmlElement(name = "ProjectFeedId")
	@JsonProperty(value = "ProjectFeedId")
	private long projectFeedId;
	
	@Getter
	@Setter
	@XmlElement(name = "FileId")
	@JsonProperty(value = "FileId")
	private long fileId;
	
	@Getter
	@Setter
	@XmlElement(name = "StatusName")
	@JsonProperty(value = "StatusName")
	private String statusName;
	
	@Getter
	@Setter
	@XmlElement(name = "StatusId")
	@JsonProperty(value = "StatusId")
	private long statusId;
	
	@Getter
	@Setter
	@XmlElement(name = "FeedId")
	@JsonProperty(value = "FeedId")
	private long feedId;
	
	@Getter
	@Setter
	@XmlElement(name = "ProjectId")
	@JsonProperty(value = "ProjectId")
	private long projectId;

	@Getter
	@Setter
	@XmlElement(name = "CompletedStepId")
	@JsonProperty(value = "CompletedStepId")
	private long completedStepId;
	
}