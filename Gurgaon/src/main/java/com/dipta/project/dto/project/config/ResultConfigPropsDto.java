package com.dipta.project.dto.project.config;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author Vinay.Kumar1
 *
 */
@XmlRootElement(name = "ResultConfig")
@JsonRootName(value = "ResultConfig")
@XmlAccessorType(XmlAccessType.NONE)
public class ResultConfigPropsDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 798402351977426049L;

	@Getter
	@Setter
	@Id
	@Column(name = "ID")
	private long id;
	
	@Getter
	@Setter
	@XmlElement(name = "SaveFlag")
	@JsonProperty(value = "SaveFlag")
	private boolean saveFlag;
	
	
	@Getter
	@Setter
	@XmlElement(name = "Category")
	@JsonProperty(value = "Category")
	private String category;
	
	@Getter
	@Setter
	@XmlElement(name = "CategoryText")
	@JsonProperty(value = "CategoryText")
	private String categoryText;
	
	@Getter
	@Setter
	@XmlElement(name = "Attributes")
	@JsonProperty(value = "Attributes")
	List<ConfigAttributesDto> attributes;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResultConfigPropsDto other = (ResultConfigPropsDto) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
