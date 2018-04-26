package com.dipta.project.dto.acl;

import java.io.Serializable;
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


@XmlRootElement(name = "GrantedPrivilegesDto")
@JsonRootName(value = "GrantedPrivilegesDto")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({PrivilegesDto.class})
public class GrantedPrivilegesDto implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@XmlElement(name = "PermissionType")
	@JsonProperty(value = "PermissionType")
	@Getter
	@Setter
	private String permissionType;
	
	@XmlElement(name = "AccessDesc")
	@JsonProperty(value = "AccessDesc")
	@Getter
	@Setter
	private String accessDesc;
	
	
	@XmlElement(name = "Privileges")
	@JsonProperty(value = "Privileges")
	@Getter
	@Setter
	private ArrayList<PrivilegesDto> privilegesDtos;


	
}