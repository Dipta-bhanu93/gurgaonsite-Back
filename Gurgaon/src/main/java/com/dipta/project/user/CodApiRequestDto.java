package com.dipta.project.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.dipta.project.service.api.CodApiRequest;

/**
 * This class is used to store API Request information.
 * @author Ashish.Patel
 *
 */
@XmlRootElement(name = "ApiRequestInfo")
@JsonRootName(value = "ApiRequestInfo")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso(CodApiRequest.class)

public class CodApiRequestDto {
	
	@Getter
	@Setter
	@XmlElement(name = "MatpURL")
	@JsonProperty(value = "MatpURL")
	private String matpURL;
	
	
	@Getter
	@Setter
	@JsonIgnore
	private long id;
	
	@Getter
	@Setter
	@XmlElement(name = "REG_EMAIL")
	@JsonProperty(value = "REG_EMAIL")
	private String regEmail;
	
	@Getter
	@Setter
	@JsonIgnore
	private String email;
	
	@Getter
	@Setter
	@XmlElement(name = "SessionAccessToken")
	@JsonProperty(value = "SessionAccessToken")
	private String sessionAccessToken;
	
	
	
	@Getter
	@Setter
	@XmlElement(name = "InputList")
	@JsonProperty(value = "InputList")
	private List<CodApiRequest> codApiRequests=new ArrayList<CodApiRequest>(); 
	
	
	@Getter
	@Setter
	@XmlElement(name = "OutputData")
	@JsonProperty(value = "OutputData")
	private List<OutputData> outputData=new ArrayList<OutputData>(); 

	
	@Getter
	@Setter
	@JsonIgnore
	private Long accessToken;
	
	@Getter
	@Setter
	@JsonIgnore
	private String requestedToken;
	
	@Getter
	@Setter
	@JsonIgnore
	private String password;
	
	
	@Getter
	@Setter
	@XmlElement(name = "TokenExpiredFlag")
	@JsonProperty(value = "TokenExpiredFlag")
	@JsonIgnore
	private String tokenExpiredFlag;

	/*
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
	
	@Getter
	@Setter
	@XmlElement(name = "RequestType")
	@JsonProperty(value = "RequestType")
	private String requestType;
	
	@Getter
	@Setter
	@XmlElement(name = "RequestDate")
	@JsonProperty(value = "RequestDate")
	@JsonIgnore
	private Date requestDate;*/
	
	@Getter
	@Setter
	@XmlElement(name = "MatchingType")
	@JsonProperty(value = "MatchingType")
	private String matchingType;
	
	
	

}