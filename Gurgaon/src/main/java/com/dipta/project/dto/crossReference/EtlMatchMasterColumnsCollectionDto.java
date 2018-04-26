package com.dipta.project.dto.crossReference;

import java.util.List;

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
 */
@XmlRootElement(name = "EtlMatchMasterColumnsCollectionDto")
@JsonRootName(value = "EtlMatchMasterColumnsCollectionDto")
@XmlAccessorType(XmlAccessType.NONE)
public class EtlMatchMasterColumnsCollectionDto {
	
	@Getter
	@Setter
	@XmlElement(name = "etlMatchMasterColumns")
	@JsonProperty(value = "etlMatchMasterColumns")
	private List<EtlMatchMasterColumnsDto> etlMatchMasterColumns;

}
