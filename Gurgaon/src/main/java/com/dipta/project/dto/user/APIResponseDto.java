package com.dipta.project.dto.user;

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
@XmlRootElement(name = "APIResponseDto")
@JsonRootName(value = "APIResponseDto")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso(CodApiRequest.class)

public class APIResponseDto {
	
	@Getter
	@Setter
	@XmlElement(name = "AllMatchedEntitiesURL")
	@JsonProperty(value = "AllMatchedEntitiesURL")
	private String matpURL;
	
		
	@Getter
	@Setter
	@XmlElement(name = "OutputData")
	@JsonProperty(value = "OutputData")
	private List<OutputData> outputData=new ArrayList<OutputData>(); 

	
}