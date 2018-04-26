/**
 * 
 */
package com.dipta.project.dto.dashboard;

import javax.xml.bind.annotation.XmlElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Aditya.Julka
 *
 */
public class SectorSummaryStatsDto {
	
	
	@Getter
	@Setter
	@XmlElement(name = "lableName")
	@JsonProperty(value = "lableName")
	private String lableName;
	

	@Getter
	@Setter
	@XmlElement(name = "platinumValue")
	@JsonProperty(value = "platinumValue")
	private int platinumValue;
	
	
	
	@Getter
	@Setter
	@XmlElement(name = "goldValue")
	@JsonProperty(value = "goldValue")
	private int goldValue;
	

	
	
	@Getter
	@Setter
	@XmlElement(name = "id")
	@JsonProperty(value = "id")
	private String id;
	
	@Getter
	@Setter
	@XmlElement(name = "classification")
	@JsonProperty(value = "classification")
	private String classification;
	
	
}


