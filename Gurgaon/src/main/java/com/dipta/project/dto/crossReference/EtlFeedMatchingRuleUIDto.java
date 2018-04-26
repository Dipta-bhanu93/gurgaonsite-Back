/**
 * 
 */
package com.dipta.project.dto.crossReference;

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
 * @author santosh.panigrahi
 *
 */
@XmlRootElement(name = "EtlFeedMatchingRuleUIDto")
@JsonRootName(value = "EtlFeedMatchingRuleUIDto")
@XmlAccessorType(XmlAccessType.NONE)
public class EtlFeedMatchingRuleUIDto {
	
	@Getter
	@Setter
	@XmlElement(name = "ruleId")
	@JsonProperty(value = "ruleId")
	private long ruleId;
	@Getter
	@Setter
	@XmlElement(name = "order")
	@JsonProperty(value = "order")
	private long order;
	@Getter
	@Setter
	@XmlElement(name = "etlMatchingColumnDetailDtos")
	@JsonProperty(value = "etlMatchingColumnDetailDtos")
	private List<EtlMatchingColumnDetailDto> etlMatchingColumnDetailDtos;
	@Getter
	@Setter
	@XmlElement(name = "etlMatchingScoreDetailDto")
	@JsonProperty(value = "etlMatchingScoreDetailDto")
	private EtlMatchingScoreDetailDto etlMatchingScoreDetailDto;
	
	

}
