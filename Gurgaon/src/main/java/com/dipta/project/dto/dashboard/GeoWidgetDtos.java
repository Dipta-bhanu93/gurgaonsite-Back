package com.dipta.project.dto.dashboard;

import java.util.ArrayList;
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


@XmlRootElement(name = "Markers")
@JsonRootName(value = "Markers")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({ArrayList.class,GeoMarkerDto.class})
public class GeoWidgetDtos {
	
	@Getter
	@Setter
	@XmlElement(name = "GoldWidget")
	@JsonProperty(value = "GoldWidget")
	private List<GeoMarkerDto> geoMarkerDtos;

	
}