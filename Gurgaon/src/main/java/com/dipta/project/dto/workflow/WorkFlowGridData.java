/**
 * 
 */
package com.dipta.project.dto.workflow;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.dipta.project.serializers.JsonDateSerializer;
import com.dipta.project.serializers.XmlDateAdapter;

/**
 * @author Ashish.Patel
 *
 */
@XmlRootElement(name = "WorkFlowGridData")
@JsonRootName(value = "WorkFlowGridData")
@XmlAccessorType(XmlAccessType.NONE)
public class WorkFlowGridData implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@XmlElement(name = "WorkFlowRecordID")
	@JsonProperty(value = "WorkFlowRecordID")
	private Long workFlowRecordID;
	
	
	@Getter
	@Setter
	@XmlElement(name = "SerialNo")
	@JsonProperty(value = "SerialNo")
	private Long serialNo;
	
	@Getter
	@Setter
	@XmlElement(name = "AssignUser")
	@JsonProperty(value = "AssignUser")
	private String assignUser ;
	
	@Getter
	@Setter
	@XmlElement(name = "AddedTime")
	@JsonProperty(value = "AddedTime")
	@JsonSerialize(using=JsonDateSerializer.class)
	@XmlJavaTypeAdapter(XmlDateAdapter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy HH:mm:ss")
	private Date addedTime ;
	
	@Getter
	@Setter
	@XmlElement(name = "ID")
	@JsonProperty(value = "ID")
	private String id ;
	
	@Getter
	@Setter
	@XmlElement(name = "Name")
	@JsonProperty(value = "Name")
	private String name ;
	
	@Getter
	@Setter
	@XmlElement(name = "Country")
	@JsonProperty(value = "Country")
	private String country ;
	
	
	//------------ 
	
	/*@Getter
	@Setter
	@XmlElement(name = "LegalName")
	@JsonProperty(value = "LegalName")
	private String legalname ;*/
	
	/*@Getter
	@Setter
	@XmlElement(name = "DomicileCountry")
	@JsonProperty(value = "DomicileCountry")
	private String domicileCountry ;*/
	
	@Getter
	@Setter
	@XmlElement(name = "Status")
	@JsonProperty(value = "Status")
	private String status ;
	
	@Getter
	@Setter
	@JsonProperty(value = "TicketID")
	@XmlElement(name = "TicketID")
	private Long ticketID;
	
	/*@Getter
	@Setter
	@XmlElement(name = "ClientSerialNo")
	@JsonProperty(value = "ClientSerialNo")
	private String clientSerialNo ;*/
	
	@Getter
	@Setter
	@XmlElement(name = "ProjectName")
	@JsonProperty(value = "ProjectName")
	private String projectName ;
	
}
