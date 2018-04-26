/**
 * 
 */
package com.dipta.project.dto.workflow;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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
import com.dipta.project.serializers.JsonDateSerializer;
import com.dipta.project.serializers.XmlDateAdapter;

/**
 * @author Ashish.Patel
 *
 */

@XmlRootElement(name = "WorkFlowSearchGrid")
@JsonRootName(value = "WorkFlowSearchGrid")
@XmlAccessorType(XmlAccessType.NONE)
@XmlSeeAlso({WorkFlowGridHeader.class, WorkFlowGridData.class,HashMap.class,WorkFlowLevelDto.class,WorkFlowMasterDto.class})
public class WorkFlowSearchGridDto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
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
	@JsonProperty(value = "BatchId")
	@XmlElement(name = "BatchId")
	private Long batchId;
	
	@Getter
	@Setter
	@XmlElement(name = "WorkFlowGridHeaderLst")
	@JsonProperty(value = "WorkFlowGridHeaderLst")
	private List<WorkFlowGridHeader> workFlowGridHeaderLst;
	
	@Getter
	@Setter
	@XmlElement(name = "WorkFlowGridDataLst")
	@JsonProperty(value = "WorkFlowGridDataLst")
	private List<WorkFlowGridData> workFlowGridDataLst;
	
	/*@Getter
	@Setter
	@XmlElement(name = "CommonPoolCount")
	@JsonProperty(value = "CommonPoolCount")
	private Long commonPool;
	
	@Getter
	@Setter
	@XmlElement(name = "AnalystAllocationCount")
	@JsonProperty(value = "AnalystAllocationCount")
	private Long analystAllocation;

	@Getter
	@Setter
	@XmlElement(name = "AdminAllocationCount")
	@JsonProperty(value = "AdminAllocationCount")
	private Long adminAllocation;

	@Getter
	@Setter
	@XmlElement(name = "QaAllocationCount")
	@JsonProperty(value = "QaAllocationCount")
	private Long qaAllocation;

	@Getter
	@Setter
	@XmlElement(name = "DeliveredAllocationCount")
	@JsonProperty(value = "DeliveredAllocationCount")
	private Long deliveredAllocation;

	@Getter
	@Setter
	@XmlElement(name = "AnalystApproveCount")
	@JsonProperty(value = "AnalystApproveCount")
	private Long analystApprove;

	@Getter
	@Setter
	@XmlElement(name = "AdminApproveCount")
	@JsonProperty(value = "AdminApproveCount")
	private Long adminApprove;

	@Getter
	@Setter
	@XmlElement(name = "AdminRejectedCount")
	@JsonProperty(value = "AdminRejectedCount")
	private Long adminRejected;

	@Getter
	@Setter
	@XmlElement(name = "QaRejectedCount")
	@JsonProperty(value = "QaRejectedCount")
	private Long qaRejected;
	
	
	@Getter
	@Setter
	@XmlElement(name = "TotalWfRecordCount")
	@JsonProperty(value = "TotalWfRecordCount")
	private Long totalWfRecordCount;

	@Getter
	@Setter
	@XmlElement(name = "GridLabel")
	@JsonProperty(value = "GridLabel")
	private String gridLabel;

	@Getter
	@Setter
	@XmlElement(name = "DataAccessPrivilege",defaultValue = "Y")
	@JsonProperty(value = "DataAccessPrivilege")
	private String dataAccessPrivilege = "Y";*/
	
	@Getter
	@Setter
	@XmlElement(name = "LastUpdatedDate")
	@JsonProperty(value = "LastUpdatedDate")
	@JsonSerialize(using=JsonDateSerializer.class)
	@XmlJavaTypeAdapter(XmlDateAdapter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MMM-yyyy HH:mm:ss")
	private Date lastUpdatedDate ;
	
/*	@Getter
	@Setter
	@XmlElement(name = "AllocatedUsersInfo")
	@JsonProperty(value = "AllocatedUsersInfo")
	private List<WorkFlowUserDto> allocatedUserList;*/
	
	@Getter
	@Setter
	@XmlElement(name = "WorkFlowStatus")
	@JsonProperty(value = "WorkFlowStatus")
	private String workFlowStatus;
	
	@Getter
	@Setter
	@XmlElement(name = "WorkFlowLevelMap")
	@JsonProperty(value = "WorkFlowLevelMap")
	private TreeMap<Long,WorkFlowLevelDto> workFlowLevelMap;
	
	@Getter
	@Setter
	@XmlElement(name = "CommonPoolLevelInfo")
	@JsonProperty(value = "CommonPoolLevelInfo")
	private WorkFlowLevelDto commonPoolLevelInfo;
	
	@Getter
	@Setter
	@XmlElement(name = "DeliveredLevelInfo")
	@JsonProperty(value = "DeliveredLevelInfo")
	private WorkFlowLevelDto deliveredLevelInfo;
	
	@Getter
	@Setter
	@XmlElement(name = "WorkFlowStatusID")
	@JsonProperty(value = "WorkFlowStatusID")
	private Long workFlowStatusID;
	
	@Getter
	@Setter
	@XmlElement(name = "WorkFlowLevel")
	@JsonProperty(value = "WorkFlowLevel")
	private Long workFlowLevel;
	
	@Getter
	@Setter
	@XmlElement(name = "WorkFlowMasterDtosLst")
	@JsonProperty(value = "WorkFlowMasterDtosLst")
	private List<WorkFlowMasterDto> workFlowMasterDtosLst;
	
	@Getter
	@Setter
	@XmlElement(name = "WorkServiceName")
	@JsonProperty(value = "WorkServiceName")
	private String workServiceName;

}
