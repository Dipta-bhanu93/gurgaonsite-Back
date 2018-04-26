/**
 * 
 */
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
 *This Class will represent master column list required for matching service.
 */
@XmlRootElement(name = "EtlMatchMasterColumnsDetail")
@JsonRootName(value = "EtlMatchMasterColumnsDetail")
@XmlAccessorType(XmlAccessType.NONE)
public class EtlMatchMasterColumnsDto {
	
	
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
	@XmlElement(name = "feedType")
	@JsonProperty(value = "feedType")
		private String feedType;
	
	

}
