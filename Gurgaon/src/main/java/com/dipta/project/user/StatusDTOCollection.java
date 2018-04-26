package com.dipta.project.user;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name = "StatusDTOs")
@JsonRootName(value = "StatusDTOs")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso(StatusDto.class)
public class StatusDTOCollection implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Getter
	@Setter
	@XmlElement(name = "StatusMaster")
	@JsonProperty(value = "StatusMaster")
	private List<StatusDto> statusDTOs;

}
