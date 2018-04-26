package com.dipta.project.dto.workflow;

import java.io.Serializable;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.dipta.project.dto.user.UserDTO;
import com.workflowcore.dto.Role;

/**
 * This class is used to store/retrieve information
 * related to workflow.
 * @author savita.khurana
 *
 */
@XmlRootElement(name = "WorkflowCoreDTO")
@JsonRootName(value = "WorkflowCoreDTO")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({UserDTO.class,Role.class})
public class WorkflowCoreDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Getter
	@Setter
	@XmlElement(name = "ServiceName")
	@JsonProperty(value = "ServiceName")
	private String serviceName;
	@Getter
	@Setter
	@XmlElement(name = "Id")
	@JsonProperty(value = "Id")
	private Long id;
	@Getter
	@Setter
	@XmlElement(name = "NextRole")
	@JsonProperty(value = "NextRole")
	private Role nextRole=new Role();
	@Getter
	@Setter
	@XmlElement(name = "CurrentRole")
	@JsonProperty(value = "CurrentRole")
	private Role currentRole=new Role();
	@Getter
	@Setter
	@XmlElement(name = "UserId")
	@JsonProperty(value = "UserId")
	private String userId;
	@Getter
	@Setter
	@XmlElement(name = "Event")
	@JsonProperty(value = "Event")
	private String event;
	@Getter
	@Setter
	@XmlElement(name = "Cdid")
	@JsonProperty(value = "Cdid")
	private Long cdid;
	@Getter
	@Setter
	@XmlElement(name = "ProjectId")
	@JsonProperty(value = "ProjectId")
	private Long projectId;
	@Getter
	@Setter
	@XmlElement(name = "WfId")
	@JsonProperty(value = "WfId")
	private Long wfId;
	@Getter
	@Setter
	@XmlElement(name = "UserDto")
	@JsonProperty(value = "UserDto")
	private UserDTO userDto;
	
	@Getter
	@Setter
	@XmlElement(name = "Comments")
	@JsonProperty(value = "Comments")
	private String comments;
	
	@Getter
	@Setter
	@XmlElement(name = "TicketID")
	@JsonProperty(value = "TicketID")
	private Long ticketID;
	
	@Getter
	@Setter
	@XmlElement(name = "BatchId")
	@JsonProperty(value = "BatchId")
	private Long batchId;
	
	@Getter
	@Setter
	@XmlElement(name = "RoleLevel")
	@JsonProperty(value = "RoleLevel")
	private Long roleLevel;
	
	@Getter
	@Setter
	@XmlElement(name = "RoleMap")
	@JsonProperty(value = "RoleMap")
	private Map<Long,Role> roleMap;
	
	@Getter
	@Setter
	@XmlElement(name = "TemplateId")
	@JsonProperty(value = "TemplateId")
	private long templateId;
	
	public WorkflowCoreDTO(){}
	public WorkflowCoreDTO(String serviceName, Long id, Role nextRole) {
		this.serviceName = serviceName;
		this.id = id;
		this.nextRole = nextRole;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "WorkflowDTO [serviceName=" + serviceName + ", ids=" + id
				+ ", nextRole=" + nextRole + ", currentRoleId=" + currentRole
				+ ", userId=" + userId + ", event=" + event + "]";
	}
	
}
