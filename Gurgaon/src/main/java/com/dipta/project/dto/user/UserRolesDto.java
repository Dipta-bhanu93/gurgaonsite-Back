package com.dipta.project.dto.user;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.dipta.project.dto.acl.PrivilegesDto;


@XmlRootElement(name = "UserRoles")
@JsonRootName(value = "UserRoles")
@XmlAccessorType(XmlAccessType.NONE)
public class UserRolesDto implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5840477678158969709L;

	@XmlElement(name = "RoleId")
	@JsonProperty(value = "RoleId")
	@Getter
	@Setter
	private Long roleId;

	@XmlElement(name = "Type")
	@JsonProperty(value = "Type")
	@Getter
	@Setter
	private String type;
	
	
	@XmlElement(name = "TypeDesc")
	@JsonProperty(value = "TypeDesc")
	@Getter
	@Setter
	private String typeDesc;
	
	
	@XmlElement(name = "Privileges")
	@JsonProperty(value = "Privileges")
	@Getter
	@Setter
	private List<PrivilegesDto> privilegeDtos;
	
	@XmlElement(name = "RoleLevel")
	@JsonProperty(value = "RoleLevel")
	@Getter
	@Setter
	private Long roleLevel;
	
	@XmlElement(name = "XorchatIcon")
	@JsonProperty(value = "XorchatIcon")
	@Getter
	@Setter
	private String xorchatIcon;
	
	
	
	/*@Getter
	@Setter
	private UserRoleCompositeId userAndRole=new UserRoleCompositeId();*/

}