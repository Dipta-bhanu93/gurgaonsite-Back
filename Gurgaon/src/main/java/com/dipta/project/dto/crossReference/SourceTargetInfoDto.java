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

@XmlRootElement(name = "SourceTargetInfoDto")
@JsonRootName(value = "SourceTargetInfoDto")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({ReplaceTransformDto.class})
public class SourceTargetInfoDto {
	
	@Getter
	@Setter
	@XmlElement(name = "SourceTargetid")
	@JsonProperty(value = "SourceTargetid")
	private long sourceTargetid;
	
	@Getter
	@Setter
	@XmlElement(name = "SourceTableName")
	@JsonProperty(value = "SourceTableName")
	private String sourceTableName;
	
	@Getter
	@Setter
	@XmlElement(name = "SourceColName")
	@JsonProperty(value = "SourceColName")
	private String sourceColName;
	
	@Getter
	@Setter
	@XmlElement(name = "ReplaceTransformPerformList")
	@JsonProperty(value = "ReplaceTransformPerformList")
	private List<ReplaceTransformDto> replaceTransformPerformList;
	
	
	@Getter
	@Setter
	@XmlElement(name = "isColumn")
	@JsonProperty(value = "isColumn")
	
	private boolean isColumn;

}
