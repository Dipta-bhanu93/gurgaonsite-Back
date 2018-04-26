/**
 * 
 */
package com.dipta.project.dto.crossReference;

import java.sql.Timestamp;

import javax.persistence.Column;
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
 *This class will represents list of all master rule defined in the system
 *
 */
@XmlRootElement(name = "EtlIDRuleMasterInformation")
@JsonRootName(value = "EtlIDRuleMasterInformation")
@XmlAccessorType(XmlAccessType.NONE)
public class EtlIDRuleMasterDto {
	
	
	@Getter
	@Setter
	@XmlElement(name = "ruleId")
	@JsonProperty(value = "ruleId")
		private long ruleId;
	
	@Getter
	@Setter
	@XmlElement(name = "ruleName")
	@JsonProperty(value = "ruleName")
		private String ruleName;
	
	
	@Getter
	@Setter
	@XmlElement(name = "ruleStatus")
	@JsonProperty(value = "ruleStatus")
		private String ruleStatus;
	
	@Getter
	@Setter
	@XmlElement(name = "description")
	@JsonProperty(value = "description")
		private String description;
	
	@Getter                   
	@Setter                   
	@XmlElement(name = "dateCreated")
	@JsonProperty(value = "dateCreated")
	private Timestamp dateCreated; 
	
	
}