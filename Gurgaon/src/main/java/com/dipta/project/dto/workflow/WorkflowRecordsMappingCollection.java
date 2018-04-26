package com.dipta.project.dto.workflow;

import java.util.ArrayList;
import java.util.HashSet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


@XmlRootElement(name = "WorkflowRecordsMappingCollection")
@JsonRootName(value = "WorkflowRecordsMappingDto")
@XmlAccessorType(XmlAccessType.NONE)
@JsonInclude(Include.NON_NULL)
@XmlSeeAlso({HashSet.class,WorkflowRecordsMappingDto.class})
public class WorkflowRecordsMappingCollection {

	@Getter
	@Setter
	@XmlElement(name = "MappedDtos")
	@JsonProperty(value = "MappedDtos")
	ArrayList<WorkflowRecordsMappingDto> mappedDtos;
	
	@Getter
	@Setter
	@JsonProperty(value = "WorkFlowId")
	@XmlElement(name = "WorkFlowId")
	private long workFlowId;
	
	@Getter
	@Setter
	@XmlElement(name = "IsProcess")
	@JsonProperty(value = "IsProcess")
	private boolean isProcess;
	
	@Getter
	@Setter
	@JsonProperty(value = "ActionID")
	@XmlElement(name = "ActionID")
	private Long actionID;
	
	@Getter
	@Setter
	@JsonProperty(value = "IsAddToWorkFlow")
	@XmlElement(name = "IsAddToWorkFlow")
	private boolean isAddToWorkFlow;
	
	@Getter
	@Setter
	@JsonProperty(value = "IsAddToTicket")
	@XmlElement(name = "IsAddToTicket")
	private boolean isAddToTicket;
	
	@Getter
	@Setter
	@JsonProperty(value = "WfBypassUserID")
	@XmlElement(name = "WfBypassUserID")
	private Long wfBypassUserID;
	
	@Getter
	@Setter
	@JsonProperty(value = "wfBypassFromUserID")
	@XmlElement(name = "wfBypassFromUserID")
	private Long wfBypassFromUserID;
	
	@Getter
	@Setter
	@JsonProperty(value = "TemplateId")
	@XmlElement(name = "TemplateId")
	private long templateId;
	
	@Getter
	@Setter
	@JsonProperty(value = "ServiceId")
	@XmlElement(name = "ServiceId")
	private long serviceId;
}
