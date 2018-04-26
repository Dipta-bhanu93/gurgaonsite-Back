package com.dipta.project.dto.crossReference;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author Ashish.Patel
 *
 */
@XmlRootElement(name = "CountryCodeCategoryRulesHeader")
@JsonRootName(value = "CountryCodeCategoryRulesHeader")
@XmlAccessorType(XmlAccessType.NONE)
public class CountryCodeCategoryRulesHeader implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@XmlElement(name = "field")
	@JsonProperty(value = "field")
	private String field;
		
	@Getter
	@Setter
	@XmlElement(name = "displayName")
	@JsonProperty(value = "displayName")
	private String displayName;
	

	@Getter
	@Setter
	@XmlElement(name = "displayOrder")
	@JsonProperty(value = "displayOrder")
	private Integer displayOrder;
	
	@Getter
	@Setter
	@XmlElement(name = "visible")
	@JsonProperty(value = "visible")
	private Boolean visible;

}