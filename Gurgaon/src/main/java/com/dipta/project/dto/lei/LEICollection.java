package com.dipta.project.dto.lei;

import java.util.List;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * This class is used to store lei request data.
 * @author neha.mehta
 *
 */
@XmlRootElement(name = "LeiCollections")
@JsonRootName(value = "LeiCollections")
@XmlAccessorType(XmlAccessType.NONE)
public class LEICollection {
	
	@Getter
	@Setter
	@XmlElement(name = "AUTHENTICATIONTOKEN")
	@JsonProperty(value = "AUTHENTICATIONTOKEN")
	private String authToken;
	
	@Getter
	@Setter
	@XmlElement(name = "LeiInformations")
	@JsonProperty(value = "LeiInformations")
	private List<LEIDTO> leiInformations;
	
	@Getter
	@Setter
	@XmlElement(name = "POTENTIALMATCHES")
	@JsonProperty(value = "POTENTIALMATCHES")
	private boolean potentialMatches;
	
	@Getter
	@Setter
	@XmlElement(name = "MINIMUMMATCHSCORE")
	@JsonProperty(value = "MINIMUMMATCHSCORE")
	private Integer minimumMatchScore;
	
	
	@Getter
	@Setter
	@XmlElement(name = "DATAACCESSTOKEN")
	@JsonProperty(value = "DATAACCESSTOKEN")
	private String dataAccessToken;
	
	
}