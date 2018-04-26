/**
 * 
 */
package com.dipta.project.dto.email;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author Aditya.Julka
 *
 */
@XmlRootElement(name = "EmailContent")
@JsonRootName(value = "EmailContent")
@XmlAccessorType(XmlAccessType.NONE)
public class EmailContentDto {
	
	

	@Getter
	@Setter
	@XmlElement(name = "event")
	@JsonProperty(value = "event")
	private String event;

	@Getter
	@Setter
	@XmlElement(name = "to")
	@JsonProperty(value = "to")
	private String to;
	
	@Getter
	@Setter
	@XmlElement(name = "cc")
	@JsonProperty(value = "cc")
	private String cc;
	
	@Getter
	@Setter
	@XmlElement(name = "body")
	private String body;
	
	@Getter
	@Setter
	@XmlElement(name = "attachments")
	private String[] attachments;
	
	public EmailContentDto() {
		super();
	}

	@Getter
	@Setter
	@XmlElement(name = "attachmentsName")
	private String[] attachmentsName;

	
	public EmailContentDto(String event, String to, String cc, String body,
			String[] attachments, String[] attachmentsName) {
		super();
		this.event = event;
		this.to = to;
		this.cc = cc;
		this.body = body;
		this.attachments = attachments;
		this.attachmentsName = attachmentsName;
	
	}
	
    
	
	
	
}
