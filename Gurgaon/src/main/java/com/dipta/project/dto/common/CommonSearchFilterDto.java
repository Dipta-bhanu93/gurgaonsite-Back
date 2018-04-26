package com.dipta.project.dto.common;

import java.io.Serializable;
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

/**
 * 
 * @author Ashish.Patel
 *
 */
@XmlRootElement(name = "CommonSearchGrid")
@JsonRootName(value = "CommonSearchGrid")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({CommonExternalFilterDto.class})
public class CommonSearchFilterDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6636456078555064502L;

	@Getter		@Setter		@XmlElement(name = "FilterList")	@JsonProperty(value = "FilterList")		private List<CommonExternalFilterDto> filterList;
	
}