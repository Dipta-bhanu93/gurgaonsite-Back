package com.dipta.project.dto.crossReference;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;


@XmlRootElement(name = "EmailDomainDTO")
@JsonRootName(value = "EmailDomainDTO")
@XmlAccessorType(XmlAccessType.NONE)
public class ReserveKeywordDTO {
	@XmlElement(name = "Id")	@JsonProperty(value = "Id") @Getter	@Setter	private Long id;
	@XmlElement(name = "Keyword")	@JsonProperty(value = "Keyword") @Getter	@Setter	private String keyword ;
	
}
