package com.dipta.project.dto.crossReference;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author Ashish.Patel
 *
 */
@XmlRootElement(name = "EtlPrestageMasterInformation")
@JsonRootName(value = "EtlPrestageMasterInformation")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({HashSet.class,HashMap.class,TreeMap.class,EtlPrestageMapDto.class})
public class EtlPrestageMasterDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@XmlElement(name = "ID")
	@JsonProperty(value = "ID")
	private long id;
	
	@Getter
	@Setter
	@XmlElement(name = "PrestageMapId")
	@JsonProperty(value = "PrestageMapId")
	private long prestageMapId;
	
	@Getter
	@Setter
	@XmlElement(name = "PrestageTabName")
	@JsonProperty(value = "PrestageTabName")
	private String prestageTabName;
	
	@Getter
	@Setter
	@XmlElement(name = "PrestageMapName")
	@JsonProperty(value = "PrestageMapName")
	private String prestageMapName; 
	
	@Getter
	@Setter
	@XmlElement(name = "FileId")
	@JsonProperty(value = "FileId")
	private long fileId; 
	
	@Getter
	@Setter
	@XmlElement(name = "Comments")
	@JsonProperty(value = "Comments")
	private String comments;
	
	@Getter
	@Setter
	@XmlElement(name = "FeedId")
	@JsonProperty(value = "FeedId")
	private long feedid;
	
	@Getter
	@Setter
	@XmlElement(name = "FeedType")
	@JsonProperty(value = "FeedType")
	private String feedType;
	
	@Getter
	@Setter
	@XmlElement(name = "etlPrestageMapList")
	@JsonProperty(value = "etlPrestageMapList")
	private List<EtlPrestageMapDto> etlPrestageMapDtoList;
	
	@Getter
	@Setter
	@XmlElement(name = "ProjectId")
	@JsonProperty(value = "ProjectId")
	private String projectId;
	

}