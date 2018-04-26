/**
 * 
 */
package com.dipta.project.dto.email;

import java.sql.Timestamp;
import java.util.Date;

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
@XmlRootElement(name = "EmailDomainDTO")
@JsonRootName(value = "EmailDomainDTO")
@XmlAccessorType(XmlAccessType.NONE)
public class EmailInfoDTO {
	
	@XmlElement(name = "id")	@JsonProperty(value = "id") @Getter	@Setter	private Long id;
	@XmlElement(name = "userId")	@JsonProperty(value = "userId") @Getter	@Setter	private Long userId;
	@XmlElement(name = "clientid")	@JsonProperty(value = "clientid") @Getter	@Setter	private Long clientid;
	@XmlElement(name = "emailContent")	@JsonProperty(value = "emailContent") @Getter	@Setter	private String emailContent;
	@XmlElement(name = "exception")	@JsonProperty(value = "exception") @Getter	@Setter	private String exception;
	@XmlElement(name = "retryCount")	@JsonProperty(value = "retryCount") @Getter @Setter private int retryCount;
	@XmlElement(name = "createdDate")	@JsonProperty(value = "createdDate") @Getter @Setter private Timestamp createdDate;   
	@XmlElement(name = "modifiedDate")	@JsonProperty(value = "modifiedDate") @Getter @Setter private Timestamp modifiedDate; 
	
	public EmailInfoDTO( Long userId, Long clientid,
			String emailContent, String exception, Integer retryCount) {
		super();
		if(userId!=null)
		{this.userId = userId;              }
		if(clientid!=null)                 
		{this.clientid = clientid;          }
		if(emailContent!=null)             
		{this.emailContent = emailContent;  }
		if(exception!=null)                
		{this.exception = exception;        }
		if(retryCount!=null)               
		{this.retryCount = retryCount;      }
		
		this.createdDate=new Timestamp(new Date().getTime());
//		this.modifiedDate=new Timestamp(new Date().getTime());
	}
	public EmailInfoDTO(){
		super();
	}
	
}
