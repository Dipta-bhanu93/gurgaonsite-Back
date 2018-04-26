package com.dipta.project.user;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * This class is used to store API Process information.
 * @author Ashish.Patel
 *
 */
@XmlRootElement(name = "ApiProcessInfo")
@JsonRootName(value = "ApiProcessInfo")
@XmlAccessorType(XmlAccessType.NONE)
public class ApiProcessDto {
	
	@Getter
	@Setter
	@XmlElement(name = "TokenExpiredFlag")
	@JsonProperty(value = "TokenExpiredFlag")
	private String tokenExpiredFlag;
	
	@Getter
	@Setter
	@XmlElement(name = "RequestStatus")
	@JsonProperty(value = "RequestStatus")
	private String requestStatus;
	
	@Getter
	@Setter
	@XmlElement(name = "Comments")
	@JsonProperty(value = "Comments")
	private String comments;

}
