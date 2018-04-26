package com.dipta.project.dto.hierarchy;

import java.util.ArrayList;
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


@XmlRootElement(name="HierarchyDataCollection")
@JsonRootName(value = "HierarchyDataCollection")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({HierarchyEntityDTO.class, ArrayList.class})
public class HierarchyDataCollection implements java.io.Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter
	@Setter
	@XmlElement(name = "HierarcyEntityList")
	@JsonProperty(value = "HierarcyEntityList")
	private List<HierarchyEntityDTO> hierarcyEntityList;

}
