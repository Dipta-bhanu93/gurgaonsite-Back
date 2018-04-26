/**
 * 
 */
package com.dipta.project.dto.dashboard;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;



/**
 * @author Aditya.Julka
 *
 */
public class SectorSummaryStatsDtoCollections {

	@Getter
	@Setter
	@XmlElement(name = "Statslist")
	@JsonProperty(value = "Statslist")
	List<SectorSummaryStatsDto> Statslist;
	
	@Getter
	@Setter
	@XmlElement(name = "series")
	@JsonProperty(value = "series")
	private  String series[];
	
}