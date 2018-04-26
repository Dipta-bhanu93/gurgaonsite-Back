package com.dipta.project.dto.acl;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


@XmlRootElement(name = "Privileges")
@JsonRootName(value = "Privileges")
@XmlAccessorType(XmlAccessType.NONE)
public class PrivilegesDto  implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@XmlElement(name = "RowNum", required=true)
	@JsonProperty(value = "RowNum")
	@Getter
	@Setter
	private Long rowId;
	

	@XmlElement(name = "Role")
	@JsonProperty(value = "Role")
	@Getter
	@Setter
	private String roleType;
	
	
	
	@XmlElement(name = "Permitted")
	@JsonProperty(value = "Permitted")
	@Getter
	@Setter
	private boolean permitted;
	
	
	@XmlElement(name = "Modifiable")
	@JsonProperty(value = "Modifiable")
	@Getter
	@Setter
	private boolean modifiable;
	
}