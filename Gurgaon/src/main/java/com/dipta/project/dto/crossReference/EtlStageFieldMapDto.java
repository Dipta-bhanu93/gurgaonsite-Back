package com.dipta.project.dto.crossReference;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@XmlRootElement(name = "EtlStageFieldMapDto")
@JsonRootName(value = "EtlStageFieldMapDto")
@XmlAccessorType(XmlAccessType.NONE)
public class EtlStageFieldMapDto {
	
	@Getter
	@Setter
	@XmlElement(name = "TableName")
	@JsonProperty(value = "TableName")
	private String tableName;
	
	@Getter
	@Setter
	@XmlElement(name = "FieldName")
	@JsonProperty(value = "FieldName")
	private String fieldName;
	
	@Getter
	@Setter
	@XmlElement(name = "DisplayName")
	@JsonProperty(value = "DisplayName")
	private String displayName;
	
	@Getter
	@Setter
	@XmlElement(name = "FeedDataType")
	@JsonProperty(value = "FeedDataType")
	private String feedDataType;
	
	@Getter
	@Setter
	@XmlElement(name = "FeedType")
	@JsonProperty(value = "FeedType")
	private String feedType;

}