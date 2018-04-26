/**
 * 
 */
package com.dipta.project.dto.workflow;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.TreeMap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.Getter;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.dipta.project.dto.project.template.TemplateServiceMasterDto;
import com.dipta.project.serializers.JsonDateSerializer;
import com.dipta.project.serializers.XmlDateAdapter;

/**
 * @author Ashish.Patel
 *
 */
@XmlRootElement(name = "WorkFlowMasterInformation")
@JsonRootName(value = "WorkFlowMasterInformation")
@XmlAccessorType(XmlAccessType.NONE)
@JsonInclude(Include.NON_NULL)
@XmlSeeAlso({HashSet.class,WorkFlowUsersMapDto.class,HashMap.class,TreeMap.class,TemplateServiceMasterDto.class})
public class WorkFlowMasterDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@XmlElement(name = "SerialNo")
	@JsonProperty(value = "SerialNo")
	private Long serialNo;
	
	@Getter
	@Setter
	@JsonProperty(value = "WorkFlowId")
	@XmlElement(name = "WorkFlowId")
	private Long workFlowId;
	
	@Getter
	@Setter
	@JsonProperty(value = "WorkFlowName")
	@XmlElement(name = "WorkFlowName")
	private String workFlowName;
	
	@Getter
	@Setter
	@JsonProperty(value = "WorkFlowLevel")
	@XmlElement(name = "WorkFlowLevel")
	private Long workFlowLevel;

	@Getter
	@Setter
	@XmlElement(name = "AttachedAdminUsers")
	@JsonProperty(value = "AttachedAdminUsers")
	private String[] attachedAdminUsers;
	
	@Getter
	@Setter
	@XmlElement(name = "AttachedAnalystUsers")
	@JsonProperty(value = "AttachedAnalystUsers")
	private String[] attachedAnalystUsers;
	
	@Getter
	@Setter
	@XmlElement(name = "AttachedQAUsers")
	@JsonProperty(value = "AttachedQAUsers")
	private String[] attachedQAUsers;
	
	@Getter
	@Setter
	@XmlElement(name = "AttachedUsers")
	@JsonProperty(value = "AttachedUsers")
	private String[] attachedUsers;
	
	@Getter
	@Setter
	@JsonProperty(value = "UserId")
	@XmlElement(name = "UserId")
	private Long userId;
	
	@Getter
	@Setter
	@XmlElement(name = "DateCreated")
	@JsonProperty(value = "DateCreated")
	private Date dateCreated;
	
	@Getter
	@Setter
	@XmlElement(name = "workFlowUsersMapList")
	@JsonProperty(value = "workFlowUsersMapList")
	private List<WorkFlowUsersMapDto> workFlowUsersMapDtoList;
	
	@Getter
	@Setter
	@XmlElement(name = "WorkFlowMasterMapDropDown", nillable=true)
	@JsonProperty(value = "WorkFlowMasterMapDropDown")
	private HashMap<String,Long> workFlowMasterMapDropDown;
	
	@Getter
	@Setter
	@JsonProperty(value = "RoleLevel")
	@XmlElement(name = "RoleLevel")
	private String roleLevel;
	
	@Getter
	@Setter
	@JsonProperty(value = "RoleAction")
	@XmlElement(name = "RoleAction")
	private String roleAction;
	
	@Getter
	@Setter
	@XmlElement(name = "WorkFlowMasterMap", nillable=true)
	@JsonProperty(value = "WorkFlowMasterMap")
	private TreeMap<String,String> workFlowMasterMap;
/*	
	@Getter
	@Setter
	@JsonProperty(value = "TicketID")
	@XmlElement(name = "TicketID")
	private Long ticketID;*/
	
	@Getter
	@Setter
	@JsonProperty(value = "BatchID")
	@XmlElement(name = "BatchID")
	private Long batchID;
	
	@Getter
	@Setter
	@JsonProperty(value = "Ispremium")
	@XmlElement(name = "Ispremium")
	private boolean ispremium;
	
	@Getter
	@Setter
	@JsonProperty(value = "ticketOrBatchID")
	@XmlElement(name = "ticketOrBatchID")
	private Long ticketOrBatchID;
	
	@Getter
	@Setter
	@JsonProperty(value = "AllocatedUserID")
	@XmlElement(name = "AllocatedUserID")
	private Long allocatedUserID;
	
	@Getter
	@Setter
	@JsonProperty(value = "AllocatedCommaSeperateUser")
	@XmlElement(name = "AllocatedCommaSeperateUser")
	private String allocatedCommaSeperateUser;
	
	@Getter
	@Setter
	@JsonProperty(value = "ticketOrBatchCommaSep")
	@XmlElement(name = "ticketOrBatchCommaSep")
	private String ticketOrBatchCommaSep;
	
	@Getter
	@Setter
	@JsonProperty(value = "WfStatusUpdate")
	@XmlElement(name = "WfStatusUpdate")
	private boolean wfStatusUpdate;
	
	@Getter
	@Setter
	@JsonProperty(value = "TotalCount")
	@XmlElement(name = "TotalCount")
	private Long totalCount;
	
	@Getter
	@Setter
	@JsonProperty(value = "DeliveredCount")
	@XmlElement(name = "DeliveredCount")
	private Long deliveredCount;
	
	@Getter
	@Setter
	@JsonProperty(value = "RecordsInCommonPool")
	@XmlElement(name = "RecordsInCommonPool")
	private Long recordsInCommonPool;
	
	@Getter
	@Setter
	@JsonProperty(value = "RecordsInProgressCount")
	@XmlElement(name = "RecordsInProgressCount")
	private Long recordsInProgressCount;
	
	@Getter
	@Setter
	@XmlElement(name = "LastUpdatedDate")
	@JsonProperty(value = "LastUpdatedDate")
	@JsonSerialize(using=JsonDateSerializer.class)
	@XmlJavaTypeAdapter(XmlDateAdapter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy HH:mm:ss")
	private Date lastUpdatedDate ;
	
	@Getter
	@Setter
	@XmlElement(name = "WorkFlowStatus")
	@JsonProperty(value = "WorkFlowStatus")
	private String workFlowStatus;
	
	@Getter
	@Setter
	@XmlElement(name = "WorkFlowStatusID")
	@JsonProperty(value = "WorkFlowStatusID")
	private Long workFlowStatusID;
	
	@Getter
	@Setter
	@XmlElement(name = "percentageCompleted")
	@JsonProperty(value = "percentageCompleted")
	private double percentageCompleted;
	
	
	@Getter
	@Setter
	@XmlElement(name = "CommaSeparatedAttachedUsers")
	@JsonProperty(value = "CommaSeparatedAttachedUsers")
	private String commaSepAttachedUsers;
	
	@Getter
	@Setter
	@JsonProperty(value = "ServiceID")
	@XmlElement(name = "ServiceID")
	private Long serviceID;
	
	@Getter
	@Setter
	@XmlElement(name = "TemplateService")
	@JsonProperty(value = "TemplateService")
	private TemplateServiceMasterDto templateServiceMasterDomain;
	
	
	@Override
	public String toString() {
		return "WorkFlowMasterDto [workFlowId=" + workFlowId
				+ ", workFlowName=" + workFlowName + ", attachedAdminUsers="
				+ Arrays.toString(attachedAdminUsers)
				+ ", attachedAnalystUsers="
				+ Arrays.toString(attachedAnalystUsers) + ", attachedQAUsers="
				+ Arrays.toString(attachedQAUsers) + ", attachedUsers="
				+ Arrays.toString(attachedUsers) + ", userId=" + userId
				+ ", dateCreated=" + dateCreated + ", workFlowUsersMapDtoList="
				+ workFlowUsersMapDtoList + ", workFlowMasterMapDropDown="
				+ workFlowMasterMapDropDown + ", roleLevel=" + roleLevel
				+ ", roleAction=" + roleAction + ", workFlowMasterMap="
				+ workFlowMasterMap +  ", batchID="
				+ batchID + ", ispremium=" + ispremium + "]";
	}

	




	
	
	


}
