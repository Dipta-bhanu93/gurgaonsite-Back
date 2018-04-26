/**
 * 
 */
package com.dipta.project.dto.workflow;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author Ashish.Patel
 *
 */
@XmlRootElement(name = "WorkFlowRecordsCountDto")
@JsonRootName(value = "WorkFlowRecordsCountDto")
@XmlAccessorType(XmlAccessType.NONE)
@JsonInclude(Include.NON_NULL)
@XmlSeeAlso({HashMap.class})
public class WorkFlowRecordsCountDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@XmlElement(name = "WorkFlowRecordsCountMap", nillable=true)
	@JsonProperty(value = "WorkFlowRecordsCountMap")
	private HashMap<String,Long> workFlowRecordsCountMap;
	
	@Getter
	@Setter
	private List<Long> existRecords;
	
	@Getter
	@Setter
	private List<Long> nonexistRecords;
	
	@Getter
	@Setter
	@XmlElement(name = "IsProcess")
	@JsonProperty(value = "IsProcess")
	private boolean isProcess;
	
	@Getter
	@Setter
	@XmlElement(name = "TicketID")
	@JsonProperty(value = "TicketID")
	private Long ticketID;
	
	@Getter
	@Setter
	@XmlElement(name = "ExistRecordCount")
	@JsonProperty(value = "ExistRecordCount")
	private Long existRecordCount;
	
	@Getter
	@Setter
	@XmlElement(name = "NonExistRecordCount")
	@JsonProperty(value = "NonExistRecordCount")
	private Long nonExistRecordCount;
	
	@Getter
	@Setter
	@XmlElement(name = "TotalRecordCount")
	@JsonProperty(value = "TotalRecordCount")
	private Long totalRecordCount;
	
	@Getter
	@Setter
	@XmlElement(name = "RecordAssignCount")
	@JsonProperty(value = "RecordAssignCount")
	private Long recordAssignCount;
	
	@Getter
	@Setter
	@XmlElement(name = "TicketStatusID")
	@JsonProperty(value = "TicketStatusID")
	private int ticketStatusID;
}