package com.dipta.project.dto.crossReference;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


/**
 * @author Ashish.Patel
 *
 */
@XmlRootElement(name = "CategoryRulesData")
@JsonRootName(value = "CategoryRulesData")
@XmlAccessorType(XmlAccessType.NONE)
public class CategoryRulesData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@JsonProperty(value = "ReplaceCategoryId")
	@XmlElement(name = "ReplaceCategoryId")
	private Long replaceCategoryId;
	
	@Getter
	@Setter
	@JsonProperty(value = "RuleId")
	@XmlElement(name = "RuleId")
	private Long ruleId;
	
	@Getter
	@Setter
	@XmlElement(name = "RuleDesc")
	@JsonProperty(value = "RuleDesc")
	private String ruleDesc;
	
	@Getter
	@Setter
	@XmlElement(name = "RuleTableName")
	@JsonProperty(value = "RuleTableName")
	private String ruleTableName;
	
	@Getter
	@Setter
	@XmlElement(name = "ReplaceText")
	@JsonProperty(value = "ReplaceText")
	private String replaceText;
	
	@Getter
	@Setter
	@XmlElement(name = "ReplaceTextWith")
	@JsonProperty(value = "ReplaceTextWith")
	private String replaceTextWith;
	
	@Getter
	@Setter
	@XmlElement(name = "ReplacePosition")
	@JsonProperty(value = "ReplacePosition")
	private String replacePosition;
	
	
}
