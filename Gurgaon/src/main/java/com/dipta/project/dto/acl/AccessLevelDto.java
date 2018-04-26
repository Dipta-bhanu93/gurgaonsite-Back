package com.dipta.project.dto.acl;

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


@XmlRootElement(name = "AccessLevelDto")
@JsonRootName(value = "AccessLevelDto")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({GrantedPrivilegesDto.class})
public class AccessLevelDto implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Getter
	@Setter
	@XmlElement(name = "RowNum")
	@JsonProperty(value = "RowNum")
	private Long rowId;
	


	/*@XmlElement(name = "PermissionType")
	@JsonProperty(value = "PermissionType")
	@Getter
	@Setter
	private String permissionType;
	*/
	
	@XmlElement(name = "grantedPrivilegesDtos")
	@JsonProperty(value = "grantedPrivilegesDtos")
	@Getter
	@Setter
	private ArrayList<GrantedPrivilegesDto> grantedPrivilegesDtos;
}
