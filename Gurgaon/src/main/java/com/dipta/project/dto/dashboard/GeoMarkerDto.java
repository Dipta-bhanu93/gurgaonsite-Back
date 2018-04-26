package com.dipta.project.dto.dashboard;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Getter;
import lombok.Setter;


@XmlRootElement(name = "Marker")
@JsonRootName(value = "Marker")
@XmlAccessorType(XmlAccessType.NONE)
public class GeoMarkerDto {

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@XmlElement(name = "Location")
	@JsonProperty(value = "Location")
	private String location;
	
	@Getter
	@Setter
	@XmlElement(name = "Alpha2Code")
	@JsonProperty(value = "Alpha2Code")
	private String alpha2Code;
	
	
	@Getter
	@Setter
	@XmlElement(name = "PlatinumCount")
	@JsonProperty(value = "PlatinumCount")
	private Long platinum_Count;
	
	@Getter
	@Setter
	@XmlElement(name = "GoldCount")
	@JsonProperty(value = "GoldCount")
	private Long gold_Count;
	
	@Getter
	@Setter
	@XmlElement(name = "Latitude")
	@JsonProperty(value = "Latitude")
	private String latitude;
	
	
	@Getter
	@Setter
	@XmlElement(name = "Longitude")
	@JsonProperty(value = "Longitude")
	private String longitude;
	
}
