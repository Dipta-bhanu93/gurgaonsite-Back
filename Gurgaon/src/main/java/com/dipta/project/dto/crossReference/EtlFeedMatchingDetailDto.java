package com.dipta.project.dto.crossReference;

import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author santosh.panigrahi
 *
 *This Class will represents linked matching id to the feed type 
 *
 */
@XmlRootElement(name = "EtlFeedMatchingDetail")
@JsonRootName(value = "EtlFeedMatchingDetail")
@XmlAccessorType(XmlAccessType.NONE)
public class EtlFeedMatchingDetailDto {
	
	@Getter
	@Setter
	@XmlElement(name = "ruleId")
	@JsonProperty(value = "ruleId")
		private long ruleId;
	
	@Getter
	@Setter
	@XmlElement(name = "feedType")
	@JsonProperty(value = "feedType")
		private String feedType;
	
	@Getter
	@Setter
	@XmlElement(name = "fileId")
	@JsonProperty(value = "fileId")
		private long fileId;
	
	@Getter
	@Setter
	@XmlElement(name = "remarks")
	@JsonProperty(value = "remarks")
		private String remarks;
	
	@Getter
	@Setter
	@XmlElement(name = "executionStatusFlag")
	@JsonProperty(value = "executionStatusFlag")
		private String executionStatusFlag;
	
	@Getter
	@Setter
	@XmlElement(name = "feedId")
	@JsonProperty(value = "feedId")
	private long feedId;
	
	
	@Getter
	@Setter
	@XmlElement(name = "etlMatchingColumnDetails")
	@JsonProperty(value = "etlMatchingColumnDetails")
		private Set<EtlMatchingColumnDetailDto> etlMatchingColumnDetails;
	
	@Getter
	@Setter
	@XmlElement(name = "EtlMatchingScoreDetails")
	@JsonProperty(value = "EtlMatchingScoreDetails")
		private Set<EtlMatchingScoreDetailDto> EtlMatchingScoreDetails;

	@Getter
	@Setter
	@XmlElement(name = "ProjectId")
	@JsonProperty(value = "ProjectId")
	private String projectId;
	
	

}