/**
 * 
 */
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

/**
 * @author santosh.panigrahi
 *
 */
@XmlRootElement(name = "EtlIDRuleDetailCollection")
@JsonRootName(value = "EtlIDRuleDetailCollection")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso(EtlIDRuleDetailDto.class)
public class EtlIDRuleDetailCollectionDto {
	@Getter
	@Setter
	@XmlElement(name = "etlIdRules")
	@JsonProperty(value = "etlIdRules")
	private List<EtlIDRuleDetailDto> etlIdRules;
	@Getter
	@Setter
	@XmlElement(name = "feedId")
	@JsonProperty(value = "feedId")
	private long feedId;


}