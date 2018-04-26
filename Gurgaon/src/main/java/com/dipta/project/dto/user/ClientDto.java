package com.dipta.project.dto.user;

import java.io.Serializable;
import java.util.HashMap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.dipta.project.dto.workflow.WorkFlowUserDto;


@XmlRootElement(name = "ClientDetails")
@JsonRootName(value = "ClientDetails")
@XmlAccessorType(XmlAccessType.NONE)
public class ClientDto implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -359883563750006060L;

	@XmlElement(name = "CompanyId")
	@JsonProperty(value = "CompanyId")
	@Getter
	@Setter
	private Long companyId;

	@XmlElement(name = "Name")
	@JsonProperty(value = "Name")
	@Getter
	@Setter
	private String name;
	
	@XmlElement(name = "Country")
	@JsonProperty(value = "Country")
	@Getter
	@Setter
	private String country;
	
	@XmlElement(name = "Address")
	@JsonProperty(value = "Address")
	@Getter
	@Setter
	private String address;
	
	@XmlElement(name = "City")
	@JsonProperty(value = "City")
	@Getter
	@Setter
	private String city;
	
	@XmlElement(name = "Contact")
	@JsonProperty(value = "Contact")
	@Getter
	@Setter
	private String contact;
	
	@XmlElement(name = "WebAddress")
	@JsonProperty(value = "WebAddress")
	@Getter
	@Setter
	private String webAddress;
	
	@XmlElement(name = "ClientUserId")
	@JsonProperty(value = "ClientUserId")
	@Getter
	@Setter
	private Long userId;
	

	@XmlElementWrapper(name = "RoleWiseUserMap")
	@JsonProperty(value = "RoleWiseUserMap")
	@Getter
	@Setter
	private HashMap<String,WorkFlowUserDto> roleWiseUserMap;
}
