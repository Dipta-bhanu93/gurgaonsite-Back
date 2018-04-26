package com.dipta.project.dto.crossReference;

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
 * This Class will represent information list of columns mapped in matching rule for the feed type.
 *
 */
@XmlRootElement(name = "EtlMatchingColumnDetail")
@JsonRootName(value = "EtlMatchingColumnDetail")
@XmlAccessorType(XmlAccessType.NONE)
public class EtlMatchingColumnDetailDto {
	
	@Getter
	@Setter
	@XmlElement(name = "ruleId")
	@JsonProperty(value = "ruleId")
		private long ruleId;
	
	@Getter
	@Setter
	@XmlElement(name = "sourceTableName")
	@JsonProperty(value = "sourceTableName")
		private String sourceTableName;
	
	@Getter
	@Setter
	@XmlElement(name = "sourceColumnName")
	@JsonProperty(value = "sourceColumnName")
		private String sourceColumnName;
	
	@Getter
	@Setter
	@XmlElement(name = "targetTableName")
	@JsonProperty(value = "targetTableName")
		private String targetTableName;
	
	@Getter
	@Setter
	@XmlElement(name = "targetColumnName")
	@JsonProperty(value = "targetColumnName")
		private String targetColumnName;
	
	@Getter
	@Setter
	@XmlElement(name = "remarks")
	@JsonProperty(value = "remarks")
		private String remarks;
	
	@Getter
	@Setter
	@XmlElement(name = "order")
	@JsonProperty(value = "order")
		private long order;
	
	@Getter
	@Setter
	@XmlElement(name = "matchingType")
	@JsonProperty(value = "matchingType")
		private String matchingType;


}
