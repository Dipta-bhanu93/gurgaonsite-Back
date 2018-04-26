package com.dipta.project.dto.dashboard;

import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


@XmlRootElement(name = "DashBoard")
@JsonRootName(value = "DashBoard")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({ArrayList.class,GoldWidgetDto.class})
public class DashboardDto implements Serializable{

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@XmlElement(name = "GoldWidget")
	@JsonProperty(value = "GoldWidget")
	private ArrayList<GoldWidgetDto> goldWidgetData;	
}