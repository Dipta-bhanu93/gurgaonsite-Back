package com.dipta.project.dto.crossReference;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;



/**
 * @author Ashish.Patel
 *
 */
@XmlRootElement(name = "ReplaceCategoryCollection")
@JsonRootName(value = "ReplaceCategoryCollection")
@XmlAccessorType(XmlAccessType.NONE)
@JsonInclude(Include.NON_NULL)
@XmlSeeAlso({ReplaceCategoryDto.class})
public class ReplaceCategoryCollection implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@XmlElement(name = "ReplaceCategoryList")
	@JsonProperty(value = "ReplaceCategoryList")
	private List<ReplaceCategoryDto> replaceCategoryList;
	
	

}