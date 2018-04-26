package com.dipta.project.dto.crossReference;

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

@XmlRootElement(name = "TransformationCollection")
@JsonRootName(value = "TransformationCollection")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({EtlTransformMasterDto.class})
public class TransformationCollection {
	
	@Getter
	@Setter
	@XmlElement(name = "TransforamtionList")
	@JsonProperty(value = "TransforamtionList")
	private List<EtlTransformMasterDto> transforamtionList;

}
