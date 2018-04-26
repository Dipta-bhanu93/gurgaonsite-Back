package com.dipta.project.dto.dashboard;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Getter;
import lombok.Setter;


@XmlRootElement(name = "GoldWidgetData")
@JsonRootName(value = "GoldWidgetData")
@XmlAccessorType(XmlAccessType.NONE)
public class GoldWidgetDto  implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@XmlElement(name = "Id")
	@JsonProperty(value = "Id")
	private Long id=1L;
	
	@Getter
	@Setter
	@XmlElement(name = "WidgetName")
	@JsonProperty(value = "WidgetName")
	private String widgetName="My Gold";
	
	@Getter
	@Setter
	@XmlElement(name = "MatchStatus")
	@JsonProperty(value = "MatchStatus")
	private String matchStatus;
	
	

	@Getter
	@Setter
	@XmlElement(name = "Count")
	@JsonProperty(value = "Count")
	private Long count;

	@Getter
	@Setter
	@XmlElement(name = "MatchStatusName")
	@JsonProperty(value = "MatchStatusName")
	private String matchStatusName;
	
	
}