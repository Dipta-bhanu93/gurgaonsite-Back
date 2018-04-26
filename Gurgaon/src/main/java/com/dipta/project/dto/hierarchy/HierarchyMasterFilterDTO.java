package com.dipta.project.dto.hierarchy;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.dipta.project.dto.common.KeyValueDto;


@XmlRootElement(name="HierarchyFiltersData")
@JsonRootName(value = "HierarchyFiltersData")
@XmlAccessorType(XmlAccessType.NONE)
public class HierarchyMasterFilterDTO {
	
	@Getter
	@Setter
	@JsonProperty(value = "Regions")
	@XmlElement(name = "Regions")
	private List<KeyValueDto> regions;
	
	@Getter
	@Setter
	@JsonProperty(value = "Levels")
	@XmlElement(name = "Levels")
	private List<KeyValueDto> levels;
}
