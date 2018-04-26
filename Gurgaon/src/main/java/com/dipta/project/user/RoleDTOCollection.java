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

@XmlRootElement(name = "RoleDTOs")
@JsonRootName(value = "RoleDTOs")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso(RolesDto.class)
public class RoleDTOCollection implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Getter
	@Setter
	@XmlElement(name = "RoleMaster")
	@JsonProperty(value = "RoleMaster")
	private List<RolesDto> roleDTOs;

}
