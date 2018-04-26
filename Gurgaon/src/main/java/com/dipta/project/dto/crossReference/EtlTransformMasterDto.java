package com.dipta.project.dto.crossReference;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@XmlRootElement(name = "EtlTransformMaster")
@JsonRootName(value = "EtlTransformMaster")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({SourceTargetInfoDto.class})
public class EtlTransformMasterDto {
	
	@Getter
	@Setter
	@XmlElement(name = "TransformMapId")
	@JsonProperty(value = "TransformMapId")
	private long transformMapId;
	
	@Getter
	@Setter
	@XmlElement(name = "FeedId")
	@JsonProperty(value = "FeedId")
	private long feedId;
	
	@Getter
	@Setter
	@XmlElement(name = "ExecuteStatusFlag")
	@JsonProperty(value = "ExecuteStatusFlag")
	private String executeStatusFlag;
	
	@Getter
	@Setter
	@XmlElement(name = "TransformSetName")
	@JsonProperty(value = "TransformSetName")
	private String transformSetName;
	
	@Getter
	@Setter
	@XmlElement(name = "TransformStatus")
	@JsonProperty(value = "TransformStatus")
	private String transformStatus;

	@Getter
	@Setter
	@XmlElement(name = "Remarks")
	@JsonProperty(value = "Remarks")
	private String remarks;
	
	@Getter
	@Setter
	@XmlElement(name = "SourceTargetList")
	@JsonProperty(value = "SourceTargetList")
	private List<SourceTargetInfoDto> sourceTargetList;
}
