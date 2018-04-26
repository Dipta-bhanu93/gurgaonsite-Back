package com.dipta.project.user;


import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Getter;
import lombok.Setter;

@XmlRootElement(name = "Status")
@JsonRootName(value = "Status")
@XmlAccessorType(XmlAccessType.NONE)
public class StatusDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4801107515835282208L;

	@Getter
	@Setter
	@XmlElement(name = "StatusId")
	@JsonProperty(value = "StatusId")
	private int statusId;

	@Getter
	@Setter
	@XmlElement(name = "Status")
	@JsonProperty(value = "Status")
	private String status;
	
	@Getter
	@Setter
	@XmlElement(name = "Description")
	@JsonProperty(value = "Description")
	private String description;
	
	
}