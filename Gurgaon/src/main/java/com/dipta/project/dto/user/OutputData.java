package com.dipta.project.dto.user;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.dipta.project.service.api.CodApiRequest;

@XmlRootElement(name = "OutputData")
@JsonRootName(value = "OutputData")
@XmlAccessorType(XmlAccessType.NONE)
public class OutputData {
	
	@Getter
	@Setter
	@XmlElement(name = "InputRequest")
	@JsonProperty(value = "InputRequest")
	private CodApiRequest inputRequest;
	
	@Getter
	@Setter
	@XmlElement(name = "MatchStatus")
	@JsonProperty(value = "MatchStatus")
	private String matchStatus;
	
	@Setter
	@Getter
	@XmlElement(name = "RecordsCount")
	@JsonProperty(value = "RecordsCount")
	private long recordsCount;
	
	
	
	@Getter
   	@Setter
   	@JsonProperty(value = "EnrichedInfo")
   	@XmlElement(name = "EnrichedInfo")
	private List<LinkedHashMap<String,Object>> enrichedRecords = new LinkedList<LinkedHashMap<String,Object>>();
	

}