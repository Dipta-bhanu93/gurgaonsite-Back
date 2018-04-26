package com.dipta.project.dto.project.execute;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@XmlRootElement(name = "ProjectSkippedFeed")
@JsonRootName(value = "ProjectSkippedFeed")
@XmlAccessorType(XmlAccessType.NONE)
public class ProjectSkippedFeed {
	
		@Getter
		@Setter
		@XmlElement(name = "FeedID")
		@JsonProperty(value = "FeedID")
		private int feedId;
		
		
		@Getter
		@Setter
		@XmlElement(name = "FeedCounter")
		@JsonProperty(value = "FeedCounter")
		private int feedCounter;
		
}