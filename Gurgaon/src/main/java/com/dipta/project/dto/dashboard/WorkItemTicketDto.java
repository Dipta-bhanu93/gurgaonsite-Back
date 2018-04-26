package com.dipta.project.dto.dashboard;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import com.dipta.project.dto.ticketManagement.gantt.GanttChartDto;
import com.dipta.project.serializers.JsonDateSerializer;
import com.dipta.project.serializers.XmlDateAdapter;

@XmlRootElement(name = "WorkItemTicketDto")
@JsonRootName(value = "WorkItemTicketDto")
@XmlAccessorType(XmlAccessType.NONE)
//@XmlSeeAlso({Date.class,GanttChartDto.class})
public class WorkItemTicketDto {
	@Getter	@Setter	@XmlElement(name = "TicketId")	@JsonProperty(value = "TicketId")
	private Long ticketId;
	@Getter	@Setter	@XmlElement(name = "TicketStatus")	@JsonProperty(value = "TicketStatus")
	private String ticketStatus;
	@Getter	@Setter	@XmlElement(name = "StatusID")	@JsonProperty(value = "StatusID")
	private int statusID;
	@XmlElement(name="ticketDesc") @JsonProperty(value="ticketDesc") @Getter @Setter private String ticketDesc;
//	@Getter	@Setter	@XmlElement(name = "GanttData")	@JsonProperty(value = "GanttData")
//	private List<GanttChartDto> ganttData;
//	
	@XmlElement(name="DateCreated") @JsonProperty(value="DateCreated") @Getter @Setter private Timestamp dateCreated;
	
	@Getter
	@Setter
	@XmlElement(name = "UpdatedDate")
	@JsonProperty(value = "UpdatedDate")
//	@JsonSerialize(using=JsonDateSerializer.class)
//	@XmlJavaTypeAdapter(XmlDateAdapter.class)
//	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy HH:mm:ss")
	private Date updatedDate;
	
	@XmlElement(name="ticketProgress") @JsonProperty(value="ticketProgress") @Getter @Setter 
	private String ticketProgress;
	
}