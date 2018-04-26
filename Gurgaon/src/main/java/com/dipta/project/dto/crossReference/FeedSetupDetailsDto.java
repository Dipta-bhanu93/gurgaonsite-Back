package com.dipta.project.dto.crossReference;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@XmlRootElement(name = "FeedSetupDetailsDto")
@JsonRootName(value = "FeedSetupDetailsDto")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({EtlPrestageMasterDto.class, EtlTransformMasterDto.class, EtlIDRuleDetailCollectionDto.class})
public class FeedSetupDetailsDto {
	
	@Getter
	@Setter
	@XmlElement(name = "mappingDto")
	@JsonProperty(value = "mappingDto")
	private EtlPrestageMasterDto mappingDto;
	
	@Getter
	@Setter
	@XmlElement(name = "transformDto")
	@JsonProperty(value = "transformDto")
	private EtlTransformMasterDto transformDto;
	
	@Getter
	@Setter
	@XmlElement(name = "idRuleCollectionDto")
	@JsonProperty(value = "idRuleCollectionDto")
	private EtlIDRuleDetailCollectionDto idRuleCollectionDto;
	
	@Getter
	@Setter
	@XmlElement(name = "matchingCollectionDto")
	@JsonProperty(value = "matchingCollectionDto")
	private EtlFeedMatchingRuleUICollectionDto matchingCollectionDto;
	
	

}