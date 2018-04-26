package com.dipta.project.dto.lei;

import java.sql.Timestamp;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * This class is used to store API Execution History Database details.
 * @author neha.mehta
 *
 */

@XmlRootElement(name = "APIHistory")
@JsonRootName(value = "APIHistory")
@XmlAccessorType(XmlAccessType.NONE)
@JsonInclude(Include.NON_NULL)
public class APIHistoryDTO {
	@Getter
	@Setter
	@XmlElement(name = "Token")
	@JsonProperty(value = "Token")
	private String token;
	
	@Getter
	@Setter
	@XmlElement(name = "UserId")
	@JsonProperty(value = "UserId")
	private String loginId;
	
	@Getter
	@Setter
	@XmlElement(name = "RequestData")
	@JsonProperty(value = "RequestData")
	private String requestData;
	
	@Getter
	@Setter
	@XmlElement(name = "RequestTime")
	@JsonProperty(value = "RequestTime")
	private Timestamp requestTime;
	
	@Getter
	@Setter
	@XmlElement(name = "ResponseData")
	@JsonProperty(value = "ResponseData")
	private String responseData;
	
	@Getter
	@Setter
	@XmlElement(name = "ResponseTime")
	@JsonProperty(value = "ResponseTime")
	private Timestamp responseTime;
}
