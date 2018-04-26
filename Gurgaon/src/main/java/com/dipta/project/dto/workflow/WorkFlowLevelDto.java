package com.dipta.project.dto.workflow;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.dipta.project.dto.user.RolesDto;

/**
 * @author Ashish.Patel
 *
 */
@XmlRootElement(name = "WorkFlowLevel")
@JsonRootName(value = "WorkFlowLevel")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({RolesDto.class, WorkFlowUserDto.class})
public class WorkFlowLevelDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@XmlElement(name = "RolesDto")
	@JsonProperty(value = "RolesDto")
	private RolesDto rolesDto;
	
	@Getter
	@Setter
	@XmlElement(name = "AllocatedUsersInfo")
	@JsonProperty(value = "AllocatedUsersInfo")
	private List<WorkFlowUserDto> allocatedUserList;
	
	@Getter
	@Setter
	@XmlElement(name = "IndividualPoolTotalCount")
	@JsonProperty(value = "IndividualPoolTotalCount")
	private Long individualPoolTotalCount;
	
	@Getter
	@Setter
	@XmlElement(name = "ApprovedTotalCount")
	@JsonProperty(value = "ApprovedTotalCount")
	private Long approvedTotalCount;
	
	@Getter
	@Setter
	@XmlElement(name = "RejectedTotalCount")
	@JsonProperty(value = "RejectedTotalCount")
	private Long rejectedTotalCount;
	
	@Getter
	@Setter
	@XmlElement(name = "CommaseperatedAllocatedUser")
	@JsonProperty(value = "CommaseperatedAllocatedUser")
	private String commaseperatedAllocatedUser;
	
	@Getter
	@Setter
	@XmlElement(name = "SubmittedPoolFlag",defaultValue = "Y")
	@JsonProperty(value = "SubmittedPoolFlag")
	private String submittedPoolFlag = "Y";
	
	@Getter
	@Setter
	@XmlElement(name = "RejectedPoolFlag",defaultValue = "Y")
	@JsonProperty(value = "RejectedPoolFlag")
	private String rejectedPoolFlag = "Y";
	
	@Getter
	@Setter
	@XmlElement(name = "IsSuperInWorkflow",defaultValue = "N")
	@JsonProperty(value = "IsSuperInWorkflow")
	private String isSuperInWorkflow = "N";


}