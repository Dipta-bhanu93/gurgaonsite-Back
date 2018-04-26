package com.dipta.project.service.api;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


/**
 * 
 * @author Shrikant.kushwaha
 *
 */
@XmlRootElement(name = "CodApiRequest")
@JsonRootName(value = "CodApiRequest")
@XmlAccessorType(XmlAccessType.NONE)
@JsonInclude(Include.NON_NULL)
public class CodApiRequest {

	@Getter
	@Setter
	@JsonIgnore
	private Long id;

	@Getter
	@Setter
	@XmlElement(name = "Name")
	@JsonProperty(value = "Name")
	private String name;
	

	@Getter
	@Setter
	@XmlElement(name = "Country")
	@JsonProperty(value = "Country")
	private String country;
	
	@Getter
	@Setter
	@XmlElement(name = "LEI")
	@JsonProperty(value = "LEI")
	private String leiCode;
	
	@Getter
	@Setter
	@XmlElement(name = "CDID")
	@JsonProperty(value = "CDID")
	private String cdid;
	
	
	@Getter
	@Setter
	private String uniqueId;
	
	
	
}
