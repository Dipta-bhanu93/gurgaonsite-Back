package com.dipta.project.dto.acl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


@XmlRootElement(name = "AccessControlList")
@JsonRootName(value = "AccessControlList")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({HashMap.class,GrantedPrivilegesDto.class, ArrayList.class})
public class AclDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/*@Getter
	@Setter
	@XmlElement(name = "ModuleName")
	@JsonProperty(value = "ModuleName")
	private String moduleName;*/
	
	
	@Getter
	@Setter
	@XmlElement(name = "ModuleId")
	@JsonProperty(value = "ModuleId")
	private Long moduleId;
	
	
	
	
	/*@XmlElement(name = "GrantedItems")
	@JsonProperty(value = "GrantedItems")
	@Getter
	@Setter
	private List<GrantedPrivilegesDto> grantedItems;*/
	
	
	/*@XmlElement(name = "AclMap")
	@JsonProperty(value = "AclMap")
	@XmlElementWrapper(name="addresses")
	@Getter
	@Setter
	private HashMap<Long, HashMap<String, ArrayList<PrivilegesDto>>> aclMap;*/
	
	
/*	@Getter
	@Setter
	@XmlElement(name = "AclMap", nillable=true)
	@JsonProperty(value = "AclMap")
	private HashMap<Long, ArrayList<GrantedPrivilegesDto>> aclMap;*/


	@Getter
	@Setter
	@XmlElement(name = "AclMap", nillable=true)
	@JsonProperty(value = "AclMap")
	private HashMap<String, AccessLevelDto> aclMap;
	
	
	
	
}
