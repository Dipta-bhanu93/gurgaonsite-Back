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
@XmlRootElement(name = "BuiltInFunctionCategoryRulesData")
@JsonRootName(value = "BuiltInFunctionCategoryRulesData")
@XmlAccessorType(XmlAccessType.NONE)
public class BuiltInFunctionCategoryRulesData implements Serializable {

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
	@XmlElement(name = "FunctionName")
	@JsonProperty(value = "FunctionName")
	private String functionName;

}
