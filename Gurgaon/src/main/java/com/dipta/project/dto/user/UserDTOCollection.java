package com.dipta.project.dto.user;

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

@XmlRootElement(name = "UserDTOs")
@JsonRootName(value = "UserDTOs")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso(UserDTO.class)
public class UserDTOCollection implements java.io.Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Getter
	@Setter
	@XmlElement(name = "UsersCreated")
	@JsonProperty(value = "UsersCreated")
	private List<UserDTO> userDTOs;
	
	@Getter
	@Setter
	@XmlElement(name = "ExSuparWithSubUsersList")
	@JsonProperty(value = "ExSuparWithSubUsersList")
	private List<UserDTO> exSuparWithSubUsersList;
	
	@Getter
	@Setter
	@XmlElement(name = "InSuparWithSubUsersList")
	@JsonProperty(value = "InSuparWithSubUsersList")
	private List<UserDTO> inSuparWithSubUsersList;

}