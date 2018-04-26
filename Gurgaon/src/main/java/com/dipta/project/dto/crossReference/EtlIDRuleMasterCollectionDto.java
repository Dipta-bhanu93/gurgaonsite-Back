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
@XmlRootElement(name = "Company")
@JsonRootName(value = "Company")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso(EtlIDRuleMasterDto.class)
public class EtlIDRuleMasterCollectionDto {
	@Getter
	@Setter
	@XmlElement(name = "etlMasterIDRules")
	@JsonProperty(value = "etlMasterIDRules")
	private List<EtlIDRuleMasterDto> etlMasterIDRules;

}
