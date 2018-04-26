package com.dipta.project.dto.dashboard;

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

@XmlRootElement(name = "WorkItemWorkFlowDto")
@JsonRootName(value = "WorkItemWorkFlowDto")
@XmlAccessorType(XmlAccessType.NONE)
//@XmlSeeAlso({Date.class,GanttChartDto.class})
public class WorkItemWorkFlowDto {
	@Getter	@Setter	@XmlElement(name = "WorkFlowId")	@JsonProperty(value = "WorkFlowId")
	private Long workFlowId;
	@Getter	@Setter	@XmlElement(name = "WorkFlowName")	@JsonProperty(value = "WorkFlowName")
	private String workFlowName;
	
	@Getter	@Setter	@XmlElement(name = "WorkFlowStatus")	@JsonProperty(value = "WorkFlowStatus")
	private String workFlowStatus;
	
//	@Getter	@Setter	@XmlElement(name = "GanttData")	@JsonProperty(value = "GanttData")
//	private List<GanttChartDto> ganttData;
	
	@Getter
	@Setter
	@XmlElement(name = "UpdatedDate")
	@JsonProperty(value = "UpdatedDate")
	@JsonSerialize(using=JsonDateSerializer.class)
	@XmlJavaTypeAdapter(XmlDateAdapter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy HH:mm:ss")
	private Date updatedDate;
}